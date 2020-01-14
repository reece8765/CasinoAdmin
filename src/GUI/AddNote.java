package GUI;

import Code.Security;
import loader.MemberLoader;
import loader.NotesLoader;
import model.Notes;
import model.User;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author reece
 */
public class AddNote extends javax.swing.JFrame {

    JTable notesTable;

    private final NotesLoader notesLoader = new NotesLoader();
    private ArrayList<Notes> notesList = new ArrayList<>();

    private final MemberLoader memberLoader = new MemberLoader();
    private ArrayList<User> memberList = new ArrayList<>();

    private final UserAdminUI mw;
    private final String en = Security.encryption;

    public AddNote(UserAdminUI mw) {
        this.mw = mw;
        initComponents();
    }
    Notes note = new Notes();
    Security sec = new Security();

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNoteID = new javax.swing.JTextField();
        txtUserID = new javax.swing.JTextField();
        txtNoteTitle = new javax.swing.JTextField();
        btnCreateUser = new javax.swing.JButton();
        btnCancelUser = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtNote = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create a Member");

        jLabel1.setText("Note ID");

        jLabel2.setText("User ID");

        jLabel4.setText("Note Title:");

        btnCreateUser.setText("Create Note");
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        btnCancelUser.setText("Cancel");
        btnCancelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUserActionPerformed(evt);
            }
        });

        jLabel5.setText("Note:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel5))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoteTitle)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNoteID, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnCreateUser)
                                .addGap(30, 30, 30)
                                .addComponent(btnCancelUser))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtNote))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNoteID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtNoteTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNote, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelUser)
                    .addComponent(btnCreateUser))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUserActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelUserActionPerformed

    public void saveNote() {
        boolean valid = true;
        boolean userValid = false;
        try {
            String[] membersList = sec.decDetails("members");
            for (String membersList1 : membersList) {
                memberList = memberLoader.loadMember(membersList1);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String[] noteList = sec.decDetails("notes");
            for (String noteList1 : noteList) {
                notesList = notesLoader.loadNotes(noteList1);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddMember.class.getName()).log(Level.SEVERE, null, ex);
        }

        Object[][] data = new Object[notesList.size()][1];
        Object[][] user = new Object[memberList.size()][1];

        for (int i = 0; i < notesList.size(); i++) {
            Notes compare = notesList.get(i);
            data[i][0] = compare.getId();

            if (data[i][0].equals(note.getId())) {
                valid = false;
            }
        }

        for (int i = 0; i < memberList.size(); i++) {
            User compare = memberList.get(i);
            user[i][0] = compare.getId();

            if (user[i][0].equals(txtUserID.getText())) {
                userValid = true;
            }
        }

        if (valid == true && userValid == true) {
            StringBuilder build = new StringBuilder();
            build.append(note.getId()).append(en).append(note.getUser()).append(en).append(note.getTitle()).append(en).append(note.getMessage());
            try {
                sec.encDetails(String.valueOf(build), "notes");
            } catch (Exception ex) {
                Logger.getLogger(AddNote.class.getName()).log(Level.SEVERE, null, ex);
            }
            mw.addNotesToList(note);
            mw.displayNotes();
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Cannot create note: ID already exists or User ID is invalid", "Failed to create note", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void check() {
        String ID = txtNoteID.getText();
        String userName = txtUserID.getText();
        String noteTitle = txtNoteTitle.getText();
        String Note = txtNote.getText();

        //A username cannot be left blank and cannot be the name of anything reserved. This checks
        if (!ID.equals("null") | !ID.equals("") && !userName.equals("") && !noteTitle.equals("") && !Note.equals("")) {
            note.setId(ID);
            note.setUser(userName);
            note.setTitle(noteTitle);
            note.setMessage(Note);
            saveNote();
        } else {
            JOptionPane.showMessageDialog(this, "Please make sure all boxes are filled in and they don't conflict with existing notes.", "Notes Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        check();
    }//GEN-LAST:event_btnCreateUserActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelUser;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtNote;
    private javax.swing.JTextField txtNoteID;
    private javax.swing.JTextField txtNoteTitle;
    private javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
