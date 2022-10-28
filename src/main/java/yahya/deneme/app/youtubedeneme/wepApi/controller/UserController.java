package yahya.deneme.app.youtubedeneme.wepApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import yahya.deneme.app.youtubedeneme.bussiness.abstracts.UserService;
import yahya.deneme.app.youtubedeneme.entities.concretes.User;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/users")
@CrossOrigin
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public List<User> getAll(){
        return userService.getAll();
    }
    @PostMapping("/addUser")
    public void save(@RequestBody User user){
        userService.save(user);
    }

    @GetMapping("getOneUser/{userId}")
    public Optional<User> getOneUser(@PathVariable("userId") int userId) {
        return userService.getOneUser(userId);
    }
    @PutMapping("updateuser/{userId}")
    public  User updateOneUser(@PathVariable int userId, @RequestBody User newUser) {
        Optional<User> user = userService.getOneUser(userId);
        if(user.isPresent()) {
            User foundUser = user.get();
            foundUser.setUserName(newUser.getUserName());
            foundUser.setPassword(newUser.getPassword());
            userService.save(foundUser);
            return foundUser;
        }else {
            return null;
        }
    }
    @DeleteMapping("deleteUser/{userId}")
    public void deleteOneUser(@PathVariable int userId) {
        userService.deleteOneUser(userId);
    }
}
