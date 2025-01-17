package exercise.daytime;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

public class Night implements Daytime {
    private String name = "night";

    public String getName() {
        return name;
    }

    // BEGIN
    @PostConstruct
    public void init() {
        System.out.println("Bean Night is initialized!");
    }
    // END
}
