package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.PostService;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.PostRepo;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;

@Service
public class PostManager implements PostService {

    private PostRepo postRepo;

    public PostManager(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAll();
    }

    @Override
    public void save(Post post) {
         postRepo.save(post);
    }
}
