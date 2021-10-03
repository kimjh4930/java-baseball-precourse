package baseball.round;

import java.util.*;

public class NumbersBall {
    private Map<Integer, Integer> numbersMap = new HashMap<>();

    public NumbersBall (final List<Integer> numbers) {
        for(int index=0 ; index<numbers.size(); ++index){
            numbersMap.put(index, numbers.get(index));
        }
    }

    public Map<Integer, Integer> getNumbers (){
        return Collections.unmodifiableMap(numbersMap);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumbersBall that = (NumbersBall) o;
        return numbersMap.equals(that.numbersMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbersMap);
    }
}
