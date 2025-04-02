package Login; 
import java.io.Serializable; 
// Convert config class to a record for improved serialization 
public record config(String dbUrl, String dbUser, String dbPassword, String privateKey) implements Serializable { 
    // Default configuration values 
    public static final String DB_URL = "jdbc:mysql://localhost:3306/chat"; // INPUT_REQUIRED {Database URL} 
    public static final String DB_USER = "root"; // INPUT_REQUIRED {Database username} 
    public static final String DB_PASSWORD = "12345678"; // INPUT_REQUIRED {Database password} 
    public static final String PRIVATE_KEY = "jnrejiufuidurenmeiocuivuvunnyvnmcewoixmceueuijkjkj"; 
    // Constructor with default values 
    public config() { 
        this(DB_URL, DB_USER, DB_PASSWORD, PRIVATE_KEY); 
    } 
}