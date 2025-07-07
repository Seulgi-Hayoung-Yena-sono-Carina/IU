package springbootdeveloper.testapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }

    @GetMapping
    public String test2(){
        return "Goodbye world";
    }
}
