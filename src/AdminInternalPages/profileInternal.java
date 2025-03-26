
package AdminInternalPages;

import Authentication.LogIn;
import Config.ConnectDB;
import Config.Session;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;


public class profileInternal extends javax.swing.JInternalFrame {

    public profileInternal() {
        initComponents();
        loadUserProfile();

        this.setLayout(new BorderLayout());

        this.setPreferredSize(new Dimension(730, 550));
        this.setSize(730, 550);

        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());
//
//        Session.getInstance().getDesktopPane().add(this);

        this.setVisible(true);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        defaultProf = new javax.swing.JLabel();
        usernameGet = new javax.swing.JLabel();
        emailGet = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        Profile = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        defaultProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/defaultProfile.png"))); // NOI18N
        jPanel3.add(defaultProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 130));

        usernameGet.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        usernameGet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(usernameGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 170, 30));

        emailGet.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        emailGet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(emailGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 170, 20));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 400));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 660, 400));

        profilePanel.setBackground(new java.awt.Color(0, 51, 51));
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        profilePanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        profilePanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        Profile.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Profile.setForeground(new java.awt.Color(255, 255, 255));
        Profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Profile.setText("Profile");
        profilePanel.add(Profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 150, -1));

        jPanel1.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

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

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 540, 90, -1));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clinicbg.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 770, 660));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    private void loadUserProfile() {
        Session session = Session.getInstance(); 
        int userId = session.getUserId();

        if (userId == 0) {
            JOptionPane.showMessageDialog(this, "No user is logged in!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        ConnectDB db = new ConnectDB();
        Connection con = db.getConnection();

        String sql = "SELECT u_username, u_email FROM users WHERE user_id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String username = rs.getString("u_username");
                String email = rs.getString("u_email");

                // Update labels
                usernameGet.setText(username);
                emailGet.setText(email);

                // Update session
                session.setUser(userId, username, email);
            } else {
                usernameGet.setText("User not found");
                emailGet.setText("");
            }

            rs.close();
            pst.close();
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading profile: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void backPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseClicked
        this.dispose();
    }//GEN-LAST:event_backPanelMouseClicked

    private void backPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseEntered
        backPanel.setBackground(hoverColor);
    }//GEN-LAST:event_backPanelMouseEntered

    private void backPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseExited
        backPanel.setBackground(navColor);
    }//GEN-LAST:event_backPanelMouseExited

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
                new profileInternal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Profile;
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel defaultProf;
    private javax.swing.JLabel emailGet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel usernameGet;
    // End of variables declaration//GEN-END:variables
}
