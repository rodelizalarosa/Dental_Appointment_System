
package Dashboard;

import Config.ConnectDB;
import PatientInternalPages.completeProfileInternal;
import Config.Session;
import PatientInternalPages.patient_profile_internal;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class PatientDash extends javax.swing.JFrame {

    public PatientDash() {
        initComponents();
        showCompleteProfile();
        Session.getInstance().setDesktopPane(mainDesktop);
        
        Integer userId = Session.getInstance().getCurrentUserId(); // Get logged-in user ID

        if (userId != null && hasPatientInfo(userId)) {
            showProfile();  // Show profile if user has patient info
        } else {
            showCompleteProfile();  // Otherwise, show the profile completion form
        }
    }
    
    private void showCompleteProfile() {
        completeProfileInternal profile = new completeProfileInternal();
        mainDesktop.add(profile);
        profile.setVisible(true); 
    }
    
    private void showProfile() {
        patient_profile_internal prof = new patient_profile_internal();
        mainDesktop.add(prof);
        prof.setVisible(true); 
    }
    
    
    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        dashPanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        appointmentPanel = new javax.swing.JPanel();
        appointment = new javax.swing.JLabel();
        servicePanel = new javax.swing.JPanel();
        services = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        mainDesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoPanel.setBackground(new java.awt.Color(0, 51, 51));
        logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/dental.png"))); // NOI18N
        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 190, 90));

        logoPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        dashPanel.setBackground(new java.awt.Color(0, 51, 51));
        dashPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dashPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dashPanelMouseExited(evt);
            }
        });
        dashPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboard.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard.setText("Dashboard");
        dashPanel.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(dashPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 130, -1));

        profilePanel.setBackground(new java.awt.Color(0, 51, 51));
        profilePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                profilePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                profilePanelMouseExited(evt);
            }
        });
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profile.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setText("Profile");
        profilePanel.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 130, -1));

        appointmentPanel.setBackground(new java.awt.Color(0, 51, 51));
        appointmentPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                appointmentPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                appointmentPanelMouseExited(evt);
            }
        });
        appointmentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appointment.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        appointment.setForeground(new java.awt.Color(255, 255, 255));
        appointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointment.setText("Appointment");
        appointmentPanel.add(appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(appointmentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 130, -1));

        servicePanel.setBackground(new java.awt.Color(0, 51, 51));
        servicePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                servicePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                servicePanelMouseExited(evt);
            }
        });
        servicePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        services.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        services.setForeground(new java.awt.Color(255, 255, 255));
        services.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        services.setText("Our Services");
        servicePanel.add(services, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 40));

        logoPanel.add(servicePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, 130, -1));

        paymentPanel.setBackground(new java.awt.Color(0, 51, 51));
        paymentPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                paymentPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                paymentPanelMouseExited(evt);
            }
        });
        paymentPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        payment.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payment.setText("Payment");
        paymentPanel.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(paymentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 130, -1));

        jPanel1.add(logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 600));

        mainDesktop.setBackground(new java.awt.Color(153, 153, 153));
        mainDesktop.setLayout(new java.awt.BorderLayout());
        jPanel1.add(mainDesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 760, 600));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private boolean hasPatientInfo(int userId) {
        boolean exists = false;

        try {
            ConnectDB db = new ConnectDB();
            Connection conn = db.getConnection();

            String query = "SELECT COUNT(*) FROM patients WHERE user_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(query)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        exists = rs.getInt(1) > 0; // If count > 0, user has patient info
                    }
                }
            }
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return exists;
    }
    
    private void dashPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseClicked
       // showDashboard();
    }//GEN-LAST:event_dashPanelMouseClicked

    private void dashPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseEntered
        dashPanel.setBackground(hoverColor);
    }//GEN-LAST:event_dashPanelMouseEntered

    private void dashPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseExited
        dashPanel.setBackground(navColor);
    }//GEN-LAST:event_dashPanelMouseExited

    private void profilePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseClicked
        // showProfile();
    }//GEN-LAST:event_profilePanelMouseClicked

    private void profilePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseEntered
        profilePanel.setBackground(hoverColor);
    }//GEN-LAST:event_profilePanelMouseEntered

    private void profilePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseExited
        profilePanel.setBackground(navColor);
    }//GEN-LAST:event_profilePanelMouseExited

    private void appointmentPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentPanelMouseEntered
        appointmentPanel.setBackground(hoverColor);
    }//GEN-LAST:event_appointmentPanelMouseEntered

    private void appointmentPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_appointmentPanelMouseExited
        appointmentPanel.setBackground(navColor);
    }//GEN-LAST:event_appointmentPanelMouseExited

    private void servicePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicePanelMouseEntered
        servicePanel.setBackground(hoverColor);
    }//GEN-LAST:event_servicePanelMouseEntered

    private void servicePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_servicePanelMouseExited
        servicePanel.setBackground(navColor);
    }//GEN-LAST:event_servicePanelMouseExited

    private void paymentPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentPanelMouseEntered
        paymentPanel.setBackground(hoverColor);
    }//GEN-LAST:event_paymentPanelMouseEntered

    private void paymentPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paymentPanelMouseExited
        paymentPanel.setBackground(navColor);
    }//GEN-LAST:event_paymentPanelMouseExited

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
            java.util.logging.Logger.getLogger(PatientDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PatientDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PatientDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PatientDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PatientDash().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointment;
    private javax.swing.JPanel appointmentPanel;
    private javax.swing.JPanel dashPanel;
    private javax.swing.JLabel dashboard;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JDesktopPane mainDesktop;
    private javax.swing.JLabel payment;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JPanel servicePanel;
    private javax.swing.JLabel services;
    // End of variables declaration//GEN-END:variables
}
