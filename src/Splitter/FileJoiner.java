package Splitter;
import java.io.*;
import java.util.zip.CRC32;

public class FileJoiner {

    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\"; // Замените на путь к папке с частями файла

        try {
            joinFiles(directoryPath);
            System.out.println("Файл успешно объединен.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void joinFiles(String directoryPath) throws IOException {
        File directory = new File(directoryPath);

        // Получаем все файлы в указанной директории
        File[] files = directory.listFiles((dir, name) -> name.endsWith(".bin"));

        if (files != null && files.length > 0) {
            // Определение общего размера файла
            long totalSize = 0;
            for (File file : files) {
                totalSize += file.length();
            }

            // Создание буфера для слияния файлов
            byte[] buffer = new byte[(int) totalSize];
            int bytesRead = 0;

            // Чтение данных из каждого файла и слияние их в буфер
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file);
                     BufferedInputStream bis = new BufferedInputStream(fis)) {
                    int chunkSize = (int) file.length();
                    bis.read(buffer, bytesRead, chunkSize);
                    bytesRead += chunkSize;
                }
            }

            // Проверка CRC32 и идентификатора каждой части
            checkCRCAndId(buffer, files);

            // Создание файла для объединенных данных
            String outputFile = directory.getParent() + File.separator + "output_file.txt";
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(buffer);
            }

            System.out.println("Файл успешно объединен и сохранен в " + outputFile);
        } else {
            System.out.println("Отсутствуют файлы для объединения.");
        }
    }

    private static void checkCRCAndId(byte[] buffer, File[] files) {
        int offset = 0;

        for (File file : files) {
            // Вычислить CRC32 для части файла
            CRC32 crc32 = new CRC32();
            crc32.update(buffer, offset, (int) file.length());
            long crcValue = crc32.getValue();

            // Проверить идентификатор (Id) части
            String fileName = file.getName();
            int idIndex = fileName.lastIndexOf("_id_");
            String id = fileName.substring(idIndex + 4, fileName.indexOf(".bin"));

            // Вывести информацию о CRC32 и Id для каждой части
            System.out.println("Проверка CRC32 для части " + file.getName() +
                    ": " + (crcValue == Long.parseLong(fileName.substring(fileName.indexOf("_crc_") + 5, idIndex))) +
                    " | Проверка Id: " + id.equals(fileName.substring(idIndex + 4, fileName.indexOf(".bin"))));

            offset += file.length();
        }
    }
}
