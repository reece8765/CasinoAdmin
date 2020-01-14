package GUI;

import Code.Global;
import Code.Update;
import javax.swing.JOptionPane;

/**
 *
 * @author reece8765
 */
public class StandardUI extends javax.swing.JFrame {

    Update update = new Update();

    /**
     * Creates new form StandardUI
     */
    public StandardUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        btnUserM = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnHelp = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuSignOut = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnuExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuUpdate = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Security Options - " + Global.currentVersion);
        setResizable(false);

        btnUserM.setText("User Management");
        btnUserM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUserM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserMActionPerformed(evt);
            }
        });

        jLabel1.setText("Current Application Version: " + Global.currentVersion);

        btnHelp.setText("Help");
        btnHelp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnHelp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHelpActionPerformed(evt);
            }
        });

        jMenu1.setText("File");

        mnuSignOut.setText("Sign Out");
        mnuSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSignOutActionPerformed(evt);
            }
        });
        jMenu1.add(mnuSignOut);
        jMenu1.add(jSeparator1);

        mnuExit.setText("Exit");
        mnuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuExitActionPerformed(evt);
            }
        });
        jMenu1.add(mnuExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");

        mnuUpdate.setText("Check for Update");
        mnuUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuUpdateActionPerformed(evt);
            }
        });
        jMenu2.add(mnuUpdate);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(btnUserM, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                .addGap(94, 94, 94)
                .addComponent(btnHelp)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUserM)
                    .addComponent(btnHelp))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void mnuSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSignOutActionPerformed
        new LoginUI().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_mnuSignOutActionPerformed

    private void btnUserMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserMActionPerformed
        UserLogin.Type = 1;
        new UserLogin(1).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnUserMActionPerformed

    private void mnuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_mnuExitActionPerformed

    private void mnuUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuUpdateActionPerformed
        boolean check = false;
        try {
            check = update.check();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Couldn't check for updates", "Update Error", JOptionPane.ERROR_MESSAGE);
        }
        if (check) {
            update.available(this);
        } else {
            JOptionPane.showMessageDialog(this, "Your software is up to date.", "Check Completed", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_mnuUpdateActionPerformed

    private void btnHelpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHelpActionPerformed
        new Notifications.HelpGUI().setVisible(true);
    }//GEN-LAST:event_btnHelpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHelp;
    private javax.swing.JButton btnUserM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnuExit;
    private javax.swing.JMenuItem mnuSignOut;
    private javax.swing.JMenuItem mnuUpdate;
    // End of variables declaration//GEN-END:variables
}
