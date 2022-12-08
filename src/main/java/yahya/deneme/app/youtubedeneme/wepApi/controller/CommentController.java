package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.CommentService;
import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;

import java.util.List;

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
    public List<Comment> findAll(){
        return commentService.findAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Comment comment) {
        commentService.save(comment);
    }
}
