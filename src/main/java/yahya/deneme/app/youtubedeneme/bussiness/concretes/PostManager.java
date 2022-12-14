package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.UserService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.PostRequest;
import yahya.deneme.app.youtubedeneme.bussiness.requests.PostUpdate;
import yahya.deneme.app.youtubedeneme.bussiness.responses.PostResponses;
import yahya.deneme.app.youtubedeneme.core.utilities.results.*;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.PostRepo;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.UserRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public DataResult<List<PostResponses>> getAllPost(Optional<Integer> userId) {
        List<Post> list;
        if( userId.isPresent()) {
            list = postRepo.findByUserId(userId.get());
        } else {
            list = postRepo.findAll();
        }
        return new SuccessDataResult<>(list.stream().map(p -> new PostResponses(p)).collect(Collectors.toList()),"post came here");
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
    public DataResult<Optional<Post>> getOnePost(int postId) {
        if(postRepo.findById((postId)).isPresent()){
            return new SuccessDataResult<>(postRepo.findById(postId),"tek post geldi");
        } else{
            return new ErrorDataResult<>("böyle bir post yok");
        }
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
