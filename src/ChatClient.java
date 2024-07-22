import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 12345;

    public static void main(String[] args) {
        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter your nickname: ");
            String nickname = scanner.nextLine();
            new ReadThread(in).start();

            String message;
            while (true) {
                message = scanner.nextLine();
                out.println(nickname + ": " + message);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ReadThread extends Thread {
        private BufferedReader in;

        public ReadThread(BufferedReader in) {
            this.in = in;
        }

        public void run() {
            try {
                String message;
                while ((message = in.readLine()) != null) {
                    System.out.println(message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
}
