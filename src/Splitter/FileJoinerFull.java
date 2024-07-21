package Splitter;


import java.io.*;
        import java.util.zip.CRC32;

public class FileJoinerFull {


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

            // Проверка CRC32 для объединенного файла
            CRC32 crc32 = new CRC32();
            crc32.update(buffer);
            long crcValue = crc32.getValue();

            // Получение расширения исходного файла из имен частей
            String originalExtension = getFileExtension(files[0].getName());

            // Получение имени файла без расширения
            String fileNameWithoutExtension = files[0].getName().replaceFirst("[.][^.]+$", "");

            // Создание файла для объединенных данных
            String outputFile = directory.getParent() + File.separator +
                    fileNameWithoutExtension + "_output_crc_" + crcValue + originalExtension;

            try (FileOutputStream fos = new FileOutputStream(outputFile)) {
                fos.write(buffer);
            }

            System.out.println("Файл успешно объединен и сохранен в " + outputFile);
            System.out.println("CRC32 для объединенного файла: " + crcValue);

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

    private static String getFileExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        int extensionStartIndex = fileName.indexOf("_crc_", lastDotIndex);
        if (lastDotIndex != -1 && extensionStartIndex != -1) {
            return fileName.substring(lastDotIndex, extensionStartIndex);
        }
        return "";
    }
}
