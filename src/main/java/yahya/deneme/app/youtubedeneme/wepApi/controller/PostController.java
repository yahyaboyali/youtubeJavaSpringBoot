package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/posts")
@CrossOrigin
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public DataResult<List<Post>> getAllPost(@RequestParam Optional<Integer> userId) {
        return postService.getAllPost(userId);
    }

    @PostMapping("/addPost")
    public Result addPost(@RequestBody Post post) {
        return postService.save(post);
    }
}
