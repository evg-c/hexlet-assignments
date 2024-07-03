package exercise.util;

public class NamedRoutes {

    public static String rootPath() {
        return "/";
    }

    public static String postsPath() {
        return "/posts";
    }

    public static String buildPostPath() {
        return "/posts/build";
    }

    public static String postPath(Long id) {
        return postPath(String.valueOf(id));
    }

    public static String postPath(String id) {
        return "/posts/" + id;
    }

    // BEGIN
    public static String editPath() {
        return "/posts/{id}/edit";
    }

    public static String postPathId() {
        return "/posts/{id}";
    }

    public static String postPathId(Long id) {
        return postPathId(String.valueOf(id));
    }

    public static String postPathId(String id) {
        return "/posts/" + id;
    }

    public static String editPathId(Long id) {
        return editPathId(String.valueOf(id));
    }

    public static String editPathId(String id) {
        return "/posts/" + id + "/edit";
    }
    // END
}
