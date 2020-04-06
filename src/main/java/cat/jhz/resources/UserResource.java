package cat.jhz.resources;

import cat.jhz.controllers.UserController;
import cat.jhz.model.Card;
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

    @GetMapping("/{id}/cards")
    public List<Card> getUserCards(@PathVariable String id) {
        List<User> userList;
        userList = userController.readAll()
            .stream()
            .filter(u -> u.getId().equals((id)))
            .collect(Collectors.toList());
        if(userList.size() != 1) throw new IllegalStateException();
        return userList.get(0).getCartes();

    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userController.add(user);
    }
}
