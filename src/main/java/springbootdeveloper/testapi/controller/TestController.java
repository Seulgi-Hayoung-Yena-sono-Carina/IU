package springbootdeveloper.testapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdeveloper.testapi.service.TestService;
import springbootdeveloper.testapi.domain.Member;

import java.util.List;

@RestController
public class TestController {

    private final TestService testservice;

    public TestController(TestService testService){
        this.testservice=testService;
    }

    @GetMapping("/test")
    public List<Member> getAllMembers(){
        List<Member> members=testservice.getAllMembers();
        return members;
    }
}
