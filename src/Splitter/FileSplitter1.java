package Splitter;



import java.io.*;
        import java.util.zip.CRC32;

public class FileSplitter1 {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\2.zip"; // Замените на путь к вашему файлу
        int chunkSize =  4194304 ; // Размер части в байтах В одном мегабайте - 1024 килобайт; В одном килобайте - 1024 бай

        try {
            splitFile(filePath, chunkSize);
            System.out.println("Файл успешно разделен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void splitFile(String filePath, int chunkSize) throws IOException {
        File inputFile = new File(filePath);

        try (FileInputStream fis = new FileInputStream(inputFile);
             BufferedInputStream bis = new BufferedInputStream(fis)) {

            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            int chunkNumber = 1;

            while ((bytesRead = bis.read(buffer)) != -1) {
                // Вычислить CRC32 для части файла
                CRC32 crc32 = new CRC32();
                crc32.update(buffer, 0, bytesRead);
                long crcValue = crc32.getValue();

                // Получить имя файла без расширения
                String fileNameWithoutExtension = inputFile.getName().replaceFirst("[.][^.]+$", "");

                // Создать файл для части и записать в него данные
                String outputFilePath = inputFile.getParent() + File.separator +
                        fileNameWithoutExtension + "_part_" + chunkNumber + "_crc_" + crcValue + ".bin";
                try (FileOutputStream fos = new FileOutputStream(outputFilePath)) {
                    fos.write(buffer, 0, bytesRead);
                }

                System.out.println("Часть " + chunkNumber + " сохранена. CRC32: " + crcValue);
                chunkNumber++;
            }
        }
    }
}
