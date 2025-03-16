
package Config;

import javax.swing.JDesktopPane;

public class Session {
    private static Session instance;
    private int userId;
    private String username;
    private String email;
    private JDesktopPane mainDesktop;

    private Session() {} // Private constructor to enforce Singleton pattern

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
}
