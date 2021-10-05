package baseball.rule;

import baseball.inning.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ThreeNumbersRuleTest {
    private Rule rule;

    @BeforeEach
    void setUp (){
        rule = new ThreeNumbersRule();
    }

    @DisplayName("digit이 3인지 확인한다.")
    @Test
    void digit (){
        assertThat(rule.getDigit()).isEqualTo(3);
    }

    @DisplayName("규칙에 따라 생성했는지 확인한다.")
    @ParameterizedTest
    @CsvSource(
        value = {
            "123:true",
            "012:false",
            "113:false",
            "980:false",
            "000:false",
            "111:false"
        },
        delimiter = ':'
    )
    void checkNumberBall (String ball, boolean result){
        assertThat(rule.validateOf(ball)).isEqualTo(result);
    }

    @DisplayName("규칙에 따라 strike 를 판정한다.")
    @ParameterizedTest
    @CsvSource(value = {"123:124:2", "135:246:0", "123:312:0", "456:456:3"}, delimiter = ':')
    void strike (String pitcher, String hitter, int strikeCount){
        //given
        List<Integer> pitchers = stringAsList(pitcher);
        List<Integer> hitters = stringAsList(hitter);

        //when
        int strike = rule.strike(pitchers, hitters);

        //then
        assertThat(strike).isEqualTo(strikeCount);
    }

    @DisplayName("규칙에 따라 ball 를 판정한다.")
    @ParameterizedTest
    @CsvSource(value = {"123:124:0", "135:246:0", "123:312:3", "456:456:0"}, delimiter = ':')
    void ball (String pitcher, String hitter, int strikeCount){
        //given
        List<Integer> pitchers = stringAsList(pitcher);
        List<Integer> hitters = stringAsList(hitter);

        //when
        int strike = rule.ball(pitchers, hitters);

        //then
        assertThat(strike).isEqualTo(strikeCount);
    }

    private List<Integer> stringAsList (String input){
        List<Integer> numbers = new ArrayList<>();
        for(char number : input.toCharArray()){
            numbers.add(number - '0');
        }
        return numbers;
    }
}