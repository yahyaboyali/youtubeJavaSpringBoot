package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;

public interface LikeService {
    DataResult<List<Like>> getAll();

    Result save(Like like);
}
