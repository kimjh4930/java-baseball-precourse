package baseball.inning.role;

import baseball.inning.NumbersBall;
import baseball.inning.Pitcher;
import baseball.inning.Rule;
import baseball.rule.ThreeNumbersRule;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class ComputerTest {
    private Pitcher computer;

    @BeforeEach
    void setUp (){
        computer = TestConfig.computer();
    }

    @DisplayName("Computer는 임의의 숫자로 구성된 숫자공을 생성한다.")
    @Test
    void pitchingTest (){
        //given
        NumbersBall expectedBall = new NumbersBall(Arrays.asList(3, 2, 1));

        //when, then
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)){
            mockRandoms
                    .when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(3, 3, 2, 1);

            NumbersBall actualBall = computer.pitching();

            assertThat(actualBall).isEqualTo(expectedBall);
        }
    }

    static class TestConfig {
        static Pitcher computer (){
            return new Computer(rule());
        }

        static Rule rule (){
            return new ThreeNumbersRule();
        }
    }

}