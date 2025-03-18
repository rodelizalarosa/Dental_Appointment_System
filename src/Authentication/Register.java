
package Authentication;

import Config.ConnectDB;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Register extends javax.swing.JFrame {

    
    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
    
    private boolean isEmailTaken(String email) {
        ConnectDB connect = new ConnectDB();
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, email);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private boolean isUsernameTaken(String username) {
        ConnectDB connect = new ConnectDB();
        
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?"; 
        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, username);
            try (ResultSet rs = pst.executeQuery()) { 
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace(); 
        }
        return false;
    }
    
    
    private boolean validatePassword(javax.swing.JPasswordField passwordField) {
        String password = new String(passwordField.getPassword());
        StringBuilder errorMessage = new StringBuilder();
        boolean isValid = true;

        if (password.isEmpty()) {
            errorMessage.append("Password cannot be empty.\n");
            isValid = false;
        }
        if (password.length() < 8) {
            errorMessage.append("Password must be at least 8 characters long.\n");
            isValid = false;
        }
        if (!password.matches(".*[A-Z].*")) {
            errorMessage.append("Password must contain at least one uppercase letter.\n");
            isValid = false;
        }
        if (!password.matches(".*[a-z].*")) {
            errorMessage.append("Password must contain at least one lowercase letter.\n");
            isValid = false;
        }
        if (!password.matches(".*\\d.*")) {
            errorMessage.append("Password must contain at least one digit.\n");
            isValid = false;
        }
        if (!password.matches(".*[!@#$%^&*()_+=\\-\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            errorMessage.append("Password must contain at least one special character.\n");
            isValid = false;
        }

        if (!isValid) {
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource("/imgs/error.png"));
            if (icon == null) {
                System.err.println("Error: Image not found at /imgs/error.png");
            }
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE, icon);
        } catch (Exception e) {
            System.err.println("Error loading image: " + e.getMessage());
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        return isValid;
 }
    
    
    
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            StringBuilder hexString = new StringBuilder();
            for (byte b : hashedBytes) {
                hexString.append(String.format("%02x", b));
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            JOptionPane.showMessageDialog(this, "Hashing error", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
    
    private boolean isAllFieldsEmpty() {
        return userName.getText().trim().isEmpty() && Role.getSelectedIndex() == 0 && Email.getText().trim().isEmpty()
                && Password.getPassword().length == 0;
    }
    
    public Register() {
        initComponents();
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        regPanel = new javax.swing.JPanel();
        create = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Role = new javax.swing.JComboBox<>();
        Password = new javax.swing.JPasswordField();
        password1 = new javax.swing.JLabel();
        username1 = new javax.swing.JLabel();
        email2 = new javax.swing.JLabel();
        role1 = new javax.swing.JLabel();
        create_button = new javax.swing.JLabel();
        SignIn = new javax.swing.JLabel();
        noAcct2 = new javax.swing.JLabel();
        errorUser = new javax.swing.JLabel();
        errorEmail = new javax.swing.JLabel();
        errorRole = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regPanel.setBackground(new java.awt.Color(0, 102, 102));
        regPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Create an Account");
        regPanel.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 230, 40));

        userName.setBackground(new java.awt.Color(204, 255, 204));
        userName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        userName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                userNameFocusLost(evt);
            }
        });
        userName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userNameActionPerformed(evt);
            }
        });
        regPanel.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 250, 40));

        Email.setBackground(new java.awt.Color(204, 255, 204));
        Email.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                EmailFocusLost(evt);
            }
        });
        Email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EmailActionPerformed(evt);
            }
        });
        regPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 250, 40));

        Role.setBackground(new java.awt.Color(204, 255, 204));
        Role.setFont(new java.awt.Font("Tw Cen MT", 0, 15)); // NOI18N
        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   Select a role", "   Admin", "   Patient", "   Dentist" }));
        Role.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                RoleFocusLost(evt);
            }
        });
        regPanel.add(Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 250, 40));

        Password.setBackground(new java.awt.Color(204, 255, 204));
        Password.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        regPanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 250, 40));

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setForeground(new java.awt.Color(255, 255, 255));
        password1.setText("Password");
        regPanel.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 90, -1));

        username1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(255, 255, 255));
        username1.setText("Username");
        regPanel.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 90, -1));

        email2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email2.setForeground(new java.awt.Color(255, 255, 255));
        email2.setText("Email");
        regPanel.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 90, -1));

        role1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        role1.setForeground(new java.awt.Color(255, 255, 255));
        role1.setText("Role");
        regPanel.add(role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 90, -1));

        create_button.setBackground(new java.awt.Color(0, 153, 153));
        create_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        create_button.setForeground(new java.awt.Color(255, 255, 255));
        create_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create_button.setText("CREATE ACCOUNT");
        create_button.setOpaque(true);
        create_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                create_buttonMouseClicked(evt);
            }
        });
        regPanel.add(create_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 160, 40));

        SignIn.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        SignIn.setForeground(new java.awt.Color(51, 204, 255));
        SignIn.setText("SIGN IN");
        SignIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignInMouseClicked(evt);
            }
        });
        regPanel.add(SignIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 480, -1, -1));

        noAcct2.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        noAcct2.setForeground(new java.awt.Color(255, 255, 255));
        noAcct2.setText("Already have an account?");
        regPanel.add(noAcct2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, -1, -1));
        regPanel.add(errorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 180, 20));
        regPanel.add(errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 190, 20));
        regPanel.add(errorRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 170, 20));
        regPanel.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 180, 20));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
        });
        regPanel.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 20, 20));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        regPanel.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 360, 20, 20));

        getContentPane().add(regPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 10, 390, 520));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/login.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void userNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userNameFocusLost
        
        String user = userName.getText();

        if (user.isEmpty()) {
            errorUser.setForeground(Color.RED);
            errorUser.setText("Username is required");
            errorUser.setForeground(Color.RED);
        } else {
            errorUser.setForeground(Color.BLACK);
            errorUser.setText("");
        }

        userName.repaint();
    }//GEN-LAST:event_userNameFocusLost

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusLost
        
        String em = Email.getText();

        if (em.isEmpty()) {
            errorEmail.setForeground(Color.RED);
            errorEmail.setText("Email is required");
            errorEmail.setForeground(Color.RED);
        } else {
            errorEmail.setForeground(Color.BLACK);
            errorEmail.setText("");
        }

        Email.repaint();
    }//GEN-LAST:event_EmailFocusLost

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void create_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_buttonMouseClicked
        
        ConnectDB connect = new ConnectDB();
        
        String usernameText = userName.getText().trim();
        String emailText = Email.getText().trim();
        String selectedRole = Role.getSelectedItem().toString().trim();
        char[] passwordChars = Password.getPassword();
        StringBuilder errorMessage = new StringBuilder();

        if (isAllFieldsEmpty()) {
            errorMessage.append("Please fill out the registration form.\n");
        } else {
            if (Role.getSelectedIndex() == 0) {
                errorMessage.append("Please select a type.\n");
            }
            if (emailText.isEmpty()) {
                errorMessage.append("Email cannot be empty.\n");
            } else if (!isValidEmail(emailText)) {
                errorMessage.append("Invalid email format.\n");
            } else if (isEmailTaken(emailText)) { 
                errorMessage.append("Email is already taken.\n");
            }
            if (usernameText.isEmpty()) {
                errorMessage.append("Username cannot be empty.\n");
            } else if (isUsernameTaken(usernameText)) {
                errorMessage.append("Username is already taken.\n");
            }
            if (!validatePassword(Password)) {
                return;
            }
        }
        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String passwordText = new String(passwordChars);
        String hashedPassword = hashPassword(passwordText);
        String sql = "INSERT INTO dcas_sys.users (username, email, role, password, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pst = connect.getConnection().prepareStatement(sql)) {
            pst.setString(1, usernameText);
            pst.setString(2, emailText);
            pst.setString(3, selectedRole);
            pst.setString(4, hashedPassword);
            pst.setString(5, "Pending");
            pst.executeUpdate();
            JOptionPane.showMessageDialog(this, "Registration Successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
            userName.setText("");
            Email.setText("");
            Password.setText("");
            
            LogIn loginPage = new LogIn();
            loginPage.setVisible(true);
            this.dispose();
            
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_create_buttonMouseClicked

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost
        
        String pass = Password.getText();

        if (pass.isEmpty()) {
            errorPassword.setForeground(Color.RED);
            errorPassword.setText("Password is required");
            errorPassword.setForeground(Color.RED);
        } else {
            errorPassword.setForeground(Color.BLACK);
            errorPassword.setText("");
        }

        Password.repaint();
    }//GEN-LAST:event_PasswordFocusLost

    private void RoleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RoleFocusLost
        
        String selectedRoleString = (String) Role.getSelectedItem();

            if (selectedRoleString == null || selectedRoleString.isEmpty() || selectedRoleString.equals("Select a role")) {
                errorRole.setForeground(Color.RED);
                errorRole.setText("Please select a valid role");
            } else {
                errorRole.setForeground(Color.BLACK);
                errorRole.setText("");
            }

        Role.repaint();
    }//GEN-LAST:event_RoleFocusLost

    private void SignInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignInMouseClicked
        LogIn log = new LogIn();
        log.setLocationRelativeTo(null);
        log.setVisible(true);
        this.dispose(); 
    }//GEN-LAST:event_SignInMouseClicked

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        hide.setVisible(true);
        show.setVisible(false);
        Password.setEchoChar('*');
    }//GEN-LAST:event_showMousePressed

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        show.setVisible(true);
        hide.setVisible(false);
        Password.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMousePressed

 
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
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel SignIn;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel create;
    private javax.swing.JLabel create_button;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorRole;
    private javax.swing.JLabel errorUser;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel noAcct2;
    private javax.swing.JLabel password1;
    private javax.swing.JPanel regPanel;
    private javax.swing.JLabel role1;
    private javax.swing.JLabel show;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel username1;
    // End of variables declaration//GEN-END:variables
}
