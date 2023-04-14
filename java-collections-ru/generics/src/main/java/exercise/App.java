package exercise;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {

    public static void main(String[] args) {
        List<Map<String, String>> books = new ArrayList<>();

        Map<String, String> book1 = new HashMap<>(
                Map.of("title", "Cymbeline", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book2 = new HashMap<>(
                Map.of("title", "Book of Fooos", "author", "FooBar", "year", "1111")
        );
        Map<String, String> book3 = new HashMap<>(
                Map.of("title", "The Tempest", "author", "Shakespeare", "year", "1611")
        );
        Map<String, String> book4 = new HashMap<>(
                Map.of("title", "Book of Foos Barrrs", "author", "FooBar", "year", "2222")
        );
        Map<String, String> book5 = new HashMap<>(
                Map.of("title", "Still foooing", "author", "FooBar", "year", "3333")
        );

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        Map<String, String> where = new HashMap<>(Map.of("author", "Shakespeare", "year", "1611"));

        List<Map<String, String>> result = App.findWhere(books, where);

        System.out.println(result); // =>
// [
//     {title=Cymbeline, year=1611, author=Shakespeare},
//     {title=The Tempest, year=1611, author=Shakespeare}
// ]
    }
    public static List findWhere(List<Map<String, String>> allBooks, Map<String, String> mapWhere) {
        if (allBooks.isEmpty()) {
            return allBooks;
        }
        List<Map<String, String>> booksResult = new ArrayList<>();
        if (mapWhere.isEmpty()) {
            return booksResult;
        }
        for (Map<String, String> mapCurrentBookFromList: allBooks) {
            // перебираем все книги из входящего списка - итерируемся по List
            boolean allPairsMatched = true;            // признак совпадения всех пар ключ-значение для данной книги
            for (Map.Entry<String, String> pairFromMapWhere: mapWhere.entrySet()) {
                // перебираем все пары ключ-значение входящего справочника - итерируемся по Map из параметра
                // все пары должны совпасть
                boolean currentPairMatched = false;     // текущую пару нашли
                for (Map.Entry<String, String> pairFromMapCurrentBookFromList: mapCurrentBookFromList.entrySet()) {
                    // перебираем все пары ключ-значение из текущей книги - итерируемся по Map нашего List
                    if (pairFromMapCurrentBookFromList.getKey().equals(pairFromMapWhere.getKey())) {
                        // ключ нашли
                        if (pairFromMapCurrentBookFromList.getValue().equals(pairFromMapWhere.getValue())) {
                            // и значение совпало
                            currentPairMatched = true;
                        }
                    }
                }
                if (!currentPairMatched) {
                    // текущую пару ключ-значение в текущей книге не нашли
                    allPairsMatched = false;
                    // другие пары из входящего справочника перебирать дальше нет смысла
                    // выходим из цикла и переходим к следующей книге
                    break;
                }
            }
            if (allPairsMatched) {                     // все пары совпали, добавляем в результат
                booksResult.add(mapCurrentBookFromList);
            }
        }
        return booksResult;
    }
}
//END
