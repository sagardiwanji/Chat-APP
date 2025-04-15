package Login;

import java.io.Serializable;

public record config(String dbUrl, String dbUser, String dbPassword, String privateKey) implements Serializable {

    public static final String DB_URL = System.getenv("DB_URL");
    public static final String DB_USER = System.getenv("DB_USER");
    public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    public static final String PRIVATE_KEY = System.getenv("PRIVATE_KEY");

    public config() {
        this(DB_URL, DB_USER, DB_PASSWORD, PRIVATE_KEY);
    }
}