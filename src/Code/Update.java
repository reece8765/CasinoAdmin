//DON'T FORGET TO UPDATE THIS CODE, THE METHOD CHECK() CURRENTLY RETURNS FALSE REGARDLESS - FOR TESTING.
package Code;

import Update.UpdateUI;
import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.io.*;
import java.net.*;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

/**
 *
 * @author reece
 */
public class Update {

    Global message = new Global();
    Security sec = new Security();
    private String newVer;

    public void remOld() {
        File oldUpdate = new File("Update.jar");
        if (oldUpdate.exists()) {
            oldUpdate.delete();
            sec.saveLog("The software has been successfully updated!");
        }
    }

    public boolean check() throws Exception {
        URL url = new URL("https://accessremote.uk/RTC/adminVer.txt");
        Scanner s = new Scanner(url.openStream());
        newVer = s.nextLine();
        if (newVer.length() > 10) {
            return false;
        }
        return !newVer.equals(Global.currentVersion);
        //return false;
    }

    public void available(JFrame mw) {
        sec.saveLog(newVer + " is now available!");
        int res = JOptionPane.showConfirmDialog(mw, "This software must be updated before you can continue. Update now?\n" + newVer, "Update Found!", JOptionPane.YES_NO_OPTION);
        if (res == 1) {
            mw.dispose();
        } else {
            UpdateUI update = new UpdateUI();
            update.setVisible(true);
            try {
                download(update);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
            }
            mw.dispose();
        }
    }

    public void download(UpdateUI mw) throws Exception {
        sec.saveLog("The admin software is being updated...");
        URL website = new URL("https://accessremote.uk/media/software/update/updater.jar");
        mw.prgInstall.setValue(10);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("update.jar");
        mw.prgInstall.setValue(30);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        mw.prgInstall.setValue(80);
        URL app = new URL("https://accessremote.uk/media/software/update/CasinoAdmin.jar");
        FileOutputStream fos2 = new FileOutputStream("new.download");
        ReadableByteChannel rbc2 = Channels.newChannel(app.openStream());
        fos2.getChannel().transferFrom(rbc2, 0, Long.MAX_VALUE);
        //text file, should be opening in default text editor
        sec.saveLog("Installing update...");
        mw.prgInstall.setValue(100);
        install(mw);
    }

    public void install(UpdateUI mw) throws IOException {
        if (!Desktop.isDesktopSupported()) {
            message.displayMessage(8, "Error");
        } else {
            Runtime.getRuntime().exec("java -jar update.jar 2");
        }
        mw.dispose();
    }
}
