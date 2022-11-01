package yahya.deneme.app.youtubedeneme.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.UserService;
import yahya.deneme.app.youtubedeneme.core.utilities.results.DataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.Result;
import yahya.deneme.app.youtubedeneme.core.utilities.results.SuccessDataResult;
import yahya.deneme.app.youtubedeneme.core.utilities.results.SuccessResult;
import yahya.deneme.app.youtubedeneme.dataAccess.abstracts.UserRepository;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserManager implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public DataResult<List<User>> getAll() {
        return new SuccessDataResult<List<User>>(this.userRepository.findAll(),"data geldi");
    }

    @Override
    public Result save(User user) {
        userRepository.save(user);
        return new SuccessResult("kaydedildi");
    }

    @Override
    public DataResult<Optional<User>> getOneUser(int userId) {
        return new SuccessDataResult<>(userRepository.findById(userId),"ssss");
    }

    @Override
    public Result deleteOneUser(int userId) {
        userRepository.deleteById(userId);
        return new SuccessResult("silindi");
    }
}
