package loader;

import Code.Security;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import model.Notes;

public class NotesLoader {

    private final ArrayList<Notes> note = new ArrayList<>();

    public ArrayList<Notes> loadNotes(String input) {
        try {
            String[] parts = input.split(Security.encryption);
            Notes notes = new Notes();
            notes.setId(parts[0].replaceAll("\\p{C}", ""));
            notes.setUser(parts[1]);
            notes.setTitle(parts[2]);
            notes.setMessage(parts[3]);
            note.add(notes);
        } catch (NumberFormatException exp) {
            JOptionPane.showMessageDialog(null, exp + "\n"
                    + "If you have no notes, you can ignore this message.", "Error during load notes process!", JOptionPane.ERROR_MESSAGE);
        }
        return note;

    }

}
