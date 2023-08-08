package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// BEGIN
public class App {
    public static void main(String[] args) {
//        Map<String, String> myMap = new HashMap<>();
//        myMap.put("key", "value");
//        myMap.put("key2", "value2");
//        KeyValueStorage storage = new InMemoryKV(myMap);
//        //App.swapKeyValue(storage);
//        System.out.println(storage.get("key", "default")); // "default");
//        System.out.println(storage.get("value", "default")); // "key");
//        System.out.println(storage.toMap()); // => {value=key, value2=key2}

//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "10"));
//        // Получение значения по ключу
//        System.out.println(storage.get("key", "default")); // "10"
//        System.out.println(storage.get("unknown", "default")); // "default"
//        // Установка нового значения
//        storage.set("key2", "value2");
//        System.out.println(storage.get("key2", "default")); // "value2"
//        // Удаление ключа
//        storage.unset("key2");
//        System.out.println(storage.get("key2", "default")); // "default"
//        // Получение всех данных из базы
//        Map<String, String> data = storage.toMap();
//        System.out.println(data); // => {key=10};
//        KeyValueStorage storage = new InMemoryKV(Map.of("key", "value", "key2", "value2"));
//        App.swapKeyValue(storage);
//        System.out.println(storage.get("key", "default")); // "default"
//        System.out.println(storage.get("value", "default")); // "key"
//        System.out.println(storage.toMap()); // => {value=key, value2=key2}
//        KeyValueStorage storage = new FileKV("src/test/resources/file", Map.of("key", "value"));
//        // Получение значения по ключу
//        System.out.println(storage.get("key", "default")); // "value"
        Map<String, String> initial = new HashMap<>();
        initial.put("key", "10");

        Map<String, String> clonedInitial = new HashMap<>();
        clonedInitial.putAll(initial);

        KeyValueStorage storage = new InMemoryKV(initial);

        initial.put("key2", "value2");
        //assertThat(storage.toMap()).isEqualTo(clonedInitial);

        Map<String, String> map = storage.toMap();
        map.put("key2", "value2");
    }
    public static void swapKeyValue(KeyValueStorage bd) {
        Map<String, String> map1 = bd.toMap();
        if (map1.isEmpty()) {
            return;
        }
        Map<String, String> map2 = new HashMap<>(map1);
        Set<Map.Entry<String, String>> setBD = map2.entrySet();
        for (Map.Entry<String, String> myEntry: setBD) {
            String keyOneEntry = myEntry.getKey();
            String valueOneEntry = myEntry.getValue();
            bd.unset(keyOneEntry);
            bd.set(valueOneEntry, keyOneEntry);
        }
    }
}
// END
