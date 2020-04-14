package cat.jhz.controllers;

import cat.jhz.model.User;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public User findUser(String id) {
        List<User> users = userRepo.stream()
                .filter(u -> u.getId().equals(id))
                .collect(Collectors.toList());
        if(users.size() != 1) throw new IllegalStateException();
        return users.get(0);
    }
}
