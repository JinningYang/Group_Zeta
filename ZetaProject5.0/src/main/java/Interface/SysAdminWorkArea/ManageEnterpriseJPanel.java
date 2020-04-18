/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SysAdminWorkArea;

import Business.Enterprise.Enterprise;
import javax.swing.JPanel;
import Business.Ecosystem.EcoSystem;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yangj
 */
public class ManageEnterpriseJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private EcoSystem system;
    /**
     * Creates new form ManageEnterpriseAdminJPanel
     */
    public ManageEnterpriseJPanel(JPanel userProcessContainer, EcoSystem system) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.system = system;
        populateTable();
        populateComboBox();
    }

     private void populateTable() {
        DefaultTableModel model = (DefaultTableModel) enterpriseJTable.getModel();

        model.setRowCount(0);
        for (Network network : system.getNetworkList()) {
            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                Object[] row = new Object[3];
                row[0] = enterprise;
                row[1] = network;
                row[2] = enterprise.getEnterpriseType().getValue();

                model.addRow(row);
            }
        }
    }
     
    private void populateComboBox() {
        networkComboBox.removeAllItems();
        enterpriseTypeComboBox.removeAllItems();

        for (Network network : system.getNetworkList()) {
            networkComboBox.addItem(network);   
        }

        for (Enterprise.EnterpriseType type : Enterprise.EnterpriseType.values()) {
            enterpriseTypeComboBox.addItem(type);
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
        enterpriseJTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        networkComboBox = new javax.swing.JComboBox();
        enterpriseTypeComboBox = new javax.swing.JComboBox();
        nameTextField = new javax.swing.JTextField();
        createJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        updateJButton = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();

        setBackground(new java.awt.Color(136, 195, 234));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enterpriseJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Name", "Network", "Type"
            }
        ));
        enterpriseJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                enterpriseJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(enterpriseJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, 375, 104));

        jLabel1.setText("Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 260, -1, -1));

        jLabel2.setText("Enterprise Type");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, -1, -1));

        jLabel3.setText("Name");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 350, -1, -1));

        networkComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        networkComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                networkComboBoxActionPerformed(evt);
            }
        });
        add(networkComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 260, 111, -1));

        enterpriseTypeComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enterpriseTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterpriseTypeComboBoxActionPerformed(evt);
            }
        });
        add(enterpriseTypeComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 300, 111, -1));
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 340, 111, -1));

        createJButton.setText("Create");
        createJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createJButtonActionPerformed(evt);
            }
        });
        add(createJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, -1, -1));

        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        add(deleteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel4.setText("Manage Enterprise");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        updateJButton.setText("Update Name");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        add(updateJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 390, -1, -1));

        jPanel3.setBackground(new java.awt.Color(0, 94, 170));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 204, 204));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Manage Enterprise Admin");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 250, -1));

        jPanel4.setBackground(new java.awt.Color(0, 105, 186));

        jLabel8.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 204));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Manage Enterprise");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 260, 60));

        jLabel9.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Manage Network");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 160, 40));

        backJButton.setText("< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        jPanel3.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 700));
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        Component[] componentArray = userProcessContainer.getComponents();
        Component component = componentArray[componentArray.length - 1];
        SystemAdminWorkAreaJPanel sysAdminwjp = (SystemAdminWorkAreaJPanel) component;
        sysAdminwjp.populateTree();
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void enterpriseTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterpriseTypeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_enterpriseTypeComboBoxActionPerformed

    private void createJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createJButtonActionPerformed
        // TODO add your handling code here:
        Network network = (Network)networkComboBox.getSelectedItem();   
        Enterprise.EnterpriseType type = (Enterprise.EnterpriseType) enterpriseTypeComboBox.getSelectedItem();

        if (network == null || type == null) {
            JOptionPane.showMessageDialog(null, "Invalid Input!");
            return;
        }
        
        String name = nameTextField.getText();  
        if(name== null ||name.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name can't be empty!");
            return;
        }
        
        ArrayList<Enterprise> entList = network.getEnterpriseDirectory().getEnterpriseList();
        
        for(Enterprise newEnt: entList){
            if(newEnt.getName().equals(name)){
                JOptionPane.showMessageDialog(null, "This Enterprise already exist!");
                nameTextField.setText("");
                return;
            }
        }
        
        Enterprise enterprise = network.getEnterpriseDirectory().createAndAddEnterprise(name, type);       
    
        JOptionPane.showMessageDialog(null, "Enterprisee was created successfully!");
        populateTable();
        nameTextField.setText("");   
    }//GEN-LAST:event_createJButtonActionPerformed

  
    
    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:

        int selectedRow = enterpriseJTable.getSelectedRow();
        if(selectedRow >= 0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete?", "Warning", selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                Enterprise enterprise = (Enterprise)enterpriseJTable.getValueAt(selectedRow, 0);
                for(Network network :system.getNetworkList())
                {
                    if(network.getEnterpriseDirectory().getEnterpriseList().remove(enterprise));
                    break;
                }
                populateTable();
                JOptionPane.showMessageDialog(null, "Delete Successfully!!");
                nameTextField.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!");
        }
             
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void networkComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_networkComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_networkComboBoxActionPerformed

    private void enterpriseJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_enterpriseJTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = enterpriseJTable.getSelectedRow();
        if(selectedRow >= 0){
            Enterprise enterprise = (Enterprise) enterpriseJTable.getValueAt(selectedRow,0);
            nameTextField.setText(enterprise.getName());
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }    
    }//GEN-LAST:event_enterpriseJTableMouseClicked

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = enterpriseJTable.getSelectedRow();

        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please selet a row from table first.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;  
        }
        
        Network network = (Network) enterpriseJTable.getValueAt(selectedRow, 1);
        Enterprise enterprise = (Enterprise) enterpriseJTable.getValueAt(selectedRow, 0);
        
        String name = nameTextField.getText();
        if (name== null ||name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name is empty!", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
            
        for (Enterprise ent :network.getEnterpriseDirectory().getEnterpriseList()){
            if(ent.getName().equals(name)){
                JOptionPane.showMessageDialog(null, "This enterprise already exist!");
                return;
            }
        }

        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to update this enterprise?", "Warning", dialogButton);
        if (dialogResult == JOptionPane.YES_OPTION) {
            enterprise.setName(name);            
            populateTable();
            JOptionPane.showMessageDialog(null, "Update Successfully!!");
            nameTextField.setText("");
        }
 
    }//GEN-LAST:event_updateJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton createJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JTable enterpriseJTable;
    private javax.swing.JComboBox enterpriseTypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JComboBox networkComboBox;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}
