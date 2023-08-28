package JavaMit.ProjektArbeit;

// На стороне отправителя:
import java.io.*;
        import java.net.Socket;

public class Sender_Info {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;

        try {
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Connected to server.");

            sendFile(socket);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendFile(Socket socket) throws IOException {
        String filePath = "path_to_your_large_file"; // Укажите путь к вашему файлу
        File file = new File(filePath);

        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
             DataOutputStream dos = new DataOutputStream(socket.getOutputStream())) {

            dos.writeUTF(file.getName());
            dos.writeLong(file.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            long bytesSent = 0;
            int currentChunk = 0;

            while ((bytesRead = bis.read(buffer)) != -1) {
                dos.writeInt(currentChunk); // Отправляем номер текущего чанка
                dos.writeLong(bytesSent); // Отправляем количество уже переданных байтов

                dos.write(buffer, 0, bytesRead);
                dos.flush();
                bytesSent += bytesRead;

                if (bytesSent >= 5 * 1024 * 1024) { // 5 MB
                    System.out.println("Cache full. Clearing cache...");
                    bytesSent = 0;
                    dos.flush();
                }

                currentChunk++;
            }

            System.out.println("File sent: " + file.getName());
        }
    }
}
