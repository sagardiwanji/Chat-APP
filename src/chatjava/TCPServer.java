package chatjava; 
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.io.PrintWriter; 
import java.net.ServerSocket; 
import java.net.Socket; 
import java.util.concurrent.Executors; 
import java.util.concurrent.ExecutorService; 
/** 
 * TCPServer class to handle incoming socket connections and process messages. 
 * Upgraded to use Java 17 features. 
 * 
 * Author: phapne 
 */ 
public class TCPServer { 
    private static final int PORT = 6788; 
    public static void main(String[] args) { 
        ExecutorService executorService = Executors.newCachedThreadPool(); 
        try (ServerSocket serverSocket = new ServerSocket(PORT)) { 
            System.out.println("Server started on port " + PORT); 
            while (true) { 
                try { 
                    Socket socket = serverSocket.accept(); 
                    executorService.submit(() -> handleClient(socket)); 
                } catch (IOException e) { 
                    System.err.println("Error accepting client connection: " + e.getMessage()); 
                    e.printStackTrace(); 
                } 
            } 
        } catch (IOException e) { 
            System.err.println("Server error: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    } 
    private static void handleClient(Socket socket) { 
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); 
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) { 
            String line = reader.readLine(); 
            if (line != null) { 
                System.out.println("Received: " + line); 
                String response = line.toUpperCase(); 
                System.out.println("Sent: " + response); 
                out.println(response); 
            } 
        } catch (IOException e) { 
            System.err.println("Error processing client request: " + e.getMessage()); 
            e.printStackTrace(); 
        } 
    } 
}