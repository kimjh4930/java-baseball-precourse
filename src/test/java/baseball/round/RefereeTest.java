package baseball.round;

import baseball.rule.ThreeNumbersRule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RefereeTest {
    private PrintStream standardOut;
    private OutputStream captor;

    private Referee referee;

    @BeforeEach
    protected void setUp (){
        standardOut = System.out;
        captor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(captor));

        referee = RefereeConfig.referee();
    }

    @DisplayName("결과를 판정한다.")
    @ParameterizedTest
    @CsvSource(value = {
                "123:124:2스트라이크:false",
                "135:246:낫싱:false",
                "123:312:3볼:false",
                "456:456:3스트라이크:true",
                "123:321:1스트라이크 2볼:false"},
                delimiter = ':')
    void judge (String pitcher, String hitter, String result, boolean gameSet){
        //given
        NumbersBall pitchers = new NumbersBall(stringAsList(pitcher));
        NumbersBall hitters = new NumbersBall(stringAsList(hitter));

        //when
        referee.getPitchersBall(pitchers);

        //then
        assertThat(referee.judge(hitters)).isEqualTo(gameSet);
        verity(result);
    }

    @AfterEach
    void tearDown (){
        System.setOut(standardOut);
        System.out.println(output());
    }

    private List<Integer> stringAsList (String input){
        List<Integer> numbers = new ArrayList<>();

        for(char number : input.toCharArray()){
            numbers.add(number - '0');
        }

        return numbers;
    }

    private void verity (final String... args){
        assertThat(output()).contains(args);
    }

    private String output(){
        return captor.toString().trim();
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