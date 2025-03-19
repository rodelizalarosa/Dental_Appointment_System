
package AdminInternalPages;

import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class userUPDATE extends javax.swing.JInternalFrame {

    private int userId;
    private String originalUsername;
    private String originalEmail;
    private String originalRole;

    Color hoverColor = new Color(0, 153, 153);
    Color navColor = new Color(0, 51, 51);

    public userUPDATE(int id, String username, String email, String role) {
        initComponents(); // Initialize GUI components

        this.userId = id;
        this.originalUsername = username;
        this.originalEmail = email;
        this.originalRole = role;

        // Set values in UI components
        userid.setText(String.valueOf(id));
        userName.setText(username);
        Email.setText(email);
        Role.setSelectedItem(role);
        Password.setText(""); // Leave password empty for security

        userid.setEditable(false); // Make user ID non-editable

        // Add Action Listener for Save Button
        change_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveChanges();
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
             query = "UPDATE users SET username=?, email=?, role=? WHERE user_id=?";
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

             query = "UPDATE users SET username=?, email=?, role=?, password=? WHERE user_id=?";
             ps = conn.prepareStatement(query);
             ps.setString(1, newUsername);
             ps.setString(2, newEmail);
             ps.setString(3, newRole);
             ps.setString(4, hashedPassword); // Use the hashed password
             ps.setInt(5, userId);
         }

         int rowsUpdated = ps.executeUpdate();
         if (rowsUpdated > 0) {
             JOptionPane.showMessageDialog(this, "User Information Updated Successfully!");
             this.dispose(); // Close the update form
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

        userid.setText(String.valueOf(id));
        userName.setText(username);
        Email.setText(email);
        Role.setSelectedItem(role);
        Password.setText(""); // Keep password field empty for security
    }

                        

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        show = new javax.swing.JLabel();
        hide = new javax.swing.JLabel();
        change_button = new javax.swing.JLabel();
        userName = new javax.swing.JTextField();
        username = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        regPanel.setBackground(new java.awt.Color(0, 102, 102));
        regPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        create.setFont(new java.awt.Font("Nirmala UI", 1, 24)); // NOI18N
        create.setForeground(new java.awt.Color(255, 255, 255));
        create.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        create.setText("Edit User Information ");
        regPanel.add(create, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, 290, 40));

        userid.setBackground(new java.awt.Color(204, 255, 204));
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

        Email.setBackground(new java.awt.Color(204, 255, 204));
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
        regPanel.add(Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 150, 250, 40));

        Role.setBackground(new java.awt.Color(204, 255, 204));
        Role.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        Role.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "   Select a role", "   Admin", "   Patient", "   Dentist" }));
        Role.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                RoleFocusLost(evt);
            }
        });
        regPanel.add(Role, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 250, 40));

        Password.setBackground(new java.awt.Color(204, 255, 204));
        Password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                PasswordFocusLost(evt);
            }
        });
        regPanel.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 250, 40));

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setForeground(new java.awt.Color(255, 255, 255));
        password1.setText("Password");
        regPanel.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, 90, -1));

        id.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        id.setForeground(new java.awt.Color(255, 255, 255));
        id.setText("User ID");
        regPanel.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, -1));

        email2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email2.setForeground(new java.awt.Color(255, 255, 255));
        email2.setText("Email");
        regPanel.add(email2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 90, -1));

        role1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        role1.setForeground(new java.awt.Color(255, 255, 255));
        role1.setText("Role");
        regPanel.add(role1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 90, -1));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
        });
        regPanel.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 20, 20));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        regPanel.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 20, 20));

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
        regPanel.add(change_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 130, 30));

        userName.setBackground(new java.awt.Color(204, 255, 204));
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
        regPanel.add(userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 250, 40));

        username.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.setText("Username");
        regPanel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 90, -1));

        jPanel1.add(regPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 610, 360));

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

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 410, 90, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clinicbg.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 480));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Email;
    private javax.swing.JPasswordField Password;
    private javax.swing.JComboBox<String> Role;
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel change_button;
    private javax.swing.JLabel create;
    private javax.swing.JLabel email2;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel id;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel password1;
    private javax.swing.JPanel regPanel;
    private javax.swing.JLabel role1;
    private javax.swing.JLabel show;
    private javax.swing.JTextField userName;
    private javax.swing.JTextField userid;
    private javax.swing.JLabel username;
    // End of variables declaration//GEN-END:variables

}
