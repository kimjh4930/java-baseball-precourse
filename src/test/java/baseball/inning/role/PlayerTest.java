package baseball.inning.role;

import baseball.inning.Hitter;
import baseball.inning.NumbersBall;
import baseball.inning.Rule;
import baseball.rule.ThreeNumbersRule;
import nextstep.test.NSTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest extends NSTest {

    @ParameterizedTest
    @DisplayName("플레이어는 규칙에 맞는 숫자공을 만들 수 있다.")
    @CsvSource(value = {"1111123,001,111123,12,1,123:123"}, delimiter = ':')
    void hitting (String inputs, String result){
        //given
        List<Integer> resultList = new ArrayList<>();
        for(char resultChar : result.toCharArray()){
            resultList.add(resultChar - '0');
        }

        NumbersBall expected = new NumbersBall(resultList);

        //when
        run(inputs.split(","));

        //then
        assertThat(TestConfig.player().hitting()).isEqualTo(expected);
    }

    @Override
    public void runMain() { }

    static class TestConfig {
        static Hitter player (){
            return new Player(rule());
        }

        static Rule rule (){
            return new ThreeNumbersRule();
        }
    }
}