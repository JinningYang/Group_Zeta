/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Donor;

import Business.Enterprise.CharityEnterprise;
import Business.Enterprise.DonorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonorWorkRequest;
import Business.WorkQueue.VolunteerWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lgfx0
 */
public class ProcessDonorJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private DonorEnterprise donor;
    private Network network;
    /**
     * Creates new form DonorWorkAreaJPanel
     */
    public ProcessDonorJPanel(JPanel userProcessContainer,UserAccount userAccount,DonorEnterprise donor, Network network) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.userAccount=userAccount;
        this.donor=donor;
        this.network= network;
        populateTable();
        populateJComboBox();
       
    }
    
    public void populateJComboBox(){
        donorJComboBox.removeAllItems();
        for (Enterprise charity: network.getEnterpriseDirectory().getEnterpriseList()){
            if(charity.getEnterpriseType().toString().equals("Charity")){
                donorJComboBox.addItem(charity.toString());
            }
        }
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)donorJTable.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request: userAccount.getWorkQueue().getWorkRequestList()){
            DonorWorkRequest drequest = (DonorWorkRequest)request;
            Object[]row = new Object[5];
            row[0]= drequest.getRequestId();
            row[1]= drequest.getToEnterprise()==null?null:drequest.getToEnterprise().getName();
            row[2]= drequest.getSender()==null?null:drequest.getSender().getPerson().getName();
            row[3]= drequest.getDonor().getQuantity();
            row[4]= drequest.getStatus();
            
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

        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        moneyJTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        donorJTable = new javax.swing.JTable();
        submitJButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        donorJComboBox = new javax.swing.JComboBox<>();
        updateJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setBackground(new java.awt.Color(255, 255, 153));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Number of Money Donate:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 190, 25));

        backJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        backJButton.setText("<<back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        moneyJTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        add(moneyJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 190, 30));

        donorJTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        donorJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Charity", "Donor Name", "Quantity", "Status"
            }
        ));
        donorJTable.setRowHeight(30);
        jScrollPane1.setViewportView(donorJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 80, 730, 150));

        submitJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 380, 80, 33));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Select the charity to donate:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 200, -1));

        donorJComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        donorJComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        add(donorJComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 310, 190, 30));

        updateJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        add(updateJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 380, -1, 33));

        deleteJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        add(deleteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, -1, 33));

        jLabel3.setBackground(new java.awt.Color(255, 255, 102));
        jLabel3.setForeground(new java.awt.Color(255, 51, 0));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\NEU_Study\\INFO 5100 Spring\\Final_Project_Zeta\\Zeta_Images\\donate money.gif")); // NOI18N
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 290, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        String money= String.valueOf(moneyJTextField.getText());
        
        DonorWorkRequest donorWorkRequest = new DonorWorkRequest();
        
        if(money==null||money.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Please input amount of money!", "CREATE", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer c;
        try {
            c= Integer.parseInt(money);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid number format! ");
            moneyJTextField.setText("");
            return;
        }
        
        if(c<=0){
            JOptionPane.showMessageDialog(null, "Donated Money must be a positive number!"); 
            moneyJTextField.setText("");
            return;
        }
        
        donorWorkRequest.getDonor().setQuantity(c);
        
        Enterprise toEnterprise=null;
        
        for(Enterprise enterprise:network.getEnterpriseDirectory().getEnterpriseList()){
            if(donorJComboBox.getSelectedItem().toString().equals(enterprise.toString())){
                toEnterprise=enterprise;
                donorWorkRequest.setToEnterprise(toEnterprise);
                toEnterprise.getWorkQueue().getWorkRequestList().add(donorWorkRequest);
                
            }
        }
        
        donorWorkRequest.setSender(userAccount);
        donorWorkRequest.setStatus("Donate");
        donorWorkRequest.setFromEnterprise(donor);
        
        userAccount.getWorkQueue().getWorkRequestList().add(donorWorkRequest);
        moneyJTextField.setText("");
        populateTable();
    }//GEN-LAST:event_submitJButtonActionPerformed

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        // TODO add your handling code here:
        
        int selectedRow = donorJTable.getSelectedRow();

        
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null, "Please select a Row!!"); 
            return;
        } 
        Integer monid = (Integer) donorJTable.getValueAt(selectedRow, 0); 
        String money = String.valueOf(moneyJTextField.getText());
        DonorWorkRequest drequest=null;
        
        for(WorkRequest request:userAccount.getWorkQueue().getWorkRequestList()){
                DonorWorkRequest newrequest=(DonorWorkRequest)request;
                if(monid.equals(newrequest.getRequestId())){
                    drequest=newrequest;
                    break;
                }
         }
        
        if(drequest!=null){
            if(drequest.getStatus().equals("Received")){
                JOptionPane.showMessageDialog(this, "The money has been received!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                moneyJTextField.setText(""); 
                return;
            }

            if(money==null|| money.trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The money cannot be empty", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
          if(Integer.parseInt(money)<=0){
            JOptionPane.showMessageDialog(this, "The money must be a positive number!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            moneyJTextField.setText(""); 
            return; 
            }
            
            drequest.getDonor().setQuantity(Integer.parseInt(money));
            
            JOptionPane.showMessageDialog(null, "Updated Successfully!"); 
            moneyJTextField.setText(""); 
        }
        populateTable();
    }//GEN-LAST:event_updateJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = donorJTable.getSelectedRow();
        
        if(selectedRow >= 0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "Warning", selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
            
            Integer dw = (Integer) donorJTable.getValueAt(selectedRow, 0);
            DonorWorkRequest drequest=null;
            for(WorkRequest request:userAccount.getWorkQueue().getWorkRequestList()){
                DonorWorkRequest newrequest=(DonorWorkRequest)request;
                if(dw.equals(newrequest.getRequestId())){
                    drequest=newrequest;
                    break;
                }
            }
            
            if(drequest!=null){
                if(drequest.getStatus().equals("Received")){
                    JOptionPane.showMessageDialog(null, "This money has already been received!");  
                    return;
                }
                drequest.getToEnterprise().getWorkQueue().getWorkRequestList().remove(drequest);
                userAccount.getWorkQueue().getWorkRequestList().remove(drequest);
                moneyJTextField.setText("");
                JOptionPane.showMessageDialog(null, "Delete Successfully!");  
                
            }
            populateTable();
        }   
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");  
        }
        
        
    }//GEN-LAST:event_deleteJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JComboBox<String> donorJComboBox;
    private javax.swing.JTable donorJTable;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField moneyJTextField;
    private javax.swing.JButton submitJButton;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}
