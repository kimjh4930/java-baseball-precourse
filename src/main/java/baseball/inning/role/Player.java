package baseball.inning.role;

import baseball.inning.Hitter;
import baseball.inning.NumbersBall;
import baseball.inning.Rule;
import nextstep.utils.Console;

import java.util.*;

public final class Player implements Hitter {
    private final Rule rule;

    public Player(Rule rule) {
        this.rule = rule;
    }

    public NumbersBall hitting (){
        return new NumbersBall(typedNumber());
    }

    private List<Integer> typedNumber (){
        String typed;

        do {
            typed = Console.readLine();
        } while(!rule.validateOf(typed));

        return convertToList(typed);
    }

    private List<Integer> convertToList (String numbers){
        List<Integer> numberList = new ArrayList<>();

        for(char number : numbers.toCharArray()){
            numberList.add(number - '0');
        }

        return Collections.unmodifiableList(numberList);
    }
}
