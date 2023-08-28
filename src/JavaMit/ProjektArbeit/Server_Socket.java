package JavaMit.ProjektArbeit;


import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.net.ServerSocket;
        import java.net.Socket;

public class Server_Socket {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(12345); // Порт для прослушивания
            System.out.println("Server started. Waiting for a connection...");

            while (true) {
                Socket socket = serverSocket.accept(); // Ожидание подключения
                System.out.println("Client connected.");

                // Получение объекта через сокет
                try (ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream())) {
                    Object receivedObject = objectInputStream.readObject();
                    if (receivedObject instanceof Person) {
                        Person person = (Person) receivedObject;
                        System.out.println("Received Person object: " + person);
                    }
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                socket.close();
                System.out.println("Connection closed.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
