package baseball;

import nextstep.test.NSTest;
import nextstep.utils.Randoms;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

public class ApplicationTest extends NSTest {
	@BeforeEach
	void beforeEach() {
		super.setUp();
	}

	@DisplayName("낫싱")
	@Test
	void 낫싱() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms
				.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(1, 3, 5);
			running("246");
			verify("낫싱");
		}
	}

	@DisplayName("게임 종료 후 재시작")
	@Test
	void 게임종료_후_재시작() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 3)
				.thenReturn(5, 8, 9);
			run("713", "1", "597", "589", "2");
			verify("3스트라이크", "게임 끝", "1스트라이크 1볼");
		}
	}

	@DisplayName("ERROR")
	@Test
	void 에러발생() {
		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 3)
				.thenReturn(5, 8, 9);
			running("12");
			verify("ERROR");
		}
	}

	@DisplayName("새로운 게임 선택 ERROR")
	@Test
	void 새로운_게임_선택_에러() {
		final String WRONG_INPUT = "3";

		try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
			mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
				.thenReturn(7, 1, 3);
			running("713", WRONG_INPUT);
			verify("3스트라이크", "게임 끝", "ERROR");
		}
	}

	@AfterEach
	void tearDown() {
		outputStandard();
	}

	@Override
	public void runMain() {
		Application.main(new String[] {});
	}
}
