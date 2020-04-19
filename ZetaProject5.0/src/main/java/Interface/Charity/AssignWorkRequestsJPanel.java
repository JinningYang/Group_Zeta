/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.Charity;

import Business.Enterprise.CharityEnterprise;
import Business.Enterprise.HospitalEnterprise;
import Business.Organization.HospitalBackOfficerOrganization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.HospitalWorkRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kathe
 */
public class AssignWorkRequestsJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private UserAccount useraccount;
    private CharityEnterprise charity;
    private HospitalBackOfficerOrganization hospitalBackOfficerOrganization;
    /**
     * Creates new form AssignWorkRequestsJPanel
     */
    public AssignWorkRequestsJPanel(JPanel userProcessContainer,UserAccount useraccount,CharityEnterprise charity) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.useraccount=useraccount;
        this.charity=charity;
        
        populateTable();
        //populateFirstProcessTable();
    }
    
    public void populateTable(){
        DefaultTableModel model = (DefaultTableModel)assignJTable.getModel();
        model.setRowCount(0);
        for(WorkRequest request:charity.getWorkQueue().getWorkRequestList()){
            if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }else if(request.getClass().getName().contains("DonorWorkRequest")){
                continue;
            }
            if(!request.getStatus().equals("Create") &&!request.getStatus().equals("Pending")){
                Object[]row=new Object[6];
                row[0]=request.getRequestId();
                row[1]=request.getFromEnterprise().getName();
                String pattern = "MM-dd-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(request.getRequestDate());
                row[2]=date;
                row[3]=request.getReceiver()==null?null:request.getReceiver().getPerson().getName();
                row[4]=request;
                row[5]=request.getStatus();
                
                model.addRow(row);
            }else{
                continue;
            }
        }
    }
    
    public void populateFirstProcessTable(){
        DefaultTableModel model = (DefaultTableModel)firstWorkRequestJTable.getModel();
        model.setRowCount(0);
        
        WorkRequest first=charity.getWorkQueue().getWorkRequestList().get(0);
        Date begin=charity.getWorkQueue().getWorkRequestList().get(0).getRequestDate();
        
        for(WorkRequest request:charity.getWorkQueue().getWorkRequestList()){
            
            if(request.getReceiver()!=null){
                continue;
            }
            if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }else if(request.getClass().getName().contains("DonorWorkRequest")){
                continue;
            }
            
            if(request.getRequestDate().before(begin)||first.getReceiver()!=null){
                    begin=request.getRequestDate();
                    first=request;
            }
        }
        if(first.getReceiver()!=null){
            JOptionPane.showMessageDialog(this, "All work requests have been processed!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }
    
        Object[]row=new Object[4];
        row[0]=first.getRequestId();
        String pattern = "MM-dd-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(first.getRequestDate());
        row[1]=date;
        //row[2]=first.getReceiver()==null?null:first.getReceiver().getPerson().getName();
        row[2]=first.getStatus();
        row[3]=first;
       
        model.addRow(row);
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
        assignJTable = new javax.swing.JTable();
        chooseAssignJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        firstWorkRequestJTable = new javax.swing.JTable();
        assignJButton = new javax.swing.JButton();
        viewJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(180, 224, 201));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        backJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        backJButton.setText("<<back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        assignJTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        assignJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id", "EnterPrise", "RequestDay", "AidWorker", "Result", "Status"
            }
        ));
        assignJTable.setEnabled(false);
        assignJTable.setRowHeight(30);
        jScrollPane1.setViewportView(assignJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 80, 730, 150));

        chooseAssignJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        chooseAssignJButton.setText("First Request To Assign");
        chooseAssignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chooseAssignJButtonActionPerformed(evt);
            }
        });
        add(chooseAssignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, -1, -1));

        firstWorkRequestJTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        firstWorkRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Id", "RequestDate", "Status", "Results"
            }
        ));
        firstWorkRequestJTable.setRowHeight(30);
        jScrollPane2.setViewportView(firstWorkRequestJTable);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 340, 720, 80));

        assignJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });
        add(assignJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 530, -1, -1));

        viewJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        viewJButton.setText("View Demand Good");
        viewJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButtonActionPerformed(evt);
            }
        });
        add(viewJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void chooseAssignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chooseAssignJButtonActionPerformed
        // TODO add your handling code here: 
       populateFirstProcessTable();
    }//GEN-LAST:event_chooseAssignJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);  
    }//GEN-LAST:event_backJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow =firstWorkRequestJTable.getSelectedRow();

        if (selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }

        HospitalWorkRequest hospitalWorkRequest=(HospitalWorkRequest)firstWorkRequestJTable.getValueAt(selectedRow, 3);

        if(hospitalWorkRequest.getReceiver()!=null){
            JOptionPane.showMessageDialog(this, "You can't assign twice!", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
        }

        hospitalWorkRequest.setReceiver(useraccount);
        hospitalWorkRequest.setStatus("Charity Begin");

        useraccount.getWorkQueue().getWorkRequestList().add(hospitalWorkRequest);
        populateTable();
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void viewJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButtonActionPerformed
        // TODO add your handling code here:
         int selectedRow=firstWorkRequestJTable.getSelectedRow(),col=0;
         if(selectedRow<0){
             JOptionPane.showMessageDialog(this, "Please select at least a row.", "INFORMATION", JOptionPane.ERROR_MESSAGE);
            return;
         }
         
         Integer wrSelectedRow=(Integer)firstWorkRequestJTable.getValueAt(selectedRow, 0);
          HospitalWorkRequest hrequest=null;
         for(WorkRequest request:charity.getWorkQueue().getWorkRequestList()){
             if(request.getClass().getName().contains("VolunteerWorkRequest")){
                continue;
            }
             if(request.getClass().getName().contains("DonorWorkRequest")){
                continue;
            }
            HospitalWorkRequest newrequest=(HospitalWorkRequest)request;
            if(wrSelectedRow.equals(newrequest.getRequestId())){
                hrequest=newrequest;
                break;
            }
        }
         
        this.userProcessContainer.add("ViewDemandGoodJPanel",new ViewDemandGoodJPanel(this.userProcessContainer,charity,hrequest));
        CardLayout cLayout = (CardLayout) this.userProcessContainer.getLayout();
        cLayout.next(userProcessContainer);
    }//GEN-LAST:event_viewJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable assignJTable;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton chooseAssignJButton;
    private javax.swing.JTable firstWorkRequestJTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton viewJButton;
    // End of variables declaration//GEN-END:variables
}
