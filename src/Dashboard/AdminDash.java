
package Dashboard;

import java.awt.Color;
import Authentication.LogIn;
import AdminInternalPages.*;
import Config.Session;
import javax.swing.ImageIcon;
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
        jPanel2 = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        logoPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        appointment = new javax.swing.JLabel();
        manage = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        profile = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        users = new javax.swing.JLabel();
        patientPanel = new javax.swing.JPanel();
        patient = new javax.swing.JLabel();
        dentistPanel = new javax.swing.JPanel();
        dentist = new javax.swing.JLabel();
        paymentPanel = new javax.swing.JPanel();
        payment = new javax.swing.JLabel();
        servicePanel = new javax.swing.JPanel();
        services = new javax.swing.JLabel();
        bookPanel = new javax.swing.JPanel();
        book = new javax.swing.JLabel();
        dashPanel = new javax.swing.JPanel();
        dashboard = new javax.swing.JLabel();
        mainDesktop = new javax.swing.JDesktopPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(0, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        jPanel2.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        jPanel2.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Welcome, Admin");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, 150, -1));

        mainPanel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 730, 60));

        logoPanel.setBackground(new java.awt.Color(0, 51, 51));
        logoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/dental.png"))); // NOI18N
        jPanel3.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 170, 90));

        logoPanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 60));

        appointment.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        appointment.setForeground(new java.awt.Color(255, 255, 255));
        appointment.setText("Appointment");
        logoPanel.add(appointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 110, 30));

        manage.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        manage.setForeground(new java.awt.Color(255, 255, 255));
        manage.setText("Manage");
        logoPanel.add(manage, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 60, 30));

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

        profile.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        profile.setForeground(new java.awt.Color(255, 255, 255));
        profile.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profile.setText("Profile");
        profilePanel.add(profile, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 130, -1));

        userPanel.setBackground(new java.awt.Color(0, 51, 51));
        userPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userPanelMouseExited(evt);
            }
        });
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        users.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        users.setForeground(new java.awt.Color(255, 255, 255));
        users.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        users.setText("Users");
        userPanel.add(users, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 130, -1));

        patientPanel.setBackground(new java.awt.Color(0, 51, 51));
        patientPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                patientPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                patientPanelMouseExited(evt);
            }
        });
        patientPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patient.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        patient.setForeground(new java.awt.Color(255, 255, 255));
        patient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patient.setText("Patients");
        patientPanel.add(patient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(patientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 130, -1));

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

        dentist.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dentist.setForeground(new java.awt.Color(255, 255, 255));
        dentist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dentist.setText("Dentist");
        dentistPanel.add(dentist, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(dentistPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 130, 30));

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

        payment.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        payment.setForeground(new java.awt.Color(255, 255, 255));
        payment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        payment.setText("Payment");
        paymentPanel.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(paymentPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 130, -1));

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

        services.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        services.setForeground(new java.awt.Color(255, 255, 255));
        services.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        services.setText("Our Services");
        servicePanel.add(services, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 110, 30));

        logoPanel.add(servicePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, 130, -1));

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

        book.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        book.setForeground(new java.awt.Color(255, 255, 255));
        book.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        book.setText("Book");
        bookPanel.add(book, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(bookPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 130, -1));

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

        dashboard.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        dashboard.setForeground(new java.awt.Color(255, 255, 255));
        dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboard.setText("Dashboard");
        dashPanel.add(dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        logoPanel.add(dashPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 130, -1));

        mainPanel.add(logoPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 170, 550));

        mainDesktop.setBackground(new java.awt.Color(255, 255, 255));
        mainDesktop.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout mainDesktopLayout = new javax.swing.GroupLayout(mainDesktop);
        mainDesktop.setLayout(mainDesktopLayout);
        mainDesktopLayout.setHorizontalGroup(
            mainDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 730, Short.MAX_VALUE)
        );
        mainDesktopLayout.setVerticalGroup(
            mainDesktopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );

        mainPanel.add(mainDesktop, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 730, 490));

        getContentPane().add(mainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void showDashboard() {
        dashboardInt dash = new dashboardInt();
        mainDesktop.add(dash);
        dash.setVisible(true);
    }
    
    private void showProfile() {
        profileInt prof = new profileInt();
        mainDesktop.add(prof);
        prof.setVisible(true);
    }
    
    private void logoutPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseEntered
        logoutPanel.setBackground(hoverColor);
    }//GEN-LAST:event_logoutPanelMouseEntered

    private void logoutPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseExited
        logoutPanel.setBackground(navColor);
    }//GEN-LAST:event_logoutPanelMouseExited

    private void profilePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseEntered
        profilePanel.setBackground(hoverColor);
    }//GEN-LAST:event_profilePanelMouseEntered

    private void profilePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseExited
        profilePanel.setBackground(navColor);
    }//GEN-LAST:event_profilePanelMouseExited

    private void userPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseEntered
        userPanel.setBackground(hoverColor);
    }//GEN-LAST:event_userPanelMouseEntered

    private void userPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userPanelMouseExited
        userPanel.setBackground(navColor);
    }//GEN-LAST:event_userPanelMouseExited

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

    private void profilePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilePanelMouseClicked
        showProfile();
    }//GEN-LAST:event_profilePanelMouseClicked

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel logoPanel;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JDesktopPane mainDesktop;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel manage;
    private javax.swing.JLabel patient;
    private javax.swing.JPanel patientPanel;
    private javax.swing.JLabel payment;
    private javax.swing.JPanel paymentPanel;
    private javax.swing.JLabel profile;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JPanel servicePanel;
    private javax.swing.JLabel services;
    private javax.swing.JPanel userPanel;
    private javax.swing.JLabel users;
    // End of variables declaration//GEN-END:variables
}
