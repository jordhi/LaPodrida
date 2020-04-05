package cat.jhz.consumers;

import cat.jhz.controllers.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RoomController.ROOM)
public class RoomController {
    public static final String ROOM = "/";

    UserController userController;
    @Autowired
    public RoomController(UserController userController) {
        this.userController = userController;
    }

    @Value("${spring.application.name}")
    String appName;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("users",userController.readAll() );
        return "index";
    }
}
