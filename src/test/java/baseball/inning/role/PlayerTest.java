package baseball.inning.role;

import baseball.exception.InvalidInputException;
import baseball.inning.Hitter;
import baseball.inning.NumbersBall;
import baseball.inning.Rule;
import baseball.rule.ThreeNumbersRule;
import nextstep.test.NSTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PlayerTest extends NSTest {

	@ParameterizedTest
	@DisplayName("플레이어는 규칙에 맞는 숫자공을 만들 수 있다.")
	@ValueSource(strings = {"1111123", "001", "111123", "12", "1"})
	void hitting_error(String input) {
		assertThatExceptionOfType(InvalidInputException.class)
			.isThrownBy(() -> TestConfig.player().hitting(input));
	}

	@ParameterizedTest
	@DisplayName("플레이어는 규칙에 맞는 숫자공을 만들 수 있다.")
	@CsvSource(value = "123:123", delimiter = ':')
	void hitting(String input, String result) {
		//given
		List<Integer> numbers = new ArrayList<>();
		for (char number : result.toCharArray()) {
			numbers.add(number - '0');
		}

		//then
		assertThat(TestConfig.player().hitting(input)).isEqualTo(new NumbersBall(numbers));
	}

	@Override
	public void runMain() {
	}

	static class TestConfig {
		static Hitter player() {
			return new Player(rule());
		}

		static Rule rule() {
			return new ThreeNumbersRule();
		}
	}
}