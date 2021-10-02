package baseball.round.computer;

import nextstep.utils.Randoms;

import java.util.*;

public final class RandomNumbersBall {
    private final int MIN = 1;
    private final int MAX = 9;

    private final int digits;

    private final Set<Integer> numbers = new LinkedHashSet<>();

    public RandomNumbersBall(final int digits) {
        this.digits = digits;
    }

    public Set<Integer> make(){
        while(numbers.size() != digits){
            int pickedNumber = Randoms.pickNumberInRange(MIN, MAX);
            numbers.add(pickedNumber);
        }

        return Collections.unmodifiableSet(numbers);
    }
}
