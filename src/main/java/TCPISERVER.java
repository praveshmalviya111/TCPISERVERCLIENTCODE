import java.io.*;
import java.net.*;

public class TCPISERVER {
    public static void main(String[] args) {
        int port = 5001;

        // Step 1: Create a server socket
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is listening on port " + port);

            // Step 2: Accept a client connection
            try (Socket clientSocket = serverSocket.accept();
                 BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                 PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                System.out.println("Client connected!");

                // Step 3: Read message from client
                String clientMessage = in.readLine();
                System.out.println("Received from client: " + clientMessage);

                // Step 4: Send response back to client
                out.println("Hello, client! Message received.");
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
