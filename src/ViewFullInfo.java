
import java.io.File;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;


public class ViewFullInfo extends javax.swing.JInternalFrame {

    
    Contacts s;
    String ContactId, Name,Name1;

    public ViewFullInfo(String newname) {
        initComponents();
        Name = System.getProperty("Name");
        
        Contacts s = DBManager.getContact(Name,newname);
            txtName.setText(s.getName()+",("+s.getCategory()+")");
            txtCity.setText(s.getCity());
            txtEmail.setText(s.getEmail());
            txtMobile.setText(s.getMobileNumber());
            txtDOB.setText(s.getDOB().toString());
            lblPhoto.setIcon(s.getIcon());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblPhoto = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabelMobile = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelDOB = new javax.swing.JLabel();
        jLabelCity = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtMobile = new javax.swing.JTextField();
        txtDOB = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setTitle("VIEW CONTACT");

        lblPhoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPhoto.setPreferredSize(new java.awt.Dimension(205, 200));

        txtName.setEditable(false);
        txtName.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtName.setBorder(null);

        jLabelMobile.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelMobile.setText("MobileNumber:");

        jLabelEmail.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelEmail.setText("Email:");

        jLabelDOB.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelDOB.setText("Date Of Birth:");

        jLabelCity.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelCity.setText("City:");

        txtCity.setEditable(false);
        txtCity.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtCity.setBorder(null);

        txtEmail.setEditable(false);
        txtEmail.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtEmail.setBorder(null);

        txtMobile.setEditable(false);
        txtMobile.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtMobile.setBorder(null);

        txtDOB.setEditable(false);
        txtDOB.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtDOB.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(13, 13, 13)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelDOB)
                                .addComponent(jLabelEmail)))
                        .addComponent(jLabelMobile))
                    .addComponent(jLabelCity))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblPhoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMobile))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelEmail)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDOB)
                            .addComponent(txtDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelCity)
                            .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelDOB;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelMobile;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtDOB;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
