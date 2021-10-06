package baseball.inning;

import baseball.ui.Inning;

public class NumberBaseballInning implements Inning {
	private final Referee referee;
	private final Pitcher pitcher;
	private final Hitter hitter;

	public NumberBaseballInning(Referee referee, Pitcher pitcher, Hitter hitter) {
		this.referee = referee;
		this.pitcher = pitcher;
		this.hitter = hitter;
	}

	@Override
	public void pitching() {
		referee.getPitchersBall(pitcher.pitching());
	}

	@Override
	public NumbersBall hitting(String userInput) {
		return hitter.hitting(userInput);
	}

	@Override
	public ResultBoard judge(NumbersBall hittersBall) {
		if (hittersBall == null) {
			return null;
		}

		return referee.judge(hittersBall);
	}
}