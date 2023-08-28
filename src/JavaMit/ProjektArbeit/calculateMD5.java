package JavaMit.ProjektArbeit;

import jdk.internal.icu.impl.StringPrepDataReader;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.RandomAccessFile;
import java.security.MessageDigest;
import java.util.Base64;


// На стороне отправителя:
public class calculateMD5 {


    private static String calculateMD5(byte[] data) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(data);
        return Base64.getEncoder().encodeToString(digest);


        // В цикле отправки чанков

//
//
//        String md5Checksum = calculateMD5(chunkData);  //
//        dos.writeUTF(md5Checksum);
//
//// На стороне получателя:
//
//        // В цикле приема чанков
//        DataInput dis;
//        String receivedChecksum = dis.readUTF();
//        byte[] receivedChunkData;
//        String calculatedChecksum = calculateMD5(receivedChunkData);
//
//        if (!receivedChecksum.equals(calculatedChecksum)) {
//            System.out.println("Checksum mismatch. Data might be corrupted.");
//            // Возможно, нужно как-то обработать эту ситуацию
//        }

//        {
//
//
//            int bufferSize = 4096; // Размер буфера, можно менять
//            byte[] buffer = new byte[bufferSize];
//            int bytesRead;
//
//
//
//            while ((bytesRead = bis.read(buffer)) != -1) {
//                dos.write(buffer, 0, bytesRead);
//                dos.flush();
//                totalBytesSent += bytesRead;
//
//                if (totalBytesSent >= maxCacheSize) {
//                    // Очистка кэша, если превышен лимит
//                    totalBytesSent = 0;
//                    dos.flush();
//                }
//            }
//        }


    }

}
