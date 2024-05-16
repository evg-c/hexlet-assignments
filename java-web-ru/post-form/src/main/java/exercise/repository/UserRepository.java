package exercise.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import exercise.App;

import exercise.model.User;
import exercise.util.Security;

public class UserRepository {
    private static List<User> entities = new ArrayList<User>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        //user.setFirstName(App.capitalize(user.getFirstName()));
        //user.setLastName(App.capitalize(user.getLastName()));
        //user.setEmail(user.getEmail().toLowerCase().trim());
        //user.setPassword(Security.encrypt(user.getPassword()));
        entities.add(user);
    }

    public static List<User> search(String term) {
        var users = entities.stream()
                .filter(entity -> entity.getFirstName().startsWith(term))
                .toList();
        return users;
    }

    public static Optional<User> find(Long id) {
        var user = entities.stream()
                .filter(entity -> entity.getId().equals(id))
                .findAny()
                .orElse(null);
        return Optional.of(user);
    }

    public static void delete(Long id) {

    }

    public static List<User> getEntities() {
        //for (User user: entities) {
        //    user.setFirstName(App.capitalize(user.getFirstName()));
        //    user.setLastName(App.capitalize(user.getLastName()));
        //    user.setEmail(user.getEmail().toLowerCase().trim());
        //    user.setPassword(Security.encrypt(user.getPassword()));
        //}
        return entities;
    }

    public static void clear() {
        entities.clear();
    }
}
