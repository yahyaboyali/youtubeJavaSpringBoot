package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.CommentService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/comment")
@CrossOrigin
public class CommentController {
    private CommentService commentService;
    @Autowired
    public CommentController (CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/getALl")
    public DataResult<List<Comment>> findAll(@RequestParam Optional<Integer> userId,
                                            @RequestParam Optional<Integer> postId){

        return commentService.findAll(userId, postId);
    }
    @GetMapping("/getOne/{commetId}")
    public DataResult<Optional<Comment>> findById(@RequestParam int commentId){
        return commentService.findById(commentId);
    }
    @PostMapping("/save")
    public Result save(@RequestBody Comment comment) {
       return commentService.save(comment);
    }
}
