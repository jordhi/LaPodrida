package cat.jhz.controllers;

import cat.jhz.model.Deck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CardController {


    private Deck deck;

    @Autowired
    public CardController(Deck deck) {
        this.deck = deck;
        deck.createDeck();
    }

    public Deck getDeck() {
        return deck;
    }

    public void deleteCard(String id) {
        deck.deleteCard(id);
    }
}
