package JavaMit.ProjektArbeit;


import javax.net.ssl.*;
        import java.io.*;
        import java.security.KeyStore;

public class SecureReceiver_MitSertificat {
    public static void main(String[] args) {
        try {
            int serverPort = 12345;

            // Загрузка самоподписанного сертификата и ключей из хранилища
            char[] keystorePassword = "your_keystore_password".toCharArray();
            char[] keyPassword = "your_key_password".toCharArray();
            KeyStore keystore = KeyStore.getInstance("JKS");
            FileInputStream fis = new FileInputStream("path_to_your_keystore_file");
            keystore.load(fis, keystorePassword);
            fis.close();

            KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
            kmf.init(keystore, keyPassword);
            TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
            tmf.init(keystore);

            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

            SSLServerSocketFactory sslServerSocketFactory = sslContext.getServerSocketFactory();
            SSLServerSocket serverSocket = (SSLServerSocket) sslServerSocketFactory.createServerSocket(serverPort);
            System.out.println("Server started. Waiting for a connection...");

            while (true) {
                SSLSocket socket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected.");

                // receiveFile(socket);

                socket.close();
                System.out.println("Connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Остальной код для приема и обработки файла остается таким же, как и в предыдущем ответе
    // ...
}
