package cat.jhz.consumers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(RoomController.ROOM)
public class RoomController {
    public static final String ROOM = "/";

    /*@GetMapping
    public String index() {
        return "index";
    }*/
}
