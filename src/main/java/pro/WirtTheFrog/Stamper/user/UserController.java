package pro.WirtTheFrog.Stamper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> users(){
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id){
        return userRepository.findById(id).get();
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return userRepository.save(user);
    }

    @PostMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user){
        User existingUser = userRepository.findById(id).get();
        existingUser.setUsername(user.getUsername());
        existingUser.setPassword(user.getPassword());
        return userRepository.save(existingUser);

    }

    @DeleteMapping("/id")
    public String deleteUser(@PathVariable Long id){
        try {
            userRepository.deleteById(id);
            return "User successfully deleted";
        } catch (Exception e) {
            return "User not found";
        }
    }
}
