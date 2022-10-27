package yahya.deneme.app.youtubedeneme.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {

}
