package springbootdeveloper.testapi.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootdeveloper.testapi.domain.Member;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
 Optional<Member> findByName(String name);
}
