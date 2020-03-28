package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    //TODO Canviar User per UserDAO???? Llista d'usuaris
    private User user;

    @Autowired
    public UserController(User user) {
        this.user = user;
    }

    public List<User> readAll() {
        List<User> u = new ArrayList<>();
        u.add(new User());
        return u;
    }
}
