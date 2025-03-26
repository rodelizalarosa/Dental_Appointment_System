
package Authentication;

import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.awt.Font;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import Dashboard.AdminDash;
import Dashboard.PatientDash;
import javax.swing.border.LineBorder;

public class LogIn extends javax.swing.JFrame {

    public LogIn() {
        initComponents();
        borderField();
       
        hide.setVisible(true);
        show.setVisible(false);
    }

    private void borderField(){
        // Make username transparent with a border
        username.setBackground(new Color(0, 0, 0, 0));
        username.setBorder(new LineBorder(Color.GRAY, 2));

        // Make password transparent with a border
        password.setBackground(new Color(0, 0, 0, 0));
        password.setBorder(new LineBorder(Color.GRAY, 2));
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
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login_panel = new javax.swing.JPanel();
        welcome = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        login_button = new javax.swing.JLabel();
        Register = new javax.swing.JLabel();
        noAcct = new javax.swing.JLabel();
        errorPassword = new javax.swing.JLabel();
        errorUsername = new javax.swing.JLabel();
        password = new javax.swing.JPasswordField();
        password1 = new javax.swing.JLabel();
        username2 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        hide = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        forgot = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        login_panel.setBackground(new java.awt.Color(0, 51, 51));
        login_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        welcome.setBackground(new java.awt.Color(255, 255, 255));
        welcome.setFont(new java.awt.Font("Bahnschrift", 1, 20)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        welcome.setText("WELCOME TO DENTALINK");
        login_panel.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 260, 40));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logo.png"))); // NOI18N
        login_panel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 110, 100));

        login_button.setBackground(new java.awt.Color(0, 153, 153));
        login_button.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        login_button.setForeground(new java.awt.Color(255, 255, 255));
        login_button.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        login_button.setText("LOG IN");
        login_button.setOpaque(true);
        login_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                login_buttonMouseClicked(evt);
            }
        });
        login_panel.add(login_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 90, 40));

        Register.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        Register.setForeground(new java.awt.Color(51, 204, 255));
        Register.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Register.setText("CREATE ACCOUNT");
        Register.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RegisterMouseClicked(evt);
            }
        });
        login_panel.add(Register, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 530, 140, -1));

        noAcct.setFont(new java.awt.Font("Verdana", 0, 13)); // NOI18N
        noAcct.setForeground(new java.awt.Color(255, 255, 255));
        noAcct.setText("Don't have an account?");
        login_panel.add(noAcct, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, -1, -1));

        errorPassword.setForeground(new java.awt.Color(255, 0, 0));
        login_panel.add(errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 130, 20));

        errorUsername.setForeground(new java.awt.Color(255, 0, 0));
        login_panel.add(errorUsername, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 190, 20));

        password.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        password.setForeground(new java.awt.Color(255, 255, 255));
        password.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passwordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passwordFocusLost(evt);
            }
        });
        password.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                passwordMouseReleased(evt);
            }
        });
        login_panel.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 350, 250, 40));

        password1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        password1.setForeground(new java.awt.Color(255, 255, 255));
        password1.setText("Password");
        login_panel.add(password1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 90, -1));

        username2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        username2.setForeground(new java.awt.Color(255, 255, 255));
        username2.setText("Username");
        login_panel.add(username2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 90, -1));

        username.setFont(new java.awt.Font("Trebuchet MS", 0, 15)); // NOI18N
        username.setForeground(new java.awt.Color(255, 255, 255));
        username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                usernameFocusLost(evt);
            }
        });
        username.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                usernameMouseReleased(evt);
            }
        });
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });
        login_panel.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, 250, 40));

        hide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/hide.png"))); // NOI18N
        hide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hideMousePressed(evt);
            }
        });
        login_panel.add(hide, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, 20, 20));

        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/show.png"))); // NOI18N
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                showMousePressed(evt);
            }
        });
        login_panel.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 360, -1, 20));

        forgot.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        forgot.setForeground(new java.awt.Color(51, 204, 255));
        forgot.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        forgot.setText("Forgot Password");
        login_panel.add(forgot, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 130, -1));

        getContentPane().add(login_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 360, 600));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/login.png"))); // NOI18N
        getContentPane().add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 940, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegisterMouseClicked
        Register reg = new Register();
        reg.setLocationRelativeTo(null);
        reg.setVisible(true);
        this.dispose();        
    }//GEN-LAST:event_RegisterMouseClicked

    private void login_buttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_login_buttonMouseClicked
        String user = username.getText().trim();
        String pass = new String(password.getPassword()).trim();

        if (user.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in both fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        } else {
            ConnectDB db = new ConnectDB();
            Connection con = db.getConnection();
            Session sess = new Session();
            String sql = "SELECT user_id, u_password, u_status, u_role FROM users WHERE u_username = ?";

            try {
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setString(1, user);
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    String storedPassword = rs.getString("u_password");
                    String status = rs.getString("u_status");
                    String roleFromDB = rs.getString("u_role");
                    int userId = rs.getInt("user_id");

                    if (storedPassword.equals(hashPassword(pass))) {  
                        if ("Pending".equalsIgnoreCase(status)) {
                            JOptionPane.showMessageDialog(this, "Your account is pending approval.", "Login Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            sess.setUser(userId, user, roleFromDB);
                            sess.logEvent("Login ", "User Logged in");
                            JOptionPane.showMessageDialog(this, "Login successful! You are logged in as " + roleFromDB + ".", "Success", JOptionPane.INFORMATION_MESSAGE);
                            this.dispose();

                            if ("Admin".equalsIgnoreCase(roleFromDB)) {
                               new AdminDash().setVisible(true);
                            } else if ("Patient".equalsIgnoreCase(roleFromDB)) {
                                new PatientDash().setVisible(true);
                            } else if ("Dentist".equalsIgnoreCase(roleFromDB)) {
                                //new DentistDas6h().setVisible(true);
                            }
                        }
                    } else {
                        sess.logEvent( "Login ", "User attempted login");
                        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    sess.logEvent( "Login ", "User attempted login");
                    JOptionPane.showMessageDialog(this, "Invalid username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
                }

                rs.close();
                pst.close();
                con.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_login_buttonMouseClicked

    private void passwordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusLost
        
        String pass = password.getText();

        if (pass.isEmpty()) {
            errorPassword.setForeground(Color.RED);
            errorPassword.setText("Password is required");
            errorPassword.setForeground(Color.RED);
        } else {
            errorPassword.setForeground(Color.BLACK);
            errorPassword.setText("");
        }

        password.repaint();
           hide.setVisible(true);
           show.setVisible(false);
    }//GEN-LAST:event_passwordFocusLost

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_usernameFocusLost
        
        String user = username.getText();

        if (user.isEmpty()) {
            errorUsername.setForeground(Color.RED);
            errorUsername.setText("Username is required");
            errorUsername.setForeground(Color.RED);
        } else {
            errorUsername.setForeground(Color.BLACK);
            errorUsername.setText("");
        }

        username.repaint();
    }//GEN-LAST:event_usernameFocusLost

    private void usernameMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usernameMouseReleased
//        username.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Username", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0)));
//        errorUsername.setText("");
    }//GEN-LAST:event_usernameMouseReleased

    private void passwordMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordMouseReleased
//        password.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2), "Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(0, 0, 0)));
//        errorPassword.setText("");
    }//GEN-LAST:event_passwordMouseReleased

    private void hideMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hideMousePressed
        show.setVisible(true);
        hide.setVisible(false);
        password.setEchoChar((char) 0);
    }//GEN-LAST:event_hideMousePressed

    private void showMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMousePressed
        hide.setVisible(true);
        show.setVisible(false);
        password.setEchoChar('*');
    }//GEN-LAST:event_showMousePressed

    private void passwordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passwordFocusGained
        show.setVisible(false); 
    }//GEN-LAST:event_passwordFocusGained

   
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
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Register;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel errorPassword;
    private javax.swing.JLabel errorUsername;
    private javax.swing.JLabel forgot;
    private javax.swing.JLabel hide;
    private javax.swing.JLabel login_button;
    private javax.swing.JPanel login_panel;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel noAcct;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel password1;
    private javax.swing.JLabel show;
    private javax.swing.JTextField username;
    private javax.swing.JLabel username2;
    private javax.swing.JLabel welcome;
    // End of variables declaration//GEN-END:variables
}
