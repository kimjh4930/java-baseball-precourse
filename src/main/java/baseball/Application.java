package baseball;

import baseball.inning.NumberBaseballInning;
import baseball.inning.Referee;
import baseball.inning.Rule;
import baseball.inning.role.Computer;
import baseball.inning.role.Player;
import baseball.rule.ThreeNumbersRule;
import baseball.game.NumberBaseballGame;

public class Application {
    public static void main(String[] args) {
        Rule rule = new ThreeNumbersRule();
        NumberBaseballGame game = new NumberBaseballGame(
            new NumberBaseballInning(
                new Referee(rule),
                new Computer(rule),
                new Player(rule)
            )
        );

        game.run();

        System.out.println("게임 종료");
    }

}
