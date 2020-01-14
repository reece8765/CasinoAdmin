/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Code.Security;
import Code.FileCheck;
import Code.Global;
import Logs.LogLoaderUI;
import Notifications.HelpGUI;
import Server.ServerUI;
import static java.lang.Thread.State.TERMINATED;

/**
 *
 * @author reece8765
 */
public class MasterUI extends javax.swing.JFrame {

    Security security = new Security();
    FileCheck file = new FileCheck();
    Global settings = new Global();
    String newSettings;

    /**
     * Creates new form temp
     */
    public MasterUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAdminInfo = new javax.swing.JTextPane();
        jPanel1 = new javax.swing.JPanel();
        btnGen = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnTest = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        pswSetAdmin = new javax.swing.JPasswordField();
        btnSetAdminPass = new javax.swing.JButton();
        lblStatus = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jPanel4 = new javax.swing.JPanel();
        btnAddUserAdmin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btnAdminResetPsw = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        btnAddFunds = new javax.swing.JButton();
        btnChargeAccount = new javax.swing.JButton();
        btnSetBalance = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCredit = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnBalance = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuLog = new javax.swing.JMenuItem();
        mnuServer = new javax.swing.JMenuItem();
        mnuDebug = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        mnuSignOut = new javax.swing.JMenuItem();
        mnuExit = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administrative Mater Panel");
        setResizable(false);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.BOTTOM);
        jTabbedPane1.setToolTipText("");

        txtAdminInfo.setEditable(false);
        txtAdminInfo.setText("Welcome to the Admin Settings page!\n\nHere you can do the following:\n-Add User Admins\n-Delete a User Admin\n-Reset a User Admin's password\n-Generate (or regenerate) USB security keys\n-Set the Admin Password\n-Enable Server\n-Manage Account Balances\n\nHere's some information:\n\nUSB KEY FILE\n----------------\n\nA USB Key File is generated and stored on Drive F. This key file is used to verify low-level authority to gain access to the Standard User Interface or the Admin Settings logon page.\nWithout this verification, you will be denied access unless you have your recovery key. Loss of all security measures may result in being locked out.\n\nWhat's stored on the USB Key?\nA Universal Unique Identidentification (UUID) string is stored along with the name of the current PC is contained within these files. This is to create difficulty for attackers, though it's easy to replicte and bypass.\nThe use of the key file is only for first identification and may be copied to appropiate members of your team.\nThese security files remain in plain text as it doesn't bypass any passwords. An attacker can only gain access to the Standard User Interface, which requires a username or password to proceed further.\n\nFor more information about this application, please refer to the documentation provided for \"Casino Admin\".\nIf a policy, setting or other feature does not work correctly - chances are, we already know about it. You can check for updates within this application to see if this software is up to date.\nThis application will let you know of any updates automatically, and so you must be online for this application to function correctly.\n\nAdmin Vs. User\n------------------\nThe build in admin account can add or remove other admin accounts with master control. Admin accounts can't add or remove other admin accounts, only the master admin account can do this.\nAdmin accounts (except the built-in admin) may add or remove user accounts which is used for the casino application. User Admin accounts cannot use this application.\n\nAdding funds to user accounts\n------------------\nTo add funds to the end user, an Account Admin must have a balance, otherwise known as a \"float balance\". The float balance is used to help owners, admins or management teams with their banking (if applicable). A user admin can add funds to end users out of their own float balance. Each User Admin had their own float balance which can be increased, decreased or reset to any amount by the master account. Records of adding or removing funds to the User Admin accounts are logged for security purposes and later financial information (if applicable).");
        txtAdminInfo.setToolTipText("");
        txtAdminInfo.setAutoscrolls(false);
        txtAdminInfo.setCaretPosition(0);
        txtAdminInfo.setFocusable(false);
        jScrollPane1.setViewportView(txtAdminInfo);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Admin Information", jPanel2);

        btnGen.setText("Generate");
        btnGen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenActionPerformed(evt);
            }
        });

        jLabel1.setText("If you don't have a USB token, please generate one with this button:");

        jLabel2.setText("To test you USB key works with this computer, click the following button:");

        btnTest.setText("Test");
        btnTest.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTestActionPerformed(evt);
            }
        });

        jLabel3.setText("Your Password: ");

        btnSetAdminPass.setText("Override");
        btnSetAdminPass.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSetAdminPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetAdminPassActionPerformed(evt);
            }
        });

        lblStatus.setText("Waiting for Test to check USB/Drive...");

        btnHelp.setText("Help");
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setText("Hello! Access Remote has developed this area for security purposes. This area is all to do with security, where you can override your old password, generate USB keys or simply test thinkgs work.\n\nEXPLANATION\n-----------------\nGenerating a USB Key:\nA USB must be present in this computer at all times when using the \"Casino Admin\" application - this is the first layer of security, so the end user can't tamer around so easy. These keys are easy to replicate, however it's more likely that the user will be caught in the process. So although unsecure, it slows down the replication of the key. \nThis isn't secure and shouldn't be considered as a major security factor. You may copy the contents of a USB key to other USB devices and use the new devices as first factor authorisation for this machine.\n\nOverriding your password:\nThis is the Master account password which is overwritten. You may do so without confirming your identity upon first use of the software, or during the recovery phase, after which this is locked and you'll need to know your old password to authenticate yourself.\n\nThat's it! For your security, all sensitive information is encrypted. DO NOT COPY THE ENCRYPTION KEY, IT'S ALSO USED TO DECRYPT THE INFORMATION - The only way to get a new key is to completely reset the software!");
        jTextPane1.setCaretPosition(0);
        jTextPane1.setFocusable(false);
        jScrollPane5.setViewportView(jTextPane1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGen))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblStatus)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(pswSetAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnSetAdminPass)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnHelp)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnTest))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnGen))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTest)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblStatus)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pswSetAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetAdminPass)
                    .addComponent(btnHelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Security", jPanel1);

        btnAddUserAdmin.setText("Add User");
        btnAddUserAdmin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddUserAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddUserAdminActionPerformed(evt);
            }
        });

        jButton2.setText("Delete User");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btnAdminResetPsw.setText("Reset a Password");
        btnAdminResetPsw.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAdminResetPsw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminResetPswActionPerformed(evt);
            }
        });

        btnAddFunds.setText("Add Funds");
        btnAddFunds.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAddFunds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddFundsActionPerformed(evt);
            }
        });

        btnChargeAccount.setText("Charge Account");
        btnChargeAccount.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnChargeAccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChargeAccountActionPerformed(evt);
            }
        });

        btnSetBalance.setText("Set Balance");
        btnSetBalance.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSetBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetBalanceActionPerformed(evt);
            }
        });

        jLabel7.setText("Admin Account Administration");

        jLabel8.setText("Admin Account Credit");

        txtCredit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCreditMouseClicked(evt);
            }
        });

        jLabel9.setText("Value: £");

        btnBalance.setText("View Balance");
        btnBalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBalanceActionPerformed(evt);
            }
        });

        jTextPane2.setEditable(false);
        jTextPane2.setText("This area is used to add, remove or modify your UserAdmins.\nUserAdmins are used to modify end users and is another added security measure to this application.\nUserAdmins cannot see other UserAdmins, nor the Master account, only the Master account can modify UserAdmins, you may set up a UserAdmin for yourself if you wish to manage end users.\n\n**IMPORTANT - DO NOT IGNORE**\nThe balance here may be based on REAL MONEY. If you are a HOME USER, the value is 0, meaning you may add or remove as much as you like. If you are a PROFESSIONAL/BUSINESS USER the value is of that you enter in GBP(£).\n\nIf you are a home user, you may ignore the next part.\n\nThe next part\n----------------\nTo help financially, a professional/business user may add funds to UserAdmins - these funds are used to assign a balance to an end user. The end user will recerive the amount that a UserAdmin specifies and this amount is deducted from the UserAdmins balance - this makes finance easier.\nAn end user may request a withdrawal - when withdrawing a balance, the balance is lost to the specified amount and this action is logged. The end users balance is then reflected.\n\nYOU ARE RESPONSIBLE FOR ANY LOSSES/GAINS FINANCIALLY AS A USE THROUGH THIS APPLICATION OR ANY CORRESPONDING APPLICATIONS. If you have made a mistake, you can reset a UserAdmins balance to a balance of your choice.\n\nUserAdmins cannot be suspended, but may have their balance removed or placed in a negative value, please make the UserAdmin aware of this action.\n\nTo revoke all access to a UserAdmin, select \"Delete User\" and enter their username. You may be prompted for proof of ID in terms of your password.");
        jTextPane2.setCaretPosition(0);
        jScrollPane6.setViewportView(jTextPane2);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator4)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(btnAddUserAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addGap(46, 46, 46)
                                .addComponent(btnAdminResetPsw))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel8)
                                    .addComponent(btnBalance)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAddFunds)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnChargeAccount)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnSetBalance)))
                                .addGap(0, 14, Short.MAX_VALUE)))
                        .addContainerGap(24, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddUserAdmin)
                    .addComponent(jButton2)
                    .addComponent(btnAdminResetPsw))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCredit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(btnAddFunds)
                    .addComponent(btnChargeAccount)
                    .addComponent(btnSetBalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBalance)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Settings", jPanel4);

        jPanel6.setEnabled(false);
        jPanel6.setFocusable(false);

        jLabel6.setText("Here is the list of clients linked to this server");

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "This feature is being developed..." };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList1.setAutoscrolls(false);
        jScrollPane3.setViewportView(jList1);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 203, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel6);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
        );

        jTabbedPane1.addTab("Casino Server", jPanel3);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("MS Reference Sans Serif", 0, 14)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Key: *=Fix or info. +=Added feature. -= Removed Feature.\n\nV1.1.1:\n*Fixed update hang issue.\n\nV1.1.0:\n+ Master account can now logon to RTC\n* Corrected spelling errors\n+ Added server functionality\n* Renamed \"Client Update\" tab to \"Casino Server\"\n+ Added \"Notes\" functionality\n+ Added explanations\n- Removed \"Help\"\n\nV1.0.4:\n- Removed caution from admin information\n* RTC: User Balance is now updated before and after a smin, so the user always has the correct balance.\n* RTC: Fixed Bonus Board bug where the system got caught in the number generation loop.\n\nV1.0.3:\n* Corrected spelling errors.\n* Updated title for master panel.\n\nV1.0.2:\n* Fixed a security issue where unauthorised users could gain access to the master account panel.\n* Corrected spelling errors.\n+ Added preperation for server configuration.\n\nV1.0.1:\n* Fixed a security bug where deleting the recovery key file allows an attacker to gain unauthorised access to the master account panel\n+ Added Version History\n\nV1.0.0:\n* Software released out of BETA stage");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setCaretPosition(0);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTextArea1.setFocusable(false);
        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 436, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Update History", jPanel5);

        jTabbedPane1.setSelectedIndex(1);

        jMenu1.setText("Admin");

        mnuLog.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
        mnuLog.setText("View Log");
        mnuLog.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogActionPerformed(evt);
            }
        });
        jMenu1.add(mnuLog);

        mnuServer.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        mnuServer.setText("Server");
        mnuServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuServerActionPerformed(evt);
            }
        });
        jMenu1.add(mnuServer);

        mnuDebug.setText("Debug");
        mnuDebug.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuDebugActionPerformed(evt);
            }
        });
        jMenu1.add(mnuDebug);
        jMenu1.add(jSeparator3);

        mnuSignOut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        mnuSignOut.setText("Sign Out");
        mnuSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSignOutActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSignOut);

        mnuExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_MASK));
        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSignOutActionPerformed
        new LoginUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuSignOutActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void btnGenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenActionPerformed
        if (Global.admin) {
            file.write();
        } else {
            new AdminPassw("auth").setVisible(true);
        }
    }//GEN-LAST:event_btnGenActionPerformed

    private void btnTestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTestActionPerformed
        boolean success = file.getFile();

        if (success) {
            lblStatus.setText("File(s) found and verified successfully!");
        } else {
            lblStatus.setText("This USB is not ready. Click \"Generate\" or copy from other USB.");
        }
    }//GEN-LAST:event_btnTestActionPerformed

    private void btnSetAdminPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetAdminPassActionPerformed
        if (Global.admin || Global.ftime) {
            try {
                security.setAdminPass(String.valueOf(pswSetAdmin.getPassword()));
                lblStatus.setText("The password was successfully updated!");
                Global.admin = false;
                Global.ftime = false;
            } catch (Exception e) {
                settings.displayMessage(5, "Error");
            }
        } else {
            new AdminPassw("auth").setVisible(true);
            lblStatus.setText("The password hasn't been updated! Please confirm credentials");
        }
    }//GEN-LAST:event_btnSetAdminPassActionPerformed

    private void btnAddUserAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddUserAdminActionPerformed
        new AddUserAdmin().setVisible(true);
    }//GEN-LAST:event_btnAddUserAdminActionPerformed

    private void mnuLogActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogActionPerformed
        new LogLoaderUI(this).setVisible(true);
    }//GEN-LAST:event_mnuLogActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new DelUser().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        new HelpGUI().setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    private void btnAdminResetPswActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminResetPswActionPerformed
        new AdminResetPass().setVisible(true);
    }//GEN-LAST:event_btnAdminResetPswActionPerformed

    private void txtCreditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCreditMouseClicked
        txtCredit.setText("10");
    }//GEN-LAST:event_txtCreditMouseClicked

    private void btnAddFundsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddFundsActionPerformed
        confirmAction(1);
    }//GEN-LAST:event_btnAddFundsActionPerformed

    private void btnChargeAccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChargeAccountActionPerformed
        confirmAction(2);
    }//GEN-LAST:event_btnChargeAccountActionPerformed

    private void btnSetBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetBalanceActionPerformed
        confirmAction(3);
    }//GEN-LAST:event_btnSetBalanceActionPerformed

    private void btnBalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBalanceActionPerformed
        viewBalance(4);
    }//GEN-LAST:event_btnBalanceActionPerformed

    private void mnuServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuServerActionPerformed
        new ServerUI(this).setVisible(true);
    }//GEN-LAST:event_mnuServerActionPerformed

    private void mnuDebugActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuDebugActionPerformed
        new debugger.GUI(this).setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_mnuDebugActionPerformed

    private void confirmAction(int input) {
        if (txtCredit.getText().matches("[0-9]{1,5}")) {
            new ConfirmAccGUI(input, Integer.parseInt(txtCredit.getText())).setVisible(true);
        } else {
            settings.displayMessage(9, "Error");
        }
    }

    private void viewBalance(int input) {
        new ConfirmAccGUI(input, 0).setVisible(true);
    }

    private void resetSave() {
        Thread go = new Thread() {
            public void run() {
                try {
                    Thread.sleep(4950);
                } catch (InterruptedException ignore) {
                    Thread.interrupted();
                    Thread.State state = TERMINATED;
                }
            }
        };
        go.start();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddFunds;
    private javax.swing.JButton btnAddUserAdmin;
    private javax.swing.JButton btnAdminResetPsw;
    private javax.swing.JButton btnBalance;
    private javax.swing.JButton btnChargeAccount;
    private javax.swing.JButton btnGen;
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnSetAdminPass;
    private javax.swing.JButton btnSetBalance;
    private javax.swing.JButton btnTest;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JMenuItem mnuDebug;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuLog;
    private javax.swing.JMenuItem mnuServer;
    private javax.swing.JMenuItem mnuSignOut;
    private javax.swing.JPasswordField pswSetAdmin;
    private javax.swing.JTextPane txtAdminInfo;
    private javax.swing.JTextField txtCredit;
    // End of variables declaration//GEN-END:variables
}
