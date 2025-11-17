package en.unideb.inf.bootstrapspring_m8.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("")
    public String showHomepage(){
        return "index";
    }
}
