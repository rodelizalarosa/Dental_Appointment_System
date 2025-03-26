
package Dashboard;

import Authentication.LogIn;
import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.TimerTask;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class LogDash extends javax.swing.JInternalFrame {

    public LogDash() {
        initComponents();
        loadLogs();
     //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        logs.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        logs.getTableHeader().setOpaque(false);
        logs.getTableHeader().setBorder(null);
        logs.getTableHeader().setBackground(new Color(51, 51, 255));
        logs.getTableHeader().setForeground(new Color(0, 0, 0));
        logs.setRowHeight(25);
        
        //table colum size
        logs.getColumnModel().getColumn(0).setPreferredWidth(10);
        logs.getColumnModel().getColumn(1).setPreferredWidth(10);
        logs.getColumnModel().getColumn(2).setPreferredWidth(150);
        logs.getColumnModel().getColumn(3).setPreferredWidth(150);
        logs.getColumnModel().getColumn(4).setPreferredWidth(55);
    }
    
    private void loadLogs() {
        ConnectDB connect = new ConnectDB();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Log ID");
        model.addColumn("User ID");
        model.addColumn("Event");
        model.addColumn("Description");
        model.addColumn("Timestamp");

        try {
            Connection conn = connect.getConnection();
            if (conn == null) {
                System.out.println("Database connection failed!");
                return;
            }

            // Query to retrieve logs with the user_id (since username isn't in logs)
            String query = "SELECT log_id, user_id, log_event, log_description, log_timestamp " +
                           "FROM logs " +
                           "ORDER BY log_timestamp DESC";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("log_id"),          // Log ID
                    rs.getInt("user_id"),         // User ID
                    rs.getString("log_event"),    // Log event
                    rs.getString("log_description"), // Description
                    rs.getTimestamp("log_timestamp") // Timestamp
                });
            }

            logs.setModel(model);
            model.fireTableDataChanged();

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Error loading logs: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    
    public int getSelectedUserId() {
        int selectedRow = logs.getSelectedRow(); // Get the selected row index

            if (selectedRow != -1) { // Check if a row is selected
                return Integer.parseInt(logs.getValueAt(selectedRow, 0).toString()); // Get user_id from the first column
            }
        return -1; // Return -1 if no row is selected
    }
    
    public void logEvent(int userId, String event, String description) {
   
        ConnectDB dbc = new ConnectDB();
        PreparedStatement pstmt = null;
        
        try {


            String sql = "INSERT INTO logs (user_id, log_event, log_description, log_timestamp) VALUES (?, ?, ?, ?)";
            pstmt = dbc.connect.prepareStatement(sql);
            pstmt.setInt(1, userId);
            pstmt.setString(2, event);
            pstmt.setString(3, description);
            pstmt.setTimestamp(4, new Timestamp(new Date().getTime()));

            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {

        }
    }
    
    public void autoRefreshLogs() {
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                loadLogs(); // Refresh logs every 5 seconds
            }
        });

        timer.start();
    }
    

     
    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        systemLogsPanel = new javax.swing.JPanel();
        logoutPanel = new javax.swing.JPanel();
        logout = new javax.swing.JLabel();
        logoutLogo = new javax.swing.JLabel();
        profileIcon = new javax.swing.JLabel();
        systemLogs = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        logs = new javax.swing.JTable();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        systemLogsPanel.setBackground(new java.awt.Color(0, 51, 51));
        systemLogsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        systemLogsPanel.add(logoutPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, -1, -1));

        profileIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/profile.png"))); // NOI18N
        systemLogsPanel.add(profileIcon, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 40, 40));

        systemLogs.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        systemLogs.setForeground(new java.awt.Color(255, 255, 255));
        systemLogs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        systemLogs.setText("System Logs");
        systemLogsPanel.add(systemLogs, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 280, -1));

        jPanel1.add(systemLogsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 60));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        logs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(logs);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 750, 410));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void logoutPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutPanelMouseClicked

        Session sess = Session.getInstance();
        int userId = sess.getUserId();
        logEvent(userId, "LOGOUT", "User logged out");
        
        
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logout;
    private javax.swing.JLabel logoutLogo;
    private javax.swing.JPanel logoutPanel;
    private javax.swing.JTable logs;
    private javax.swing.JLabel profileIcon;
    private javax.swing.JLabel systemLogs;
    private javax.swing.JPanel systemLogsPanel;
    // End of variables declaration//GEN-END:variables
}
