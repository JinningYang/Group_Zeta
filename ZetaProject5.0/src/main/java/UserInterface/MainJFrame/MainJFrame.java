/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.MainJFrame;

import Business.DB4OUtil.DB4OUtil;
import Business.Ecosystem.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import static java.time.Clock.system;
import javax.swing.GroupLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Interface.SysAdminWorkArea.RegisterSysadminJPanel;
import Interface.SysAdminWorkArea.RegisterSysadminJPanel;
import java.awt.Dimension;

/**
 *
 * @author kathe
 */

public class MainJFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainJFrame
     */
    private EcoSystem system;
    private DB4OUtil dB4OUtil = DB4OUtil.getInstance();
    
    public MainJFrame() {
        initComponents();
        system=dB4OUtil.retrieveSystem();
      //  this.setSize(1200, 700);    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        rightJPanel = new javax.swing.JPanel();
        leftJPanel = new javax.swing.JPanel();
        userNameJTextField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginJButton = new javax.swing.JButton();
        logoutJButton = new javax.swing.JButton();
        registerJButton = new javax.swing.JButton();
        showPasswordCheckBox = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jSplitPane1.setAutoscrolls(true);

        rightJPanel.setToolTipText("");
        rightJPanel.setAutoscrolls(true);
        rightJPanel.setDoubleBuffered(false);
        rightJPanel.setName(""); // NOI18N
        rightJPanel.setLayout(new java.awt.CardLayout());
        jSplitPane1.setRightComponent(rightJPanel);
        rightJPanel.getAccessibleContext().setAccessibleName("");

        leftJPanel.setBackground(new java.awt.Color(136, 195, 234));
        leftJPanel.setPreferredSize(new java.awt.Dimension(200, 700));
        leftJPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userNameJTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        userNameJTextField.setBorder(null);
        userNameJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameJTextFieldActionPerformed(evt);
            }
        });
        leftJPanel.add(userNameJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 140, 30));

        passwordField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        passwordField.setBorder(null);
        passwordField.setPreferredSize(new java.awt.Dimension(15, 40));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });
        leftJPanel.add(passwordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 140, 30));

        loginJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loginJButton.setText("Login");
        loginJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginJButtonActionPerformed(evt);
            }
        });
        leftJPanel.add(loginJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 90, 30));

        logoutJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        logoutJButton.setText("Logout");
        logoutJButton.setEnabled(false);
        logoutJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutJButtonActionPerformed(evt);
            }
        });
        leftJPanel.add(logoutJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 97, -1));

        registerJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        registerJButton.setText("Register");
        registerJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerJButtonActionPerformed(evt);
            }
        });
        leftJPanel.add(registerJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 580, 97, -1));

        showPasswordCheckBox.setBackground(new java.awt.Color(136, 195, 234));
        showPasswordCheckBox.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        showPasswordCheckBox.setText("show password");
        showPasswordCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPasswordCheckBoxActionPerformed(evt);
            }
        });
        leftJPanel.add(showPasswordCheckBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("User Name");
        leftJPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, -1));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Password");
        leftJPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, -1));

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("*Do not have an account?");
        leftJPanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 550, -1, -1));

        jSplitPane1.setLeftComponent(leftJPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void showPasswordCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPasswordCheckBoxActionPerformed
        // TODO add your handling code here:
        if(showPasswordCheckBox.isSelected()){
            passwordField.setEchoChar((char)0);
        }else{
            passwordField.setEchoChar('*');
        }
    }//GEN-LAST:event_showPasswordCheckBoxActionPerformed

    private void registerJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerJButtonActionPerformed
        RegisterSysadminJPanel registerSysadminJPanel=new RegisterSysadminJPanel(rightJPanel,system);
        rightJPanel.add("RegisterSysadminJPanel",registerSysadminJPanel);
        CardLayout layout= (CardLayout) rightJPanel.getLayout();
        layout.next(rightJPanel);
    }//GEN-LAST:event_registerJButtonActionPerformed

    private void logoutJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutJButtonActionPerformed
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");
        showPasswordCheckBox.setSelected(false);
        showPasswordCheckBox.setEnabled(true);
        registerJButton.setEnabled(true);

        rightJPanel.removeAll();
        JPanel blankJP = new JPanel();
        rightJPanel.add("blank", blankJP);
        CardLayout crdLyt = (CardLayout) rightJPanel.getLayout();
        crdLyt.next(rightJPanel);
        dB4OUtil.storeSystem(system);
    }//GEN-LAST:event_logoutJButtonActionPerformed

    private void loginJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginJButtonActionPerformed
        // Get user name
        String userName = userNameJTextField.getText();
        // Get Password
        char[] passwordCharArray = passwordField.getPassword();
        String password = String.valueOf(passwordCharArray);

        //Step1: Check in the system admin user account directory if you have the user
        UserAccount userAccount=system.getUserAccountDirectory().authenticateUser(userName, password);

        Network myNetwork=null;
        Enterprise inEnterprise=null;
        Organization inOrganization=null;

        if (userAccount == null) {
            userAccount=system.getSystemUserDirectory().authenticateUser(userName, password);
            if(userAccount==null){
                for(Network network:system.getNetworkList()){
                //Step 2.a: check against each enterprise
                for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
                    userAccount=enterprise.getUserAccountDirectory().authenticateUser(userName, password);
                    
                    if(userAccount!=null){
                        inEnterprise=enterprise;
                        myNetwork=network;
                        break;
                    }

                    for(Organization organization:enterprise.getOrganizationDirectory().getOrganizationList()){
                        userAccount=organization.getUserAccountDirectory().authenticateUser(userName, password);

                        if(userAccount!=null){
                            inEnterprise=enterprise;
                            inOrganization=organization;
                            myNetwork=network;
                            break;
                        }
                    }

                    if(userAccount!=null){
                        break;
                    }
                }
                if(userAccount != null) {
                    break;
                }
            }
            }
            

        }

        if(userAccount==null){
            JOptionPane.showMessageDialog(null, "Invalid credentials");
            //userNameJTextField.setText("");
            //passwordField.setText("");
            return;
        }
        else{
            CardLayout layout= (CardLayout) rightJPanel.getLayout();
            rightJPanel.add("SysAdminWorkArea",userAccount.getRole().createWorkArea(rightJPanel, userAccount, inOrganization, inEnterprise, myNetwork,system));
            layout.next(rightJPanel);
        }

        loginJButton.setEnabled(false);
        logoutJButton.setEnabled(true);
        userNameJTextField.setEnabled(false);
        passwordField.setEnabled(false);
        registerJButton.setEnabled(false);

        showPasswordCheckBox.setEnabled(false);
    }//GEN-LAST:event_loginJButtonActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void userNameJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameJTextFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainJFrame().setVisible(true);
            }
        });
    }
    
    public void setActivate() {
        logoutJButton.setEnabled(false);
        userNameJTextField.setEnabled(true);
        passwordField.setEnabled(true);
        loginJButton.setEnabled(true);

        userNameJTextField.setText("");
        passwordField.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JPanel leftJPanel;
    private javax.swing.JButton loginJButton;
    private javax.swing.JButton logoutJButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton registerJButton;
    private javax.swing.JPanel rightJPanel;
    private javax.swing.JCheckBox showPasswordCheckBox;
    private javax.swing.JTextField userNameJTextField;
    // End of variables declaration//GEN-END:variables
}
