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
    public User getUser(@PathVariable String id) {
        return userController.findUser(id);
    }

    @GetMapping("/{id}/cards")
    public List<Card> getUserCards(@PathVariable String id) {
        User u = userController.findUser(id);
        return u.getCartes();
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userController.add(user);
    }

    //Add card to user with a String pathVariable
    /*@PutMapping("{id}/cards/{idcard}")
    public void addCardToUser(@PathVariable String id, @PathVariable String idcard) {
        userController.findUser(id).addCard(idcard);
    }*/

    @PutMapping("{id}/cards/")
    public void addCardToUser(@PathVariable String id, @RequestBody Card card) {
        userController.findUser(id).addCard(card);
    }
}
