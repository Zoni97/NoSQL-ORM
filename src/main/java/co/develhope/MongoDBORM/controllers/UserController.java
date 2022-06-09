package co.develhope.MongoDBORM.controllers;

import co.develhope.MongoDBORM.entities.User;
import co.develhope.MongoDBORM.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User createUser(@RequestBody User user) {
        user.setId(null);
        return userRepository.save(user);
    }

    @GetMapping("")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody  User user){
        user.setId(id);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userRepository.deleteById(id);
    }
}
