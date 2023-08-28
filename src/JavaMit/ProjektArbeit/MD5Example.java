package JavaMit.ProjektArbeit;

import java.security.MessageDigest;
import java.util.Base64;

public class MD5Example {
    public static void main(String[] args) {
        byte[] chunkData = {0x12, 0x34, 0x56, 0x78}; // Пример данных в массиве (замените на свои данные)
        String md5Checksum = calculateMD5(chunkData);
        System.out.println("MD5 Checksum: " + md5Checksum);
    }

    private static String calculateMD5(byte[] data) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Digest = md.digest(data);

            Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(md5Digest);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
