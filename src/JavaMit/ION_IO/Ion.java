package JavaMit.ION_IO;

import java.io.File;

public class Ion {
    public static void main(String[] args) {
        File test123 = new File("C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Рисунки\\WhatsApp Image 2022-12-17 at 14.49.31.jpeg");
        double b =( test123.length());
        double c = b /1024/1024;
        System.out.println(c);

        long bytes = 2048; // Замените на свое значение в байтах
        double kilobytes = (double) bytes / 1024;

        System.out.println(bytes + " байт = " + kilobytes + " килобайт");
    }
}

