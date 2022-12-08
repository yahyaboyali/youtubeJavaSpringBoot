package yahya.deneme.app.youtubedeneme.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {
    List<Post> findByUserId(int userId);
}
