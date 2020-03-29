package controllers;

import model.User;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    //TODO Defnir corectament on s'emmagatzemen els usuaris del joc. Si aquesta classe ho controla o bé és necessaria una classe repositori
    //private final UserRepository userRepo;
    private List<User> userRepo = new ArrayList<>();

    public UserController() {
        //this.userRepo = userRepo;
    }

    public List<User> readAll() {
        //List<User> u = new ArrayList<>();
        //u.add(new User("1"));
        return userRepo;
    }

    public void add(User user) {
        userRepo.add(user);
    }
}
