package cat.jhz.resources;

import cat.jhz.controllers.CardController;
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

    private CardController cardController;

    @Autowired
    public UserResource(UserController userController, CardController cardController) {
        this.userController = userController;
        this.cardController = cardController;
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

    @PutMapping("{id}")
    public void addCardToUser(@PathVariable String id, @RequestBody Card card) {
        userController.findUser(id).addCard(card);
        //It's not necessary delete card from deck because avery round start with full deack
        //cardController.deleteCard(card.getId());
    }


    @PutMapping("{id}/cards")
    public void addCardListToUser(@PathVariable String id, @RequestBody List<Card> cardsList) {
        userController.findUser(id).clearListCards();
        userController.findUser(id).addListCards(cardsList);
    }

    @DeleteMapping("{id}/resetcards")
    public void deleteCardsFromUser(@PathVariable String id) {
        userController.findUser(id).getCartes().clear();
    }
}
