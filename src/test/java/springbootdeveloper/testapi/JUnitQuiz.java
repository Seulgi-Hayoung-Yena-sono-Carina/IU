package springbootdeveloper.testapi;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JUnitQuiz {
    @BeforeEach
    public void beforeEach(){
        System.out.println("Hello");
    }

    @DisplayName("가")
    @Test
    public void testQuiz1() {
        String name1="이동형";
        String name2="이동형";
        String name3="이동순";

        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();
        assertThat(name1).isEqualTo(name2);
        assertThat(name1).isNotEqualTo(name3);
    }

    @Test
    public void testQuiz2(){
        int number1=15;
        int number2=0;
        int number3=-3;

        assertThat(number1).isPositive();
        assertThat(number2).isZero();
        assertThat(number3).isNegative();
        assertThat(number1).isGreaterThan(number2);
        assertThat(number3).isLessThan(number2);

    }

    @AfterAll
    public static void afterAll(){
        System.out.println("Bye");
    }

    }
