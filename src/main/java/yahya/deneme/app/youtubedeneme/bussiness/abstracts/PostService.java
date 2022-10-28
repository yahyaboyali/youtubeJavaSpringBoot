package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;

public interface PostService {
    List<Post> findAll();

    void save(Post post);
}
