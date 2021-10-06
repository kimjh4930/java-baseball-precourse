package baseball.inning;

import baseball.exception.InvalidInputException;
import baseball.inning.role.Computer;
import baseball.inning.role.Player;
import baseball.rule.ThreeNumbersRule;
import baseball.ui.Inning;
import nextstep.test.NSTest;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class NumberBaseballInningTest extends NSTest {
	private Inning inning;

	@BeforeEach
	void beforeEach() {
		this.setUp();
	}

	@Override
	protected void setUp() {
		super.setUp();
		inning = RoundTestConfig.inning();
	}

	@DisplayName("라운드 정상종료")
	@Test
	void 라운드_정상종료() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5, 8, 9);
			run("597", "589");

			List<ResultBoard> expectedResults = new ArrayList<>();
			expectedResults.add(new ResultBoard(1, 1, false));
			expectedResults.add(new ResultBoard(3, 0, true));

			assertThat(inning.judge(stringToNumbersBall("597"))).isIn(expectedResults);
			assertThat(inning.judge(stringToNumbersBall("589"))).isIn(expectedResults);
		}
	}

	@DisplayName("에러발생")
	@Test
	void 에러발생() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(5, 8, 9);

			assertThatExceptionOfType(InvalidInputException.class)
				.isThrownBy(() -> run("12"));
		}
	}

	private NumbersBall stringToNumbersBall(String input) {
		List<Integer> numbers = new ArrayList<>();
		for (char number : input.toCharArray()) {
			numbers.add(number - '0');
		}

		return new NumbersBall(numbers);
	}

	@Override
	public void runMain() {
		inning.pitching();
		inning.hitting(Console.readLine());
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	static class RoundTestConfig {
		static Inning inning() {
			return new NumberBaseballInning(referee(), pitcher(), hitter());
		}

		static Referee referee() {
			return new Referee(rule());
		}

		static Pitcher pitcher() {
			return new Computer(rule());
		}

		static Hitter hitter() {
			return new Player(rule());
		}

		static Rule rule() {
			return new ThreeNumbersRule();
		}
	}

}