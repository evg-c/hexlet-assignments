package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {
    public static List<String> validate(Address adr) {
        List<String> listFieldsNull = new ArrayList<>();
        Class<?> adrClass = adr.getClass();
        //System.out.println(adrClass);
        Field[] fieldAdr = adrClass.getDeclaredFields();
        //System.out.println(fieldAdr);
        for (Field field: fieldAdr) {
            //System.out.println(field);
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(adr) == null) {
                        listFieldsNull.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return listFieldsNull;
    }

    public static Map<String, List<String>> advancedValidate(Address adr) {
        Map<String, List<String>> notValidFields = new HashMap<>();
        Class<?> adrClass = adr.getClass();
        Field[] fieldAdr = adrClass.getDeclaredFields();
        for (Field field: fieldAdr) {
            if (field.isAnnotationPresent(NotNull.class)) {
                field.setAccessible(true);
                try {
                    if (field.get(adr) == null) {
                        notValidFields.put(field.getName(), List.of("can not be null"));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            if (field.isAnnotationPresent(MinLength.class)) {
                field.setAccessible(true);
                MinLength annoMinLen = field.getAnnotation(MinLength.class);
                int lenAnno = annoMinLen.minLength();
                try {
                    String valueField = (String) field.get(adr);
                    if (valueField.length() < lenAnno) {
                        notValidFields.put(field.getName(),
                                List.of("length less then " + Integer.toString(lenAnno)));
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return notValidFields;
    }

    public static void main(String[] args) {
//        Address address = new Address(null, "London", "1-st street", "7", "2");
//        List<String> notValidFields = Validator.validate(address);
//        System.out.println(notValidFields); // => [country]
//
//        Address address2 = new Address("England", null, null, "7", "2");
//        List<String> notValidFields2 = Validator.validate(address2);
//        System.out.println(notValidFields2); // => [city, street]

        Address address3 = new Address("USA", "Texas", null, "7", "2");
        Map<String, List<String>> notValidateFields = Validator.advancedValidate(address3);
        System.out.println(notValidateFields); // =>  {country=[length less than 4], street=[can not be null]}
    }
}
// END
