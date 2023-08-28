package JavaMit.ProjektArbeit;

import java.io.*;
import java.net.Socket;
import java.security.MessageDigest;
import java.util.Base64;

public class Receiver {
    public static void main(String[] args) {
        String serverHost = "localhost";
        int serverPort = 12345;

        try {
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Connected to server.");

            receiveFile(socket);

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void receiveFile(Socket socket) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream())) {
            DataInputStream dis = new DataInputStream(bis);

            String fileName = dis.readUTF();
            long fileSize = dis.readLong();
            System.out.println("Receiving file: " + fileName);

            File file = new File("received_" + fileName);
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long bytesReceived = 0;

                while (bytesReceived < fileSize && (bytesRead = bis.read(buffer, 0, (int) Math.min(buffer.length, fileSize - bytesReceived))) != -1) {
                    bos.write(buffer, 0, bytesRead);
                    bos.flush();
                    bytesReceived += bytesRead;

                    // Учет размера кэша и очистка при необходимости
                    if (bytesReceived >= 5 * 1024 * 1024) { // 5 MB
                        System.out.println("Clearing cache...");
                        bytesReceived = 0;
                        bos.flush();
                    }
                }

                System.out.println("File received: " + file.getName());
            }
        }
    }
}
