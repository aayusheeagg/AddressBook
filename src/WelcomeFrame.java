
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WelcomeFrame extends javax.swing.JFrame implements ActionListener {

    String ContactId, Name;

    public void login() {
        setTitle("Welcome " + System.getProperty("Name"));
        mnuAdd.setVisible(true);
        mnuEdit.setVisible(true);
        mnuLogout.setVisible(true);
        mnupass.setVisible(true);
        mnuLogin.setVisible(false);
    }

    public WelcomeFrame() {
        initComponents();
        ContactId = System.getProperty("ContactId");
        Name = System.getProperty("Name");
        setTitle("Welcome: User ");
        mnuLogin.addActionListener(this);
        mnuAdd.addActionListener(this);
        mnuEdit.addActionListener(this);
        mnupass.addActionListener(this);
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        mnuAdd.setVisible(false);
        mnuEdit.setVisible(false);
        mnupass.setVisible(false);
        mnuLogout.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuRegister = new javax.swing.JMenuItem();
        mnuLogin = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAdd = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        mnuEdit = new javax.swing.JMenuItem();
        Logoutbtn = new javax.swing.JMenu();
        mnupass = new javax.swing.JMenuItem();
        mnuLogout = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 666, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 466, Short.MAX_VALUE)
        );

        jMenu1.setMnemonic('S');
        jMenu1.setText("Login");
        jMenu1.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        mnuRegister.setText("Register");
        mnuRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuRegisterActionPerformed(evt);
            }
        });
        jMenu1.add(mnuRegister);

        mnuLogin.setMnemonic('S');
        mnuLogin.setText("Login to your profile");
        jMenu1.add(mnuLogin);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Add");
        jMenu2.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        mnuAdd.setText("Add Contact");
        jMenu2.add(mnuAdd);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Edit");
        jMenu3.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        mnuEdit.setText("Edit Contact");
        jMenu3.add(mnuEdit);

        jMenuBar1.add(jMenu3);

        Logoutbtn.setText("Logout");
        Logoutbtn.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        mnupass.setText("Change Password");
        Logoutbtn.add(mnupass);

        mnuLogout.setText("Logout from your profile");
        mnuLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuLogoutActionPerformed(evt);
            }
        });
        Logoutbtn.add(mnuLogout);

        jMenuBar1.add(Logoutbtn);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuLogoutActionPerformed

        String ContactId = null;
        String password = null;
        LoginInfo info = DBManager.loginuser(ContactId, password);
        if (info == null) {
            JOptionPane.showMessageDialog(this, "You are successfully logged out");
            mnuAdd.setVisible(false);
            mnuEdit.setVisible(false);
            mnupass.setVisible(false);
            mnuLogout.setVisible(false);
            mnuLogin.setVisible(true);
            setTitle("Welcome: User ");
        }

    }//GEN-LAST:event_mnuLogoutActionPerformed

    private void mnuRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuRegisterActionPerformed
        Register f = new Register();
            jDesktopPane1.add(f);
            f.setVisible(true);
    }//GEN-LAST:event_mnuRegisterActionPerformed

    public void update(String newname) {
        UpdateContact uc = new UpdateContact(newname);
        jDesktopPane1.add(uc);
       uc.setVisible(true);
    }

    public void fullInfo(String newname) {
        ViewFullInfo vi = new ViewFullInfo(newname);
       jDesktopPane1.add(vi);
       vi.setVisible(true);
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Logoutbtn;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem mnuAdd;
    private javax.swing.JMenuItem mnuEdit;
    private javax.swing.JMenuItem mnuLogin;
    private javax.swing.JMenuItem mnuLogout;
    private javax.swing.JMenuItem mnuRegister;
    private javax.swing.JMenuItem mnupass;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent evt) {
         if (evt.getSource() == mnuLogin) {
            LoginFrame f = new LoginFrame(this);
            jDesktopPane1.add(f);
            f.setVisible(true);
        } else if (evt.getSource() == mnuAdd) {
            AddContact f = new AddContact();
            jDesktopPane1.add(f);
            f.setVisible(true);
        } else if (evt.getSource() == mnuEdit) {
            EditContact f = new EditContact(this);
            jDesktopPane1.add(f);
            f.setVisible(true);
        } else if (evt.getSource() == mnupass) {
            UpdatePassword up = new UpdatePassword();
            jDesktopPane1.add(up);
            up.setVisible(true);
        }
    }
}
