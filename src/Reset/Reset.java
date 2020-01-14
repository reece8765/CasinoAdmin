package Reset;

import Code.Security;
import GUI.FirstTime;
import javax.swing.JOptionPane;

/**
 *
 * @author reece8765
 */
public class Reset {

    Security code = new Security();

    public boolean verify(String input) {
        boolean valid = false;
        String key = code.getRecovery();
        if (!key.equals("")) {
            if (input.equals(key)) {
                valid = true;
                erase();
            } else {
                JOptionPane.showMessageDialog(null, "Incorrect recovery key.", "Security Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return valid;
    }

    private void erase() {
        code.encSettings("1e 1d ");
        try {
            code.setAdminPass("Password5");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Password was NOT reset!\n" + e, "Critical error", JOptionPane.ERROR_MESSAGE);
        }
        new FirstTime().setVisible(true);
    }
}
