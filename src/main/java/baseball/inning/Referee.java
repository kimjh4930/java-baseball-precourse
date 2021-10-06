package baseball.inning;

public final class Referee {
	private final Rule rule;

	private NumbersBall pitchersBall;
	private NumbersBall hittersBall;

	/**
	 * 심판이 참고할 규칙
	 * @param rule
	 */
	public Referee(Rule rule) {
		this.rule = rule;
	}

	/**
	 * 투수에게서 숫자공을 받는다.
	 * @param pitchersBall
	 */

	public void getPitchersBall(final NumbersBall pitchersBall) {
		this.pitchersBall = pitchersBall;
	}

	/**
	 *
	 * @param hittersBall 타자의 공
	 * @return 판정결과를 반환
	 */

	public ResultBoard judge(final NumbersBall hittersBall) {
		this.hittersBall = hittersBall;
		int strike = strike();
		int ball = ball();

		return new ResultBoard(strike, ball, gameSet(strike));
	}

	private int strike() {
		return rule.strike(pitchersBall.toList(), hittersBall.toList());
	}

	private int ball() {
		return rule.ball(pitchersBall.toList(), hittersBall.toList());
	}

	/**
	 * @param strike
	 * @return 이닝을 종료 할 수 있으면 true, 그렇지 않으면 false 를 반환한다.
	 */
	private boolean gameSet(final int strike) {
		return strike == rule.getDigit();
	}
}
