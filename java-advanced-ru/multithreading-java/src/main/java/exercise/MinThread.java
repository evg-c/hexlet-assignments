package exercise;

import java.util.Arrays;

// BEGIN
public class MinThread extends Thread {

    private int[] numbers;
    private int min;

    MinThread(int[] numbers) {
        this.numbers = numbers;
    }

    @Override
    public void run() {
        min = Arrays.stream(numbers).min().getAsInt();
    }

    public int getMin() {
        return min;
    }
}
// END
