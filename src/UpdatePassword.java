
import javax.swing.JOptionPane;

public class UpdatePassword extends javax.swing.JInternalFrame {

    String Name,current,newpas,confirm;

    public UpdatePassword() {
        initComponents();
        Name = System.getProperty("Name");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        currentpass = new javax.swing.JLabel();
        newpass = new javax.swing.JLabel();
        confirmpass = new javax.swing.JLabel();
        btnupdate = new javax.swing.JButton();
        txtcurrpass = new javax.swing.JPasswordField();
        txtpass = new javax.swing.JPasswordField();
        txtconfpass = new javax.swing.JPasswordField();

        setClosable(true);
        setIconifiable(true);
        setTitle("Change Password");

        currentpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        currentpass.setText("Current Password:");

        newpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        newpass.setText("New Password:");

        confirmpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        confirmpass.setText("Confirm Password:");

        btnupdate.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });

        txtcurrpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        txtpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtpassFocusGained(evt);
            }
        });

        txtconfpass.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtconfpass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtconfpassFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtconfpassFocusLost(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(newpass)
                            .addComponent(currentpass)
                            .addComponent(confirmpass))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtconfpass, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                            .addComponent(txtpass)
                            .addComponent(txtcurrpass)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(btnupdate)))
                .addContainerGap(57, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentpass)
                    .addComponent(txtcurrpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newpass)
                    .addComponent(txtpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirmpass)
                    .addComponent(txtconfpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(btnupdate)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        current =new String(txtcurrpass.getPassword());
        newpas = new String(txtpass.getPassword());
        confirm = new String(txtconfpass.getPassword());
        if (DBManager.updatepasswd(Name, current, newpas) == true) {
            JOptionPane.showMessageDialog(this, "Password Changed");
            dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Server Error");
            dispose();
        }
        

    }//GEN-LAST:event_btnupdateActionPerformed

    private void txtconfpassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfpassFocusLost
        confirm = new String(txtconfpass.getPassword());
        newpas = new String(txtpass.getPassword());
        if (!newpas.equals(confirm)) {
            JOptionPane.showMessageDialog(this, "The fields do not match");
            txtconfpass.requestFocus();
        }
           
    }//GEN-LAST:event_txtconfpassFocusLost

    private void txtpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtpassFocusGained
        current =new String(txtcurrpass.getPassword());
        if (current.equals("")) {
            JOptionPane.showMessageDialog(this, "This field cannot be Empty");
            txtcurrpass.requestFocus();
        }
    }//GEN-LAST:event_txtpassFocusGained

    private void txtconfpassFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtconfpassFocusGained
        newpas = new String(txtpass.getPassword());
        if (newpas.equals("")) {
            JOptionPane.showMessageDialog(this, "This field cannot be Empty");
            txtpass.requestFocus();
        }
    }//GEN-LAST:event_txtconfpassFocusGained


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel confirmpass;
    private javax.swing.JLabel currentpass;
    private javax.swing.JLabel newpass;
    private javax.swing.JPasswordField txtconfpass;
    private javax.swing.JPasswordField txtcurrpass;
    private javax.swing.JPasswordField txtpass;
    // End of variables declaration//GEN-END:variables
}
