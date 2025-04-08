package exercise;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.CompletableFuture;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String filepath1, String filepath2, String filepath3)
            throws Exception {

        CompletableFuture<String> futureReadFile1 = CompletableFuture.supplyAsync(() -> {
            try {
                Path path = Paths.get(filepath1);
                return Files.readString(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                //throw new RuntimeException(e);
                String err = e.toString();
                return "Не получилось прочитать из файла " + filepath1 + " " + err;
            }
        }).exceptionally(ex -> {
            System.out.println("Не получилось прочитать из файла " + filepath1);
            return "Не получилось прочитать из файла " + filepath1 + " " + ex.toString();
        });

        String str1 = futureReadFile1.get();
        StringBuilder resultString = new StringBuilder();
        resultString.append(str1);

        CompletableFuture<String> futureReadFile2 = CompletableFuture.supplyAsync(() -> {
            try {
                Path path = Paths.get(filepath2);
                return Files.readString(path, StandardCharsets.UTF_8);
            } catch (IOException e) {
                //throw new IOException(e);
                System.out.println(e.toString());
                String err = e.toString();
                return "Не получилось прочитать из файла " + filepath2 + " " + err;
            }
        }).exceptionally(ex -> {
            System.out.println("Не получилось прочитать из файла " + filepath2);
            return "Не получилось прочитать из файла " + filepath2 + " " + ex.toString();
        });

        String str2 = futureReadFile2.get();
        resultString.append(str2);
        String resultStr = resultString.toString();

        String outputFile = defineOutputFile(filepath3);
        CompletableFuture<String> writeToFile = futureReadFile1
                .thenCombine(futureReadFile2, (string1, string2) -> {
                    Path path = Paths.get(outputFile);
                    String result = string1 + string2;
                    try {
                        path = Files.writeString(path, result, StandardCharsets.UTF_8);
                        return path.toString();
                    } catch (IOException e) {
                        System.out.println(e.toString());
                        return "Ошибка: Не удалось записать результат в результирующий файл " + outputFile
                                + e.toString();
                    }
                }).exceptionally(ex -> {
                    return "Ошибка: Не удалось записать результат в результирующий файл " + outputFile + ex.toString();
                });
        return writeToFile;

    }

    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
//        String result = unionFiles("nonExistingFile",
//                "file", "").get();
        //System.out.println("Результат: " + result);

        Long result = getDirectorySize("src/test/resources/empty_dir").get();
        System.out.println("Результат: " + result + " байт");
        // END
    }

    public static String defineOutputFile(String file) {
        Path writeFilePath;
        if (file == null || file.isEmpty()) {
            File createFile = new File("result.txt");
            writeFilePath = Paths.get(createFile.toURI());
            if (createFile.exists()) {
                return writeFilePath.toString();
            }
            try {
                if (createFile.createNewFile()) {
                    return writeFilePath.toString();
                } else {
                    return "Ошибка: Не удалось создать результирующий файл!";
                }
            } catch (IOException e) {
                return "Ошибка: Не удалось создать результирующий файл! " + e.getMessage();
            }
        } else {
            writeFilePath = Paths.get(file);
        }
        return writeFilePath.toString();
    }

    public static CompletableFuture<Long> getDirectorySize(String directory) {

        CompletableFuture<Long> dirSize = CompletableFuture.supplyAsync(() -> {
            if ((directory == null) || (directory.isEmpty())) {
                System.out.println("Директория не задана!");
                return 0L;
            }
            try {
                File folder = new File(directory);
                File[] files = folder.listFiles();
                long sumSizes = 0;
                for (File file : files) {
                    if (file.isFile()) {
                        sumSizes = sumSizes + file.length();
                    }
                }
                Long result = sumSizes;
                return result;
            } catch (Exception e) {
                System.out.println("Не удалось получить список файлов директории " + directory);
                return 0L;
            }

        }).exceptionally(ex -> {
            System.out.println("Не удалось прочитать список файлов директории " + directory);
            return 0L;
        });

        return dirSize;
    }
}

