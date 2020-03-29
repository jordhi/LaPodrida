package model;


import controllers.UserController;
import org.junit.jupiter.api.Test;
import testConfig.TestConfig;

import static org.junit.Assert.assertEquals;

@TestConfig
public class UserTest {

    private UserController userRepo;

    public UserTest(UserController userRepo) {
        this.userRepo = userRepo;
    }

    @Test
    void testCreate() {
        User user = new User("1");
        this.userRepo.add(user);
        String u = userRepo.readAll().stream().filter(p -> p.equals(user.getId())).toString();
        assertEquals("1",u);
    }

}
