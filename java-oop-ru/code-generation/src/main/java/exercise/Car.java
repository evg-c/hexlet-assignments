package exercise;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.Value;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

// BEGIN
@Value
// END
class Car {
    int id;
    String brand;
    String model;
    String color;
    User owner;

    // BEGIN
    public String serialize() throws JsonProcessingException {
        ObjectMapper myMapper = new ObjectMapper();
        myMapper.enable(SerializationFeature.INDENT_OUTPUT);
        String jsonRepresentation = myMapper.writeValueAsString(this);
        return jsonRepresentation;
    }

    public static Car unserialize(String jsonRepresentative) throws IOException {
        ObjectMapper myMapper = new ObjectMapper();
        Car myCar = myMapper.readValue(jsonRepresentative, Car.class);
        return myCar;
    }
    // END
}
