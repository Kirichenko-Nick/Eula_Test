package JavaMit.ProjektArbeit;


import java.io.*;
        import java.net.Socket;
        import java.security.MessageDigest;
        import java.util.Base64;

public class Sender_mitwierhlungsChankVer {
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

            MessageDigest md = MessageDigest.getInstance("MD5");
            Base64.Encoder encoder = Base64.getEncoder();

            while ((bytesRead = bis.read(buffer)) != -1) {
                md.update(buffer, 0, bytesRead);
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

            byte[] checksumBytes = md.digest();
            dos.write(checksumBytes); // Отправляем контрольную сумму MD5

            System.out.println("File sent: " + file.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
