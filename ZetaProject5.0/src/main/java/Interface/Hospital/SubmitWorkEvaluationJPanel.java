/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Hospital;

import Business.Enterprise.HospitalEnterprise;
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
public class SubmitWorkEvaluationJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount useraccount;
    private HospitalEnterprise hospital;
    /**
     * Creates new form SubmitWorkEvaluationJPanel
     */
    public SubmitWorkEvaluationJPanel(JPanel userProcessContainer,UserAccount useraccount,HospitalEnterprise hospital) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.useraccount=useraccount;
        this.hospital=hospital;
        
        populateTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)submitEvaluationJTable.getModel();
        model.setRowCount(0);
        
        for(WorkRequest request:useraccount.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }
            HospitalWorkRequest hrequest=(HospitalWorkRequest)request;
            Object[] row=new Object[5];
            row[0]=hrequest.getRequestId();
            row[1]=hrequest.getToEnterprise()==null?null:hrequest.getToEnterprise().getName();
            row[2]=hrequest.getEvaluation()==null?null:request.getEvaluation();
            row[3]=hrequest.getStatus();
            row[4]=hrequest;
            
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

        jLabel1 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        submitEvaluationJTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        evaluationJTextField = new javax.swing.JTextField();
        submitJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(192, 233, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Submit Work Evaluation");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 30, 370, 39));

        backJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        backJButton.setText("<<back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        submitEvaluationJTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        submitEvaluationJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id", "Charity", "Evaluation", "Status", "Results"
            }
        ));
        submitEvaluationJTable.setRowHeight(30);
        jScrollPane1.setViewportView(submitEvaluationJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(113, 104, 770, 160));

        jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel2.setText("Evaluation:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 27));

        evaluationJTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        evaluationJTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                evaluationJTextFieldActionPerformed(evt);
            }
        });
        add(evaluationJTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 310, 250, 30));

        submitJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        submitJButton.setText("Submit");
        submitJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitJButtonActionPerformed(evt);
            }
        });
        add(submitJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void evaluationJTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_evaluationJTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_evaluationJTextFieldActionPerformed

    private void submitJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitJButtonActionPerformed
        // TODO add your handling code here:
        String evaluation=evaluationJTextField.getText();
        
        int selectedRow=submitEvaluationJTable.getSelectedRow(),col=0;
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer wrSelectedRow=(Integer)submitEvaluationJTable.getValueAt(selectedRow, 0);
        HospitalWorkRequest hrequest=null;
        
        for(WorkRequest request:hospital.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }
            HospitalWorkRequest newrequest=(HospitalWorkRequest)request;
            if(wrSelectedRow.equals(newrequest.getRequestId())){
                hrequest=newrequest;
                break;
            }
        }
        
        
        
        if(!hrequest.getStatus().equals("Completed")){
            JOptionPane.showMessageDialog(null, "Your work request hasn't been completed!");
            evaluationJTextField.setText("");
            return;
        }
        
        if(evaluation== null ||evaluation.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "You must input something!");
            return;
        }else {
            if (!hrequest.getEvaluation().equalsIgnoreCase("Waiting")) {
                JOptionPane.showMessageDialog(null, "You have evaluated!");
                evaluationJTextField.setText("");
                return;
            }
            JOptionPane.showMessageDialog(null, "Submit Successfully!");
            evaluationJTextField.setText("");
        }
        
         hrequest.setEvaluation(evaluation);        
         populateTable();
         evaluationJTextField.setText("");
    }//GEN-LAST:event_submitJButtonActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JTextField evaluationJTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable submitEvaluationJTable;
    private javax.swing.JButton submitJButton;
    // End of variables declaration//GEN-END:variables
}
