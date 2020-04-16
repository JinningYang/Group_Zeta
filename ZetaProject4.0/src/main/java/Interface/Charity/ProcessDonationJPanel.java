/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Charity;

import Business.Enterprise.CharityEnterprise;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.DonorWorkRequest;
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
public class ProcessDonationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount useraccount;
    private CharityEnterprise charity;
    private int sum=0;
    /**
     * Creates new form ProcessDonationJPanel
     */
    public ProcessDonationJPanel(JPanel userProcessContainer,UserAccount useraccount,CharityEnterprise charity) {
        initComponents();
        this.userProcessContainer= userProcessContainer;
        this.useraccount= useraccount;
        this.charity=charity;
        
        populateTable();
        sumJLabel.setText(Integer.toString(sum));
    }

    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)donationJTable.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request: charity.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }else if(request.getClass().getName().contains("HospitalWorkRequest")){
                continue;
            }
            DonorWorkRequest drequest = (DonorWorkRequest)request;
            Object[]row=new Object[5];
            row[0]= drequest.getRequestId();
            row[1]= drequest.getReceiver()==null?null:drequest.getReceiver().getPerson().getName();
            row[2]= drequest.getSender();
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

        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        donationJTable = new javax.swing.JTable();
        processJButton = new javax.swing.JButton();
        sumJLabel = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        backJButton.setText("<<back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        donationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Receiver", "Donor Name", "Money ", "Status"
            }
        ));
        jScrollPane1.setViewportView(donationJTable);
        if (donationJTable.getColumnModel().getColumnCount() > 0) {
            donationJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        processJButton.setText("Process");
        processJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                processJButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Sum of Donation:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(24, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(backJButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(processJButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sumJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(backJButton)
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sumJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(processJButton)
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void processJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_processJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow =donationJTable.getSelectedRow();
        
        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer wrSelectedRow=(Integer)donationJTable.getValueAt(selectedRow, 0);
        
        DonorWorkRequest drequest=null;
         for(WorkRequest request:charity.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }else if(request.getClass().getName().contains("HospitalWorkRequest")){
                continue;
            }
            DonorWorkRequest newrequest=(DonorWorkRequest)request;
            if(wrSelectedRow.equals(newrequest.getRequestId())){
                drequest=newrequest;
                break;
            }
        }
        if(drequest!=null){
            if(drequest.getReceiver()!=null){
                JOptionPane.showMessageDialog(this, "You can't process twice!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
                return;
            }
            drequest.setReceiver(useraccount);
            drequest.setStatus("Received");
        }
        
         if(drequest.getStatus().equals("Received")){
                sum+= drequest.getDonor().getQuantity();
         }
        
       populateTable();
       sumJLabel.setText(Integer.toString(sum));
    }//GEN-LAST:event_processJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTable donationJTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton processJButton;
    private javax.swing.JLabel sumJLabel;
    // End of variables declaration//GEN-END:variables
}
