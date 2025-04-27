package chatjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import java.util.Properties;
import java.io.FileInputStream;
/** 
 * TCPClient class to handle client-side socket communication. 
 * Upgraded to use Java 17 features. 
 */
public class TCPClient {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream("config.properties")) {
            properties.load(fis);
        } catch (IOException ex) {
            System.err.println("Error loading configuration: " + ex.getMessage());
            ex.printStackTrace();
            return;
        }

        String serverIp = properties.getProperty("server.ip", "127.0.0.1");
        int serverPort = Integer.parseInt(properties.getProperty("server.port", "6788"));

        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try (Socket socket = new Socket(serverIp, serverPort);
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
            }
        });
    }
}
