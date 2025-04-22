package Login;

import java.io.Serializable;

public record config(String dbUrl, String dbUser, String dbPassword, String privateKey, String serverIp) implements Serializable {

    public static final String DB_URL = System.getenv("DB_URL");
    public static final String DB_USER = System.getenv("DB_USER");
    public static final String DB_PASSWORD = System.getenv("DB_PASSWORD");
    public static final String PRIVATE_KEY = System.getenv("PRIVATE_KEY");
    public static final String DEFAULT_SERVER_IP = "127.0.0.1";

    public config() {
        this(DB_URL, DB_USER, DB_PASSWORD, PRIVATE_KEY, resolveServerIp());
    }

    private static String resolveServerIp() {
        String ip = System.getenv("SERVER_IP");
        return (ip == null || ip.isEmpty()) ? DEFAULT_SERVER_IP : ip;
    }

    public String getServerIp() {
        return serverIp;
    }
}