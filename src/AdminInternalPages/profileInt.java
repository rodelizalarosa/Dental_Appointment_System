
package AdminInternalPages;

import Config.ConnectDB;
import Config.Session;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class profileInt extends javax.swing.JInternalFrame {

    
    public profileInt() {
        initComponents();
        loadUserProfile(); // Load user data
    }

    Color hoverColor = new Color (0,153,153);
    Color navColor = new Color (0,51,51);
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profileInternalFrame = new javax.swing.JInternalFrame();
        profilePanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        defaultProf = new javax.swing.JLabel();
        usernameGet = new javax.swing.JLabel();
        emailGet = new javax.swing.JLabel();
        backPanel = new javax.swing.JPanel();
        back = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        profileInternalFrame.setBackground(new java.awt.Color(255, 255, 255));
        profileInternalFrame.setVisible(true);
        profileInternalFrame.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        profilePanel.setBackground(new java.awt.Color(255, 255, 255));
        profilePanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        defaultProf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/defaultProfile.png"))); // NOI18N
        jPanel2.add(defaultProf, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 130, 130));

        usernameGet.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 24)); // NOI18N
        usernameGet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(usernameGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 170, 30));

        emailGet.setFont(new java.awt.Font("Tw Cen MT Condensed", 1, 14)); // NOI18N
        emailGet.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel2.add(emailGet, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 170, 20));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 220, 400));

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

        jPanel1.add(backPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 360, 90, -1));

        profilePanel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 650, 400));

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/login.png"))); // NOI18N
        profilePanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 460));

        profileInternalFrame.getContentPane().add(profilePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 720, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profileInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, 730, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(profileInternalFrame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    
    
    private void backPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseEntered
        backPanel.setBackground(hoverColor);
    }//GEN-LAST:event_backPanelMouseEntered

    private void backPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseExited
        backPanel.setBackground(navColor);
    }//GEN-LAST:event_backPanelMouseExited

    private void backPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backPanelMouseClicked
        this.dispose();
    }//GEN-LAST:event_backPanelMouseClicked

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
                new profileInt().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel back;
    private javax.swing.JPanel backPanel;
    private javax.swing.JLabel defaultProf;
    private javax.swing.JLabel emailGet;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JInternalFrame profileInternalFrame;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel usernameGet;
    // End of variables declaration//GEN-END:variables
}
