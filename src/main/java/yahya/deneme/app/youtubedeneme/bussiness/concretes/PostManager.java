package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.UserService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.PostRequest;
import yahya.deneme.app.youtubedeneme.bussiness.requests.PostUpdate;
import yahya.deneme.app.youtubedeneme.core.utilities.results.*;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.PostRepo;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.UserRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

@Service
public class PostManager implements PostService {

    private PostRepo postRepo;
    private UserService userService;
    private final UserRepository userRepository;

    public PostManager(PostRepo postRepo, UserService userService,
                       UserRepository userRepository) {
        this.postRepo = postRepo;
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<Post>> getAllPost(Optional<Integer> userId) {
        if( userId.isPresent()) {
            return new SuccessDataResult<>(postRepo.findByUserId(userId.get()),"post geldi hanım");
        }
        return new SuccessDataResult<>(postRepo.findAll(),"tüm postlar geldi hanım");
    }

    @Override
    public Result save(PostRequest postRequest) {
        DataResult<Optional<User>> dataResult = userService.getOneUser(postRequest.getUserId());
        if(!dataResult.getData().isPresent()) {
            return new ErrorResult("böyle bir kullanıcı yok");
        } else {
            Post post = new Post(postRequest.getId(),postRequest.getTitle(),postRequest.getText(),dataResult.getData().get());
            postRepo.save(post);
            return new SuccessResult("başarılı");
        }
    }

    @Override
    public DataResult<Post> getOnePost(int postId) {
        return new SuccessDataResult<>(postRepo.findById(postId).orElse(null),"tek post geldi");
    }

    @Override
    public Result updatePost(int postId , PostUpdate postUpdate) {
        Optional<Post> post = postRepo.findById(postId);
        if(post.isPresent()) {
            Post newPost = post.get();
            newPost.setText(postUpdate.getText());
            newPost.setTitle(postUpdate.getTitle());
            postRepo.save(newPost);
            return new SuccessResult("başarılı");
        }else {
            return new ErrorResult("böyle bir post yok");
        }
    }
    @Override
    public Result deletePost(int postId) {
            postRepo.deleteById(postId);
            return new SuccessResult("başarılı silindi");
    }
}
