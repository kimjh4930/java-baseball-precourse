package baseball.ui;

import baseball.inning.NumbersBall;
import baseball.inning.ResultBoard;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class BaseballScreenTest extends NSTest {
	private BaseballScreen screen;

	@BeforeEach
	void beforeEach() {
		super.setUp();

		screen = new BaseballScreen(new MockInning());
	}

	@DisplayName("게임 새로 시작 - 잘못된 값 입력")
	@Test
	void error() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 2, 3);

			running("123", "3", "4");
			verify("ERROR");
		}
	}

	@Override
	public void runMain() {
		screen.play();
	}

	@AfterEach
	void teardown() {
		outputStandard();
	}

	class MockInning implements Inning {
		@Override
		public void pitching() {
		}

		@Override
		public NumbersBall hitting(String userInput) {
			return null;
		}

		@Override
		public ResultBoard judge(NumbersBall hittersBall) {
			return new ResultBoard(3, 0, true);
		}
	}
}