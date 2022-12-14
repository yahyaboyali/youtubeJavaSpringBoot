package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.CommentService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.CommentRequest;
import yahya.deneme.app.youtubedeneme.bussiness.requests.CommentUpdateResponse;
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
    public Result createComment(@RequestBody CommentRequest commentRequest) {
       return commentService.createComment(commentRequest);
    }
    @PutMapping("/updateComment/{commentId}")
    public Result updateComment(@PathVariable int commentId, @RequestBody CommentUpdateResponse commentUpdateResponse) {
        return commentService.updateComment(commentId, commentUpdateResponse);
    }
    @DeleteMapping("/deleteComment/{commentId}")
    public Result deleteCommit(@PathVariable int commentId) {
        return commentService.deleteComment(commentId);
    }
}
