package yahya.deneme.app.youtubedeneme.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Like;

import java.util.List;
import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like, Integer> {
    List<Like> findByUserIdAndPostId(Optional<Integer> userId, Optional<Integer> postId);

    List<Like> findByPostId(Optional<Integer> postId);

    List<Like> findByUserId(Optional<Integer> userId);
}
