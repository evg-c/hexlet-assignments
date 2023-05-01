package exercise;

import java.util.LinkedHashMap;
import java.util.Map;
//import java.util.Set;
//import java.util.TreeSet;
import java.util.HashMap;
//import java.util.stream.Collectors;
import java.util.stream.Stream;

// BEGIN
public class App {
    public static void main(String[] args) {
        Map<String, Object> data1 = new HashMap<>(
                Map.of("one", "eon", "two", "two", "four", true)
        );
        System.out.println(data1); //=> {two=two, four=true, one=eon}

        Map<String, Object> data2 = new HashMap<>(
                Map.of("two", "own", "zero", 4, "four", true)
        );
        System.out.println(data2); //=> {zero=4, two=own, four=true}

        Map<String, String> result = App.genDiff(data1, data2);
        System.out.println(result); //=> {four=unchanged, one=deleted, two=changed, zero=added}
    }
    public static Map<String, String> genDiff(Map<String, Object> map1, Map<String, Object> map2) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> elementMap1: map1.entrySet()) {
            // идем по элементам первой мапы
            String currentKey = elementMap1.getKey();
            // берем ключ
            if (map2.containsKey(currentKey)) {
                // ищем этот ключ во второй мапе
                if (map2.get(currentKey).equals(elementMap1.getValue())) {
                    // значения по ключу одинаковы
                    result.put(currentKey, "unchanged");
                } else {
                    // значения по ключу разные
                    result.put(currentKey, "changed");
                }
            } else {
                // этого ключа во второй мапе нет
                result.put(currentKey, "deleted");
            }
        }
        for (Map.Entry<String, Object> elementMap2: map2.entrySet()) {
            // идем по элементам второй мапы
            String currentKey = elementMap2.getKey();
            // берем ключ
            if (!map1.containsKey(currentKey)) {
                result.put(currentKey, "added");
            }
        }
//        Map<String, String> sortedMap = result.entrySet().stream()
//                .sorted(Map.Entry.comparingByKey())
//                .collect(Collectors.toMap(
//                        Map.Entry::getKey,
//                        Map.Entry::getValue,
//                        (a, b) -> { throw new AssertionError(); },
//                        LinkedHashMap::new
//                ));
        //return result;
        Map<String, String> resultMap = new LinkedHashMap<>();
        Stream<Map.Entry<String, String>> sortedStream = result.entrySet().stream();
        sortedStream.sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> resultMap.put(x.getKey(), x.getValue()));
        //return sortedMap;
        return resultMap;
    }
}
//END
