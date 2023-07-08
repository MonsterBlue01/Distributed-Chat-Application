import java.io.*;
import java.net.*;
import java.util.*;

public class Server {
    // Define the port the server will listen on
    private static final int PORT = 1234;
    private List<ClientHandler> clients = new ArrayList<>();
    private List<User> users = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        new Server().startServer();
    }

    public void startServer() throws IOException {
        ServerSocket serverSocket = new ServerSocket(PORT);
        System.out.println("Server started on port " + PORT);
        // Initialize some users for testing purposes
        users.add(new User("user1", "password1"));
        users.add(new User("user2", "password2"));

        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New user is trying to build a connection");
    
            ClientHandler clientHandler = new ClientHandler(clientSocket);
            clients.add(clientHandler);
    
            new Thread(clientHandler).start();
        }
    }

    private class ClientHandler implements Runnable {
        private Socket clientSocket;
        private BufferedReader in;
        private PrintWriter out;
        private User user;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                out = new PrintWriter(clientSocket.getOutputStream(), true);
    
                // Read username and password
                String username = in.readLine();
                String password = in.readLine();
    
                // Check if the user exists
                for (User u : users) {
                    if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                        this.user = u;
                        System.out.println("New client connected"); // If authentication is successful
                        out.println("Login Successful");
                        break;
                    }
                }
    
                if (this.user == null) {
                    System.out.println("New user verification failed"); // If authentication fails
                    out.println("Invalid username or password");
                    return; // If authentication fails, don't proceed
                }
    
            } catch (IOException e) {
                System.out.println("Error getting streams: " + e.getMessage());
            }
        }

        public void run() {
            String input;
            try {
                while ((input = in.readLine()) != null) {
                    System.out.println("Received message: " + input);
                    broadcastMessage(input);
                }
            } catch (IOException e) {
                System.out.println("Error reading from client: " + e.getMessage());
            } finally {
                try {
                    if (in != null) in.close();
                    if (out != null) out.close();
                    if (clientSocket != null) clientSocket.close();
                    clients.remove(this);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void broadcastMessage(String message) {
            for (ClientHandler client : clients) {
                client.out.println(message);
            }
        }
    }
}