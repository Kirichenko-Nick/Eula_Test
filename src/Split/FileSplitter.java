package Split;

import java.io.*;
import java.util.zip.CRC32;

public class FileSplitter {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\Test.pdf"; // Замените на путь к вашему файлу
        int chunkSize = 4194304; // Размер части в байтах

        try {
            splitFile(filePath, chunkSize);
            System.out.println("Файл успешно разделен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void splitFile(String filePath, int chunkSize) throws IOException {
        File inputFile = new File(filePath);

        // Получить расширение исходного файла
        String fileExtension = getFileExtension(inputFile.getName());

        try (FileInputStream fis = new FileInputStream(inputFile);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            CRC32 crc32 = new CRC32();
            int chunkNumber = 1;

            while ((bytesRead = bis.read(buffer)) != -1) {
                // Вычислить CRC32 для части файла
                crc32.update(buffer, 0, bytesRead);

                // Создать файл для части и записать в него данные
                String outputFilePath = inputFile.getParent() + File.separator +
                        inputFile.getName().replaceFirst("[.][^.]+$", "") +
                        "_part_" + chunkNumber + "_crc_" + crc32.getValue() + fileExtension + ".bin";
                try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                    fos.write(buffer, 0, bytesRead);
                }

                System.out.println("Часть " + chunkNumber + " сохранена. CRC32: " + crc32.getValue());
                chunkNumber++;
            }

            System.out.println("Файл успешно разделен. CRC32 для всего файла: " + crc32.getValue());
        }
    }

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex != -1) {
            return fileName.substring(lastDotIndex);
        }
        return "";
    }
}
