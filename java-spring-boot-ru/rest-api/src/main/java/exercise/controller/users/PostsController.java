package exercise.controller.users;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public Optional<List<Post>> showPostsOneUser(@PathVariable String id) {
        var result = posts.stream()
                .filter(p -> (p.getUserId() == Integer.parseInt(id)))
                .toList();
        return Optional.of(result);
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@PathVariable String id, @RequestBody Post data) {
        var newPost = new Post();
        newPost.setSlug(data.getSlug());
        newPost.setTitle(data.getTitle());
        newPost.setBody(data.getBody());
        newPost.setUserId(Integer.parseInt(id));
        posts.add(newPost);
        return newPost;
    }
}
// END
