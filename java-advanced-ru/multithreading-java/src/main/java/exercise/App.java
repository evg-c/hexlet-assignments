package exercise;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.logging.Level;

class App {
    private static final Logger LOGGER = Logger.getLogger("AppLogger");

    // BEGIN
    public static Map<String, Integer> getMinMax(int[] numbers) {
        MaxThread maxThread = new MaxThread(numbers);
        MinThread minThread = new MinThread(numbers);

        maxThread.start();
        LOGGER.info("Thread MaxThread started");

        minThread.start();
        LOGGER.info("Thread MinThread started");

        try {
            maxThread.join();
            LOGGER.info("Thread MaxThread finished");
        } catch (InterruptedException e) {
            LOGGER.info("Thread MaxThread interrupted");
        }

        try {
            minThread.join();
            LOGGER.info("Thread MinThread finished");
        } catch (InterruptedException e) {
            LOGGER.info("Thread MinThread interrupted");
        }

        int max = maxThread.getMax();
        int min = minThread.getMin();
        Map<String, Integer> result = new HashMap<>();
        result.put("min", min);
        result.put("max", max);
        return result;
    }
    // END

    public static void main(String[] args) throws InterruptedException {
        int[] numbers = {10, -4, 67, 100, -100, 8};
        System.out.println(getMinMax(numbers));
    }
}
