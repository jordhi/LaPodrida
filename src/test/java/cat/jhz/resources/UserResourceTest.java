package cat.jhz.resources;

import cat.jhz.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.web.reactive.server.WebTestClient;
import testConfig.ApiTestConfig;
import org.springframework.web.reactive.function.BodyInserters;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
                .body(BodyInserters.fromObject(user))
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

}
