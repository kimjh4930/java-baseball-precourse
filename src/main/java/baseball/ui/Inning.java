package baseball.ui;

import baseball.inning.NumbersBall;
import baseball.inning.ResultBoard;

public interface Inning {
    void pitching ();

    NumbersBall hitting(String userInput);

    ResultBoard judge (NumbersBall hittersBall);
}
