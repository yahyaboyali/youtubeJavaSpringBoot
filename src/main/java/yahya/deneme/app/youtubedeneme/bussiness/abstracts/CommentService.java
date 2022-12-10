package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;

import java.util.List;
import java.util.Optional;

public interface CommentService {

    DataResult<List<Comment>> findAll(Optional<Integer> userId, Optional<Integer> postId);

    Result save(Comment comment);

    DataResult<Optional<Comment>> findById(int commentId);
}
