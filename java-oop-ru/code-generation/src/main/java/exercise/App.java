package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

// BEGIN
public class App {
    public static void save(Path pathToFile, Car carToSave) throws JsonProcessingException, IOException {
        String strToSave = carToSave.serialize();
        Files.writeString(pathToFile, strToSave, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
    }

    public static Car extract(Path pathToFile) throws IOException {
        String strFromFile = Files.readString(pathToFile);
        Car oneCar = Car.unserialize(strFromFile);
        return oneCar;
    }
}
// END
