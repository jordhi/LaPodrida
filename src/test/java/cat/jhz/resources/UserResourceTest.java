package cat.jhz.resources;

import cat.jhz.model.Card;
import cat.jhz.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;
import cat.jhz.ApiTestConfig;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@ApiTestConfig
public class UserResourceTest {
    @Autowired
    private WebTestClient webTestClient;

    @Test
    void readAll() {
        User user = new User("10");
        this.webTestClient
                .post()
                .uri(UserResource.USER)
                .body(BodyInserters.fromValue(user))
                .exchange()
                .expectStatus().isOk();
        List<User> list =
                this.webTestClient
                .get().uri(UserResource.USER)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(User.class)
                .returnResult().getResponseBody();
        assertTrue(list.size() > 0);
        assertNotNull(list.get(0).getId());

    }

    @Test
    void putCardToUser() {
        User user = new User("9");
        Card card = new Card();
        card.setId("11");
        card.setNum("1");
        card.setPal("1");
        //add User with post
        this.webTestClient
                .post()
                .uri(UserResource.USER)
                .body(BodyInserters.fromValue(user))
                .exchange()
                .expectStatus().isOk();
        //put card to User
        this.webTestClient
                .put()
                .uri(UserResource.USER + "/9")
                .body(BodyInserters.fromValue(card))
                .exchange()
                .expectStatus().isOk();

        //read cards from user with get
        List<Card> cartes =
        this.webTestClient
                .get()
                .uri(UserResource.USER + "/9/cards")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Card.class)
                .returnResult()
                .getResponseBody();

        assertTrue(cartes.size() > 0);
        assertNotNull(cartes.get(0).getId());
        assertEquals("11",cartes.get(0).getId());
    }

    @Test
    void resetCardsFromUser() {
        User user = new User("10");
        Card card = new Card();
        card.setId("11");
        card.setNum("1");
        card.setPal("1");
        //add User with post
        this.webTestClient
                .post()
                .uri(UserResource.USER)
                .body(BodyInserters.fromValue(user))
                .exchange()
                .expectStatus().isOk();
        //put card to User
        this.webTestClient
                .put()
                .uri(UserResource.USER + "/10")
                .body(BodyInserters.fromValue(card))
                .exchange()
                .expectStatus().isOk();
        //delete cards from User
        this.webTestClient
                .delete()
                .uri(UserResource.USER + "/10/resetcards")
                .exchange()
                .expectStatus().isOk();

        List<Card> cartes =
                this.webTestClient
                        .get()
                        .uri(UserResource.USER + "/10/cards")
                        .exchange()
                        .expectStatus().isOk()
                        .expectBodyList(Card.class)
                        .returnResult()
                        .getResponseBody();
        assertTrue(cartes.size() == 0);
    }

    @Test
    public void putListCardsToUser() {
        User user = new User("20");
        List<Card> listcard = new ArrayList<>();
        listcard.add(new Card("21","2","1"));
        listcard.add(new Card("22","2","2"));
        listcard.add(new Card("23","2","3"));

        //add User with post
        this.webTestClient
                .post()
                .uri(UserResource.USER)
                .body(BodyInserters.fromValue(user))
                .exchange()
                .expectStatus().isOk();

        //add List cards to User
        this.webTestClient
                .put()
                .uri(UserResource.USER + "/20/cards")
                .body(BodyInserters.fromValue(listcard))
                .exchange()
                .expectStatus().isOk();

        List<Card> cartes =
                this.webTestClient
                        .get()
                        .uri(UserResource.USER + "/20/cards")
                        .exchange()
                        .expectStatus().isOk()
                        .expectBodyList(Card.class)
                        .returnResult()
                        .getResponseBody();

        assertTrue(cartes.size() == 3);
    }

}
