package Split;

import java.io.*;
import java.util.zip.CRC32;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            // Создание буфера для слияния файлов
            byte[] buffer = new byte[4096];
            int bytesRead;
            CRC32 crc32 = new CRC32();

            // Получение имени файла без расширения и CRC32 из первой части
            String[] fileNameParts = files[0].getName().split("_");
            String fileNameWithoutExtension = fileNameParts[0];

            // Извлекаем CRC32 из имени файла
            long originalCRC32 = extractCRC32(fileNameParts);

            // Проверка целостности файла по CRC32
            for (File file : files) {
                try (FileInputStream fis = new FileInputStream(file);
                     BufferedInputStream bis = new BufferedInputStream(fis)) {
                    while ((bytesRead = bis.read(buffer)) != -1) {
                        crc32.update(buffer, 0, bytesRead);
                    }
                }
            }

            if (originalCRC32 != crc32.getValue()) {
                System.out.println("Ошибка: CRC32 не совпадает. Файл поврежден.");
                return;
            }

            // Создание файла для объединенных данных с оригинальным именем и расширением
            String outputFile = directory.getParent() + File.separator +
                    fileNameWithoutExtension + "_output_crc_" + crc32.getValue() + ".bin";
            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                // Записать данные в объединенный файл
                for (File file : files) {
                    try (FileInputStream fis = new FileInputStream(file);
                         BufferedInputStream bis = new BufferedInputStream(fis)) {
                        while ((bytesRead = bis.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    }
                }
            }

            System.out.println("Файл успешно объединен. CRC32 для объединенного файла: " + crc32.getValue());

            // Удаление частей файлов
            for (File file : files) {
                if (file.delete()) {
                    System.out.println("Файл " + file.getName() + " удален.");
                } else {
                    System.out.println("Не удалось удалить файл " + file.getName());
                }
            }
        } else {
            System.out.println("Отсутствуют файлы для объединения.");
        }
    }

    private static long extractCRC32(String[] fileNameParts) {
        // Используем регулярное выражение для извлечения CRC32 из имени файла
        Pattern pattern = Pattern.compile("crc_(\\d+)");
        Matcher matcher = pattern.matcher(fileNameParts[fileNameParts.length - 2]);

        if (matcher.find()) {
            return Long.parseLong(matcher.group(1));
        } else {
            return 0L; // Или другое значение по умолчанию
        }
    }
}
