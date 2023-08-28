package JavaMit.ProjektArbeit;


import java.io.*;
        import java.net.Socket;

public class ClientChank {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;

        String filePath = "path_to_your_large_file"; // Укажите путь к вашему большому файлу

        try {
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Connected to server.");

            sendFile(socket, filePath);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(Socket socket, String filePath) throws IOException {
        File file = new File(filePath);
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            dos.writeUTF(file.getName());
            dos.writeLong(file.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
                dos.flush();
            }

            System.out.println("File sent: " + file.getName());
        }
    }
}
