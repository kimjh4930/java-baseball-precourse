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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumbersBall that = (NumbersBall) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
