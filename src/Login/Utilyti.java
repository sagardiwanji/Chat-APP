package Login; 
import java.security.MessageDigest; 
import java.security.NoSuchAlgorithmException; 
public class Utilyti { 
    /** 
     * Generates a SHA-256 hash for the given input. 
     * 
     * @param input The input string to hash. 
     * @return The SHA-256 hash of the input string. 
     */ 
    public static String generateSHA256Hash(String input) { 
        try { 
            MessageDigest digest = MessageDigest.getInstance("SHA-256"); 
            byte[] hashBytes = digest.digest(input.getBytes()); 
            StringBuilder hexString = new StringBuilder(); 
            for (byte b : hashBytes) { 
                String hex = Integer.toHexString(0xff & b); 
                if (hex.length() == 1) hexString.append('0'); 
                hexString.append(hex); 
            } 
            return hexString.toString(); 
        } catch (NoSuchAlgorithmException e) { 
            System.err.println("Error generating hash: " + e.getMessage()); 
            e.printStackTrace(); 
            throw new RuntimeException("Error generating hash", e); 
        } 
    }
    public static String getSecurityMD5(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    } 
}