package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.LikeService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.UserService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.LikeRequest;
import yahya.deneme.app.youtubedeneme.core.utilities.results.*;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.LikeRepo;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.UserRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class LikeManager implements LikeService {

    private LikeRepo likeRepo ;
    private PostService postService;
    private UserService userService;

    public LikeManager(LikeRepo likeRepo, PostService postService, UserService userService) {
        this.likeRepo = likeRepo;
        this.postService = postService;
        this.userService = userService;
    }
    @Override
    public DataResult<List<Like>> getAll(Optional<Integer> userId, Optional<Integer> postId) {
        if(userId.isPresent() && postId.isPresent()) {
            return new SuccessDataResult<>(likeRepo.findByUserIdAndPostId(userId,postId),"user-post-like");
        } else if (postId.isPresent()) {
            return new SuccessDataResult<>(likeRepo.findByPostId(postId),"post-like");
        } else if( userId.isPresent()) {
            return new SuccessDataResult<>(likeRepo.findByUserId(userId),"user-like");
        } else {
            return new ErrorDataResult<>("data yok hacı");
        }
    }

    @Override
    public Result save(LikeRequest likeRequest) {
        Optional<User> user = userService.getOneUser(likeRequest.getUserId()).getData();
        Optional<Post> post = postService.getOnePost(likeRequest.getPostId()).getData();
        if(user.isPresent() && post.isPresent()) {
            Like like = new Like(likeRequest.getId(),user.get(),post.get());
            likeRepo.save(like);
            return new SuccessResult("like eklendi");
        } else {
            return new ErrorResult("böyle bir post veya user yok");
        }
    }

    @Override
    public DataResult<Optional<Like>> getOneLike(int likeId) {
        if(likeRepo.findById(likeId).isPresent()) {
            return new SuccessDataResult<>(likeRepo.findById(likeId),"geldi");
        } else {
            return new ErrorDataResult<>("data yok");
        }
    }

    @Override
    public Result deleteLike(int likeId) {
        if(likeRepo.findById(likeId).isPresent()){
            likeRepo.deleteById(likeId);
            return new SuccessResult("silindi");
        }else {
            return new ErrorResult("böyle bir veri yok");
        }
    }
}
