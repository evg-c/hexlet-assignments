package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        User owner = new User(1, "Ivan", "P", 25);
////        System.out.println(owner.getFirstName()); // "Ivan"
//        Car car = new Car(1, "bmv", "x5", "black", owner);
//        String jsonRepresentation = car.serialize();
//        System.out.println(jsonRepresentation); // =>
///*
//{
//  "id":1,
//  "brand":"bmv",
//  "model":"x5",
//  "color":"black",
//  "owner":{
//      "id":1,
//      "firstName":"Ivan",
//      "lastName":"P",
//      "age":25
//  }
//}
//*/
////        String jsonRepresentation = // получаем JSON представление объекта
//        Car instance = Car.unserialize(jsonRepresentation);
//        System.out.println(instance.getBrand()); // "bmv"
//        System.out.println(instance.getModel()); // "x5"
//        Path path1 = Paths.get("/tmp/file1.json");
//        Car car1 = new Car(1, "audi", "q3", "black", owner);
//        App.save(path1, car1); // Сохраняет представление объекта в

        Path path2 = Paths.get("/tmp/file2.json");
        Car car2 = App.extract(path2); // Возвращает инстанс класса Car
        System.out.println(car2.getModel()); // "passat"
    }
}
