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

}

