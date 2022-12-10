package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.bussiness.requests.LikeRequest;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface LikeService {
    DataResult<List<Like>> getAll(Optional<Integer> userId, Optional<Integer> postId);

    Result save(LikeRequest likeRequest);

    DataResult<Optional<Like>> getOneLike(int likeId);

    Result deleteLike(int likeId);
}
