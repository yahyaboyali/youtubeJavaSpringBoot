package yahya.deneme.app.youtubedeneme.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;

public interface LikeRepo extends JpaRepository<Like, Integer> {
}
