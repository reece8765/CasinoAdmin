/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;

/**
 *
 * @author Reece
 */
public class Security {

    /**
     *
     */
    public static final String encryption = "::";

    public void saveLog(String input) {
        File file = new File("C:\\RTC\\data.temp");
        if (!file.exists()) {
            createLog(input, file);
        } else {
            try {
                FileWriter fw = new FileWriter(file, true);
                try (BufferedWriter bw = new BufferedWriter(fw)) {
                    bw.append(getTime() + ": " + input);
                    bw.newLine();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error Code: W1", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }

    public String getUserBalance(String username) throws Exception {
        return decrypt("C:\\RTC\\data\\", username + "-balance.dat", false);
    }

    private void createLog(String temp, File file) {
        try {
            FileWriter fw = new FileWriter(file);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                bw.append("");
                bw.close();
                saveLog(temp);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error Code: W1", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String getTime() throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String time = String.valueOf(dateFormat.format(date));
        return time;
    }

    public boolean verify(String input) {
        boolean valid;

        //String user = getUserName();
        String read = "";
        try {
            BufferedReader reader;
            try (FileReader file = new FileReader("C:\\RTC\\lockdown\\keyCode.sec")) {
                reader = new BufferedReader(file);
                read = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
        }

        String computerName = getCompName();
        String computerNameInput = "";

        try {
            BufferedReader reader;
            try (FileReader file = new FileReader("F:\\RTC\\keyCode2.sec")) {
                reader = new BufferedReader(file);
                computerNameInput = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Key Not Validated", "Error 1", JOptionPane.ERROR_MESSAGE);
        }

        valid = input.equals(read) && computerName.equals(computerNameInput);
        return valid;
    }

    //Get the computers name
    protected String getCompName() {
        String retVal = "";
        try {
            retVal = InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            JOptionPane.showMessageDialog(null, "OS Error", "You must be running a supported OS!", JOptionPane.ERROR_MESSAGE);
        }
        return retVal;
    }

    //Generate encryption key
    public void genKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        keyGen.init(56);
        Key key = keyGen.generateKey();

        byte[] keyAsByte = key.getEncoded();
        try (FileOutputStream keyfos = new FileOutputStream("C:\\RTC\\lockdown\\data.key")) {
            keyfos.write(keyAsByte);
        }
    }

    // Set and encrypt the administrative password
    public void setAdminPass(String input) throws Exception {
        encrypt("C:\\RTC\\lockdown\\", "data.dat", input);
    }

    public void encryptFile(String path, String file, String input) throws Exception {
        encrypt(path, file, input);
    }

    //encrypt any information with the key generated
    private void encrypt(String path, String file, String input) throws Exception {
        byte[] encrypted = retEnc(input);
        boolean overwrite = false;
        if (file.equals("members.dat") || file.equals("Doors.dat")) {
            overwrite = true;
        }
        try {
            FileOutputStream fs = new FileOutputStream(path + file, overwrite);
            fs.write(encrypted);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Key Error. Key may not exist.", "Error Encrypting!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public byte[] retEnc(String input) throws Exception {
        byte[] text = input.getBytes("UTF8");

        byte[] encKey;
        try (FileInputStream keyFis = new FileInputStream("C:\\RTC\\lockdown\\data.key")) {
            encKey = new byte[keyFis.available()];
            keyFis.read(encKey);
        }
        Key key = new SecretKeySpec(encKey, "DES");

        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");

        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(text);
    }

    private byte[] retKey(boolean debug) { //Load the key file
        byte[] encKey = null;
        if (!debug) {
            try (FileInputStream keyFis = new FileInputStream("C:\\RTC\\lockdown\\data.key")) {
                encKey = new byte[keyFis.available()];
                keyFis.read(encKey);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Key doesn't exist", "Decryption Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Key cannot be loaded\nPlease make sure you have the correct file permissions.", "Decryption Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
            }
        } else {
            try (FileInputStream keyFis = new FileInputStream("C:\\RTC\\debug\\data.key")) {
                encKey = new byte[keyFis.available()];
                keyFis.read(encKey);
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Key doesn't exist", "Decryption Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Key cannot be loaded\nPlease make sure you have the correct file permissions.", "Decryption Error", JOptionPane.ERROR_MESSAGE);
                System.out.println(ex);
            }
        }
        return encKey;
    }

    public byte[] getKey() {
        return retKey(false);
    }

    //Decrypt any information with the key generated
    private String decrypt(String path, String file, boolean debug) throws Exception {
        Key keyFromFile = new SecretKeySpec(retKey(debug), "DES"); //Load key
        File verify = new File(path + file);
        if (!verify.exists()) {
            verify.createNewFile();
        }
        byte[] encText = null;
        try (FileInputStream encryptedText = new FileInputStream(path + file)) {

            encText = new byte[encryptedText.available()];
            encryptedText.read(encText);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Security.class.getName()).log(Level.SEVERE, null, ex);
        } //Load encrypted text

        Cipher decrypter = Cipher.getInstance("DES/ECB/PKCS5Padding");
        decrypter.init(Cipher.DECRYPT_MODE, keyFromFile);
        // Prepare decryptor

        byte[] decryptedText = decrypter.doFinal(encText); //Decrypt text
        return new String(decryptedText); //Return decrypted text as string
    }

    public String[] decDetails(String file) throws Exception {
        return decrypt("C:\\RTC\\UserInfo\\", file + ".dat", false).split("##");
    }

    public String decSLineFile(String folder, String file) throws Exception {
        return decrypt("C:\\RTC\\" + folder + "\\", file, false);
    }

    public void deleteTemp(String folder, String file) throws Exception {
        File temp = new File("C:\\RTC\\" + folder + "\\" + file);
        if (temp.exists()) {
            temp.delete();
        }
    }

    public void encDetails(String input, String file) throws Exception {
        encrypt("C:\\RTC\\UserInfo\\", file + ".dat", input + "##");
    }

    public String decAll(String input, String file, boolean debug) throws Exception {
        return decrypt(input, file, debug); //Dectrypt a file with input and file path, then return as plain text string
    }

    public String getAdminPassword() throws Exception {
        return decrypt("C:\\RTC\\lockdown\\", "data.dat", false);
    }

    //User Administrative Methods
    //Get User Admin Password
    public String getUserAdminPassword(String username) throws Exception {
        return decrypt("C:\\RTC\\data\\", username + ".txt", false);
    }

    //Add a new User Admin
    public void addUserAdmin(String path, String username, String input) {
        try {
            encrypt(path, username + ".txt", input);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error Code: W2\nThe admin wasn't created" + e, "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Set a new User Admin Password
    public void setUserAdminPassword(String username, String input) throws Exception {
        encrypt("C:\\RTC\\data\\", username + ".txt", input);
    }

    //Password recovery
    public String genCode() {
        String value = UUID.randomUUID().toString();
        try {
            encrypt("C:\\RTC\\data\\", "recovery.key", value);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return value;
    }

    public String getRecovery() {
        String get = "";
        try {
            get = decrypt("C:\\RTC\\data\\", "recovery.key", false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
        }
        return get;
    }

    public void encSettings(String input) {
        try {
            encrypt("C:\\RTC\\Data\\", "settings.dat", input);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error Saving Settings!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String decSettings() {
        String set = "";
        try {
            set = decrypt("C:\\RTC\\Data\\", "settings.dat", false);
        } catch (Exception ignore) {

        }
        return set;
    }

    public void encWords(String input) {
        try {
            encrypt("C:\\RTC\\UserInfo\\", "Ben.dat", input);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Error Saving Settings!", JOptionPane.ERROR_MESSAGE);
        }
    }
}
