package JavaMit.ProjektArbeit;

import java.io.*;
        import java.net.ServerSocket;
        import java.net.Socket;

public class Server_Chank {
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
        try (BufferedInputStream bis = new BufferedInputStream(socket.getInputStream())) {
            DataInputStream dis = new DataInputStream(bis);

            String fileName = dis.readUTF();
            long fileSize = dis.readLong();

            File file = new File("received_" + fileName);
            try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file))) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                long bytesReceived = 0;

                while (bytesReceived < fileSize && (bytesRead = bis.read(buffer, 0, (int) Math.min(buffer.length, fileSize - bytesReceived))) != -1) {
                    bos.write(buffer, 0, bytesRead);
                    bos.flush();
                    bytesReceived += bytesRead;
                }

                System.out.println("File received: " + file.getName());
            }
        }
    }
}
