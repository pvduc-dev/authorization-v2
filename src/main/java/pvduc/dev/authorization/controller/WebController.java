package pvduc.dev.authorization.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/sign-in")
    public String signIn() {
        return "sign-in";
    }
}
