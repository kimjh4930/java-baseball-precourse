package baseball.rule;

import baseball.round.Rule;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
}