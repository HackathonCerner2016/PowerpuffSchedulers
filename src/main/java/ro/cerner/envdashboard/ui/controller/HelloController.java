package ro.cerner.envdashboard.ui.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
    
    @RequestMapping("/index.html")
    public String index() {
        return "Greetings from Spring Boot!";
    }
    
}
