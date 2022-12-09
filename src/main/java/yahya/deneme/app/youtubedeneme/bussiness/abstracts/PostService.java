package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.bussiness.requests.PostRequest;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface PostService {
    DataResult<List<Post>> getAllPost(Optional<Integer> userId);

    Result save(PostRequest postRequest);

    DataResult<Post> getOnePost(int postId);
    Result updatePost(int postId);

    Result deletePost(int postId);
}
