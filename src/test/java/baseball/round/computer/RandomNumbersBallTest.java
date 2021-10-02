package baseball.round.computer;

import baseball.round.Rule;
import baseball.rule.ThreeNumbersRule;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class RandomNumbersBallTest {
    private RandomNumbersBall randomNumbersBall;

    @BeforeEach
    void setUp (){
        randomNumbersBall = TestConfig.getRandomNumbersBall();
    }

    @DisplayName("랜덤숫자공을 생성한다.")
    @Test
    void makeNumbersBall (){
        //given
        int expectedLength = 3;

        //when, then
        try(final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)){
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(1,1,2,3);

            Set<Integer> numbersBall = randomNumbersBall.make();

            assertThat(numbersBall.size()).isEqualTo(expectedLength);
        }
    }

    static class TestConfig {
        public static RandomNumbersBall getRandomNumbersBall(){
            return new RandomNumbersBall(getThreeNumbersRule().getDigit());
        }

        public static Rule getThreeNumbersRule (){
            return new ThreeNumbersRule();
        }
    }

}