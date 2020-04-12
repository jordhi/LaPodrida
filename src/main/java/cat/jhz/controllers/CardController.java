package cat.jhz.controllers;

import cat.jhz.model.Deck;
import org.springframework.stereotype.Controller;

@Controller
public class CardController {
    private Deck deck = new Deck();

    public CardController() {
        deck.createDeck();
    }

    public Deck getDeck() {
        return deck;
    }
}
