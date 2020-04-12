package cat.jhz.resources;

import cat.jhz.controllers.CardController;
import cat.jhz.model.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
