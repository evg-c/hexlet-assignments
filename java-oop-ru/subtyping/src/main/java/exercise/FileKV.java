package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class FileKV implements KeyValueStorage {
    private Map<String, String> storageInMemory  = new HashMap<>();;
    private String pathToFile;
    public FileKV (String pathTo, Map<String, String> storage) {
        //this.storageInMemory = storage;
        this.storageInMemory.putAll(storage);
        this.pathToFile = pathTo;
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
        return storageInMemory.getOrDefault(key, defaultValue);
    }

    @Override
    public Map<String, String> toMap() {
        //return this.storageInMemory;
        Map<String, String> mapOut = new HashMap<>();
        mapOut.putAll(storageInMemory);
        return mapOut;
    }

    public void save(String pathTo, Map<String, String> mapIn) {
        if (pathTo.isEmpty()) {
            System.out.println("Файл сохранения базы не указан!");
            return;
        }
//        if (mapIn.isEmpty()) {
//            System.out.println("База для сохранения пуста!");
//            return;
//        }
        String stringJsonForSave = Utils.serialize(mapIn);
        Utils.writeFile(pathTo, stringJsonForSave);
    }

    public Map<String, String> restore(String pathTo) {
        String stringJsonForRestore = Utils.readFile(pathTo);
        Map<String, String> mapOut = Utils.unserialize(stringJsonForRestore);
        return mapOut;
    }
}
// END
