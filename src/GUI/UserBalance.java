/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2019 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 *
 * Contributor(s): reece
 */
package GUI;

import Code.Details;
import Code.Security;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import loader.MemberLoader;
import model.User;

/**
 *
 * @author reece
 */
public class UserBalance extends javax.swing.JFrame {

    JTable memberTable;
    private final String en = Security.encryption;

    private final MemberLoader memberLoader = new MemberLoader();
    private ArrayList<User> memberList = new ArrayList<>();

    private final UserAdminUI mw;
    private final int row;

    /**
     * Creates new form UserBalance
     *
     * @param mw
     * @param row
     */
    Object[][] data = new Object[1][7];
    double adminBalance;

    public UserBalance(UserAdminUI mw, int row) {
        this.mw = mw;
        this.row = row;
        initComponents();
        try {
            String[] membersList = sec.decDetails("members");
            for (int i = 0; i < membersList.length; i++) {
                memberList = memberLoader.loadMember(membersList[i]);
            }
            User user = memberList.get(row);
            data[0][0] = user.getId();
            data[0][1] = user.getName();
            data[0][2] = user.getAddress();
            data[0][3] = user.getPhone();
            data[0][4] = user.getActive();
            data[0][5] = user.getPassword();
            data[0][6] = user.getBalance();
            setAdminBalance();
        } catch (Exception ex) {
            Logger.getLogger(AddMember.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //User user = new User();
    Security sec = new Security();
    double balance = 0;
    double originalBalance = 0;

    private void setAdminBalance() {
        try {
            adminBalance = Double.parseDouble(sec.getUserBalance(Code.Details.LoggedOn));
            balance = Double.parseDouble(String.valueOf(data[0][6]));
            originalBalance = balance;
            setBalanceText();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnPlus10 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        lblABalance = new javax.swing.JLabel();
        lblBalance = new javax.swing.JLabel();
        btnNegative10 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Edit balance");
        setResizable(false);

        jLabel1.setText("Your assigned credit:");

        jLabel2.setText("Users current balance:");

        btnPlus10.setText("+ £10");
        btnPlus10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPlus10ActionPerformed(evt);
            }
        });

        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        lblABalance.setText("Admin Balance");

        lblBalance.setText("Balance");

        btnNegative10.setText("- £10");
        btnNegative10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNegative10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(lblABalance, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(lblBalance, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnNegative10)
                        .addGap(18, 18, 18)
                        .addComponent(btnPlus10)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblABalance))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblBalance))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPlus10)
                    .addComponent(jButton2)
                    .addComponent(btnNegative10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnNegative10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNegative10ActionPerformed
        double newBalance = balance - 10;
        if (newBalance >= originalBalance) {
            balance = newBalance;
            adminBalance += 10;
            setBalanceText();
        } else {
            JOptionPane.showMessageDialog(null, "Cannot withdraw funds the user already has!");
        }
    }//GEN-LAST:event_btnNegative10ActionPerformed

    private void setBalanceText() {
        lblBalance.setText("£" + balance);
        lblABalance.setText("£" + adminBalance);
    }

    private void btnPlus10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPlus10ActionPerformed
        if (adminBalance > 0) {
            balance = balance + 10;
            adminBalance -= 10;
            setBalanceText();
        } else {
            JOptionPane.showMessageDialog(null, "Can't add funds to the user when you have insufficient funds!");
        }
    }//GEN-LAST:event_btnPlus10ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void update() {
        //Prepare to write new member information
        String ID;
        String Name;
        String Address;
        String Phone;
        int active;
        ID = String.valueOf(data[0][0]);
        Name = String.valueOf(data[0][1]);
        Address = String.valueOf(data[0][2]);
        Phone = String.valueOf(data[0][3]);
        active = Integer.parseInt(String.valueOf(data[0][4]));
        String password = String.valueOf(data[0][5]);
        //Edit the selected member with the new information
        mw.editMember(ID, Name, Address, Phone, password, balance, active, row);
        //Display new results
        mw.displayMembers();
        try {
            //Update admin balance
            sec.encryptFile("c:\\RTC\\data\\" + Details.LoggedOn, "-balance.dat", String.valueOf(adminBalance));
        } catch (Exception ex) {
            Logger.getLogger(UserBalance.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Record the event
        sec.saveLog("User " + ID + ": " + Name + "'s balance was updated by £" + (balance-originalBalance) + " by " + Details.LoggedOn + ".");
        //Exit
        this.dispose();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNegative10;
    private javax.swing.JButton btnPlus10;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblABalance;
    private javax.swing.JLabel lblBalance;
    // End of variables declaration//GEN-END:variables

}