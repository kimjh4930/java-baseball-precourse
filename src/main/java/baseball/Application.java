package baseball;

import baseball.inning.NumberBaseballInning;
import baseball.inning.Referee;
import baseball.inning.Rule;
import baseball.inning.role.Computer;
import baseball.inning.role.Player;
import baseball.rule.ThreeNumbersRule;
import baseball.ui.BaseballScreen;
import baseball.ui.Inning;

public class Application {
	public static void main(String[] args) {
		Rule rule = new ThreeNumbersRule();
		Inning inning = new NumberBaseballInning(
			new Referee(rule),
			new Computer(rule),
			new Player(rule)
		);

		BaseballScreen baseball = new BaseballScreen(inning);
		baseball.play();
	}
}
