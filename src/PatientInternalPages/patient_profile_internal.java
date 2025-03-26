
package PatientInternalPages;

import Authentication.LogIn;
import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class patient_profile_internal extends javax.swing.JInternalFrame {

   
    public patient_profile_internal() {
        initComponents();
        loadUserFullName();
        
         //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

     
    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    private void loadUserFullName() {
        int userId = Session.getInstance().getUserId(); // Get logged-in user's ID

        try {
            ConnectDB db = new ConnectDB();
            Connection conn = db.getConnection();

            // Query to get first_name and last_name separately
            String query = "SELECT p_fname, p_lname FROM patients WHERE user_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String firstName = rs.getString("p_fname");
                String lastName = rs.getString("p_lname");

                if (firstName == null || lastName == null) {
                    fullName.setText("Unknown User");
                } else {
                    fullName.setText(firstName + " " + lastName);
                }
            } else {
                fullName.setText("User not found");
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
            fullName.setText("Error loading name");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        patientProfilePanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        patientProfile = new javax.swing.JLabel();
        fullName = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientProfilePanel.setBackground(new java.awt.Color(0, 51, 51));
        patientProfilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        patientProfilePanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        patientProfilePanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        patientProfile.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        patientProfile.setForeground(new java.awt.Color(255, 255, 255));
        patientProfile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientProfile.setText("Patient Profile");
        patientProfilePanel.add(patientProfile, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 280, -1));

        jPanel1.add(patientProfilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        fullName.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jPanel1.add(fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, 270, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked
        
        Session sess = new Session();  
        sess.logEvent("LOGOUT", "User logged out");
        
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
    private javax.swing.JLabel fullName;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel patientProfile;
    private javax.swing.JPanel patientProfilePanel;
    private javax.swing.JLabel profileIcon;
    // End of variables declaration//GEN-END:variables
}
