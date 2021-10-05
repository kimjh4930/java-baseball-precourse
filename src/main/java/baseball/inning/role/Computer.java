package baseball.inning.role;

import baseball.inning.NumbersBall;
import baseball.inning.Pitcher;
import baseball.inning.Rule;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class Computer implements Pitcher {
    private final int MIN = 1;
    private final int MAX = 9;

    private final Rule rule;

    public Computer(Rule rule) {
        this.rule = rule;
    }

    public NumbersBall pitching (){
        return new NumbersBall(randomNumbers());
    }

    private List<Integer> randomNumbers (){
        Set<Integer> pickedNumbers = new LinkedHashSet<>();

        while(pickedNumbers.size() != rule.getDigit()){
            pickedNumbers.add(Randoms.pickNumberInRange(MIN, MAX));
        }

        return new ArrayList<>(pickedNumbers);
    }
}
