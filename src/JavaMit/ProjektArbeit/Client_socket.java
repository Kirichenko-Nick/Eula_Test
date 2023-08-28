package JavaMit.ProjektArbeit;


import java.io.IOException;
        import java.io.ObjectOutputStream;
        import java.net.Socket;

public class Client_socket {
    public static void main(String[] args) {
        String serverHost = "localhost"; // Имя или IP-адрес сервера
        int serverPort = 12345; // Порт сервера

        try {
            Socket socket = new Socket(serverHost, serverPort);
            System.out.println("Connected to server.");

            // Создание объекта для отправки
            Person person = new Person("Bob", 25);

            // Отправка объекта через сокет
            try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream())) {
                objectOutputStream.writeObject(person);
                System.out.println("Person object sent.");
            }

            socket.close();
            System.out.println("Connection closed.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
