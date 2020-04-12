package cat.jhz.model;

import java.util.ArrayList;
import java.util.List;

public class Deck {
    private List<Card> deck = new ArrayList<>();
    private String name;

    public Deck() {}

    public List<Card> getDeck() {
        return deck;
    }

    public List<Card> createDeck() {
        for(int i=1; i<=48; i++) {
            String is = String.valueOf((i%12)+1);
            String pal = String.valueOf((i%4)+1);
            deck.add(new Card(is + pal, is, pal));
        }
        return deck;
    }
}
