package baseball.round;

import baseball.rule.Digit;

public interface Rule {
    Digit getDigit ();
    boolean validateOf (String numberBall);
}
