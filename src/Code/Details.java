/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import loader.MemberLoader;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author reece8765
 */
public class Details {

    JTable memberTable;
    Security security = new Security();

    private final MemberLoader memberLoader = new MemberLoader();
    private ArrayList<User> memberList = new ArrayList<>();

    public static String LoggedOn;
    public static String USRTYPE;
    public static final String url = "https://accessremote.uk";

    public int passWord(String username, char[] pass) {
        int retVal = 0;
        String strPassword;

        try {
            strPassword = security.getUserAdminPassword(username);
            char[] correctPass = strPassword.toCharArray();

            if (Arrays.equals(pass, correctPass)) {
                retVal = 4;

            } else {
                retVal = 2;
            }
        } catch (Exception ERR) {
            retVal = 3;
        }
        strPassword = "";
        return retVal;
    }

    public double getPercentage(int total, int i) {
        return (1.0f * i / total) * 100;
    }

    public boolean addAdmin(String username, String password) {
        boolean created = false;
        if (USRTYPE.equals("Admin")) {
            File newAdmin = new File("C:\\RTC\\UserInfo\\" + username + ".txt");
            if (newAdmin.exists()) {
                JOptionPane.showMessageDialog(null, "Cannot overwrite this admin!", "Admin Exists", JOptionPane.WARNING_MESSAGE);
                created = false;
            } else {
                try {
                    security.addUserAdmin("C:\\RTC\\data\\", username, password);
                    created = true;
                } catch (Exception e) {
                    created = false;
                }
            }
            username = null;
            password = null;
        } else {
            JOptionPane.showMessageDialog(null, "You do not have permission to add a new Admin.", "Access Denied", JOptionPane.ERROR_MESSAGE);
        }
        return created;
    }

    public int changePassword(String username, char oldPassword[], char newPassword[]) {
        int retVal = 0;
        if (USRTYPE.equals("Admin")) {
            String strPassword = "";
            try {
                strPassword = security.getUserAdminPassword(username);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e, "Admin Password Fault", JOptionPane.ERROR_MESSAGE);
            }
            char[] correctPass = strPassword.toCharArray();

            if (newPassword.length < 4) {
                retVal = 1;
            }
            if (Arrays.equals(oldPassword, correctPass) && newPassword.length >= 4 && retVal != 1) {
                retVal = 4;
                String get = String.valueOf(newPassword);
                try {
                    security.setUserAdminPassword(username, get);
                } catch (Exception err) {
                    JOptionPane.showMessageDialog(null, err, "ERROR", JOptionPane.ERROR_MESSAGE);
                }

            } else if (retVal != 1) {
                retVal = 2;
            }
            strPassword = null;
        } else {
            String[] membersList = {""};
            try {
                membersList = security.decDetails("members");
            } catch (Exception ex) {
                Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
            }
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }
            Object[][] data = new Object[memberList.size()][7];
            for (int i = 0; i < memberList.size(); i++) {
                User member = memberList.get(i);
                data[i][0] = member.getId();
                data[i][1] = member.getPassword();
                if (username.equals(data[i][0]) && String.valueOf(oldPassword).equals(data[i][1])) {
                    FileWriter write = null;
                    try {
                        member.setPassword(String.valueOf(newPassword));
                        File file = new File("C:\\RTC\\UserInfo\\members.dat");
                        write = new FileWriter(file, false);
                        BufferedWriter writer = new BufferedWriter(write);
                        writer.write("");
                        writer.close();
                        write.close();
                        for (int j = 0; j < memberList.size(); j++) {
                            User save = memberList.get(j);
                            data[j][0] = save.getId();
                            data[j][1] = save.getName();
                            data[j][2] = save.getAddress();
                            data[j][3] = save.getPhone();
                            data[j][4] = save.getPassword();
                            data[j][5] = save.getBalance();
                            data[j][6] = save.getActive();
                            StringBuilder build = new StringBuilder();
                            build.append(data[j][0]).append(Security.encryption).append(data[j][1]).append(Security.encryption).append(data[j][2]).append(Security.encryption).append(data[j][3]).append(Security.encryption).append(data[j][4]).append(Security.encryption).append(data[j][5]).append(Security.encryption).append(data[j][6]).append(Security.encryption);
                            try {
                                security.encDetails(String.valueOf(build), "members");
                            } catch (Exception ex) {
                                Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                        retVal = 4;
                    } catch (IOException ex) {
                        Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
                    } finally {
                        try {
                            write.close();
                        } catch (IOException ex) {
                            Logger.getLogger(Details.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                } else if (newPassword.length < 4) {
                    retVal = 1;
                } else {
                    retVal = 0;
                }
            }
        }
        return retVal;
    }
//NEEDS MODIFYING

    public int memLogin(String ID) {
        //By defualt, if no conditions are met, return the value 2 (user doesn't exist).
        int retVal = 2;
        try {
            //Assign whatever is in the members.txt file into the memberList variable.
            String[] membersList = security.decDetails("members");
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }

            //Try to read the memberList variable, assigning it into a virtual gird or "table".
            Object[][] data = new Object[memberList.size()][1];
            for (int i = 0; i < memberList.size(); i++) {
                User member = memberList.get(i);
                data[i][0] = member.getId();
                //This will assign the member details to the system if, and only if, the member ID is a match.
                if (data[i][0].equals(ID)) {
                    retVal = 1;
                    USRTYPE = "Member";
                    LoggedOn = member.getId();

                }
            }
        } catch (Exception ex) {
            Logger.getLogger(Details.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        //Return code value
        return retVal;
    }

    public boolean validateString(String input) {
        return input.matches("[a-zA-Z]{3,10}");
    }

    public boolean validateURL(String URL) {
        /*try {
            InetAddress address = InetAddress.getByName(URL);
            return (address.isReachable(10000));
        } catch (IOException ignore) {
            System.out.println(ignore);
            return false;
        }
*/
        return true;
    }
}
