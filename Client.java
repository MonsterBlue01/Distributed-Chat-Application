import java.io.*;
import java.net.*;
import java.util.*;

public class Client {
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 1234;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public void startClient() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Read username and password from user input
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter password: ");
            String password = scanner.nextLine();

            // Send username and password to the server for authentication
            out.println(username);
            out.println(password);

            String response = in.readLine();
            if (response.equals("Login Successful")) {
                System.out.println("You are now logged in!");
            } else {
                System.out.println("Login Failed");
                return;
            }

            // Start a new thread for receiving messages
            new Thread(new ReceivedMessagesHandler()).start();

            // Sending messages happens in the main thread
            while (scanner.hasNextLine()) {
                String text = scanner.nextLine();
                Message message = new Message(username, text); // Create a new Message object
                out.println(message.toString()); // Send the string representation of the Message
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private class ReceivedMessagesHandler implements Runnable {
        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println("Received message: " + message); // This will print the string representation of the Message
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.startClient();
    }
}
