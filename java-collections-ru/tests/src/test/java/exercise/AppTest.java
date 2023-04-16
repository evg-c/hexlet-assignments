package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        // первый тест
        List<Integer> test1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // System.out.println(App.take(numbers1, 2)); // => [1, 2]
        List<Integer> rightResultTest1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        // List<Integer> wrongResultTest1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        assertThat(test1).isEqualTo(rightResultTest1);

        // второй тест
        List<Integer> test2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        // System.out.println(App.take(numbers2, 8)); // => [7, 3, 10]
        List<Integer> rightResultTest2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        assertThat(test2).isEqualTo(rightResultTest2);
        // END
    }
}
