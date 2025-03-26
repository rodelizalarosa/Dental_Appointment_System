
package ManageUserInternalPages;

import Authentication.*;
import Config.*;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JComponent;
import java.security.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.DefaultListCellRenderer;


public class userADD extends javax.swing.JInternalFrame {

    public userADD() {
        initComponents();    
        borderField();
        
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        
        hidePass.setVisible(true);
        showPass.setVisible(false);
        
        hideCon.setVisible(true);
        showCon.setVisible(false);
        
    }

    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    private void borderField(){
        
         // Make username transparent with a border
        userName.setBackground(new Color(0, 0, 0, 0));
        userName.setBorder(new LineBorder(Color.GRAY, 2));
        
        // Make email transparent with a border
        Email.setBackground(new Color(0, 0, 0, 0));
        Email.setBorder(new LineBorder(Color.GRAY, 2));
        
        // Make role transparent with a border
        Role.setForeground(Color.WHITE);
        Role.setBackground(new Color(0, 0, 0, 0));
        Role.setBorder(new LineBorder(Color.GRAY, 2));
        
        // Make password transparent with a border
        Password.setBackground(new Color(0, 0, 0, 0));
        Password.setBorder(new LineBorder(Color.GRAY, 2));
        
        // Make confirm password transparent with a border
        ConfirmPass.setBackground(new Color(0, 0, 0, 0));
        ConfirmPass.setBorder(new LineBorder(Color.GRAY, 2));
        
        Role.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                Component c = super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);

                if (c instanceof JComponent) {
                    ((JComponent) c).setOpaque(true);
                }

                // Set the text color to white
                c.setForeground(Color.WHITE);

                if (isSelected) {
                    c.setBackground(hoverColor);
                } else {
                    c.setBackground(navColor);
                }

