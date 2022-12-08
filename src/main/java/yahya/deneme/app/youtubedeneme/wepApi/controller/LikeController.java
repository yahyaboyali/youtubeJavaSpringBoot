package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.LikeService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;

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
    public DataResult<List<Like>> getAll(){
        return likeService.getAll();
    }

    @PostMapping("/addLike")
    public Result addLike(@RequestBody Like like) {
        return likeService.save(like);
    }
}
