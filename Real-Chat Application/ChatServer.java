import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
    private ServerSocket serverSocket;
    private List<HandleClient> clients = new ArrayList<>();

    public ChatServer(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        System.out.println("Chat Server Started on Port: " + port);
        
        // Continuously listen for new clients
        while (true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("New Client Connected");
            
            HandleClient clientThread = new HandleClient(clientSocket);
            clients.add(clientThread);
            clientThread.start();
        }
    }

    // Inner class to handle each client
    private class HandleClient extends Thread {
        private Socket clientSocket;
        private BufferedReader reader;
        private BufferedWriter writer;

        public HandleClient(Socket clientSocket) throws IOException {
            this.clientSocket = clientSocket;
            this.reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            this.writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
        }

        @Override
        public void run() {
            try {
                String messageFromClient;
                while ((messageFromClient = reader.readLine()) != null) {
                    System.out.println("Received from Client: " + messageFromClient);
                    broadcastMessage(messageFromClient, this);
                }
            } catch (IOException e) {
                System.out.println("Error in Client Handling: " + e.getMessage());
            } finally {
                try {
                    clients.remove(this);
                    clientSocket.close();
                } catch (IOException e) {
                    System.out.println("Error Closing Socket: " + e.getMessage());
                }
            }
        }
    }

    // Broadcast message to all clients except the sender
    private void broadcastMessage(String message, HandleClient sender) throws IOException {
        for (HandleClient client : clients) {
            if (client != sender) {
                client.writer.write(message);
                client.writer.newLine();
                client.writer.flush();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer(8000); // Start server on port 8000
    }
}
