package springbootdeveloper.testapi.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springbootdeveloper.testapi.repository.MemberRepository;
import springbootdeveloper.testapi.domain.Member;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private MemberRepository memberRepository;

    public List<Member> getAllMembers(){

        return memberRepository.findAll();
    }
}
