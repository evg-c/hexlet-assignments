package exercise;

import io.javalin.Javalin;
import java.util.List;
import java.util.stream.Collectors;

import exercise.model.User;
import exercise.dto.users.UsersPage;
import static io.javalin.rendering.template.TemplateUtil.model;
import io.javalin.rendering.template.JavalinJte;

import org.apache.commons.lang3.StringUtils;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        app.get("/users", ctx -> {
            List<User> findUsers;
            var term = ctx.queryParam("term");
            if (term != null) {
                findUsers = findUsersTerm(USERS, term);
            } else {
                findUsers = USERS;
            }
            var page = new UsersPage(findUsers, term);
            ctx.render("users/index.jte", model("page", page));
        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }

    public static List<User> findUsersTerm(List<User> listUsers, String term) {
        return listUsers.stream()
                .filter(user -> user.getFirstName().toLowerCase().startsWith(term.toLowerCase()))
                .collect(Collectors.toList());
    }
}
