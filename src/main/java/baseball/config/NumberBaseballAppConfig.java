package baseball.config;

import baseball.inning.*;
import baseball.inning.role.Computer;
import baseball.inning.role.Player;
import baseball.rule.ThreeNumbersRule;
import baseball.ui.Inning;
import baseball.ui.NumberBaseballGame;

public class NumberBaseballAppConfig {

    public NumberBaseballGame baseballGame (){
        return new NumberBaseballGame(inning());
    }

    private Inning inning (){
        return new NumberBaseballInning(referee(), computer(), player());
    }

    private Pitcher computer (){
        return new Computer(rule());
    }

    private Hitter player (){
        return new Player(rule());
    }

    private Referee referee (){
        return new Referee(rule());
    }

    private Rule rule (){
        return new ThreeNumbersRule();
    }
}
