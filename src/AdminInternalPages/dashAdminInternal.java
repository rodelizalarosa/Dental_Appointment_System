
package AdminInternalPages;

import Authentication.LogIn;
import Config.ConnectDB;
import Config.Session;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;

public class dashAdminInternal extends javax.swing.JInternalFrame {

    public dashAdminInternal() {
        initComponents();
        
        //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
    }

    
    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashMainPanel = new javax.swing.JPanel();
        dashboardPanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        Dashboard = new javax.swing.JLabel();
        patientsPanel = new javax.swing.JPanel();
        totalPatient = new javax.swing.JLabel();
        patientIcon = new javax.swing.JLabel();
        patientNumber = new javax.swing.JLabel();
        activeDoctorPanel = new javax.swing.JPanel();
        activeDoctor = new javax.swing.JLabel();
        doctorIcon = new javax.swing.JLabel();
        doctorNumber = new javax.swing.JLabel();
        appointmentsPanel = new javax.swing.JPanel();
        totalAppointment = new javax.swing.JLabel();
        appointmentIcon = new javax.swing.JLabel();
        appointmentNumber = new javax.swing.JLabel();
        totalAccountsPanel = new javax.swing.JPanel();
        totalServices = new javax.swing.JLabel();
        services = new javax.swing.JLabel();
        servicesNumber = new javax.swing.JLabel();
        transTable = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        transactions = new javax.swing.JLabel();
        refreshPanel = new javax.swing.JPanel();
        refresh = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashMainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashboardPanel.setBackground(new java.awt.Color(0, 51, 51));
        dashboardPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        logoutPanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 80, 30));

        logoutLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logout.png"))); // NOI18N
        logoutPanel.add(logoutLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 30, 30));

        dashboardPanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 20, 120, -1));

        profileIcon.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        profileIcon.setForeground(new java.awt.Color(255, 255, 255));
        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/male_user_50px.png"))); // NOI18N
        profileIcon.setText("  Hello, Admin");
        dashboardPanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 190, 60));

        Dashboard.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        Dashboard.setForeground(new java.awt.Color(255, 255, 255));
        Dashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Dashboard.setText("Dashboard");
        dashboardPanel.add(Dashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 20, 150, -1));

        dashMainPanel.add(dashboardPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 60));

        patientsPanel.setBackground(new java.awt.Color(255, 255, 255));
        patientsPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        patientsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalPatient.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        totalPatient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalPatient.setText("Total Patient");
        patientsPanel.add(totalPatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        patientIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/patient.png"))); // NOI18N
        patientsPanel.add(patientIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        patientNumber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        patientNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        patientsPanel.add(patientNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 60, 50));

        dashMainPanel.add(patientsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 170, 120));

        activeDoctorPanel.setBackground(new java.awt.Color(255, 255, 255));
        activeDoctorPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activeDoctor.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        activeDoctor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activeDoctor.setText("Active Doctor");
        activeDoctorPanel.add(activeDoctor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        doctorIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        doctorIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/medical.png"))); // NOI18N
        activeDoctorPanel.add(doctorIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 50, 50));

        doctorNumber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        doctorNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activeDoctorPanel.add(doctorNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 60, 50));

        dashMainPanel.add(activeDoctorPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 170, 120));

        appointmentsPanel.setBackground(new java.awt.Color(255, 255, 255));
        appointmentsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalAppointment.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        totalAppointment.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAppointment.setText("Total Appointment");
        appointmentsPanel.add(totalAppointment, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        appointmentIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/appointment.png"))); // NOI18N
        appointmentsPanel.add(appointmentIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 50, 40));

        appointmentNumber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        appointmentNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appointmentsPanel.add(appointmentNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 60, 50));

        dashMainPanel.add(appointmentsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 170, 120));

        totalAccountsPanel.setBackground(new java.awt.Color(255, 255, 255));
        totalAccountsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        totalServices.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        totalServices.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalServices.setText("Total Services");
        totalAccountsPanel.add(totalServices, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 140, 20));

        services.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/healthcare.png"))); // NOI18N
        totalAccountsPanel.add(services, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 40, 40));

        servicesNumber.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        servicesNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        totalAccountsPanel.add(servicesNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 60, 50));

        dashMainPanel.add(totalAccountsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 200, 170, 120));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        transTable.setViewportView(jTable1);

        dashMainPanel.add(transTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 740, 220));

        transactions.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        transactions.setText("Recent Transcations");
        dashMainPanel.add(transactions, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 220, 30));

        refreshPanel.setBackground(new java.awt.Color(0, 51, 51));
        refreshPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                refreshPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                refreshPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                refreshPanelMouseExited(evt);
            }
        });
        refreshPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        refresh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refresh.setForeground(new java.awt.Color(255, 255, 255));
        refresh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        refresh.setText("Refresh");
        refreshPanel.add(refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 60, 30));

        dashMainPanel.add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 80, -1));

        getContentPane().add(dashMainPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void displayStatistics() {
        ConnectDB db = new ConnectDB();
        Connection con = db.getConnection();

        if (con == null) {
            System.out.println("Database connection failed!");
            return;
        }

        try {
            // 1. Count Active Doctors
            String query1 = "SELECT COUNT(*) AS ActiveDoctors FROM doctors WHERE u_status = 'Active'";
            PreparedStatement stmt1 = con.prepareStatement(query1);
            ResultSet rs1 = stmt1.executeQuery();
            if (rs1.next()) {
                int activeCount = rs1.getInt("ActiveDoctors");
                doctorNumber.setText(" " + activeCount);
            }
            rs1.close();
            stmt1.close();

            // 2. Count Total Patients
            String query2 = "SELECT COUNT(*) AS TotalPatients FROM patients";
            PreparedStatement stmt2 = con.prepareStatement(query2);
            ResultSet rs2 = stmt2.executeQuery();
            if (rs2.next()) {
                int patientCount = rs2.getInt("TotalPatients");
                patientNumber.setText(" " + patientCount);
            }
            rs2.close();
            stmt2.close();

            // 3. Count Total Appointments
            String query3 = "SELECT COUNT(*) AS TotalAppointments FROM appointments";
            PreparedStatement stmt3 = con.prepareStatement(query3);
            ResultSet rs3 = stmt3.executeQuery();
            if (rs3.next()) {
                int appointmentCount = rs3.getInt("TotalAppointments");
                appointmentNumber.setText(" " + appointmentCount);
            }
            rs3.close();
            stmt3.close();

            // 4. Count Total Services Availed
            String query4 = "SELECT COUNT(*) AS TotalServices FROM dental_services";
            PreparedStatement stmt4 = con.prepareStatement(query4);
            ResultSet rs4 = stmt4.executeQuery();
            if (rs4.next()) {
                int serviceCount = rs4.getInt("TotalServices");
                totalServices.setText(" " + serviceCount);
            }
            rs4.close();
            stmt4.close();

            // Close the connection
            con.close();

        } catch (SQLException ex) {
            System.out.println("Database Error: " + ex.getMessage());
        }
    }

    
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

    private void refreshPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseClicked
      
    }//GEN-LAST:event_refreshPanelMouseClicked

    private void refreshPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseEntered
        refreshPanel.setBackground(hoverColor);
    }//GEN-LAST:event_refreshPanelMouseEntered

    private void refreshPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseExited
        refreshPanel.setBackground(navColor);
    }//GEN-LAST:event_refreshPanelMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Dashboard;
    private javax.swing.JLabel activeDoctor;
    private javax.swing.JPanel activeDoctorPanel;
    private javax.swing.JLabel appointmentIcon;
    private javax.swing.JLabel appointmentNumber;
    private javax.swing.JPanel appointmentsPanel;
    private javax.swing.JPanel dashMainPanel;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel doctorIcon;
    private javax.swing.JLabel doctorNumber;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JLabel patientIcon;
    private javax.swing.JLabel patientNumber;
    private javax.swing.JPanel patientsPanel;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JLabel refresh;
    private javax.swing.JPanel refreshPanel;
    private javax.swing.JLabel services;
    private javax.swing.JLabel servicesNumber;
    private javax.swing.JPanel totalAccountsPanel;
    private javax.swing.JLabel totalAppointment;
    private javax.swing.JLabel totalPatient;
    private javax.swing.JLabel totalServices;
    private javax.swing.JScrollPane transTable;
    private javax.swing.JLabel transactions;
    // End of variables declaration//GEN-END:variables
}
