/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface.SysAdminWorkArea;

import Business.DB4OUtil.DB4OUtil;
import Business.Ecosystem.EcoSystem;
import Business.Network.Network;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author yangj
 */
public class ManageNetworkJPanel extends javax.swing.JPanel {

    /**
     * Creates new form ManageNetworkJPanel
     */
    private JPanel userProcessContainer;
    private EcoSystem system;
    
    public ManageNetworkJPanel(JPanel userProcessContainer,EcoSystem system) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.system=system;
        populateNetworkTable();
    }

    public void populateNetworkTable(){
        DefaultTableModel model=(DefaultTableModel)networkJTable.getModel();
        model.setRowCount(0);
        
        for (Network network : system.getNetworkList()) {
            Object[] row = new Object[1];
            row[0] = network;
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
        jScrollPane1 = new javax.swing.JScrollPane();
        networkJTable = new javax.swing.JTable();
        nameTextField = new javax.swing.JTextField();
        createJButton = new javax.swing.JButton();
        deleteJButton = new javax.swing.JButton();
        updateJButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        backJButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(136, 195, 234));
        setPreferredSize(new java.awt.Dimension(1200, 700));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("Manage Network");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, -1, -1));

        networkJTable.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        networkJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Name"
            }
        ));
        networkJTable.setGridColor(new java.awt.Color(204, 204, 204));
        networkJTable.setRowHeight(30);
        networkJTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                networkJTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(networkJTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 500, 150));

        nameTextField.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        nameTextField.setBorder(null);
        add(nameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 320, 220, 30));

        createJButton.setBackground(new java.awt.Color(204, 204, 204));
        createJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        createJButton.setText("Create");
        createJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createJButtonActionPerformed(evt);
            }
        });
        add(createJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 470, -1, -1));

        deleteJButton.setBackground(new java.awt.Color(204, 204, 204));
        deleteJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        deleteJButton.setText("Delete");
        deleteJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteJButtonActionPerformed(evt);
            }
        });
        add(deleteJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 470, -1, -1));

        updateJButton.setBackground(new java.awt.Color(204, 204, 204));
        updateJButton.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        updateJButton.setText("Update");
        updateJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateJButtonActionPerformed(evt);
            }
        });
        add(updateJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 470, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 94, 170));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Enterprise Admin");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 240, -1));

        jLabel4.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Manage Enterprise");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 180, -1));

        jPanel2.setBackground(new java.awt.Color(0, 105, 186));

        jLabel3.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.light"));
        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Manage Network");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(54, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 260, 60));

        backJButton.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        backJButton.setText("<<Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });
        jPanel1.add(backJButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, 100, 30));

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 700));

        jLabel5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel5.setText("Name");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));
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
        populateNetworkTable();
    }//GEN-LAST:event_backJButtonActionPerformed

    private void createJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createJButtonActionPerformed
        // TODO add your handling code here:
        String name = nameTextField.getText();
        
        if(name== null ||name.trim().isEmpty()){
            JOptionPane.showMessageDialog(null, "Name can't be empty!");
            return;
        }
        
        for(Network net : system.getNetworkList()){
            if (net.getName().equals(name)) {
                JOptionPane.showMessageDialog(null, "This network already exist!");
            nameTextField.setText("");        
                return;
            }
        }
        
        Network network = system.createAndAddNetwork();
        network.setName(name); 
        populateNetworkTable();
        nameTextField.setText("");
    }//GEN-LAST:event_createJButtonActionPerformed

    private void deleteJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = networkJTable.getSelectedRow();
        if(selectedRow >= 0){
            int selectionButton = JOptionPane.YES_NO_OPTION;
            int selectionResult = JOptionPane.showConfirmDialog(null, "Are you sure to delete this network?", "Warning", selectionButton);
            if(selectionResult == JOptionPane.YES_OPTION){
                Network network = (Network) networkJTable.getValueAt(selectedRow, 0);
                system.deleteNetwork(network);
                populateNetworkTable();
                nameTextField.setText("");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!!");
        }
    }//GEN-LAST:event_deleteJButtonActionPerformed

    private void networkJTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_networkJTableMouseClicked
        // TODO add your handling code here:
        int selectedRow = networkJTable.getSelectedRow();
        if(selectedRow >= 0){
            Network nw = (Network) networkJTable.getValueAt(selectedRow,0);
            nameTextField.setText(nw.getName());   
        }else{
            JOptionPane.showMessageDialog(null, "Please select a Row!");
        }
    }//GEN-LAST:event_networkJTableMouseClicked

    private void updateJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateJButtonActionPerformed
        // TODO add your handling code here:
        int selectedRow = networkJTable.getSelectedRow();

        if(selectedRow<0)
        {
            JOptionPane.showMessageDialog(null, "Please selet a row from table first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;   
        }
        
        String name = nameTextField.getText();
        if (name== null ||name.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Name is empty.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
            
            //Check duplicated network  
        for (Network u :system.getNetworkList()){
            if(u.getName().equals(name)){
                JOptionPane.showMessageDialog(null, "This network is already registered!");
                return;
            }
        }
            
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int dialogResult = JOptionPane.showConfirmDialog(null, "Would you like to update this newtwork?", "Warning", dialogButton); 
        if (dialogResult == JOptionPane.YES_OPTION) {
            Network nt = (Network) networkJTable.getValueAt(selectedRow, 0);
            nt.setName(name);
            populateNetworkTable();
            nameTextField.setText("");
        }
    }//GEN-LAST:event_updateJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JButton createJButton;
    private javax.swing.JButton deleteJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JTable networkJTable;
    private javax.swing.JButton updateJButton;
    // End of variables declaration//GEN-END:variables
}
