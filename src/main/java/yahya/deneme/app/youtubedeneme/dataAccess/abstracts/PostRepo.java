package yahya.deneme.app.youtubedeneme.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Post;

public interface PostRepo extends JpaRepository<Post, Integer> {
}
