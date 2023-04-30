package exercise;

import java.nio.file.Path;
import java.nio.file.Paths;
//import java.util.List;
import java.util.stream.Collectors;
//import java.util.Arrays;
import java.nio.file.Files;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static void main(String[] args) throws Exception {
        String data1 = readFixture("s1.conf");
        //String content = Files.readString(Path.of(data1));
        String result = App.getForwardedVariables(data1);
        System.out.println(result); // => "MAIL=tirion@google.com,HOME=/home/tirion,var3=value"
    }

    private static String readFixture(String fileName) throws Exception {
        Path filePath = getFixturePath(fileName);
        return Files.readString(filePath).trim();
    }

    private static Path getFixturePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize();
    }

    public static String getForwardedVariables(String stringIn) {
        if (stringIn.isEmpty()) {
            return "";
        }
        String[] arrIn = stringIn.split("\n");
//        List<String> allVariables = Arrays.stream(arrIn)
//                .filter(str -> str.startsWith("environment="))
//                .map(strEnv -> strEnv.replaceAll("environment=", ""))
//                .collect(Collectors.toList());
//        List<String> listResult = allVariables.stream()
//                .filter(str -> str.toUpperCase().startsWith("\"X_FORWARDED_"))
//                .peek(System.out::println)
//                .map(strVar -> strVar.replaceAll("\"X_FORWARDED_", ""))
//                .collect(Collectors.toList());
//        String result = "";
//        if (listResult.size() > 1) {
//            result = listResult.stream()
//                    .map(str -> str.replaceAll("\"", ""))
//                    .collect(Collectors.joining(","));
//        } else {
//            result = listResult.get(0);
//        }
//        List<String> all = Arrays.stream(arrIn)
//                .filter(str -> str.startsWith("environment="))
//                .map(variable -> variable.replaceAll("environment=", ""))
//                .flatMap(element -> Stream.of(element.split(",")))
//                .map(variable -> variable.replaceAll("\"X_FORWARDED_", ""))
//                .peek(System.out::println)
//                .collect(Collectors.toList());
        return Stream.of(stringIn.split("\n"))
                .filter(str -> str.startsWith("environment="))
                .map(v -> v.replaceAll("environment=", "").replaceAll("\"", "").trim())
                .flatMap(element -> Stream.of(element.split(",")))
                .filter(variable -> variable.startsWith("X_FORWARDED_"))
                .map(variable -> variable.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
