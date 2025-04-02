package chatjava; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.Socket; 
import java.util.Scanner; 
import java.util.concurrent.Executors; 
import java.util.concurrent.ExecutorService; 
/** 
 * TCPClient class to handle client-side socket communication. 
 * Upgraded to use Java 17 features. 
 */ 
public class TCPClient { 
    private static final String SERVER_ADDRESS = "127.0.0.1"; 
    private static final int SERVER_PORT = 6788; 
    public static void main(String[] args) { 
        ExecutorService executorService = Executors.newCachedThreadPool(); 
        executorService.submit(() -> { 
            try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT); 
                 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true); 
                 Scanner sc = new Scanner(System.in)) { 
                System.out.println("Enter text: "); 
                String st = sc.nextLine(); 
                System.out.println("Sent: " + st); 
                out.println(st); 
                String line = reader.readLine(); 
                System.out.println("Received: " + line); 
            } catch (IOException e) { 
                System.err.println("An I/O error occurred: " + e.getMessage()); 
                e.printStackTrace(); 
            } catch (Exception e) { 
                System.err.println("An unexpected error occurred: " + e.getMessage()); 
                e.printStackTrace(); 
            } 
        }); 
    } 
}