package Splitter01;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.CRC32;

public class FileSplitter {

    public static void splitFile(String inputFileName, int chunkSize) throws IOException {
        List<String> inputFiles = new ArrayList<>();

        try (FileInputStream fis = new FileInputStream(inputFileName)) {
            byte[] buffer = new byte[chunkSize];
            int bytesRead;
            int partNumber = 1;

            while ((bytesRead = fis.read(buffer)) != -1) {
                String outputFileName = String.format("%s_part_%d_crc32_%d.bin", inputFileName, partNumber,
                        calculateCRC32(buffer, bytesRead));

                inputFiles.add(outputFileName);

                try (FileOutputStream fos = new FileOutputStream(outputFileName)) {
                    fos.write(buffer, 0, bytesRead);
                }

                partNumber++;
            }
        }

        // Сохраняем имена файлов в формате JSON
        saveInputFilesToJson(inputFiles, inputFileName);
    }

    private static long calculateCRC32(byte[] data, int length) {
        CRC32 crc32 = new CRC32();
        crc32.update(data, 0, length);
        return crc32.getValue();
    }

    private static void saveInputFilesToJson(List<String> inputFiles, String inputFileName) throws IOException {
        String jsonFileName = inputFileName + "_input_files.json";

        try (FileWriter writer = new FileWriter(jsonFileName)) {
            writer.write("[\n");
            for (String inputFile : inputFiles) {
                writer.write(String.format("  \"%s\",\n", inputFile));
            }
            writer.write("]\n");
        }

        System.out.println("Имена файлов успешно сохранены в " + jsonFileName);
    }

    public static void main(String[] args) {
        try {
            splitFile("example.txt", 1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
