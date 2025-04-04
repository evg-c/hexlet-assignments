package exercise;

import java.util.Random;

// BEGIN
public class ListThread extends Thread {

    private SafetyList list;
    static final int SCOPE_OF_RANDOM_TO_1000 = 1000;  // диапазон генерации случайного числа

    ListThread(SafetyList list) {
        this.list = list;
    }

    @Override
    public void run() {
        Random rnd = new Random();
        for (int i = 0; i < 1000; i++) {
            int randomNumber = rnd.nextInt(SCOPE_OF_RANDOM_TO_1000); // переменная для хранения случайного числа
            try {
                sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            list.add(randomNumber);
            //System.out.println(randomNumber);
        }
    }
}
// END
