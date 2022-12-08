package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.core.utilities.results.SuccessDataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.SuccessResult;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.PostRepo;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

@Service
public class PostManager implements PostService {

    private PostRepo postRepo;

    public PostManager(PostRepo postRepo) {
        this.postRepo = postRepo;
    }


    @Override
    public DataResult<List<Post>> getAllPost(Optional<Integer> userId) {
        if( userId.isPresent()) {
            return new SuccessDataResult<List<Post>>(postRepo.findByUserId(userId.get()),"post geldi hanım");
        }
        return new SuccessDataResult<List<Post>>(postRepo.findAll(),"tüm postlar geldi hanım");
    }

    @Override
    public Result save(Post post) {
        postRepo.save(post);
        return new SuccessResult("başarılı");
    }
}
