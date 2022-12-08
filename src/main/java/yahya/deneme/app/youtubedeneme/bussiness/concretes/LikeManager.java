package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.LikeService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.core.utilities.results.SuccessDataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.SuccessResult;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.LikeRepo;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
@Service
public class LikeManager implements LikeService {

    private LikeRepo likeRepo ;

    public LikeManager(LikeRepo likeRepo) {
        this.likeRepo = likeRepo;
    }


    @Override
    public DataResult<List<Like>> getAll() {
        return new SuccessDataResult<List<Like>>(this.likeRepo.findAll(),"likes");
    }

    @Override
    public Result save(Like like) {
        return new SuccessResult("like eklendi");
    }
}
