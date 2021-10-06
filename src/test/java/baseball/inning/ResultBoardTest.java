package baseball.inning;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBoardTest {
	private ResultBoard board;

	@DisplayName("3스트라이크")
	@Test
	void threeStrike() {
		board = new ResultBoard(3, 0, true);
		assertThat(board.read()).isEqualTo("3스트라이크");
		assertThat(board.gameSet()).isTrue();
	}

	@DisplayName("2스트라이크 1볼")
	@Test
	void twoStrikeOneBall() {
		board = new ResultBoard(1, 2, false);
		assertThat(board.read()).isEqualTo("1스트라이크 2볼");
	}

	@DisplayName("3볼")
	@Test
	void threeBall() {
		board = new ResultBoard(0, 3, false);
		assertThat(board.read()).isEqualTo("3볼");
	}

	@DisplayName("낫싱")
	@Test
	void nothing() {
		board = new ResultBoard(0, 0, false);
		assertThat(board.read()).isEqualTo("낫싱");
	}
}