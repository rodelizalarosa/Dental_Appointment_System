
package AdminInternalPages;

import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class profileInternal extends javax.swing.JInternalFrame {

    public profileInternal() {
        initComponents();
        loadUserProfile();
        
        // Remove the border
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder());

        // Remove the title bar
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
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

        jPanel2.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 90, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, 650, 400));

        bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/clinicbg.png"))); // NOI18N
        jPanel1.add(bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 780, 480));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 470));

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

        String sql = "SELECT username, email FROM users WHERE user_id = ?";

        try {
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, userId);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String username = rs.getString("username");
                String email = rs.getString("email");

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
            java.util.logging.Logger.getLogger(profileInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(profileInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(profileInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(profileInt.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new profileInternal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel defaultProf;
    private javax.swing.JLabel emailGet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel usernameGet;
    // End of variables declaration//GEN-END:variables
}
