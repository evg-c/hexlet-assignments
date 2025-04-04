package exercise;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

class App {

    public static void main(String[] args) throws InterruptedException {
        // BEGIN
        SafetyList list = new SafetyList();
        Thread thread1 = new ListThread(list);
        Thread thread2 = new ListThread(list);
        thread1.start();
        System.out.println("Thread " + thread1.getName() + " started: " + LocalTime.now());
        thread2.start();
        System.out.println("Thread " + thread2.getName() + " started: " + LocalTime.now());
        thread1.join();
        System.out.println("Thread " + thread1.getName() + " finished: " + LocalTime.now());
        thread2.join();
        System.out.println("Thread " + thread2.getName() + " finished: " + LocalTime.now());
        System.out.println("Количество элементов в листе - " + list.getSize());
        // END
    }
}

