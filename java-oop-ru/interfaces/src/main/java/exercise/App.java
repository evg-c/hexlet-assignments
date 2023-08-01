package exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import static java.util.Collections.sort;

// BEGIN
public class App {
    public static void main(String[] args) {
        List<Home> apartments = new ArrayList<>(List.of(
                new Flat(41, 3, 10),
                new Cottage(125.5, 2),
                new Flat(80, 10, 2),
                new Cottage(150, 3)
        ));
        List<String> result = App.buildApartmentsList(apartments, 3);
        System.out.println(result);
    }
    public static List<String> buildApartmentsList(List<Home> homeList, int countHome) {
        sort(homeList, new Comparator<Home>() {
            @Override
            public int compare(Home o1, Home o2) {
                return o1.compareTo(o2);
            }
        });
        List<String> resultList =
            homeList.stream().
            limit(countHome).
            map(Home::toString).
            collect(Collectors.toList());
        return resultList;
    }
}
// END
