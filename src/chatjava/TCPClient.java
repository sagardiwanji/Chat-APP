package chatjava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class TCPClient {
    private static final String CONFIG_FILE = "src/Login/config.java";
    private static String serverAddress;
    private static int serverPort;

    static {
        try (var inputStream = TCPClient.class.getClassLoader().getResourceAsStream(CONFIG_FILE)) {
            if (inputStream == null) {
                throw new IOException("Configuration file not found");
            }
            Properties properties = new Properties();
            properties.load(inputStream);
            serverAddress = properties.getProperty("server.address", "127.0.0.1");
            serverPort = Integer.parseInt(properties.getProperty("server.port", "6788"));
        } catch (IOException | NumberFormatException e) {
            System.err.println("Failed to load configuration, using defaults: " + e.getMessage());
            serverAddress = "127.0.0.1";
            serverPort = 6788;
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(() -> {
            try (Socket socket = new Socket(serverAddress, serverPort);
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