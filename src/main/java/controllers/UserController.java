package controllers;

import model.User;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    //private final UserRepository userRepo;
    private List<User> userRepo = new ArrayList<>();

    public UserController() {
    }

    public List<User> readAll() {
        return userRepo;
    }

    public void add(User user) {
        userRepo.add(user);
    }
}
