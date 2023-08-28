package JavaMit.ProjektArbeit;


import java.io.IOException;
        import java.io.ObjectInputStream;
        import java.io.ObjectOutputStream;
        import java.net.InetAddress;
        import java.net.ServerSocket;
        import java.net.Socket;

public class Server_3 {

    private static ServerSocket server;

    private static Socket connection;
    private static ObjectOutputStream output;
    private static ObjectInputStream input;
    private static Boolean isAlreadyConnected = false;

    public static void main(String[] args) {

        try {

            server = new ServerSocket(6666, 100);

            while(true) {
                connection = server.accept();

                if(!isAlreadyConnected) {
                    System.out.println("Connected");
                    isAlreadyConnected = true;
                }

                output = new ObjectOutputStream(connection.getOutputStream());
                output.flush();
                input = new ObjectInputStream(connection.getInputStream());

                String message = (String) input.readObject();

                System.out.println("User sent you: " + message);
                output.writeObject("Your message: " + message);
                output.flush();
            }
        }
        catch (IOException e) {
            System.out.println("Probably something wrong with connection. Application will be switched off.");
            System.exit(-1);
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        finally {
            close();
        }
    }

    // Don't know if it's necessary:
    private static void close() {
        try {
            output.close();
            input.close();
            connection.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
