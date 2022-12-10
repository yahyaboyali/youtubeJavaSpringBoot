package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.CommentService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.*;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.CommentRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class CommentManager implements CommentService {
    private CommentRepository commentRepository;

    public CommentManager(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
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
    public Result save(Comment comment) {
        commentRepository.save(comment);
        return new SuccessResult("post eklendi");
    }

    @Override
    public DataResult<Optional<Comment>> findById(int commentId) {
        if(commentRepository.findById(commentId).isPresent()){
            return new SuccessDataResult<>(commentRepository.findById(commentId),"başarılı");
        } else {
            return new ErrorDataResult<>("böyle bir şey yok");
        }
    }
}
