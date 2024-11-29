import java.io.*;
import java.net.*;

public class ChatClient {
    private Socket clientSocket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private BufferedReader inputReader;

    public ChatClient(String host, int port) throws UnknownHostException, IOException {
        clientSocket = new Socket(host, port);
        System.out.println("Connected to Chat Server");
        
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        inputReader = new BufferedReader(new InputStreamReader(System.in));
        
        // Start listening for messages from server
        new ListenForMessages().start();
        
        // Continuously send user's input to server
        String message;
        while ((message = inputReader.readLine()) != null) {
            writer.write(message);
            writer.newLine();
            writer.flush();
        }
    }

    // Inner class to listen for incoming messages from server
    private class ListenForMessages extends Thread {
        @Override
        public void run() {
            try {
                String messageFromServer;
                while ((messageFromServer = reader.readLine()) != null) {
                    System.out.println("Server/Other Client: " + messageFromServer);
                }
            } catch (IOException e) {
                System.out.println("Error Reading from Server: " + e.getMessage());
            } finally {
                try {
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error Closing Socket: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        new ChatClient("localhost", 8000); // Connect to server on localhost at port 8000
    }
}
