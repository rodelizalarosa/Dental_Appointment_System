package Config;

import javax.swing.JDesktopPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Session {
    private static Session instance;
    private int userId; 
    private String username;
    private String email;
    private JDesktopPane mainDesktop;

    // Private constructor to enforce Singleton pattern
    public Session() {}
    
    public void logEvent(String event, String description) {
        // Ensure a valid user is logged in before logging events

        
        if (userId == 0) {  
            System.out.println("⚠ No user logged in. Skipping log event.");
            return;
        }

        String sql = "INSERT INTO logs (user_id, log_event, log_description) VALUES (?, ?, ?)";

        try (Connection con = ConnectDB.getConnection();
             PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setInt(1, userId);  // Automatically use logged-in user ID
            pstmt.setString(2, event);
            pstmt.setString(3, description);
            pstmt.executeUpdate();

        } catch (Exception e) {
            System.err.println("❌ Error logging event: " + e.getMessage());
        }
    }

    


    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    public void setUser(int userId, String username, String email) {
        this.userId = userId;
        this.username = username;
        this.email = email;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }
    
    public void setDesktopPane(JDesktopPane desktopPane) {
        this.mainDesktop = desktopPane;
    }

    public JDesktopPane getDesktopPane() {
        return mainDesktop;
    }

    public void setUserId(int id) {
        this.userId = id;
    }

    public Integer getCurrentUserId() {
        return userId; // Corrected: Returns the stored userId
    }
}
