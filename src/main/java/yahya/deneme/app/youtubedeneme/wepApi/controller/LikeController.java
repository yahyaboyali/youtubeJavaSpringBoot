package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.LikeService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.LikeRequest;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/likes")
@CrossOrigin
public class LikeController {
    private LikeService likeService;
    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }
    @GetMapping("/getAll")
    public DataResult<List<Like>> getAll(@RequestParam Optional<Integer> userId, @RequestParam Optional<Integer> postId){
        return likeService.getAll(userId,postId);
    }

    @PostMapping("/addLike")
    public Result addLike(@RequestBody LikeRequest likeRequest) {
        return likeService.save(likeRequest);
    }

    @GetMapping("/getOneLike/{likeId}")
    public DataResult<Optional<Like>> getOneLike(@PathVariable int likeId) {
        return likeService.getOneLike(likeId);
    }
    @DeleteMapping("/deleteLike/{likeId}")
    public Result deleteLike(@PathVariable int likeId) {
        return likeService.deleteLike(likeId);
    }
}
