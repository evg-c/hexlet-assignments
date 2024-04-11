package exercise;

import io.javalin.Javalin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
import io.javalin.http.NotFoundResponse;
// END

public final class App {

    private static final List<Map<String, String>> COMPANIES = Data.getCompanies();

    public static Javalin getApp() {
        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
        });
        // BEGIN
        app.get("/companies/{id}", ctx -> {
            var idCompany = ctx.pathParam("id");
            if ((idCompany == null) || (idCompany.isEmpty())) {
                new NotFoundResponse("Company with empty id not found");
            } else {
                Map<String, String> oneCompany = new HashMap<>();
                for (Map<String, String> one: COMPANIES) {
                    // перебираем лист с мапами
                    for (Map.Entry<String, String> oneEntry: one.entrySet()) {
                        // перебираем строки конкретной мапы
                        if (oneEntry.getKey().equals("id") && oneEntry.getValue().equals(idCompany)) {
                            oneCompany.putAll(one);
                        }
                    }
                }
                if (oneCompany.isEmpty()) {
                    ctx.result("Company not found");
                    ctx.status(404);
                } else {
                    ctx.json(oneCompany);
                }
            }
        });

        // END
        app.get("/companies", ctx -> {
            ctx.json(COMPANIES);
        });
        app.get("/", ctx -> {
            ctx.result("open something like (you can change id): /companies/5");
        });

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
