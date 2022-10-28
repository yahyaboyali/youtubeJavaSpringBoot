package yahya.deneme.app.youtubedeneme.bussiness.abstracts;

import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    DataResult<List<User>> getAll();

    Result save(User user);

    DataResult<Optional<User>> getOneUser(int userId);

    Result deleteOneUser(int userId);
}
