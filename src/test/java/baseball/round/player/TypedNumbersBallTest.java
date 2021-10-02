package baseball.round.player;

import baseball.round.Rule;
import baseball.rule.ThreeNumbersRule;
import nextstep.test.NSTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.LinkedHashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TypedNumbersBallTest extends NSTest{

    @ParameterizedTest
    @DisplayName("값을 제대로 입력할 때까지 입력받는다.")
    @CsvSource(value = {"1111123,001,111123,12,1,123:123"}, delimiter = ':')
    void 값을_제대로_입력해야_테스트_종료 (String inputs, String result){
        //given
        Set<Integer> expected = new LinkedHashSet<>();
        for(char number : result.toCharArray()){
            expected.add(number - '0');
        }

        //when
        run(inputs.split(","));

        //then
        assertThat(TestConfig.numbersBall().make()).isEqualTo(expected);
    }

    @Override
    public void runMain() { }

    static class TestConfig {
        static TypedNumbersBall numbersBall() {
            return new TypedNumbersBall(rule());
        }

        static Rule rule (){
            return new ThreeNumbersRule();
        }
    }

}