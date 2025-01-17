package exercise.controller;

import exercise.daytime.Day;
import exercise.daytime.Daytime;
import exercise.daytime.Night;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

// BEGIN
@RestController
public class WelcomeController {

    @Autowired
    private Day day;

    @Autowired
    private Night night;

    @Bean
    @Scope("prototype")
    public Daytime objectTime() {
        int currentHour = LocalDateTime.now().getHour();
        if (currentHour >= 6 && currentHour < 22) {
            return day;
        }
        if (currentHour >=22 || currentHour < 6) {
            return night;
        }
        return null;
    }

    @GetMapping(path = "/welcome")
    public String index() {
        String currentDayTime = objectTime().getName();
        return "It is " + currentDayTime + " now! Welcome to Spring!";
    }
}
// END
