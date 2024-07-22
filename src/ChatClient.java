import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;
    private String nickname;

    public void startConnection(String ip, int port) {
        try {
            clientSocket = new Socket(ip, port);
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendMessage(String msg) {
        out.println(nickname + ": " + msg);
        try {
            System.out.println("Server response: " + in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void stopConnection() {
        try {
            in.close();
            out.close();
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter server IP address: ");
        String serverIp = scanner.nextLine();

        System.out.print("Enter your nickname: ");
        client.nickname = scanner.nextLine();

        int port = 12345;  // Use a fixed port number

        client.startConnection(serverIp, port);

        System.out.println("Type your messages below (type 'exit' to quit):");
        while (true) {
            String message = scanner.nextLine();
            if (message.equalsIgnoreCase("exit")) {
                break;
            }
            client.sendMessage(message);
        }

        client.stopConnection();
        scanner.close();
    }
}
