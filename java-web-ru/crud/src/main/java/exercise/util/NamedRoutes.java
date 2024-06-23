package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    // BEGIN
    public static String postsPath() {
        return "/posts";
    }

    public static String postPathId() {
        return "/posts/{id}";
    }

    public static String postId(Long id) {
        return postId(String.valueOf(id));
    }

    public static String postId(String id) {
        return "/posts/" + id;
    }
    // END
}
