package GUI;

import Code.Details;
import loader.MemberLoader;
import model.User;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import Code.Security;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author reece8765
 */
public class AddMember extends javax.swing.JFrame {

    JTable memberTable;
    private final String en = Security.encryption;

    private final MemberLoader memberLoader = new MemberLoader();
    private ArrayList<User> memberList = new ArrayList<>();

    private final UserAdminUI mw;

    public AddMember(UserAdminUI mw) {
        this.mw = mw;
        initComponents();
    }
    User user = new User();
    Security sec = new Security();
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtUserID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtPhoneNumber = new javax.swing.JTextField();
        btnCreateUser = new javax.swing.JButton();
        btnCancelUser = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        pswNewPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Create a Security Member");
        setType(java.awt.Window.Type.UTILITY);

        jLabel1.setText("User ID:");

        jLabel2.setText("Name:");

        jLabel3.setText("Password:");

        jLabel4.setText("Phone Number: 07");

        btnCreateUser.setText("Create Member");
        btnCreateUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCreateUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateUserActionPerformed(evt);
            }
        });

        btnCancelUser.setText("Cancel");
        btnCancelUser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelUserActionPerformed(evt);
            }
        });

        jLabel5.setText("Address:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCreateUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(btnCancelUser))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAddress))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPhoneNumber))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtUserID)
                                .addGap(25, 25, 25)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtName))
                            .addComponent(pswNewPass))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pswNewPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPhoneNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelUser)
                    .addComponent(btnCreateUser))
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
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelUserActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelUserActionPerformed

    public void saveMember() {
        //Initialize
        boolean valid;
        boolean idValid = true;
        try {
            String[] membersList = sec.decDetails("members");
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }
        } catch (Exception ex) {
            Logger.getLogger(AddMember.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Create new object
        Object[][] data = new Object[memberList.size()][6];

        //Read the members ID from members list (Comparing to see if the ID exists)
        for (int i = 0; i < memberList.size(); i++) {
            User compare = memberList.get(i);
            data[i][0] = compare.getId();
            //If this ID exists already, cancel the operation.
            idValid = !data[i][0].equals(txtUserID.getText());
        }

        String temp = String.valueOf(pswNewPass.getPassword());
        valid = !temp.contains("-") || !temp.equals("");

        temp = null;

        //If everything is OK, append the new user to the file.
        if (valid && idValid) {
            String id = String.valueOf(user.getId());
            String name = user.getName();
            String address = user.getAddress();
            String phone = String.valueOf(user.getPhone());
            String pass = user.getPassword();
            String balance = String.valueOf(user.getBalance());
            String active = String.valueOf(user.getActive());
            //Try to write the above information to the file.
            StringBuilder build = new StringBuilder();
            build.append(id).append(en).append(name).append(en).append(address).append(en).append(phone).append(en).append(pass).append(en).append(balance).append(en).append(active);
            try {
                sec.encDetails(String.valueOf(build), "members");
            } catch (Exception ex) {
                Logger.getLogger(AddMember.class.getName()).log(Level.SEVERE, null, ex);
            }

            mw.addMemberToList(user);
            mw.displayMembers();
            this.dispose();
        } else if (!idValid) {
            JOptionPane.showMessageDialog(this, "Cannot create user: ID already exists", "User Error", JOptionPane.ERROR_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Password contains an illegal character.", "Password Warning", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void btnCreateUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateUserActionPerformed
        String ID = txtUserID.getText();
        String userName = txtName.getText();
        String phoneNumber = txtPhoneNumber.getText();
        String address = txtAddress.getText();
        char[] pass = pswNewPass.getPassword();
        String passWord = String.valueOf(pass);
        int active = 1;
        String By = Details.LoggedOn;

        //A username cannot be left blank and cannot be the name of anything reserved. This checks
        if (!userName.equals("null") || !userName.equals("")) {
            user.setId(ID);
            user.setPhone(phoneNumber);
            user.setName(userName);
            user.setAddress(address);
            user.setPassword(passWord);
            user.setBalance("0.0");
            user.setActive(active);
            sec.saveLog("User " + ID + ": " + userName + " was added by " + By + ".");
            saveMember();
        } else {
            JOptionPane.showMessageDialog(this, "The username " + userName + " is reserved and cannot be used.", "User Error", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCreateUserActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelUser;
    private javax.swing.JButton btnCreateUser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField pswNewPass;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPhoneNumber;
    private javax.swing.JTextField txtUserID;
    // End of variables declaration//GEN-END:variables
}
