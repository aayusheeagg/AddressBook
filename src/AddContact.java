
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class AddContact extends javax.swing.JInternalFrame {

    DefaultComboBoxModel model;
    JFileChooser fc;
    File photo, photofile;
    Contacts s;
    String ContactId, Name;
    BufferedImage resizedImageJpg, originalImage;

    public AddContact() {
        initComponents();
        pb.setVisible(false);
        ContactId = System.getProperty("ContactId");
        Name = System.getProperty("Name");

        fc = new JFileChooser("f:/Media");
        lblPhoto.setIcon(null);

        JSpinner.DateEditor ed = new JSpinner.DateEditor(jSpinnerDOB, "dd-MMMM-yyyy");
        jSpinnerDOB.setEditor(ed);

        ArrayList<Category> list = DBManager.getAllCategory();
        model = (DefaultComboBoxModel) jComboBoxCategory.getModel();
        for (Category c : list) {
            model.addElement(c);
        }
    }

    void resetForm() {
        txtName.setText("");
        txtMobile.setText("");
        txtCity.setText("");
        txtEmail.setText("");
        jRadioMale.setSelected(true);
        jRadioFemale.setSelected(true);
        jSpinnerDOB.setValue(new Date());
        jComboBoxCategory.setSelectedIndex(0);
        txtName.requestFocus();
        lblPhoto.setIcon(null);
        photo = null;
    }

    private BufferedImage resizeImg(BufferedImage originalImage, int type) {
        BufferedImage resizedImage = new BufferedImage(200, 200, type);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, 200, 200, null);
        g.dispose();
        return resizedImage;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gender = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabelCity = new javax.swing.JLabel();
        jLabelCategory = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jComboBoxCategory = new javax.swing.JComboBox();
        txtCity = new javax.swing.JTextField();
        jLabelGender = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();
        jLabelDOB = new javax.swing.JLabel();
        txtMobile = new javax.swing.JTextField();
        jLabelEmail = new javax.swing.JLabel();
        jButtonSubmit = new javax.swing.JButton();
        txtEmail = new javax.swing.JTextField();
        jSpinnerDOB = new javax.swing.JSpinner();
        jRadioMale = new javax.swing.JRadioButton();
        txtName = new javax.swing.JTextField();
        jLabelMobile = new javax.swing.JLabel();
        jRadioFemale = new javax.swing.JRadioButton();
        lblPhoto = new javax.swing.JLabel();
        btnBrowse = new javax.swing.JButton();
        pb = new javax.swing.JProgressBar();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("ADD  CONTACTS");
        setPreferredSize(new java.awt.Dimension(794, 563));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add your Contacts", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Constantia", 1, 24), new java.awt.Color(51, 51, 255))); // NOI18N

        jLabelCity.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelCity.setText("City:");

        jLabelCategory.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelCategory.setText("Category:");

        jLabelName.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelName.setText("Name:");

        jComboBoxCategory.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N

        txtCity.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtCity.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelGender.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelGender.setText("Gender:");

        jButtonReset.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jButtonReset.setText("Reset");
        jButtonReset.setBorder(null);

        jLabelDOB.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelDOB.setText("Date Of Birth:");

        txtMobile.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtMobile.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelEmail.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelEmail.setText("Email:");

        jButtonSubmit.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jButtonSubmit.setText("Submit");
        jButtonSubmit.setBorder(null);
        jButtonSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSubmitActionPerformed(evt);
            }
        });

        txtEmail.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jSpinnerDOB.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jSpinnerDOB.setModel(new javax.swing.SpinnerDateModel());

        gender.add(jRadioMale);
        jRadioMale.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jRadioMale.setSelected(true);
        jRadioMale.setText("Male");
        jRadioMale.setBorder(null);

        txtName.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        txtName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelMobile.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jLabelMobile.setText("MobileNumber:");

        gender.add(jRadioFemale);
        jRadioFemale.setFont(new java.awt.Font("Palatino Linotype", 0, 18)); // NOI18N
        jRadioFemale.setText("Female");
        jRadioFemale.setBorder(null);

        lblPhoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        lblPhoto.setPreferredSize(new java.awt.Dimension(205, 200));

        btnBrowse.setText("Browse");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseActionPerformed(evt);
            }
        });

        pb.setBackground(new java.awt.Color(204, 204, 255));
        pb.setForeground(new java.awt.Color(0, 0, 0));
        pb.setStringPainted(true);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabelCity))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(23, 23, 23)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabelGender)
                                .addComponent(jLabelDOB)
                                .addComponent(jLabelEmail)
                                .addComponent(jLabelCategory)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabelName)
                                    .addGap(2, 2, 2)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabelMobile)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSpinnerDOB, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCity)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jRadioMale)
                                .addGap(29, 29, 29)
                                .addComponent(jRadioFemale))
                            .addComponent(jComboBoxCategory, 0, 176, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnBrowse)
                        .addGap(70, 70, 70))
                    .addComponent(pb, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblPhoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(78, 78, 78))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelName)
                                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtMobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelMobile))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabelEmail)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jSpinnerDOB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelDOB))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabelCity)
                                    .addComponent(btnBrowse, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioMale)
                            .addComponent(jRadioFemale)
                            .addComponent(jLabelGender)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(pb, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelCategory))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSubmitActionPerformed
        String Name1 = txtName.getText();
        String errors = "";
        if (txtName.getText().equals("")) {
            errors += "Name can not be Empty\n";
        }
        if (txtMobile.getText().equals("")) {
            errors += "Mobile Number can not be Empty\n";
        }
        if (!errors.equals("")) {
            JOptionPane.showMessageDialog(this, errors);
            return;
        }

        if (!txtEmail.getText().equals("") && !Pattern.matches("\\w+@\\w+[.]com", txtEmail.getText())) {
            errors += "E-Mail is not Valid\n";
        }
        if (!Pattern.matches("\\d{10}", txtMobile.getText())) {
            errors += "Mobile Number must be 10 digits\n";
        }
        if (!errors.equals("")) {
            JOptionPane.showMessageDialog(this, errors);
            return;
        }
        String gender;
        if (jRadioMale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }
        String email = txtEmail.getText();
        String mobile = txtMobile.getText();
        String city = txtCity.getText();
        Date dateOfBirth = (Date) jSpinnerDOB.getValue();
        Category c = (Category) jComboBoxCategory.getSelectedItem();
        String Category = c.getCategory();
        s = new Contacts(Name, Name1, mobile, email, dateOfBirth, city, gender, Category, photo);
        if (DBManager.insertContact(s) == true) {
            JOptionPane.showMessageDialog(this, "Record Saved");
            resetForm();
        } else {
            JOptionPane.showMessageDialog(this, "Record Not Saved");
        }
    }//GEN-LAST:event_jButtonSubmitActionPerformed

    private void btnBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseActionPerformed

        int x = fc.showOpenDialog(this);

        if (x == JFileChooser.APPROVE_OPTION) {

            photo = fc.getSelectedFile();
            photofile = new File(photo.getAbsolutePath());

            try {
                originalImage = ImageIO.read(photofile);
            } catch (IOException ex) {
                System.out.println("ex");
            }
            int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
            resizedImageJpg = resizeImg(originalImage, type);

            Worker t = new Worker();
            t.start();

        }


    }//GEN-LAST:event_btnBrowseActionPerformed

    class Worker extends Thread {

        public void run() {
            btnBrowse.setEnabled(false);
            jButtonSubmit.setEnabled(false);
            jButtonReset.setEnabled(false);
            pb.setVisible(true);
            long download = 0, bytes = 128;
            int progress = 0; //12292

            while ((download <= photofile.length())) {
                download += bytes;
                try {
                    Thread.sleep(10);
                } catch (Exception ex) {
                }
                progress = (int) ((download * 1.0 / photofile.length()) * 100);
                pb.setValue(progress);
            }
            download = 0;
            pb.setVisible(false);
            try {
                if (ImageIO.write(resizedImageJpg, "jpg", photofile)) {
                    lblPhoto.setIcon(new ImageIcon(resizedImageJpg));
                }

            } catch (Exception ex) {
                System.out.println("ex");
            }
            btnBrowse.setEnabled(true);
            jButtonSubmit.setEnabled(true);
            jButtonReset.setEnabled(true);

        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBrowse;
    private javax.swing.ButtonGroup gender;
    private javax.swing.JButton jButtonReset;
    private javax.swing.JButton jButtonSubmit;
    private javax.swing.JComboBox jComboBoxCategory;
    private javax.swing.JLabel jLabelCategory;
    private javax.swing.JLabel jLabelCity;
    private javax.swing.JLabel jLabelDOB;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelGender;
    private javax.swing.JLabel jLabelMobile;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton jRadioFemale;
    private javax.swing.JRadioButton jRadioMale;
    private javax.swing.JSpinner jSpinnerDOB;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JProgressBar pb;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMobile;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
