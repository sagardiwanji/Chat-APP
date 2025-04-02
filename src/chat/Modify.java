package chat; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException; 
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.util.logging.Level; 
import java.util.logging.Logger; 
public class Modify { 
    public static void saveFile(String text) { 
        try (FileOutputStream fos = new FileOutputStream("data.txt", true)) { 
            byte[] b = text.getBytes("utf-8"); 
            fos.write(b); 
            Logger.getLogger(Modify.class.getName()).log(Level.INFO, "File saved successfully."); 
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, "File not found: {0}", ex.getMessage()); 
        } catch (IOException ex) { 
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, "IO Exception: {0}", ex.getMessage()); 
        } 
    } 
    public static void saveAs(String address, String text) { 
        try (FileOutputStream fos = new FileOutputStream(address, true)) { 
            byte[] b = text.getBytes("utf-8"); 
            fos.write(b); 
            Logger.getLogger(Modify.class.getName()).log(Level.INFO, "File saved as {0} successfully.", address); 
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, "File not found: {0}", ex.getMessage()); 
        } catch (IOException ex) { 
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, "IO Exception: {0}", ex.getMessage()); 
        } 
    } 
    public static String openFile(String address) { 
        StringBuilder buffer = new StringBuilder(); 
        try (FileInputStream f = new FileInputStream(address)) { 
            int code; 
            while ((code = f.read()) != -1) { 
                buffer.append((char) code); 
            } 
            Logger.getLogger(Modify.class.getName()).log(Level.INFO, "File opened successfully."); 
        } catch (FileNotFoundException e) { 
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, "File not found: {0}", e.getMessage()); 
        } catch (IOException e) { 
            Logger.getLogger(Modify.class.getName()).log(Level.SEVERE, "IO Exception: {0}", e.getMessage()); 
        } 
        return buffer.toString(); 
    } 
}