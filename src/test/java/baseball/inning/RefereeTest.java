package baseball.inning;

import baseball.rule.ThreeNumbersRule;
import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RefereeTest extends NSTest {
    private Referee referee;

    @BeforeEach
    void beforeEach (){
        super.setUp();
        referee = RefereeConfig.referee();
    }

    @DisplayName("결과를 판정한다.")
    @ParameterizedTest
    @CsvSource(value = {
                "123:124:2:0:false",
                "135:246:0:0:false",
                "123:312:0:3:false",
                "456:456:3:0:true",
                "123:321:1:2:false"
                },
                delimiter = ':')
    void judge (String pitcher, String hitter, int strike, int ball, boolean gameSet){
        //given
        NumbersBall pitchers = new NumbersBall(stringAsList(pitcher));
        NumbersBall hitters = new NumbersBall(stringAsList(hitter));
        ResultBoard expectedBoard = new ResultBoard(strike, ball, gameSet);

        //when
        referee.getPitchersBall(pitchers);
        ResultBoard board = referee.judge(hitters);

        //then
        assertThat(board).isEqualTo(expectedBoard);
    }

    @Override
    public void runMain() {
    }

    @AfterEach
    void tearDown (){
        outputStandard();
    }

    private List<Integer> stringAsList (String input){
        List<Integer> numbers = new ArrayList<>();

        for(char number : input.toCharArray()){
            numbers.add(number - '0');
        }

        return numbers;
    }

    static class RefereeConfig {
        static Referee referee (){
            return new Referee(rule());
        }

        static Rule rule (){
            return new ThreeNumbersRule();
        }
    }

}