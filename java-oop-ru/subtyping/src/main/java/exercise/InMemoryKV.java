package exercise;

import java.util.Map;
import java.util.HashMap;

// BEGIN
public class InMemoryKV implements KeyValueStorage {

    private Map<String, String> storageInMemory = new HashMap<>();

    public InMemoryKV(Map<String, String> mapIn) {
        //this.storageInMemory = mapIn;
        this.storageInMemory.putAll(mapIn);
    }
    @Override
    public void set(String key, String value) {
        if (storageInMemory.containsKey(key)) {
            storageInMemory.replace(key, value);
        } else {
            this.storageInMemory.put(key, value);
        }
    }

    @Override
    public void unset(String key) {
        if (storageInMemory.containsKey(key)) {
            storageInMemory.remove(key);
        }
    }

    @Override
    public String get(String key, String defaultValue) {
        if (storageInMemory.containsKey(key)) {
            return storageInMemory.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public Map<String, String> toMap() {
        Map<String, String> mapOut = new HashMap<>();
        mapOut.putAll(storageInMemory);
        return mapOut;
    }
}
// END
