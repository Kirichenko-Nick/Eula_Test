package Splitter01;

import java.io.*;
import java.util.List;
import java.util.zip.CRC32;

public class FileJoiner {

    public static void joinFiles(List<String> inputFiles, String outputFileName) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
            for (String inputFileName : inputFiles) {
                try (FileInputStream fis = new FileInputStream(inputFileName)) {
                    byte[] buffer = new byte[1024];
                    int bytesRead;

                    while ((bytesRead = fis.read(buffer)) != -1) {
                        fos.write(buffer, 0, bytesRead);
                    }
                }
            }
        }

        // Проверяем CRC32 объединенного файла
        long calculatedCRC32 = calculateCRC32(outputFileName);
        System.out.println("CRC32 для объединенного файла: " + calculatedCRC32);

        // Получаем CRC32 из JSON и проверяем совпадение
        long expectedCRC32 = getExpectedCRC32FromJson(outputFileName);
        System.out.println("Ожидаемый CRC32 из JSON: " + expectedCRC32);

        if (calculatedCRC32 == expectedCRC32) {
            System.out.println("CRC32 совпадают. Файлы успешно объединены.");
        } else {
            System.out.println("Ошибка: CRC32 не совпадает. Файл может быть поврежден.");
        }
    }

    private static long calculateCRC32(String fileName) throws IOException {
        try (FileInputStream fis = new FileInputStream(fileName)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            CRC32 crc32 = new CRC32();

            while ((bytesRead = fis.read(buffer)) != -1) {
                crc32.update(buffer, 0, bytesRead);
            }

            return crc32.getValue();
        }
    }

    private static long getExpectedCRC32FromJson(String outputFileName) throws IOException {
        String jsonFileName = outputFileName + "_input_files.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().startsWith("\"" + outputFileName + "\"")) {
                    int startIndex = line.indexOf("crc32_") + 6;
                    int endIndex = line.indexOf(".bin\"");
                    return Long.parseLong(line.substring(startIndex, endIndex));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        // Указать имена файлов, которые нужно объединить
        // (замените их реальными именами файлов)
        List<String> inputFiles = List.of("example.txt_part_1_crc32_123456.bin", "example.txt_part_2_crc32_789012.bin");
        try {
            joinFiles(inputFiles, "combined_example.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
