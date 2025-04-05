import java.io.*;
import java.net.*;

public class TCPICLIENT {
    public static void main(String[] args) {
        String serverAddress = "localhost";
        int port = 5001;

        // Step 1: Connect to the server
        try (Socket socket = new Socket(serverAddress, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.println("Connected to server!");

            // Step 2: Send message to the server
            out.println("Hello, server! This is a client message.");

            // Step 3: Read response from the server
            String serverResponse = in.readLine();
            System.out.println("Received from server: " + serverResponse);

        } catch (IOException e) {
            System.err.println("Client error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

