package springbootdeveloper.testapi.domain;

import lombok.*;
import jakarta.persistence.Column; // jakarta.persistence로 변경
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@NoArgsConstructor (access= AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Entity
public class Member {
   @Id
   @GeneratedValue(strategy=GenerationType.IDENTITY)
   @Column(name="id",updatable=false)
   private Long id;

   @Column(name="name",nullable=false)
   private String name;
}
