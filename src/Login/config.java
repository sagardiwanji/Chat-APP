package Login;

import java.io.Serializable;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

// Convert config class to a record for improved serialization
public record config(String dbUrl, String dbUser, String dbPassword, String privateKey) implements Serializable {
    // Default configuration values loaded from properties file
    public static final String DB_URL;
    public static final String DB_USER;
    public static final String DB_PASSWORD;
    public static final String PRIVATE_KEY;

    static {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
            DB_URL = properties.getProperty("db.url");
            DB_USER = properties.getProperty("db.user");
            DB_PASSWORD = properties.getProperty("db.password");
            PRIVATE_KEY = properties.getProperty("private.key");
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration properties", e);
        }
    }

    // Constructor with default values
    public config() {
        this(DB_URL, DB_USER, DB_PASSWORD, PRIVATE_KEY);
    }
}
