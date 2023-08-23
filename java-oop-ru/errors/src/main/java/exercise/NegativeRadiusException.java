package exercise;

// BEGIN
public class NegativeRadiusException extends Exception {
    public NegativeRadiusException(String message) {
        super(message);
        System.out.println(message);
    }
}
// END