                return c;
            }
        });
      }


    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addUserPanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        addUser = new javax.swing.JLabel();
        addUserMain = new javax.swing.JPanel();
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
        errorUser = new javax.swing.JLabel();
        errorEmail = new javax.swing.JLabel();
        errorRole = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        showPass = new javax.swing.JLabel();
        hideCon = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JLabel();
        ConfirmPass = new javax.swing.JPasswordField();
        errorConfirmPass = new javax.swing.JLabel();
        showCon = new javax.swing.JLabel();
        hidePass = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addUserPanel.setBackground(new java.awt.Color(0, 51, 51));
        addUserPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        addUserPanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        addUserPanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        addUser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        addUser.setForeground(new java.awt.Color(255, 255, 255));
        addUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addUser.setText("Add User");
        addUserPanel.add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, -1));

        getContentPane().add(addUserPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        addUserMain.setBackground(new java.awt.Color(255, 255, 255));
        addUserMain.setForeground(new java.awt.Color(255, 255, 255));
        addUserMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regPanel.setBackground(new java.awt.Color(0, 51, 51));
        regPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Create User Account");
        regPanel.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, 270, 40));

        userName.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        userName.setForeground(new java.awt.Color(255, 255, 255));
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
        regPanel.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 250, 40));

        Email.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Email.setForeground(new java.awt.Color(255, 255, 255));
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
        regPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 250, 40));

        Role.setFont(new java.awt.Font("Tw Cen MT", 0, 15)); // NOI18N
        Role.setForeground(new java.awt.Color(255, 255, 255));
        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   Select a role", "   Admin", "   Patient", "   Dentist" }));
        Role.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                RoleFocusLost(evt);
            }
        });
        regPanel.add(Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 250, 40));

        Password.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        regPanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 250, 40));

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setForeground(new java.awt.Color(255, 255, 255));
        password1.setText("Password");
        regPanel.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 90, -1));

        username1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username1.setForeground(new java.awt.Color(255, 255, 255));
        username1.setText("Username");
        regPanel.add(username1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 90, -1));

        email2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email2.setForeground(new java.awt.Color(255, 255, 255));
        email2.setText("Email");
        regPanel.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 90, -1));

        role1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        role1.setForeground(new java.awt.Color(255, 255, 255));
        role1.setText("Role");
        regPanel.add(role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 90, -1));

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
        regPanel.add(create_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 250, 40));
        regPanel.add(errorUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 180, 20));
        regPanel.add(errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 190, 20));
        regPanel.add(errorRole, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 170, 20));
        regPanel.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 180, 20));

        showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        showPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showPassMousePressed(evt);
            }
        });
        regPanel.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 20, 20));

        hideCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hideCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideConMousePressed(evt);
            }
        });
        regPanel.add(hideCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 20, 20));

        confirmPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        confirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        confirmPassword.setText("Confirm Password");
        regPanel.add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 250, 160, -1));

        ConfirmPass.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        ConfirmPass.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ConfirmPassFocusLost(evt);
            }
        });
        regPanel.add(ConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 250, 40));
        regPanel.add(errorConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 310, 180, 20));

        showCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        showCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showConMousePressed(evt);
            }
        });
        regPanel.add(showCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 20, 20));

        hidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hidePassMousePressed(evt);
            }
        });
        regPanel.add(hidePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 20, 20));

        addUserMain.add(regPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 630, 410));

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

        addUserMain.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 530, 90, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clinicbg.png"))); // NOI18N
        addUserMain.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 640));

        getContentPane().add(addUserMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean isValidEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email.matches(emailRegex);
    }
    
    private boolean isEmailTaken(String email) {
        ConnectDB connect = new ConnectDB();
        String sql = "SELECT COUNT(*) FROM users WHERE u_email = ?";
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
        
        String sql = "SELECT COUNT(*) FROM users WHERE u_username = ?"; 
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
        return userName.getText().trim().isEmpty() 
                && (Role.getSelectedItem() == null || Role.getSelectedIndex() == 0) // Check for both null & index
                && Email.getText().trim().isEmpty()
                && Password.getPassword().length == 0 
                && ConfirmPass.getPassword().length == 0;
    }

    
    private void backPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseClicked
        this.dispose(); 

        userInternal dash = new userInternal();
        Session.getInstance().getDesktopPane().add(dash);
        dash.setVisible(true);
    }//GEN-LAST:event_backPanelMouseClicked

    private void backPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseEntered
        backPanel.setBackground(hoverColor);
    }//GEN-LAST:event_backPanelMouseEntered

    private void backPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseExited
        backPanel.setBackground(navColor);
    }//GEN-LAST:event_backPanelMouseExited

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

    private void create_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_create_buttonMouseClicked

        ConnectDB connect = new ConnectDB();

        String usernameText = userName.getText().trim();
        String emailText = Email.getText().trim();
        String selectedRole = Role.getSelectedItem().toString().trim();
        char[] passwordChars = Password.getPassword();
        char[] confirmPasswordChars = ConfirmPass.getPassword();
        String passwordText = new String(passwordChars);
        String confirmPasswordText = new String(confirmPasswordChars);
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
            if (!passwordText.equals(confirmPasswordText)) {
            errorMessage.append("Passwords do not match.\n");
        }
        }
        if (errorMessage.length() > 0) {
            JOptionPane.showMessageDialog(this, errorMessage.toString(), "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String hashedPassword = hashPassword(passwordText);
        String sql = "INSERT INTO dcas_sys.users (u_username, u_email, u_role, u_password, u_status) VALUES (?, ?, ?, ?, ?)";
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
            ConfirmPass.setText("");


        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_create_buttonMouseClicked

    private void showPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMousePressed
        hidePass.setVisible(true);
        showPass.setVisible(false);
        Password.setEchoChar('*');
    }//GEN-LAST:event_showPassMousePressed

    private void hideConMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideConMousePressed
        showCon.setVisible(true);
        hideCon.setVisible(false);
        ConfirmPass.setEchoChar((char) 0);
    }//GEN-LAST:event_hideConMousePressed

    private void ConfirmPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ConfirmPassFocusLost
         String conpass = ConfirmPass.getText();

        if (conpass.isEmpty()) {
            errorConfirmPass.setForeground(Color.RED);
            errorConfirmPass.setText("Confirm Password is required");
            errorConfirmPass.setForeground(Color.RED);
        } else {
            errorConfirmPass.setForeground(Color.BLACK);
            errorConfirmPass.setText("");
        }

        ConfirmPass.repaint();
    }//GEN-LAST:event_ConfirmPassFocusLost

    private void showConMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showConMousePressed
        hideCon.setVisible(true);
        showCon.setVisible(false);
        ConfirmPass.setEchoChar('*');
    }//GEN-LAST:event_showConMousePressed

    private void hidePassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hidePassMousePressed
        showPass.setVisible(true);
        hidePass.setVisible(false);
        Password.setEchoChar((char) 0);
    }//GEN-LAST:event_hidePassMousePressed

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

    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
      
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userADD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPass;
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel addUser;
    private javax.swing.JPanel addUserMain;
    private javax.swing.JPanel addUserPanel;
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel confirmPassword;
    private javax.swing.JLabel create;
    private javax.swing.JLabel create_button;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel errorConfirmPass;
    private javax.swing.JLabel errorEmail;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorRole;
    private javax.swing.JLabel errorUser;
    private javax.swing.JLabel hideCon;
    private javax.swing.JLabel hidePass;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JPanel regPanel;
    private javax.swing.JLabel role1;
    private javax.swing.JLabel showCon;
    private javax.swing.JLabel showPass;
    private javax.swing.JTextField userName;
    private javax.swing.JLabel username1;
    // End of variables declaration//GEN-END:variables

    void setLocationRelativeTo(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
