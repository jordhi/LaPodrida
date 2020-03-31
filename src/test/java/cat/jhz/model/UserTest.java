package cat.jhz.model;


import cat.jhz.controllers.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import cat.jhz.resources.UserResource;
import org.springframework.context.annotation.ComponentScan;
import testConfig.TestConfig;

import static org.junit.Assert.assertEquals;

@TestConfig
public class UserTest {
   // @Autowired
   /* public UserController userController;

    public UserTest(UserController userController) {
        this.userRepo = userController;
    }
    */
    //TODO No em funciona Autowired al test

    private UserController userRepo = new UserController();


    @Test
    void testCreate() {
        User user = new User("1");
        this.userRepo.add(user);
        String u = userRepo.readAll().get(0).getId();
        assertEquals("1",u);
    }

}
