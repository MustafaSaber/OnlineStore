package A2Z;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class User {
    private String name;
    private String Email;
    private String username;
    private String password;

    public User() {
        name = Email = username = password = "";
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String name, String email, String username, String password) {
        this.name = name;
        Email = email;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
