/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Hospital;

import Business.Enterprise.HospitalEnterprise;
import Business.UserAccount.UserAccount;
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
public class SubmitVolunteerEvalJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount useraccount;
    private HospitalEnterprise hospital;
    /**
     * Creates new form SubmitVolunteerEvalJPanel
     */
    public SubmitVolunteerEvalJPanel(JPanel userProcessContainer,UserAccount useraccount,HospitalEnterprise hospital) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.useraccount=useraccount;
        this.hospital=hospital;
        
        populateTable();
    }
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)volunteerJTable.getModel();
        model.setRowCount(0);
        
        for (WorkRequest request:useraccount.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("HospitalWorkRequest")){
                continue;
            }
            VolunteerWorkRequest vrequest = (VolunteerWorkRequest)request;
            Object[] row=new Object[5];
            row[0]=vrequest.getRequestId();
            row[1]=vrequest.getFromEnterprise()==null?null:vrequest.getFromEnterprise().getName();
            row[2]=vrequest.getEvaluation()==null?null:vrequest.getEvaluation();
            row[3]=vrequest.getStatus();
            row[4]=vrequest;
            
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        volunteerJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        evaluationJTextField = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();

        backJButton.setText("<<back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel1.setText("Submit Volunteer Evaluation");

        volunteerJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Charity", "Evaluation", "Status", "Result"
            }
        ));
        jScrollPane1.setViewportView(volunteerJTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Evaluation:");

        evaluationJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluationJTextFieldActionPerformed(evt);
            }
        });

        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(backJButton))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jLabel2)
                                .addGap(46, 46, 46)
                                .addComponent(evaluationJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(submitJButton)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(backJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(evaluationJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addComponent(submitJButton)
                .addContainerGap(61, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        //        DoctorWorkArea dwjp = (DoctorWorkArea) component;
        //        dwjp.populateTable();
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void evaluationJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluationJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evaluationJTextFieldActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        String evaluation=evaluationJTextField.getText();
        
        int selectedRow=volunteerJTable.getSelectedRow(),col=0;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer wrSelectedRow=(Integer)volunteerJTable.getValueAt(selectedRow, 0);
        VolunteerWorkRequest vrequest=null;
        
        for(WorkRequest request:hospital.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("HospitalWorkRequest")){
                continue;
            }
            VolunteerWorkRequest newrequest=(VolunteerWorkRequest)request;
            if(wrSelectedRow.equals(newrequest.getRequestId())){
                vrequest=newrequest;
                break;
            }
        }
        
        if(!vrequest.getStatus().equals("Completed")){
            JOptionPane.showMessageDialog(null, "Your work request hasn't been completed!");
            return;
        }
        
        if(evaluation.isEmpty()){
            JOptionPane.showMessageDialog(null, "You must input something!");
            return;
        }else {
            if (!vrequest.getEvaluation().equalsIgnoreCase("Waiting")) {
                JOptionPane.showMessageDialog(null, "You have evaluated!");
                return;
            }
            JOptionPane.showMessageDialog(null, "Submit Successfully!");
        }
        
         vrequest.setEvaluation(evaluation);
         populateTable();
    }//GEN-LAST:event_submitJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField evaluationJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton submitJButton;
    private javax.swing.JTable volunteerJTable;
    // End of variables declaration//GEN-END:variables
}
