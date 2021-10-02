package baseball.round.player;

import baseball.round.Hitter;
import baseball.round.Rule;

import java.util.LinkedHashSet;
import java.util.Set;

public final class Player implements Hitter {
    private final Rule rule;

    private Set<Integer> numbers = new LinkedHashSet<>();

    public Player(Rule rule) {
        this.rule = rule;
    }

    public Set<Integer> hitting (){
        return new TypedNumbersBall(rule).make();
    }
}
