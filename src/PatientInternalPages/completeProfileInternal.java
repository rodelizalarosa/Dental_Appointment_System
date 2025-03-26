
package PatientInternalPages;

import Authentication.LogIn;
import Config.ConnectDB;
import Config.Session;
import Dashboard.PatientDash;
import ManageUserInternalPages.userInternal;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicInternalFrameUI;


public class completeProfileInternal extends javax.swing.JInternalFrame {


    public completeProfileInternal() {
        initComponents();
        borderField();
       
         //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
    }
    
   

    Color hoverColor = new Color(0, 153, 153);
    Color navColor = new Color(0, 51, 51);
    
    private void borderField(){
        firstName.setBackground(new Color(0, 0, 0, 0));
        firstName.setBorder(new LineBorder(Color.GRAY, 2));
        
        middleName.setBackground(new Color(0, 0, 0, 0));
        middleName.setBorder(new LineBorder(Color.GRAY, 2));
        
        lastName.setBackground(new Color(0, 0, 0, 0));
        lastName.setBorder(new LineBorder(Color.GRAY, 2));

        Gender.setBackground(new Color(0, 0, 0, 0));
        Gender.setBorder(new LineBorder(Color.GRAY, 2));

        DOB.setBackground(new Color(0, 0, 0, 0));
        DOB.setBorder(new LineBorder(Color.GRAY, 2));

        Age.setBackground(new Color(0, 0, 0, 0));
        Age.setBorder(new LineBorder(Color.GRAY, 2));
        
        contactNumber.setBackground(new Color(0, 0, 0, 0));
        contactNumber.setBorder(new LineBorder(Color.GRAY, 2));
        
        Gender.setRenderer(new DefaultListCellRenderer() {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (isSelected) {
                component.setBackground(new Color(0, 153, 153)); // Background when selected
                component.setForeground(Color.WHITE); // Text color when selected
            } else {
                component.setBackground(new Color(0,51,51)); // Background when not selected
                component.setForeground(Color.WHITE); // Text color when not selected
            }

            return component;
        }
         });
    }
    
        private boolean isAllFieldsEmpty() {
         return firstName.getText().trim().isEmpty() || firstName.getText().equals("First Name") &&
                middleName.getText().trim().isEmpty() || middleName.getText().equals("Middle Name") &&
                lastName.getText().trim().isEmpty() || lastName.getText().equals("Last Name") &&
                DOB.getText().trim().isEmpty() &&
                Age.getText().trim().isEmpty() &&
                contactNumber.getText().trim().isEmpty();
        }
   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        completeProfilePanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        manageUser = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        regPanel = new javax.swing.JPanel();
        create = new javax.swing.JLabel();
        firstname = new javax.swing.JLabel();
        save_button = new javax.swing.JLabel();
        errorFirst = new javax.swing.JLabel();
        errorGender = new javax.swing.JLabel();
        errorLast = new javax.swing.JLabel();
        middlename = new javax.swing.JLabel();
        lastname = new javax.swing.JLabel();
        errorUser1 = new javax.swing.JLabel();
        gender = new javax.swing.JLabel();
        Gender = new javax.swing.JComboBox<>();
        errorDOB = new javax.swing.JLabel();
        dob = new javax.swing.JLabel();
        DOB = new javax.swing.JTextField();
        errorLast1 = new javax.swing.JLabel();
        age = new javax.swing.JLabel();
        Age = new javax.swing.JTextField();
        errorAge = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        contactNumber = new javax.swing.JTextField();
        errorContact = new javax.swing.JLabel();
        firstName = new javax.swing.JTextField();
        middleName = new javax.swing.JTextField();
        lastName = new javax.swing.JTextField();
        bg = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        completeProfilePanel.setBackground(new java.awt.Color(0, 51, 51));
        completeProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoutPanel.setBackground(new java.awt.Color(0, 51, 51));
        logoutPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logoutPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logoutPanelMouseExited(evt);
            }
        });
        logoutPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        logout.setForeground(new java.awt.Color(255, 255, 255));
        logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logout.setText("Logout");
        logoutPanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 70, 30));

        logoutLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logout.png"))); // NOI18N
        logoutPanel.add(logoutLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        completeProfilePanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        completeProfilePanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        manageUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        manageUser.setForeground(new java.awt.Color(255, 255, 255));
        manageUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        manageUser.setText("Complete Personal Information");
        completeProfilePanel.add(manageUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 280, -1));

        jPanel1.add(completeProfilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        backPanel.setBackground(new java.awt.Color(0, 51, 51));
        backPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backPanelMouseExited(evt);
            }
        });
        backPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        back.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        back.setForeground(new java.awt.Color(255, 255, 255));
        back.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        back.setText("BACK");
        backPanel.add(back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 70, 30));

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 90, -1));

        regPanel.setBackground(new java.awt.Color(0, 51, 51));
        regPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Personal Information");
        regPanel.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 270, 40));

        firstname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        firstname.setForeground(new java.awt.Color(255, 255, 255));
        firstname.setText("First Name");
        regPanel.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 90, -1));

        save_button.setBackground(new java.awt.Color(0, 153, 153));
        save_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        save_button.setForeground(new java.awt.Color(255, 255, 255));
        save_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        save_button.setText("SAVE CHANGES");
        save_button.setOpaque(true);
        save_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                save_buttonMouseClicked(evt);
            }
        });
        regPanel.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 360, 250, 40));
        regPanel.add(errorFirst, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, 20));
        regPanel.add(errorGender, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 190, 20));
        regPanel.add(errorLast, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 180, 20));

        middlename.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        middlename.setForeground(new java.awt.Color(255, 255, 255));
        middlename.setText("Middle Name");
        regPanel.add(middlename, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 110, -1));

        lastname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lastname.setForeground(new java.awt.Color(255, 255, 255));
        lastname.setText("Last Name");
        regPanel.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, -1));
        regPanel.add(errorUser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, 180, 20));

        gender.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        gender.setForeground(new java.awt.Color(255, 255, 255));
        gender.setText("Gender");
        regPanel.add(gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 90, -1));

        Gender.setFont(new java.awt.Font("Tw Cen MT", 0, 15)); // NOI18N
        Gender.setForeground(new java.awt.Color(255, 255, 255));
        Gender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-Select gender-", "Male", "Female" }));
        Gender.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                GenderFocusLost(evt);
            }
        });
        regPanel.add(Gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 250, 40));
        regPanel.add(errorDOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 170, 20));

        dob.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dob.setForeground(new java.awt.Color(255, 255, 255));
        dob.setText("Date of Birth");
        regPanel.add(dob, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 90, -1));

        DOB.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        DOB.setForeground(new java.awt.Color(255, 255, 255));
        DOB.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                DOBFocusLost(evt);
            }
        });
        DOB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DOBActionPerformed(evt);
            }
        });
        regPanel.add(DOB, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 90, 250, 40));
        regPanel.add(errorLast1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, 180, 20));

        age.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        age.setForeground(new java.awt.Color(255, 255, 255));
        age.setText("Age");
        regPanel.add(age, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 160, 90, -1));

        Age.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Age.setForeground(new java.awt.Color(255, 255, 255));
        Age.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                AgeFocusLost(evt);
            }
        });
        Age.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgeActionPerformed(evt);
            }
        });
        regPanel.add(Age, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 180, 250, 40));
        regPanel.add(errorAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 220, 180, 20));

        contact.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        contact.setForeground(new java.awt.Color(255, 255, 255));
        contact.setText("Contact Number");
        regPanel.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 250, 130, -1));

        contactNumber.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        contactNumber.setForeground(new java.awt.Color(255, 255, 255));
        contactNumber.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                contactNumberFocusLost(evt);
            }
        });
        contactNumber.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactNumberActionPerformed(evt);
            }
        });
        regPanel.add(contactNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 270, 250, 40));
        regPanel.add(errorContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 310, 180, 20));

        firstName.setForeground(new java.awt.Color(255, 255, 255));
        firstName.setAutoscrolls(false);
        firstName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstNameActionPerformed(evt);
            }
        });
        regPanel.add(firstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 250, 40));

        middleName.setForeground(new java.awt.Color(255, 255, 255));
        middleName.setAutoscrolls(false);
        regPanel.add(middleName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 40));

        lastName.setForeground(new java.awt.Color(255, 255, 255));
        lastName.setAutoscrolls(false);
        regPanel.add(lastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 250, 40));

        jPanel1.add(regPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 660, 450));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clinicbg.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 780, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

  

    
    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked

        int choice = JOptionPane.showConfirmDialog(
            this,
            "Are you sure you want to log out?",
            "Confirm Logout",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            new ImageIcon(getClass().getResource("/imgs/logout.png"))
        );

        if (choice == JOptionPane.YES_OPTION) {
            LogIn lg = new LogIn();
            lg.setLocationRelativeTo(null);
            lg.setVisible(true);

            this.dispose();
        }
    }//GEN-LAST:event_logoutPanelMouseClicked

    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        logoutPanel.setBackground(hoverColor);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        logoutPanel.setBackground(navColor);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void save_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_save_buttonMouseClicked

     try {
        ConnectDB db = new ConnectDB();
        Connection conn = db.getConnection();

        // Get the current user ID from the session
        Integer userId = Session.getInstance().getCurrentUserId(); 

        // Retrieve text from input fields and trim spaces
        String firstname = firstName.getText().trim();
        String middlename = middleName.getText().trim();
        String lastname = lastName.getText().trim();
        String gender = Gender.getSelectedItem().toString().trim();
        String dob = DOB.getText().trim(); // Ensure it's in YYYY-MM-DD format
        String age = Age.getText().trim();
        String contactnumber = contactNumber.getText().trim();


        // Error message collector
        StringBuilder errorMessage = new StringBuilder();

        // Validate required fields
        if (isAllFieldsEmpty()) {
            errorMessage.append("Please fill in all required fields.\n");
        }

        // Validate Date of Birth format
        if (!dob.matches("\\d{4}-\\d{2}-\\d{2}")) {
            errorMessage.append("Invalid Date of Birth format. Use YYYY-MM-DD.\n");
        }

        // Validate Age (should be a number)
        if (!age.matches("\\d+")) {
            errorMessage.append("Age must be a numeric value.\n");
        }

        // Validate Contact Number (must be 10-11 digits)
        if (!contactnumber.matches("\\d{10,11}")) {
            errorMessage.append("Contact Number must be 10-11 digits.\n");
        }

        // Show all errors in a single message
        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Insert new patient record
        String query = "INSERT INTO patients (p_fname, p_mname, p_lname, p_gender, p_dob, p_age, p_contactNumber, user_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(query)) {
            ps.setString(1, firstname);
            ps.setString(2, middlename);
            ps.setString(3, lastname);
            ps.setString(4, gender);
            ps.setString(5, dob);
            ps.setString(6, age);
            ps.setString(7, contactnumber);

            if (userId != null) {
                ps.setInt(8, userId);
            } else {
                ps.setNull(8, java.sql.Types.INTEGER);
            }

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Profile saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

                firstName.setText("");
                middleName.setText("");
                lastName.setText("");
                DOB.setText("");
                Age.setText("");
                contactNumber.setText("");

                // Open profile page
                patient_profile_internal pdash = new patient_profile_internal();
                Session.getInstance().getDesktopPane().add(pdash);
                pdash.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Failed to save profile.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        conn.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_save_buttonMouseClicked

    private void backPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseClicked
        this.dispose();
        
        patient_profile_internal pdash = new patient_profile_internal();
        Session.getInstance().getDesktopPane().add(pdash);
        pdash.setVisible(true);
    }//GEN-LAST:event_backPanelMouseClicked

    private void backPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseEntered
        backPanel.setBackground(hoverColor);
    }//GEN-LAST:event_backPanelMouseEntered

    private void backPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseExited
        backPanel.setBackground(navColor);
    }//GEN-LAST:event_backPanelMouseExited

    private void GenderFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_GenderFocusLost

        String selectedRoleString = (String) Gender.getSelectedItem();

        if (selectedRoleString == null || selectedRoleString.isEmpty() || selectedRoleString.equals("Select gender")) {
            errorGender.setForeground(Color.RED);
            errorGender.setText("Please select a valid gender");
        } else {
            errorGender.setForeground(Color.BLACK);
            errorGender.setText("");
        }

        Gender.repaint();
    }//GEN-LAST:event_GenderFocusLost

    private void DOBFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_DOBFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBFocusLost

    private void DOBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DOBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DOBActionPerformed

    private void AgeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_AgeFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeFocusLost

    private void AgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AgeActionPerformed

    private void contactNumberFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_contactNumberFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberFocusLost

    private void contactNumberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactNumberActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactNumberActionPerformed

    private void firstNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstNameActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Age;
    private javax.swing.JTextField DOB;
    private javax.swing.JComboBox<String> Gender;
    private javax.swing.JLabel age;
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JPanel completeProfilePanel;
    private javax.swing.JLabel contact;
    private javax.swing.JTextField contactNumber;
    private javax.swing.JLabel create;
    private javax.swing.JLabel dob;
    private javax.swing.JLabel errorAge;
    private javax.swing.JLabel errorContact;
    private javax.swing.JLabel errorDOB;
    private javax.swing.JLabel errorFirst;
    private javax.swing.JLabel errorGender;
    private javax.swing.JLabel errorLast;
    private javax.swing.JLabel errorLast1;
    private javax.swing.JLabel errorUser1;
    private javax.swing.JTextField firstName;
    private javax.swing.JLabel firstname;
    private javax.swing.JLabel gender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lastName;
    private javax.swing.JLabel lastname;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel manageUser;
    private javax.swing.JTextField middleName;
    private javax.swing.JLabel middlename;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JPanel regPanel;
    private javax.swing.JLabel save_button;
    // End of variables declaration//GEN-END:variables
}
