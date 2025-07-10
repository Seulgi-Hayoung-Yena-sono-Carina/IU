package springbootdeveloper.testapi;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class JUnitTest {
    @DisplayName("1+2=3")
    @Test
            public void test1() {
        int a=1;
        int b=2;
        int sum=3;


        assertThat(a+b).isEqualTo(sum); //Assertion 쓰고 assertThat 하는 습관 들이기

    }

}
