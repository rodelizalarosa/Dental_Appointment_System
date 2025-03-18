
package AdminInternalPages;

import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.table.DefaultTableModel;


public class userInternal extends javax.swing.JInternalFrame {

    public userInternal() {
        initComponents();
        loadUsers();
        setBackground(new Color(255, 255, 255));
        
        //remove border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0,0,0,0));
        BasicInternalFrameUI bi = (BasicInternalFrameUI)this.getUI();
        bi.setNorthPane(null);
        
        users.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12)); 
        users.getTableHeader().setOpaque(false);
        users.getTableHeader().setBorder(null);
        users.getTableHeader().setBackground(new Color(51, 51, 255));
        users.getTableHeader().setForeground(new Color(0, 0, 0));
        users.setRowHeight(25);
        
        //table colum size
        users.getColumnModel().getColumn(0).setPreferredWidth(25);
        users.getColumnModel().getColumn(1).setPreferredWidth(55);
        users.getColumnModel().getColumn(2).setPreferredWidth(150);
        users.getColumnModel().getColumn(3).setPreferredWidth(55);
        users.getColumnModel().getColumn(4).setPreferredWidth(55);
        
    }
    
    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashIntPanel = new javax.swing.JPanel();
        paneHolder = new javax.swing.JScrollPane();
        users = new javax.swing.JTable();
        refreshPanel = new javax.swing.JPanel();
        refresh = new javax.swing.JLabel();
        deletePanel = new javax.swing.JPanel();
        delete = new javax.swing.JLabel();
        editPanel = new javax.swing.JPanel();
        edit = new javax.swing.JLabel();
        addPanel = new javax.swing.JPanel();
        add = new javax.swing.JLabel();
        activatePanel = new javax.swing.JPanel();
        activate = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        dashIntPanel.setBackground(new java.awt.Color(255, 255, 255));
        dashIntPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        paneHolder.setAutoscrolls(true);

        users.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        paneHolder.setViewportView(users);

        dashIntPanel.add(paneHolder, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 670, 310));

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

        dashIntPanel.add(refreshPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 100, 80, -1));

        deletePanel.setBackground(new java.awt.Color(0, 51, 51));
        deletePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                deletePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                deletePanelMouseExited(evt);
            }
        });
        deletePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setForeground(new java.awt.Color(255, 255, 255));
        delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        delete.setText("DELETE");
        deletePanel.add(delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        dashIntPanel.add(deletePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 110, -1));

        editPanel.setBackground(new java.awt.Color(0, 51, 51));
        editPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                editPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                editPanelMouseExited(evt);
            }
        });
        editPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        edit.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        edit.setForeground(new java.awt.Color(255, 255, 255));
        edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        edit.setText("EDIT");
        editPanel.add(edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        dashIntPanel.add(editPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 110, -1));

        addPanel.setBackground(new java.awt.Color(0, 51, 51));
        addPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                addPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                addPanelMouseExited(evt);
            }
        });
        addPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add.setForeground(new java.awt.Color(255, 255, 255));
        add.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        add.setText("ADD");
        addPanel.add(add, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        dashIntPanel.add(addPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 100, 110, -1));

        activatePanel.setBackground(new java.awt.Color(0, 51, 51));
        activatePanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                activatePanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                activatePanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                activatePanelMouseExited(evt);
            }
        });
        activatePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        activate.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        activate.setForeground(new java.awt.Color(255, 255, 255));
        activate.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        activate.setText("Activate");
        activatePanel.add(activate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, 30));

        dashIntPanel.add(activatePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 110, -1));

        getContentPane().add(dashIntPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 740, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void refreshPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseClicked
        loadUsers();
    }//GEN-LAST:event_refreshPanelMouseClicked

    private void refreshPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseEntered
        refreshPanel.setBackground(hoverColor);
    }//GEN-LAST:event_refreshPanelMouseEntered

    private void refreshPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_refreshPanelMouseExited
        refreshPanel.setBackground(navColor);
    }//GEN-LAST:event_refreshPanelMouseExited

    private void deletePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseEntered
        deletePanel.setBackground(hoverColor);
    }//GEN-LAST:event_deletePanelMouseEntered

    private void deletePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseExited
        deletePanel.setBackground(navColor);
    }//GEN-LAST:event_deletePanelMouseExited

    private void editPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseEntered
        editPanel.setBackground(hoverColor);
    }//GEN-LAST:event_editPanelMouseEntered

    private void editPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseExited
        editPanel.setBackground(navColor);
    }//GEN-LAST:event_editPanelMouseExited

    private void addPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseClicked

        userADD ad = new userADD(); // Create the new internal frame

            JDesktopPane desktopPane = this.getDesktopPane(); // Get the parent DesktopPane

            if (desktopPane != null) { // Check if it's not null before using it
                desktopPane.add(ad); // Add the internal frame to the desktop pane
                ad.setVisible(true); // Show the frame

                // Center the internal frame
                int x = (desktopPane.getWidth() - ad.getWidth()) / 2;
                int y = (desktopPane.getHeight() - ad.getHeight()) / 2;
                ad.setLocation(x, y);

                try {
                    ad.setSelected(true); // Bring it to front
                } catch (java.beans.PropertyVetoException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Error: JDesktopPane is null!"); // Debugging output
            }

        this.dispose();
    }//GEN-LAST:event_addPanelMouseClicked

    private void addPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseEntered
        addPanel.setBackground(hoverColor);
    }//GEN-LAST:event_addPanelMouseEntered

    private void addPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addPanelMouseExited
        addPanel.setBackground(navColor);
    }//GEN-LAST:event_addPanelMouseExited

    private void activatePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activatePanelMouseClicked
        int selectedUserId = getSelectedUserId(); // Get the selected user's ID

        if (selectedUserId != -1) {
            try {
                ConnectDB db = new ConnectDB(); // Create an instance of dbConnector
                Connection conn = db.getConnection(); // Get database connection

                String query = "UPDATE users SET status = 'Active' WHERE user_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, selectedUserId);

                int rowsUpdated = pstmt.executeUpdate();
                if (rowsUpdated > 0) {
                    JOptionPane.showMessageDialog(this, "User Account Activated Successfully!");
                } else {
                    JOptionPane.showMessageDialog(this, "Failed to Activate User Account.");
                }
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a User to Activate.");
        }
    }//GEN-LAST:event_activatePanelMouseClicked

    private void activatePanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activatePanelMouseEntered
        activatePanel.setBackground(hoverColor);
    }//GEN-LAST:event_activatePanelMouseEntered

    private void activatePanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_activatePanelMouseExited
        activatePanel.setBackground(navColor);
    }//GEN-LAST:event_activatePanelMouseExited

    private void deletePanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletePanelMouseClicked
        int selectedUserId = getSelectedUserId(); // Get the selected user's ID

        if (selectedUserId != -1) {
            int confirmation = JOptionPane.showConfirmDialog(
                this, 
                "Do you want to delete the user information?", 
                "Confirm Deletion", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE
            );

            if (confirmation == JOptionPane.YES_OPTION) {
                try {
                    ConnectDB db = new ConnectDB(); // Create an instance of dbConnector
                    Connection conn = db.getConnection(); // Get database connection

                    String query = "DELETE FROM users WHERE user_id = ?";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, selectedUserId);

                    int rowsDeleted = pstmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(this, "User Deleted Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(this, "Failed to Delete User.");
                    }
                    pstmt.close();
                    conn.close();
                } catch (SQLException e) {
                    JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage());
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a User to Delete.");
        }
    }//GEN-LAST:event_deletePanelMouseClicked

    private void editPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editPanelMouseClicked
       
         int selectedUserId = getSelectedUserId(); // Get selected user's ID

        if (selectedUserId != -1) {
            ConnectDB connect = new ConnectDB();
            Connection conn = connect.getConnection();

            if (conn == null) {
                JOptionPane.showMessageDialog(this, "Database connection failed!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                String query = "SELECT username, email, role FROM users WHERE user_id = ?";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setInt(1, selectedUserId);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    // Retrieve user details
                    String username = rs.getString("username");
                    String email = rs.getString("email");
                    String role = rs.getString("role");

                    // Pass data to userUPDATE form (without password)
                    userUPDATE updateForm = new userUPDATE(selectedUserId, username, email, role);
                    Session.getInstance().getDesktopPane().add(updateForm);
                    updateForm.setUserData(selectedUserId, username, email, role);
                    updateForm.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(this, "User not found.");
                }

                // Close resources
                rs.close();
                pstmt.close();
                conn.close();

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select a User to Edit.");
        }
    }//GEN-LAST:event_editPanelMouseClicked

    private void loadUsers() {
        ConnectDB connect = new ConnectDB();

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("User ID");
        model.addColumn("Username");
        model.addColumn("Email");
        model.addColumn("Role");
        model.addColumn("Status");

        try {
            Connection conn = connect.getConnection();
            if (conn == null) {
                System.out.println("Database connection failed!");
                return;
            }

            String query = "SELECT user_id, username, email, role, status FROM users"; // Corrected query
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("user_id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("role"),
                    rs.getString("status")
                });
            }

            users.setModel(model);
            model.fireTableDataChanged();

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            System.out.println("Error loading users: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public int getSelectedUserId() {
        int selectedRow = users.getSelectedRow(); // Get the selected row index

            if (selectedRow != -1) { // Check if a row is selected
                return Integer.parseInt(users.getValueAt(selectedRow, 0).toString()); // Get user_id from the first column
            }
        return -1; // Return -1 if no row is selected
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
            java.util.logging.Logger.getLogger(dashboardInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashboardInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashboardInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashboardInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userInternal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel activate;
    private javax.swing.JPanel activatePanel;
    private javax.swing.JLabel add;
    private javax.swing.JPanel addPanel;
    private javax.swing.JPanel dashIntPanel;
    private javax.swing.JLabel delete;
    private javax.swing.JPanel deletePanel;
    private javax.swing.JLabel edit;
    private javax.swing.JPanel editPanel;
    private javax.swing.JScrollPane paneHolder;
    private javax.swing.JLabel refresh;
    private javax.swing.JPanel refreshPanel;
    private javax.swing.JTable users;
    // End of variables declaration//GEN-END:variables
}
