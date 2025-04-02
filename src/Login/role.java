package Login; 
import java.io.Serializable; 
// Convert role class to a record if it is primarily used as a data carrier 
public record role(String roleName, String[] permissions) implements Serializable { 
    public role { 
        if (roleName == null || roleName.isBlank()) { 
            throw new IllegalArgumentException("Role name cannot be null or blank"); 
        } 
        if (permissions == null) { 
            throw new IllegalArgumentException("Permissions cannot be null"); 
        } 
    } 
}