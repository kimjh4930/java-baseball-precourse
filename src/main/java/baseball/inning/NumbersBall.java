package baseball.inning;

import java.util.*;

public final class NumbersBall {
    private final List<Integer> numbers;

    public NumbersBall (final List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> toList (){
        return new ArrayList<>(numbers);
    }

}
