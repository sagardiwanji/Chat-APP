package Login; 
import java.io.Serializable; 
// Convert Users class to a record if it is primarily used as a data carrier 
public record Users(String username, String email, String password, int role_id, int active) implements Serializable { 
    public Users(String username, String email, String password, int role_id) { 
        this(username, email, password, role_id, 0); 
    } 
    public String getUsername() { 
        return username; 
    } 
    public String getEmail() { 
        return email; 
    } 
    public String getPassword() { 
        return password; 
    } 
    public int getRole_id() { 
        return role_id; 
    } 
    public int getActive() { 
        return active; 
    } 
}