package JavaMit.ProjektArbeit;


import java.io.*;
        import java.net.ServerSocket;
        import java.net.Socket;
        import java.security.MessageDigest;
        import java.util.Base64;

public class Receiver_MD5 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            System.out.println("Server started. Waiting for a connection...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected.");

                receiveFile(socket);

                socket.close();
                System.out.println("Connection closed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveFile(Socket socket) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
             DataInputStream dis = new DataInputStream(bis)) {

            String fileName = dis.readUTF();
            long fileSize = dis.readLong();
            System.out.println("Receiving file: " + fileName);

            File file = new File("received_" + fileName);
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long bytesReceived = 0;
                int expectedChunk = 0;
                long expectedBytes = 0;

                MessageDigest md = MessageDigest.getInstance("MD5");
                Base64.Encoder encoder = Base64.getEncoder();

                while (bytesReceived < fileSize) {
                    int receivedChunk = dis.readInt();
                    long receivedBytes = dis.readLong();
                    if (receivedChunk != expectedChunk || receivedBytes != expectedBytes) {
                        System.out.println("Received chunk " + receivedChunk + " / " + receivedBytes + " bytes. Resuming...");
                        dis.skip(fileSize - bytesReceived); // Пропустить данные, которые уже были получены
                        continue;
                    }

                    bytesRead = bis.read(buffer, 0, (int) Math.min(buffer.length, fileSize - bytesReceived));
                    if (bytesRead == -1) {
                        break;
                    }

                    md.update(buffer, 0, bytesRead);
                    bos.write(buffer, 0, bytesRead);
                    bos.flush();
                    bytesReceived += bytesRead;

                    expectedChunk++;
                    expectedBytes = bytesReceived;

                    if (bytesReceived >= 5 * 1024 * 1024) { // 5 MB
                        System.out.println("Cache full. Clearing cache...");
                        bytesReceived = 0;
                        bos.flush();
                    }
                }

                byte[] receivedChecksumBytes = new byte[md.getDigestLength()];
                dis.readFully(receivedChecksumBytes);
                String receivedChecksum = new String(receivedChecksumBytes);

                String calculatedChecksum = encoder.encodeToString(md.digest());
                if (receivedChecksum.equals(calculatedChecksum)) {
                    System.out.println("Checksum verification successful.");
                } else {
                    System.out.println("Checksum verification failed. File might be corrupted.");
                }

                System.out.println("File received: " + file.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}