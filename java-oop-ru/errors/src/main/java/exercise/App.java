package exercise;

// BEGIN
public class App {
    public static void printSquare(Circle oneCircle) {
        if (oneCircle == null) {
            System.out.println("Circle is null");
        }
        try {
            System.out.println(Math.round(oneCircle.getSquare()));
        } catch (NegativeRadiusException e) {
            //System.out.println("Не удалось посчитать площадь");;
        } finally {
            System.out.println("Вычисление окончено");
        }
    }
}
// END
