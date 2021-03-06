/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Charity;

import Business.UserAccount.UserAccount;
import Business.WorkQueue.HospitalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kathe
 */
public class DriverWorkAreaJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    /**
     * Creates new form DriverWorkAreaJPanel
     */
    public DriverWorkAreaJPanel(JPanel userProcessContainer,UserAccount userAccount) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        
        populateTable();
        valueLabel.setText(userAccount.getUsername());
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)driverJTable.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request:userAccount.getWorkQueue().getWorkRequestList()){
            Object[] row = new Object[4];
            row[0]=request.getRequestId();
            row[1]=request.getFromEnterprise().getName();
            //row[2]=request.getDriver()==null?null:request.getDriver().getPerson().getName();
            row[2]=request.getStatus();
            row[3]=request;
            
            model.addRow(row);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        driverJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        processJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        valueLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(199, 245, 246));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        driverJTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        driverJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Enterprise", "Status", "Result"
            }
        ));
        driverJTable.setRowHeight(30);
        jScrollPane1.setViewportView(driverJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 730, 120));

        assignJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, -1, -1));

        processJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });
        add(processJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 280, -1, -1));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Driver Work Area");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 60, 300, 39));

        valueLabel.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        valueLabel.setText("<value>");
        add(valueLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 40, 170, 26));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel10.setText("Enterprise:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, -1, 30));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\NEU_Study\\INFO 5100 Spring\\Final_Project_Zeta\\Zeta_Images\\carrot.gif")); // NOI18N
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 800, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = driverJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
         HospitalWorkRequest hospitalWorkRequest=(HospitalWorkRequest)driverJTable.getValueAt(selectedRow, 3);
         
         if(hospitalWorkRequest.getResult()!=null){
            JOptionPane.showMessageDialog(this, "You have already processed it!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
         }
         
         hospitalWorkRequest.setStatus("Driver Begin");
         populateTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = driverJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        HospitalWorkRequest hospitalWorkRequest=(HospitalWorkRequest)driverJTable.getValueAt(selectedRow, 3);
        
        if(hospitalWorkRequest.getDriver()==null){
            JOptionPane.showMessageDialog(this, "You haven't assigned driver!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(hospitalWorkRequest.getResult()!=null){
            JOptionPane.showMessageDialog(this, "You can't submit result twice!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(!hospitalWorkRequest.getStatus().equals("Driver Begin")){
             JOptionPane.showMessageDialog(this, "You haven't assigned driver!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
         }
        //hospitalWorkRequest.setStatus("Delivery");
        
        DriverProcessJPanel driverProcessJPanel=new DriverProcessJPanel(userProcessContainer,hospitalWorkRequest);
        userProcessContainer.add("driverProcessJPanel",driverProcessJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        populateTable();
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable driverJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JLabel valueLabel;
    // End of variables declaration//GEN-END:variables
}
