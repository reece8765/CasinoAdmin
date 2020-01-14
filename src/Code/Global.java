package Code;

import javax.swing.JOptionPane;

/**
 *
 * @author reece8765
 */
public class Global {

    public static boolean admin, passwd, ftime, sActivated = false;
    public final static boolean reset = false;
    public static final boolean test = false;
    public static final String currentVersion = "V1.1.1";
    public static final String usrMgmtVersion = "V3.0";
    public static double balance;
    public static String SName;

    Security sec = new Security();

    private String error(int errorCode) {
        switch (errorCode) {
            case 1:
                return "Critical files failed to load! Error Code: 4000";
            case 2:
                return "Decryption Key Files Not Found! Error Code: 4001";
            case 3:
                return "Access Remote is currently undergoing maintenance, please try again later. Error Code: 4002";
            case 4:
                return "Couldn't determine update status... Error Code: 4003";
            case 5:
                return "Couldn't write required files... Error Code: 4004";
            case 6:
                return "This application requires the latest updates.\nYou must be online and able to access the website 'accessremote.uk'\nMake sure you're connected and try again.";
            case 7:
                return "The credentials you entered were incorrect. Error Code: 4006";
            case 8:
                return "Update Failed. Error Code: 4007";
            case 9:
                return "Invalid Input. Error Code: 4008";
            case 10:
                return "Your User Account has been Disabled by your Administrator\n"
                        + "Please seek advice from your admin.";
            case 11:
                return "Transaction Cancelled.\nMake sure you have enough funds.";
            default:
                return "An unknown error occured... (5000)";
        }
    }

    private String inform(int errorCode) {
        switch (errorCode) {
            case 1:
                return "New Device Detected! Administrative configuration required.\n"
                        + "Please see your System Administrator for access.";
            case 2:
                return "Transaction was successful!";
            default:
                return "An unknown error occured (5000)";
        }
    }

    private String warn(int errorCode) {
        switch (errorCode) {
            case 1:
                return "This action was disabled by the software developer.";
            default:
                return "An unknown error occured (5000)";
        }
    }

    public void displayMessage(int errorCode, String mode) {
        switch (mode) {
            case "Error":
                JOptionPane.showMessageDialog(null, error(errorCode), "Error", JOptionPane.ERROR_MESSAGE);
                break;
            case "Inform":
                JOptionPane.showMessageDialog(null, inform(errorCode), "Important!", JOptionPane.INFORMATION_MESSAGE);
                break;
            case "Warn":
                JOptionPane.showMessageDialog(null, warn(errorCode), "Notice", JOptionPane.WARNING_MESSAGE);
                break;
            default:
                JOptionPane.showMessageDialog(null, "This error is for the developers.\n"
                        + "There appears to be a misconfiguration, the program didn't pass a valid argument.\n"
                        + "The correct message could not be displayed...", "Invalid Message Code!", JOptionPane.ERROR_MESSAGE);
                break;
        }

    }

    public void save(String settings) {
        sec.encSettings(settings);
    }
}
