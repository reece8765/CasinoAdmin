package GUI;

import loader.MemberLoader;
import loader.NotesLoader;
import model.Notes;
import model.User;
import Code.Security;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reece8765
 */
public class Edit extends javax.swing.JFrame {

    Security sec = new Security();
    private final int mode;
    private final UserAdminUI mw;
    private final int row;
    private MemberLoader memberLoader = new MemberLoader();
    private ArrayList<User> memberList = new ArrayList<>();

    private NotesLoader notesLoader = new NotesLoader();
    private ArrayList<Notes> notesList = new ArrayList<>();
    int booksBorrowed;
    String status;
    String bookedTo;
    LocalDate returnDate;
    private String password;
    Object[][] data = new Object[1][7];

    public Edit(UserAdminUI mw, int mode, int row) {
        initComponents();
        this.row = row;
        this.mode = mode;
        this.mw = mw;

        try {
            String[] membersList = sec.decDetails("members");
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddMember.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String[] noteList = sec.decDetails("notes");
            for (int i = 0; i < noteList.length; i++) {
                notesList = notesLoader.loadNotes(noteList[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddMember.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (mode) {
            case 2:
                User user = memberList.get(row);
                data[0][0] = user.getId();
                data[0][1] = user.getName();
                data[0][2] = user.getAddress();
                data[0][3] = user.getPhone();
                data[0][4] = user.getActive();
                data[0][5] = user.getPassword();
                data[0][6] = user.getBalance();
                password = String.valueOf(data[0][5]);

                lblIDISBN.setText("ID: ");
                lblTitleName.setText("Name: ");
                lblAuthAdd.setText("Address: ");
                lblPubPhone.setText("Phone: 07");
                lblPubDate.setVisible(false);
                txtIDISBN.setEditable(false);
                txtPubDate.setEnabled(false);
                chkMemberActive.setEnabled(true);
                if (Integer.parseInt(String.valueOf(data[0][4])) == 1) {
                    chkMemberActive.setSelected(true);
                }
                txtIDISBN.setText(String.valueOf(data[0][0]));
                txtTitleName.setText(String.valueOf(data[0][1]));
                txtAuthAdd.setText(String.valueOf(data[0][2]));
                txtPubPhone.setText(String.valueOf(data[0][3]));
                txtPubDate.setVisible(false);
                break;

            case 3:
                lblIDISBN.setText("ID: ");
                lblTitleName.setText("User: ");
                lblAuthAdd.setText("Title: ");
                lblPubPhone.setText("Message: ");
                lblPubDate.setText("N/A");
                txtIDISBN.setEnabled(false);
                txtTitleName.setEnabled(false);
                txtPubDate.setEnabled(false);

                Object[][] noteData = new Object[1][4];
                Notes note = notesList.get(row);
                noteData[0][0] = note.getId();
                noteData[0][1] = note.getUser();
                noteData[0][2] = note.getTitle();
                noteData[0][3] = note.getMessage();

                txtIDISBN.setText(String.valueOf(noteData[0][0]));
                txtTitleName.setText(String.valueOf(noteData[0][1]));
                txtAuthAdd.setText(String.valueOf(noteData[0][2]));
                txtPubPhone.setText(String.valueOf(noteData[0][3]));
                txtPubDate.setText("Not applicable for this type of data.");
                break;
            default:
                break;
        }
    }

    private void update() {
        String ID;
        String Name;
        String Address;
        String Phone;
        String Title;
        String Message;
        String User;
        double balance;
        int activeInt;
        boolean active;
        switch (mode) {
            case 2:
                ID = txtIDISBN.getText();
                Name = txtTitleName.getText();
                Address = txtAuthAdd.getText();
                Phone = txtPubPhone.getText();
                active = (chkMemberActive.isSelected());
                balance = Double.parseDouble(String.valueOf(data[0][6]));
                if (active) {
                    activeInt = 1;
                } else {
                    activeInt = 0;
                }
                //ID, Name, Address, Phone, password, balance, active, row
                mw.editMember(ID, Name, Address, Phone, password, balance, activeInt, row);
                mw.displayMembers();
                break;
            case 3:
                ID = txtIDISBN.getText();
                User = txtTitleName.getText();
                Title = txtAuthAdd.getText();
                Message = txtPubPhone.getText();
                mw.editNote(ID, User, Title, Message, row);
                break;
            default:
                break;
        }
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIDISBN = new javax.swing.JLabel();
        lblTitleName = new javax.swing.JLabel();
        lblAuthAdd = new javax.swing.JLabel();
        lblPubPhone = new javax.swing.JLabel();
        lblPubDate = new javax.swing.JLabel();
        txtIDISBN = new javax.swing.JTextField();
        txtTitleName = new javax.swing.JTextField();
        txtAuthAdd = new javax.swing.JTextField();
        txtPubPhone = new javax.swing.JTextField();
        txtPubDate = new javax.swing.JTextField();
        btnUpdate = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        chkMemberActive = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit Member");
        setResizable(false);

        lblIDISBN.setText("ID:");

        lblTitleName.setText("jLabel2");

        lblAuthAdd.setText("jLabel3");

        lblPubPhone.setText("jLabel4");

        lblPubDate.setText("jLabel5");

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        chkMemberActive.setText("Enable Access");
        chkMemberActive.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdate))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblAuthAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtAuthAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPubPhone)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPubPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPubDate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblTitleName)
                                    .addComponent(lblIDISBN))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtIDISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTitleName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(chkMemberActive))
                        .addGap(0, 50, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIDISBN)
                    .addComponent(txtIDISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitleName)
                    .addComponent(txtTitleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAuthAdd)
                    .addComponent(txtAuthAdd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPubPhone)
                    .addComponent(txtPubPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPubDate)
                    .addComponent(txtPubDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkMemberActive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancel)
                    .addComponent(btnUpdate))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        update();
    }//GEN-LAST:event_btnUpdateActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JCheckBox chkMemberActive;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblAuthAdd;
    private javax.swing.JLabel lblIDISBN;
    private javax.swing.JLabel lblPubDate;
    private javax.swing.JLabel lblPubPhone;
    private javax.swing.JLabel lblTitleName;
    private javax.swing.JTextField txtAuthAdd;
    private javax.swing.JTextField txtIDISBN;
    private javax.swing.JTextField txtPubDate;
    private javax.swing.JTextField txtPubPhone;
    private javax.swing.JTextField txtTitleName;
    // End of variables declaration//GEN-END:variables
}
