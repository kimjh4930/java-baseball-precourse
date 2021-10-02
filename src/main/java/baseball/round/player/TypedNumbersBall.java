package baseball.round.player;

import baseball.round.Rule;
import nextstep.utils.Console;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class TypedNumbersBall {
    private final Rule rule;

    private final Set<Integer> numbers = new LinkedHashSet<>();

    public TypedNumbersBall(Rule rule) {
        this.rule = rule;
    }

    public Set<Integer> make() {
        String typedNumbers;

        do {
            typedNumbers = Console.readLine();
        } while(!rule.validateOf(typedNumbers));

        for(char number : typedNumbers.toCharArray()){
            numbers.add(number - '0');
        }

        return Collections.unmodifiableSet(numbers);
    }
}
