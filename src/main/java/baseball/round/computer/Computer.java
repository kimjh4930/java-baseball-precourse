package baseball.round.computer;

import baseball.round.Pitcher;
import baseball.round.Rule;

import java.util.Set;

public final class Computer implements Pitcher {
    private final Rule rule;

    public Computer(Rule rule) {
        this.rule = rule;
    }

    public Set<Integer> pitching (){
        return new RandomNumbersBall(rule.getDigit()).make();
    }
}
