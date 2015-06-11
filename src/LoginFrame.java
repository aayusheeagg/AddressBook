
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class LoginFrame extends javax.swing.JInternalFrame {
    WelcomeFrame f;
    String Name;
    
    public LoginFrame(WelcomeFrame f) {
        initComponents();
        Name=System.getProperty("Name");
        this.f = f;
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanelleft2 = new javax.swing.JPanel();
        txtWelcome2 = new javax.swing.JLabel();
        jLabelPassword2 = new javax.swing.JLabel();
        btnSubmit2 = new javax.swing.JButton();
        jLabelUsername2 = new javax.swing.JLabel();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();

        jPasswordField1.setText("jPasswordField1");

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("LOGIN ");

        jPanelleft2.setPreferredSize(new java.awt.Dimension(380, 320));

        txtWelcome2.setFont(new java.awt.Font("Palatino Linotype", 1, 18)); // NOI18N
        txtWelcome2.setForeground(new java.awt.Color(51, 51, 255));
        txtWelcome2.setText("Welcome User,  Enter your details below:");

        jLabelPassword2.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelPassword2.setText("Password:");

        btnSubmit2.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        btnSubmit2.setText("Submit");
        btnSubmit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmit2ActionPerformed(evt);
            }
        });

        jLabelUsername2.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelUsername2.setText("Username:");

        txtUsername.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanelleft2Layout = new javax.swing.GroupLayout(jPanelleft2);
        jPanelleft2.setLayout(jPanelleft2Layout);
        jPanelleft2Layout.setHorizontalGroup(
            jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelleft2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtWelcome2, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelleft2Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelUsername2)
                            .addComponent(jLabelPassword2))
                        .addGap(49, 49, 49)
                        .addGroup(jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSubmit2)
                            .addComponent(txtUsername, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                            .addComponent(txtPassword))))
                .addContainerGap())
        );
        jPanelleft2Layout.setVerticalGroup(
            jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelleft2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtWelcome2, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsername2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanelleft2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword2)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(btnSubmit2)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 492, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(jPanelleft2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(56, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 416, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(46, 46, 46)
                    .addComponent(jPanelleft2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(46, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSubmit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmit2ActionPerformed
        String ContactId = txtUsername.getText();
        String password = new String(txtPassword.getPassword());

        LoginInfo info = DBManager.loginuser(ContactId, password);
        if (info == null) {
            JOptionPane.showMessageDialog(this, "Credentials Incorrect", "Error", JOptionPane.ERROR_MESSAGE);
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        } else {
            System.setProperty("ContactId", info.getContactId());
            System.setProperty("Name", info.getName());
            setTitle("Welcome : "+info.getName());
            JOptionPane.showMessageDialog(this, "Welcome To Address Book Application "+info.getName());
            f.login();
            dispose();
            
        }  
    }//GEN-LAST:event_btnSubmit2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSubmit2;
    private javax.swing.JLabel jLabelPassword2;
    private javax.swing.JLabel jLabelUsername2;
    private javax.swing.JPanel jPanelleft2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    private javax.swing.JLabel txtWelcome2;
    // End of variables declaration//GEN-END:variables
}
