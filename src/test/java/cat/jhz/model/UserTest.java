package cat.jhz.model;


import cat.jhz.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cat.jhz.TestConfig;

import static org.junit.Assert.assertEquals;

@TestConfig
public class UserTest {
    @Autowired
    private UserController userRepo; // = new UserController();

    @Test
    void testAddUserToUserController() {
        User user = new User("1");
        this.userRepo.add(user);
        String u = userRepo.readAll().get(0).getId();
        assertEquals("1",u);
    }

    @Test
    void testAddCardToUser() {
        String idcard1 = "12", idcard2 = "101";
        User user = new User("1");
        this.userRepo.add(user);
        user.addCard(idcard1);
        user.addCard(idcard2);
        assertEquals(2, user.getCartes().size());
        assertEquals("1", user.getCartes().get(0).getNum());
        assertEquals("2", user.getCartes().get(0).getPal());
        assertEquals("10", user.getCartes().get(1).getNum());
        assertEquals("1", user.getCartes().get(1).getPal());
    }
}

