package baseball.inning;

import java.util.List;

public interface Rule {
    int getDigit ();

    boolean validateOf (String numberBall);

    int strike (List<Integer> pitchers, List<Integer> hitters);

    int ball (List<Integer> pitchers, List<Integer> hitters);
}
