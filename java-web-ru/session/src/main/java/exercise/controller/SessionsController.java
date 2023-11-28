package exercise.controller;

import java.util.Collections;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.Security;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;
import io.javalin.validation.ValidationException;

public class SessionsController {

    // BEGIN
    public static void index(Context ctx) throws Exception {
        var name = ctx.sessionAttribute("currentUser");
        var page = new MainPage(name);
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", Collections.singletonMap("page", page));
        ctx.redirect("/");
    }

    public static void create(Context ctx) {
        try {
            var name = ctx.formParamAsClass("name", String.class)
                    .check(value -> UsersRepository.existsByName(value), "Wrong username")
                    .get();

            var user = UsersRepository.findByName(name);
            var password = ctx.formParamAsClass("password", String.class)
                    .check(value -> encrypt(value).hashCode() == user.getPassword().hashCode(),
                            "Wrong password")
                    .get();
        } catch (NotFoundResponse e) {
            var name = ctx.formParam("name");
            var page = new LoginPage(name, e.getMessage());
            ctx.render("build.jte", Collections.singletonMap("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect("/");

        var page = new MainPage(ctx.sessionAttribute("name"));
        ctx.render("index.jte", Collections.singletonMap("page", page));
    }
    // END
}
