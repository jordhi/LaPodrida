package model;


import controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import resources.UserResource;
import testConfig.TestConfig;

import static org.junit.Assert.assertEquals;

@TestConfig
public class UserTest {
    @Autowired
    private UserResource userResource;

    //TODO No em funciona Autowired al test
    private UserController userRepo = new UserController();
    /*public UserTest(UserController userRepo) {
        this.userRepo = userRepo;
    }*/

    @Test
    void testCreate() {
        User user = new User("1");
        this.userRepo.add(user);
        String u = userRepo.readAll().get(0).getId();
        assertEquals("1",u);
    }

}
