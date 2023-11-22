package exercise.controller;

import exercise.dto.posts.PostPage;
import exercise.dto.posts.PostsPage;
import exercise.model.Post;
import exercise.repository.PostRepository;
import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

import java.util.Collections;
import java.util.List;

public class PostsController {

    // BEGIN
    public static void show(Context ctx) {
        var id = ctx.pathParamAsClass("id", Long.class).get();
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", Collections.singletonMap("page", page));
    }
    public static void showAllPosts(Context ctx) {
        var pageNumb = ctx.queryParamAsClass("page", Integer.class).getOrDefault(1);
        var per = ctx.queryParamAsClass("per", Integer.class).getOrDefault(5);
        var posts = PostRepository.getEntities()
                .subList((pageNumb - 1) * per, pageNumb * per);
        var lastPage = PostRepository.getEntities().size() / per;
        var page = new PostsPage(posts, pageNumb, lastPage);
        ctx.render("posts/index.jte", Collections.singletonMap("page", page));

    }
    // END
}
