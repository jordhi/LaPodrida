package cat.jhz.resources;

import cat.jhz.controllers.UserController;
import cat.jhz.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(UserResource.USER)
public class UserResource {
    public static final String USER = "/users";

    private UserController userController;

    @Autowired
    public UserResource(UserController userController) {
        this.userController = userController;
    }

    @GetMapping
    public List<User> readAll() {
        return userController.readAll();
    }

    @GetMapping("/{id}")
    public List<User> getUser(@PathVariable String id) {
        return
                userController.readAll()
                        .stream()
                        .filter(u -> u.getId().equals(id))
                        .collect(Collectors.toList());
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userController.add(user);
    }
}
