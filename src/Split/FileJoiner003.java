package Split;


import java.io.*;
import java.nio.file.*;
import java.util.zip.CRC32;
import java.util.regex.*;

public class FileJoiner003 {

                    public static void main(String[] args) {
                        String directoryPath = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\"; // Замените на путь к папке с частями файла
                        String outputPath = "C:\\Users\\Student\\OneDrive - GFN AG (EDU)\\Desktop_2\\Presentation ChnkeFile\\Splitter\\output"; // Замените на желаемый путь

                        try {
                            joinFiles(directoryPath, outputPath);
                            System.out.println("Файл успешно объединен и сохранен в " + outputPath);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    private static void joinFiles(String directoryPath, String outputPath) throws IOException {
                        File directory = new File(directoryPath);

                        // Получаем все файлы в указанной директории
                        File[] files = directory.listFiles((dir, name) -> name.endsWith(".bin"));

                        if (files != null && files.length > 0) {
                            // Создание временного файла для объединенных данных
                            String tempFileName = outputPath + File.separator + "temp_output.bin";

                            try (FileOutputStream fos = new FileOutputStream(tempFileName);
                                 BufferedOutputStream bos = new BufferedOutputStream(fos)) {

                                for (File file : files) {
                                    try (FileInputStream fis = new FileInputStream(file);
                                         BufferedInputStream bis = new BufferedInputStream(fis)) {

                                        byte[] buffer = new byte[4096];
                                        int bytesRead;
                                        while ((bytesRead = bis.read(buffer)) != -1) {
                                            bos.write(buffer, 0, bytesRead);
                                        }
                                    }
                                }
                            } // Конец блока try-with-resources

                            // Проверка целостности файла по CRC32
                            if (isFileIntegrityValid(tempFileName, files)) {
                                // Убеждаемся, что все потоки закрыты перед удалением файлов
                                for (File file : files) {
                                    try {
                                        Files.deleteIfExists(file.toPath());
                                        System.out.println("Файл " + file.getName() + " удален.");
                                    } catch (IOException e) {
                                        System.out.println("Не удалось удалить файл " + file.getName());
                                        e.printStackTrace();
                                    }
                                }

                                // Перемещение временного файла на место
                                String fileNameWithoutExtension = files[0].getName().split("_part_")[0];
                                String outputFile = outputPath + File.separator +
                                        fileNameWithoutExtension + "_output.bin";

                                try (FileInputStream fis = new FileInputStream(tempFileName);
                                     FileOutputStream fos = new FileOutputStream(outputFile)) {

                                    byte[] buffer = new byte[4096];
                                    int bytesRead;
                                    while ((bytesRead = fis.read(buffer)) != -1) {
                                        fos.write(buffer, 0, bytesRead);
                                    }

                                    System.out.println("Файл успешно объединен.");
                                } // Конец блока try-with-resources
                            } else {
                                System.out.println("Ошибка: CRC32 не совпадает. Файл поврежден.");
                            }

                            // Удаление временного файла
                            Files.deleteIfExists(Path.of(tempFileName));
                        } else {
                            System.out.println("Отсутствуют файлы для объединения.");
                        }
                    }

                    private static boolean isFileIntegrityValid(String filePath, File[] files) {
                        CRC32 crc32 = new CRC32();
                        try (FileInputStream fis = new FileInputStream(filePath);
                             BufferedInputStream bis = new BufferedInputStream(fis)) {
                            byte[] buffer = new byte[4096];
                            int bytesRead;
                            while ((bytesRead = bis.read(buffer)) != -1) {
                                crc32.update(buffer, 0, bytesRead);
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        long expectedCRC32 = extractCRC32(files[0].getName());
                        return crc32.getValue() == expectedCRC32;
                    }

                    private static long extractCRC32(String fileName) {
                        Matcher matcher = Pattern.compile("_crc_(\\d+)").matcher(fileName);
                        if (matcher.find()) {
                            return Long.parseLong(matcher.group(1));
                        } else {
                            return -1;
                        }
                    }
                }
