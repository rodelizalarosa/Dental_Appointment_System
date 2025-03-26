
package ManageUserInternalPages;

import Authentication.LogIn;
import ManageUserInternalPages.userInternal;
import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.awt.Component;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;


public class userUPDATE extends javax.swing.JInternalFrame {

    private int userId;
    private String originalUsername;
    private String originalEmail;
    private String originalRole;

    Color hoverColor = new Color(0, 153, 153);
    Color navColor = new Color(0, 51, 51);

    public userUPDATE(int id, String username, String email, String role) {
        initComponents(); // Initialize GUI components
        borderField();

        this.userId = id;
        this.originalUsername = username;
        this.originalEmail = email;
        this.originalRole = role;

        populateFields(); // Populate fields with provided data

        userid.setEditable(false); // Make user ID non-editable

        // Add Action Listener for Save Button
        change_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveChanges();
            }
        });

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
    }

    private void populateFields() {
        userid.setText(String.valueOf(userId));
        userName.setText(originalUsername);
        Email.setText(originalEmail);

        // Find the matching role, ignoring leading spaces
        for (int i = 0; i < Role.getItemCount(); i++) {
            String item = Role.getItemAt(i).trim();
            if (item.equals(originalRole.trim())) {
                Role.setSelectedIndex(i);
                break;
            }
        }

        Password.setText(""); // Leave password empty for security
    }



    private void borderField(){
        userid.setBackground(new Color(0, 0, 0, 0));
        userid.setBorder(new LineBorder(Color.GRAY, 2));

        userName.setBackground(new Color(0, 0, 0, 0));
        userName.setBorder(new LineBorder(Color.GRAY, 2));

        Email.setBackground(new Color(0, 0, 0, 0));
        Email.setBorder(new LineBorder(Color.GRAY, 2));

        Role.setBackground(new Color(0, 0, 0, 0));
        Role.setBorder(new LineBorder(Color.GRAY, 2));

        Password.setBackground(new Color(0, 0, 0, 0));
        Password.setBorder(new LineBorder(Color.GRAY, 2));

        ConfirmPass.setBackground(new Color(0, 0, 0, 0));
        ConfirmPass.setBorder(new LineBorder(Color.GRAY, 2));
        
        Role.setRenderer(new DefaultListCellRenderer() {
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

    private void saveChanges() {
        try {
         ConnectDB db = new ConnectDB();
         Connection conn = db.getConnection();

         // Get updated data from fields
         String newUsername = userName.getText().trim();
         String newEmail = Email.getText().trim();
         String newRole = Role.getSelectedItem().toString().trim();
         String newPassword = new String(Password.getPassword()).trim();

         // If the password field is empty, do NOT update the password
         String query;
         PreparedStatement ps;

         if (newPassword.isEmpty()) {
             query = "UPDATE users SET u_username=?, u_email=?, u_role=? WHERE user_id=?";
             ps = conn.prepareStatement(query);
             ps.setString(1, newUsername);
             ps.setString(2, newEmail);
             ps.setString(3, newRole);
             ps.setInt(4, userId);
         } else {
             // Hash the new password before updating
             String hashedPassword = hashPassword(newPassword);
             if (hashedPassword == null) {
                 return; // Hashing failed, don't proceed with update
             }

             query = "UPDATE users SET u_username=?, u_email=?, u_role=?, u_password=? WHERE user_id=?";
             ps = conn.prepareStatement(query);
             ps.setString(1, newUsername);
             ps.setString(2, newEmail);
             ps.setString(3, newRole);
             ps.setString(4, hashedPassword); 
             ps.setInt(5, userId);
         }

         int rowsUpdated = ps.executeUpdate();
         if (rowsUpdated > 0) {
             JOptionPane.showMessageDialog(this, "User Information Updated Successfully!");
             this.dispose();
         } else {
             JOptionPane.showMessageDialog(this, "Failed to Update User Information.");
         }

         ps.close();
         conn.close();
     } catch (SQLException e) {
         JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
     }
 }

    public void setUserData(int id, String username, String email, String role) {
        this.userId = id;
        this.originalUsername = username;
        this.originalEmail = email;
        this.originalRole = role;

        // Fetch role & password from DB
        try {
            ConnectDB db = new ConnectDB();
            Connection conn = db.getConnection();
            String query = "SELECT u_role, u_password FROM users WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                this.originalRole = rs.getString("u_role"); 
                String storedPassword = rs.getString("u_password");

                userid.setText(String.valueOf(id));
                userName.setText(username);
                Email.setText(email);
                Role.setSelectedItem(originalRole);
                Password.setText("********"); // Hide actual password for security
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error retrieving user data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


                        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        updateUserPanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        updateuser = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        regPanel = new javax.swing.JPanel();
        create = new javax.swing.JLabel();
        userid = new javax.swing.JTextField();
        Email = new javax.swing.JTextField();
        Role = new javax.swing.JComboBox<>();
        Password = new javax.swing.JPasswordField();
        password1 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        email2 = new javax.swing.JLabel();
        role1 = new javax.swing.JLabel();
        showCon = new javax.swing.JLabel();
        hidePass = new javax.swing.JLabel();
        change_button = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        confirmPassword = new javax.swing.JLabel();
        ConfirmPass = new javax.swing.JPasswordField();
        hideCon = new javax.swing.JLabel();
        showPass = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(760, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        updateUserPanel.setBackground(new java.awt.Color(0, 51, 51));
        updateUserPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        updateUserPanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        updateUserPanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        updateuser.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        updateuser.setForeground(new java.awt.Color(255, 255, 255));
        updateuser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updateuser.setText("Update User");
        updateUserPanel.add(updateuser, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 150, -1));

        getContentPane().add(updateUserPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regPanel.setBackground(new java.awt.Color(0, 51, 51));
        regPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Edit User Information ");
        regPanel.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 290, 40));

        userid.setForeground(new java.awt.Color(255, 255, 255));
        userid.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                useridFocusLost(evt);
            }
        });
        userid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                useridActionPerformed(evt);
            }
        });
        regPanel.add(userid, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 70, 40));

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
        regPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 40));

        Role.setBackground(new java.awt.Color(204, 255, 204));
        Role.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Role.setForeground(new java.awt.Color(255, 255, 255));
        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   Select a role", "   Admin", "   Patient", "   Dentist" }));
        Role.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                RoleFocusLost(evt);
            }
        });
        regPanel.add(Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 150, 250, 40));

        Password.setForeground(new java.awt.Color(255, 255, 255));
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        regPanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 250, 40));

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setForeground(new java.awt.Color(255, 255, 255));
        password1.setText("Password");
        regPanel.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 90, -1));

        id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("User ID");
        regPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, -1));

        email2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email2.setForeground(new java.awt.Color(255, 255, 255));
        email2.setText("Email");
        regPanel.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        role1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        role1.setForeground(new java.awt.Color(255, 255, 255));
        role1.setText("Role");
        regPanel.add(role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 130, 90, -1));

        showCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        showCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showConMousePressed(evt);
            }
        });
        regPanel.add(showCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 20, 20));

        hidePass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hidePass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hidePassMousePressed(evt);
            }
        });
        regPanel.add(hidePass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 20, 20));

        change_button.setBackground(new java.awt.Color(0, 153, 153));
        change_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        change_button.setForeground(new java.awt.Color(255, 255, 255));
        change_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        change_button.setText("Save changes");
        change_button.setOpaque(true);
        change_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                change_buttonMouseClicked(evt);
            }
        });
        regPanel.add(change_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 300, 210, 40));

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
        regPanel.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 80, 250, 40));

        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        regPanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 90, -1));

        confirmPassword.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        confirmPassword.setForeground(new java.awt.Color(255, 255, 255));
        confirmPassword.setText("Confirm Password");
        regPanel.add(confirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 160, -1));

        ConfirmPass.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        ConfirmPass.setForeground(new java.awt.Color(255, 255, 255));
        ConfirmPass.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ConfirmPassFocusLost(evt);
            }
        });
        regPanel.add(ConfirmPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, 250, 40));

        hideCon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hideCon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideConMousePressed(evt);
            }
        });
        regPanel.add(hideCon, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 20, 20));

        showPass.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        showPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showPassMousePressed(evt);
            }
        });
        regPanel.add(showPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 230, 20, 20));

        jPanel1.add(regPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 630, 360));

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

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 520, 90, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clinicbg.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 780, 690));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 770, 610));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_EmailFocusLost

    }//GEN-LAST:event_EmailFocusLost

    private void EmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EmailActionPerformed

    private void RoleFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_RoleFocusLost

    }//GEN-LAST:event_RoleFocusLost

    private void PasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PasswordFocusLost

    }//GEN-LAST:event_PasswordFocusLost

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

    private void change_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_change_buttonMouseClicked

        
            
    }//GEN-LAST:event_change_buttonMouseClicked

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
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameFocusLost

    private void userNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userNameActionPerformed

    private void useridActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_useridActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_useridActionPerformed

    private void useridFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_useridFocusLost

    }//GEN-LAST:event_useridFocusLost

    private void ConfirmPassFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ConfirmPassFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_ConfirmPassFocusLost

    private void hideConMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideConMousePressed
        showCon.setVisible(true);
        hideCon.setVisible(false);
        ConfirmPass.setEchoChar((char) 0);
    }//GEN-LAST:event_hideConMousePressed

    private void showPassMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showPassMousePressed
        hidePass.setVisible(true);
        showPass.setVisible(false);
        Password.setEchoChar('*');
    }//GEN-LAST:event_showPassMousePressed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField ConfirmPass;
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel change_button;
    private javax.swing.JLabel confirmPassword;
    private javax.swing.JLabel create;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel hideCon;
    private javax.swing.JLabel hidePass;
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JPanel regPanel;
    private javax.swing.JLabel role1;
    private javax.swing.JLabel showCon;
    private javax.swing.JLabel showPass;
    private javax.swing.JPanel updateUserPanel;
    private javax.swing.JLabel updateuser;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userid;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

}
