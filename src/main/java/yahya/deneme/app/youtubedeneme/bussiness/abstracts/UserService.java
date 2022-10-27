package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    void save(User user);
}
