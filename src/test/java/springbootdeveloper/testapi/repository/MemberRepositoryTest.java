package springbootdeveloper.testapi.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import springbootdeveloper.testapi.domain.Member;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @Sql("/insert-members.sql")
    @Test
    void getAllMembers(){
        List<Member> members=memberRepository.findAll();

        assertThat(members.size()).isEqualTo(3);
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberById(){
        Member member=memberRepository.findById(2L).get();

        assertThat(member.getName()).isEqualTo("B");
    }

    @Sql("/insert-members.sql")
    @Test
    void getMemberByName(){
        Member member=memberRepository.findByName("C").get();

        assertThat(member.getId()).isEqualTo(3);
    }

    @Test
    void saveMember(){
        Member member= new Member(1L,"A");

        memberRepository.save(member);

        assertThat(memberRepository.findById(1L).get().getName()).isEqualTo("A");

    }

    @Test
    void saveMembers(){
        List<Member> members=List.of(new Member(null,"B"),new Member(null,"C"));

        memberRepository.saveAll(members);

        assertThat(memberRepository.findAll().size()).isEqualTo(2);
    }
}