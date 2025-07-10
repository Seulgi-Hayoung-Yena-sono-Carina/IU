package springbootdeveloper.testapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springbootdeveloper.testapi.service.TestService;
import springbootdeveloper.testapi.domain.Member;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TestController {

    private final TestService testservice;

    @GetMapping("/test")
    public List<Member> getAllMembers(){
        return testservice.getAllMembers();
    }
}
