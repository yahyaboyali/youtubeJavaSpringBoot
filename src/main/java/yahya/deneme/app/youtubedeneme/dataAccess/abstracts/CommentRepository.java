package yahya.deneme.app.youtubedeneme.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.Comment;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    List<Comment> findByUserIdAndPostId(int userId, int postId);

    List<Comment> findByUserId(int userId);

    List<Comment> findByPostId(int postId);
}
