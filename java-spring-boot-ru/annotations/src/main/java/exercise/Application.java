package exercise;

import exercise.model.Address;
import exercise.annotation.Inspect;
import java.lang.reflect.Method;

public class Application {
    public static void main(String[] args) {
        var address = new Address("London", 12345678);

        // BEGIN
        for (Method method: Address.class.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Inspect.class)) {
                String packageNameType = method.getReturnType().getPackageName();
                String type = method.getReturnType().getName();
                if (type.contains(packageNameType)) {
                    type = type.substring(packageNameType.length() + 1);
                }
                System.out.println("Method " + method.getName() + " returns a value of type " + type);
            }
        }
        // END
    }
}
