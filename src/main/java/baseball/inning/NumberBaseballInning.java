package baseball.inning;

import baseball.ui.Inning;

public final class NumberBaseballInning implements Inning {
	private final Referee referee;
	private final Pitcher pitcher;
	private final Hitter hitter;

	/**
	 *
	 * @param referee : 심판, 타자의 숫자공이 투수의 광과 일치하는지 확인한다.
	 * @param pitcher : 투수, 타자가 맞춰야 하는 공을 심판에게 알려준다.
	 * @param hitter  : 타자, 투수의 공을 맞출 때까지 새로운 숫자공을 심판에게 건넨다.
	 */

	public NumberBaseballInning(final Referee referee, final Pitcher pitcher, final Hitter hitter) {
		this.referee = referee;
		this.pitcher = pitcher;
		this.hitter = hitter;
	}

	/**
	 * 투수가 숫자공을 만들어 심판에게 건넨다.
	 */
	@Override
	public void pitching() {
		referee.getPitchersBall(pitcher.pitching());
	}

	/**
	 * 사용자가 입력한 값이 규칙에 맞는지 확인한다.
	 * 규칙에 맞지 않는경우 null 을 반환한다.
	 *
	 * @param userInput    사용자가 입력한 값.
	 * @return 규칙에 맞는 숫자공
	 */

	@Override
	public NumbersBall hitting(String userInput) {
		return hitter.hitting(userInput);
	}

	/**
	 * 	타자와 투수의 숫자공이 일치하는지 확인후
	 *
	 * @param hittersBall 타자가 건네준 숫자공.
	 * @return 심판 판정 결과
	 */
	@Override
	public ResultBoard judge(NumbersBall hittersBall) {
		if (hittersBall == null) {
			return null;
		}

		return referee.judge(hittersBall);
	}
}