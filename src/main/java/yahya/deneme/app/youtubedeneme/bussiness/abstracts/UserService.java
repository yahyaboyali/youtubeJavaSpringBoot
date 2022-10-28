package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAll();

    void save(User user);

    Optional<User> getOneUser(int userId);

    void deleteOneUser(int userId);
}
