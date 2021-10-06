package baseball.inning;

import java.util.Objects;

public final class ResultBoard {
	private final int strike;
	private final int ball;
	private final boolean gameSet;

	public ResultBoard(int strike, int ball, boolean gameSet) {
		this.strike = strike;
		this.ball = ball;
		this.gameSet = gameSet;
	}

	public String read() {
		if (strike == 0 && ball == 0) {
			return "낫싱";
		}

		return addCallSign(strike, ball);
	}

	public boolean gameSet() {
		return this.gameSet;
	}

	private String addCallSign(int strike, int ball) {
		if (strike != 0 && ball == 0) {
			return strike + "스트라이크";
		}
		if (strike == 0 && ball != 0) {
			return ball + "볼";
		}
		return strike + "스트라이크 " + ball + "볼";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ResultBoard board = (ResultBoard)o;
		return strike == board.strike && ball == board.ball && gameSet == board.gameSet;
	}

	@Override
	public int hashCode() {
		return Objects.hash(strike, ball, gameSet);
	}
}