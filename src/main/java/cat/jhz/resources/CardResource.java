package cat.jhz.resources;

import cat.jhz.controllers.CardController;
import cat.jhz.model.Card;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping(CardResource.DECK)
public class CardResource {
    public static final String DECK = "/deck";
    public static final String CARD_DECK = "/deck/{id}";

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

    @GetMapping(value = "/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public @ResponseBody byte[] getCardImage(@PathVariable String id) throws IOException {
        System.out.println(getClass().getClassLoader().getResource("images/cards/" + id + ".png"));
        InputStream in = getClass().getClassLoader().getResourceAsStream("images/cards/" + id + ".png");
        return IOUtils.toByteArray(in);
    }
}
