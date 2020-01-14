package loader;

import Code.Security;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.User;

public class MemberLoader {

    private final ArrayList<User> members = new ArrayList();

    public ArrayList<User> loadMember(String input) {
        try { //Read the line
            String[] parts = input.split(Security.encryption); //Split the string into parts when it picks up the character(s) stored in that variable
            User member = new User(); //Create a new user called "member"
            member.setId(parts[0].replaceAll("\\p{C}", ""));
            member.setName(parts[1]);
            member.setAddress(parts[2]);
            member.setPhone(parts[3]);
            member.setPassword(parts[4]);
            member.setBalance(parts[5]);
            member.setActive(Integer.parseInt(parts[6]));
            members.add(member);
        } catch (NumberFormatException exp) {
            JOptionPane.showMessageDialog(null, exp + "\n"
                    + "If you have no members, you can ignore this message.", "Error during load user process!", JOptionPane.ERROR_MESSAGE);
        }
        return members;
    }

}
