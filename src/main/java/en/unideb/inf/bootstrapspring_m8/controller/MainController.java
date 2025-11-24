package en.unideb.inf.bootstrapspring_m8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("")
    public String showHomepage(){
        return "index";
    }

    @GetMapping("/persons")
    public String getAllPersons(){
        return "persons";
    }
}
