package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.CommentService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.UserService;
import yahya.deneme.app.youtubedeneme.bussiness.requests.CommentRequest;
import yahya.deneme.app.youtubedeneme.bussiness.requests.CommentUpdateResponse;
import yahya.deneme.app.youtubedeneme.core.utilities.results.*;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.CommentRepository;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.UserRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManager implements CommentService {
    private CommentRepository commentRepository;
    private UserService userService;
    private PostService postService;
    private final UserRepository userRepository;

    public CommentManager(CommentRepository commentRepository, UserService userService, PostService postService,
                          UserRepository userRepository) {
        this.commentRepository = commentRepository;
        this.userService = userService;
        this.postService = postService;
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<Comment>> findAll(Optional<Integer> userId, Optional<Integer> postId) {
        if(userId.isPresent() && postId.isPresent()) {
            return new SuccessDataResult<>(commentRepository.findByUserIdAndPostId(userId.get(),postId.get()),"comment ve user ile geldi");
        } else if (userId.isPresent()) {
            return new SuccessDataResult<>(commentRepository.findByUserId(userId.get()),"user ile geldi");
        } else if (postId.isPresent()) {
            return new SuccessDataResult<>(commentRepository.findByPostId(postId.get()), "post ile geldi");
        } else {
            return new SuccessDataResult<>(commentRepository.findAll(),"alayı geldi");
        }
    }

    @Override
    public Result createComment(CommentRequest commentRequest) {
        Optional<User> user = userService.getOneUser(commentRequest.getUserId()).getData();
        Optional<Post> post = postService.getOnePost(commentRequest.getPostId()).getData();
        if(post.isPresent() && user.isPresent()) {
            Comment comment = new Comment(commentRequest.getId(),user.get(),post.get(),commentRequest.getText());
            commentRepository.save(comment);
            return new SuccessResult("comment eklendi");
        }else {
            return new ErrorResult("comment ekelenemedi böyle bir post olmayabilir veya böyle bir user olmayabilir");
        }
    }

    @Override
    public DataResult<Optional<Comment>> findById(int commentId) {
        if(commentRepository.findById(commentId).isPresent()){
            return new SuccessDataResult<>(commentRepository.findById(commentId),"başarılı");
        } else {
            return new ErrorDataResult<>("böyle bir şey yok");
        }
    }

    @Override
    public Result updateComment(int commentId, CommentUpdateResponse commentUpdateResponse) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()) {
            Comment newComment = comment.get();
            newComment.setText(commentUpdateResponse.getText());
            commentRepository.save(newComment);
            return new SuccessResult("edited commit success");
        } else {
            return new ErrorResult("böyle bir commit yok aga");
        }
    }

    @Override
    public Result deleteComment(int commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        if(comment.isPresent()) {
            commentRepository.deleteById(commentId);
            return new SuccessResult("başarılı bir şekilde silindi");
        } else {
            return new ErrorResult("böyle bir comment yok olmayanı silemezsin");
        }
    }
}
