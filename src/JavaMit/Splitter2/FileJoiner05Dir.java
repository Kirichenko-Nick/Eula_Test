package JavaMit.Splitter2;


import java.io.*;
        import java.util.Arrays;
        import java.util.List;
        import java.util.zip.CRC32;

public class FileJoiner05Dir {

    public static void joinFiles(String directoryPath, String outputFileName) throws IOException {
        File directory = new File(directoryPath);

        // Фильтр для выбора файлов с расширением .bin
        FilenameFilter binFilter = (dir, name) -> name.endsWith(".bin");

        // Получаем список файлов в директории
        String[] inputFiles = directory.list(binFilter);

        if (inputFiles != null && inputFiles.length > 0) {
            List<String> inputFilesList = Arrays.asList(inputFiles);

            try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
                for (String inputFileName : inputFilesList) {
                    String fullPath = directoryPath + File.separator + inputFileName;
                    try (FileInputStream fis = new FileInputStream(fullPath)) {
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
            long expectedCRC32 = getExpectedCRC32FromJson(directoryPath, inputFilesList);
            System.out.println("Ожидаемый CRC32 из JSON: " + expectedCRC32);

            if (calculatedCRC32 == expectedCRC32) {
                System.out.println("CRC32 совпадают. Файлы успешно объединены.");
            } else {
                System.out.println("Ошибка: CRC32 не совпадает. Файл может быть поврежден.");
            }
        } else {
            System.out.println("В указанной директории нет файлов с расширением .bin");
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

    private static long getExpectedCRC32FromJson(String directoryPath, List<String> inputFilesList) throws IOException {
        String jsonFileName = directoryPath + File.separator + "input_files.json";
        try (BufferedReader reader = new BufferedReader(new FileReader(jsonFileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String inputFileName : inputFilesList) {
                    if (line.trim().startsWith("\"" + inputFileName + "\"")) {
                        int startIndex = line.indexOf("crc32_") + 6;
                        int endIndex = line.indexOf(".bin\"");
                        return Long.parseLong(line.substring(startIndex, endIndex));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String directoryPath = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\";
        String outputFileName = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\Test.pdf";

        try {
            joinFiles(directoryPath, outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
