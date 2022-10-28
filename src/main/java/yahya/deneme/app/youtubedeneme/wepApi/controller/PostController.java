package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("getAll")
    public List<Post> getAllPost() {
        return postService.findAll();
    }
    @PostMapping()
    public void addPost(@RequestBody Post post) {
        postService.save(post);
    }
}
