
package Dashboard;

import ManageUserInternalPages.*;
import java.awt.Color;
import Authentication.LogIn;
import AdminInternalPages.*;
import Config.*;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;


public class AdminDash extends javax.swing.JFrame {
    
    public AdminDash() {
        
        initComponents();
        showDashboard();
        Session.getInstance().setDesktopPane(mainDesktop);
    }

    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        logoPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        manage = new javax.swing.JLabel();
        dashPanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        logsPanel = new javax.swing.JPanel();
        logs = new javax.swing.JLabel();
        patientPanel = new javax.swing.JPanel();
        patient = new javax.swing.JLabel();
        dentistPanel = new javax.swing.JPanel();
        dentist = new javax.swing.JLabel();
        bookPanel = new javax.swing.JPanel();
        book = new javax.swing.JLabel();
        servicePanel = new javax.swing.JPanel();
        services = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        users1 = new javax.swing.JLabel();
        appointment = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        mainDesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoPanel.setBackground(new java.awt.Color(0, 51, 51));
        logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/dental.png"))); // NOI18N
        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 190, 90));

        logoPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        manage.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        manage.setForeground(new java.awt.Color(255, 255, 255));
        manage.setText("Manage");
        logoPanel.add(manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 160, 30));

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

        logoPanel.add(dashPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 130, -1));

        logsPanel.setBackground(new java.awt.Color(0, 51, 51));
        logsPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logsPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                logsPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                logsPanelMouseExited(evt);
            }
        });
        logsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logs.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        logs.setForeground(new java.awt.Color(255, 255, 255));
        logs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logs.setText("Logs");
        logsPanel.add(logs, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(logsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 130, -1));

        patientPanel.setBackground(new java.awt.Color(0, 51, 51));
        patientPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                patientPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientPanelMouseExited(evt);
            }
        });
        patientPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patient.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        patient.setForeground(new java.awt.Color(255, 255, 255));
        patient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient.setText("Patients");
        patientPanel.add(patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(patientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 130, -1));

        dentistPanel.setBackground(new java.awt.Color(0, 51, 51));
        dentistPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                dentistPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                dentistPanelMouseExited(evt);
            }
        });
        dentistPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dentist.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        dentist.setForeground(new java.awt.Color(255, 255, 255));
        dentist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dentist.setText("Dentist");
        dentistPanel.add(dentist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(dentistPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 130, -1));

        bookPanel.setBackground(new java.awt.Color(0, 51, 51));
        bookPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                bookPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                bookPanelMouseExited(evt);
            }
        });
        bookPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        book.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        book.setForeground(new java.awt.Color(255, 255, 255));
        book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        book.setText("Book");
        bookPanel.add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(bookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 130, -1));

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

        logoPanel.add(servicePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 490, 130, -1));

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

        logoPanel.add(paymentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 540, 130, -1));

        userPanel.setBackground(new java.awt.Color(0, 51, 51));
        userPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userPanelMouseExited(evt);
            }
        });
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        users1.setForeground(new java.awt.Color(255, 255, 255));
        users1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users1.setText("Users");
        userPanel.add(users1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 40));

        logoPanel.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 130, -1));

        appointment.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        appointment.setForeground(new java.awt.Color(255, 255, 255));
        appointment.setText("Appointment");
        logoPanel.add(appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 160, 30));

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

        logoPanel.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 130, -1));

        mainPanel.add(logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 600));

        mainDesktop.setBackground(new java.awt.Color(204, 204, 204));
        mainDesktop.setForeground(new java.awt.Color(255, 255, 255));
        mainDesktop.setPreferredSize(new java.awt.Dimension(760, 600));
        mainDesktop.setLayout(new java.awt.BorderLayout());
        mainPanel.add(mainDesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 760, 600));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showUser() {
        userInternal dash = new userInternal();
        mainDesktop.add(dash);
        dash.setVisible(true); 
    }
    
    private void showProfile() {
        profileInternal prof = new profileInternal();
        mainDesktop.add(prof);
        prof.setVisible(true);
    }
    
    private void showLogs() {
        LogDash log = new LogDash();
        mainDesktop.add(log);
        log.setVisible(true);
    }
    
    private void showDashboard(){
        dashAdminInternal adm = new dashAdminInternal();
        mainDesktop.add(adm);
        adm.setVisible(true);
    }
    
    private void showPatient(){
        patientInternal ptn = new patientInternal();
        mainDesktop.add(ptn);
        ptn.setVisible(true);
    }
    
    
    
    private void logsPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPanelMouseEntered
        logsPanel.setBackground(hoverColor);
    }//GEN-LAST:event_logsPanelMouseEntered

    private void logsPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPanelMouseExited
        logsPanel.setBackground(navColor);
    }//GEN-LAST:event_logsPanelMouseExited

    private void patientPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseEntered
        patientPanel.setBackground(hoverColor);
    }//GEN-LAST:event_patientPanelMouseEntered

    private void patientPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseExited
        patientPanel.setBackground(navColor);
    }//GEN-LAST:event_patientPanelMouseExited

    private void dentistPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dentistPanelMouseEntered
        dentistPanel.setBackground(hoverColor);
    }//GEN-LAST:event_dentistPanelMouseEntered

    private void dentistPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dentistPanelMouseExited
        dentistPanel.setBackground(navColor);
    }//GEN-LAST:event_dentistPanelMouseExited

    private void bookPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPanelMouseEntered
        bookPanel.setBackground(hoverColor);
    }//GEN-LAST:event_bookPanelMouseEntered

    private void bookPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bookPanelMouseExited
        bookPanel.setBackground(navColor);
    }//GEN-LAST:event_bookPanelMouseExited

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

    private void dashPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseEntered
        dashPanel.setBackground(hoverColor);
    }//GEN-LAST:event_dashPanelMouseEntered

    private void dashPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseExited
        dashPanel.setBackground(navColor);
    }//GEN-LAST:event_dashPanelMouseExited

    private void dashPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashPanelMouseClicked
       showDashboard();
    }//GEN-LAST:event_dashPanelMouseClicked

    private void logsPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logsPanelMouseClicked
        showLogs();
    }//GEN-LAST:event_logsPanelMouseClicked

    private void userPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseClicked
        showUser();
    }//GEN-LAST:event_userPanelMouseClicked

    private void userPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseEntered
        userPanel.setBackground(hoverColor);
    }//GEN-LAST:event_userPanelMouseEntered

    private void userPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseExited
        userPanel.setBackground(navColor);
    }//GEN-LAST:event_userPanelMouseExited

    private void patientPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_patientPanelMouseClicked
       showPatient();
    }//GEN-LAST:event_patientPanelMouseClicked

    private void profilePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseClicked
        showProfile();
    }//GEN-LAST:event_profilePanelMouseClicked

    private void profilePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseEntered
        profilePanel.setBackground(hoverColor);
    }//GEN-LAST:event_profilePanelMouseEntered

    private void profilePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseExited
        profilePanel.setBackground(navColor);
    }//GEN-LAST:event_profilePanelMouseExited

    
    public static void confirmExit() {
        int choice = JOptionPane.showConfirmDialog(
            null,
            "Are you sure you want to exit?",
            "Confirm Exit",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            System.exit(0); // Exit the application
        } 
    }
    
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
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDash.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDash().setVisible(true);
                confirmExit();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appointment;
    private javax.swing.JLabel book;
    private javax.swing.JPanel bookPanel;
    private javax.swing.JPanel dashPanel;
    private javax.swing.JLabel dashboard;
    private javax.swing.JLabel dentist;
    private javax.swing.JPanel dentistPanel;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JLabel logs;
    private javax.swing.JPanel logsPanel;
    private javax.swing.JDesktopPane mainDesktop;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel manage;
    private javax.swing.JLabel patient;
    private javax.swing.JPanel patientPanel;
    private javax.swing.JLabel payment;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JLabel profile;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JPanel servicePanel;
    private javax.swing.JLabel services;
    private javax.swing.JPanel userPanel;
    private javax.swing.JLabel users1;
    // End of variables declaration//GEN-END:variables
}
