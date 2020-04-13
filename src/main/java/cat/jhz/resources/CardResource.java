package cat.jhz.resources;

import cat.jhz.controllers.CardController;
import cat.jhz.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(CardResource.DECK)
public class CardResource {
    public static final String DECK = "/deck";

    private CardController cardController;

    @Autowired
    public CardResource(CardController cardController) {
        this.cardController = cardController;
    }

    @GetMapping
    public List<Card> readAll() {
        return cardController.getDeck().getDeck();
    }

    @DeleteMapping("/{id}")
    public void deleteCardFromDeck(@PathVariable String id) {
        cardController.deleteCard(id);
    }
}
