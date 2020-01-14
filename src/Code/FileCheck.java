package Code;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;
import javax.swing.JOptionPane;

/**
 *
 * @author Reece
 */
public class FileCheck {

    Global message = new Global();

    public boolean getFile() {
        String read = "";
        try {
            FileReader file = new FileReader("F:\\RTC\\keyCode.sec");
            BufferedReader reader = new BufferedReader(file);
            read = reader.readLine();
            file.close();
            reader.close();
        } catch (IOException e) {
            message.displayMessage(2, "Error");
        }
        Security valid = new Security();
        return valid.verify(read);
    }

    public void write() {
        Security comp = new Security();
        String value = UUID.randomUUID().toString();

        try {
            FileWriter store = new FileWriter("C:\\RTC\\lockdown\\keyCode.sec");
            BufferedWriter writer = new BufferedWriter(store);
            store.write(value);
            store.close();
            writer.close();
        } catch (IOException e) {
            message.displayMessage(2, "ERROR");
        }

        try {
            FileWriter file2 = new FileWriter("F:\\RTC\\keyCode2.sec");
            BufferedWriter reader2 = new BufferedWriter(file2);
            file2.write(comp.getCompName());
            file2.close();
            reader2.close();
        } catch (IOException e) {
            message.displayMessage(5, "ERROR");
        }

        try {
            FileWriter store = new FileWriter("F:\\RTC\\keyCode.sec");
            BufferedWriter writer = new BufferedWriter(store);
            store.write(value);
            store.close();
            writer.close();
        } catch (IOException e) {
            message.displayMessage(5, "ERROR");
        }
    }

    public boolean mkDir() {
        boolean successTot = false;
        boolean success = (new File("F:\\RTC")).mkdirs();
        if (success) {
            message.displayMessage(1, "Inform");
        }

        boolean success2 = (new File("C:\\RTC\\lockdown")).mkdirs();
        if (!success2) {
            // Directory creation failed (Might already exist?)
        }

        boolean success3 = (new File("C:\\RTC\\data")).mkdirs();
        if (!success3) {
            // Directory creation failed, probably already there.
        }
        boolean success4 = (new File("C:\\RTC\\UserInfo")).mkdirs();
        if (!success4) {
            // Directory creation failed, probably already there.
        }
        if (success4) {
            try {
                File file = new File("C:\\RTC\\UserInfo\\members.dat");
                //Tell java to write to the file defined above using the filewriter we created above.
                FileWriter fileWriter = new FileWriter(file, false);

                //Always wrap this into a buffered writer, this helps make thins run smoothly.
                BufferedWriter bw = new BufferedWriter(fileWriter);
                bw.write("");
                bw.close();
            } catch (IOException er) {
                JOptionPane.showMessageDialog(null, er, "Warning during setup!", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (success2 | success3) {
            successTot = true;
        }
        return successTot;
    }
}
