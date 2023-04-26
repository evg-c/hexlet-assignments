package exercise;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.List;
//import java.util.stream.Collectors;
import java.util.stream.Stream;

//import static java.util.Collections.addAll;


// BEGIN
public class App {
    public static void main(String[] args) {
        String[][] image = {
            {"*", "*", "*", "*"},
            {"*", " ", " ", "*"},
            {"*", " ", " ", "*"},
            {"*", "*", "*", "*"},
        };
        System.out.println(Arrays.deepToString(image)); // =>
// [
//     [*, *, *, *],
//     [*,  ,  , *],
//     [*,  ,  , *],
//     [*, *, *, *],
// ]
        String[][] enlargedImage = App.enlargeArrayImage(image);
        System.out.println(Arrays.deepToString(enlargedImage)); // =>
// [
//     [*, *, *, *, *, *, *, *],
//     [*, *, *, *, *, *, *, *],
//     [*, *,  ,  ,  ,  , *, *],
//     [*, *,  ,  ,  ,  , *, *],
//     [*, *,  ,  ,  ,  , *, *],
//     [*, *,  ,  ,  ,  , *, *],
//     [*, *, *, *, *, *, *, *],
//     [*, *, *, *, *, *, *, *],
// ]
    }
    public static String[][] enlargeArrayImage(String[][] arrIn) {
        int rows = arrIn.length;
        if (rows == 0) {
            return arrIn;
        }
        int columns = arrIn[0].length;
        if (columns == 0) {
            return arrIn;
        }
        //String[] arrayOneDimensional = (String[]) Arrays.stream(arrIn)
        //    .flatMap(Arrays::stream)
        //    .toArray();
        List<String> arrayListOneDimensional = Stream.of(arrIn)
            .flatMap(Stream::of)
            .toList();
        // получили одномерную последовательность
        List<String> arrayListOneDimensionalCopy = new ArrayList<>();
        for (int i = 0; i < arrayListOneDimensional.size(); i++) {
            arrayListOneDimensionalCopy.add(arrayListOneDimensional.get(i));
            arrayListOneDimensionalCopy.add(arrayListOneDimensional.get(i));       //увеличиваем в два раза
        }
        // получили удвоенную последовательность, только по горизонтали
        String[][] arrIncreaseHorizont = new String[rows * 2][columns * 2];
        int l = 0; // счетчик из последовательности
        for (int j = 0; j < arrIncreaseHorizont.length; j++) {
            for (int k = 0; k < arrIncreaseHorizont[0].length; k++) {
                arrIncreaseHorizont[j][k] = arrayListOneDimensionalCopy.get(l);
                l++;
            }
            // одну строку заполнили
            arrIncreaseHorizont[j + 1] = arrIncreaseHorizont[j];
            j++;
        }
//        arrIncreaseHorizont = new String[][]{arrayListOneDimensionalCopy.stream().toArray(String[][]::new)};
//        // получили новый двумерный массив увеличенный по горизонтали
//        List<List<String>> arrayListTwoDimensional = new ArrayList<>();
//        for (String[] oneRow: arrIncreaseHorizont) {
//            List<String> singleRow = new ArrayList<>();
//            singleRow.addAll(Arrays.asList(oneRow));
//            singleRow.addAll(Arrays.asList(oneRow));  // увеличиваем в два раза по вертикали
//            arrayListTwoDimensional.add(singleRow);
//            singleRow.clear();
//        }
//        // получили двумерный arrayList увеличенный по вертикали
//        return arrayListTwoDimensional.stream()
//            .toArray(String[][]::new);
        return arrIncreaseHorizont;
    }
}
// END
