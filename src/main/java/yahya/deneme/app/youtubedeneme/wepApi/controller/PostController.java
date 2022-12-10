package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.PostRequest;
import yahya.deneme.app.youtubedeneme.bussiness.requests.PostUpdate;
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
    @GetMapping("/{postId}")
    public DataResult<Optional<Post>> getOnePost(@PathVariable int postId) {
        return postService.getOnePost(postId);
    }

    @PostMapping("/addPost")
    public Result addPost(@RequestBody PostRequest postRequest) {
        return postService.save(postRequest);
    }
    @PutMapping("/{postId}")
    public Result updatePost(@PathVariable int postId , @RequestBody PostUpdate postUpdate) {
        return postService.updatePost(postId, postUpdate);
    }
    @DeleteMapping("deletePost/{postId}")
    public Result deletePost(@PathVariable int postId) {
        return postService.deletePost(postId);
    }

}
