package baseball.rule;

import baseball.round.Rule;

import java.util.HashSet;
import java.util.Set;

public final class ThreeNumbersRule implements Rule {
    public final String ZERO = "0";
    public final Digit digit;

    public Digit getDigit (){
        return this.digit;
    }

    public ThreeNumbersRule() {
        this.digit = new Digit(3);
    }

    public boolean validateOf (final String numberBall){
        return checkLength(numberBall) &&
                notContainZero(numberBall) &&
                checkDuplicate(numberBall);
    }

    private boolean checkLength (final String numberBall){
        return numberBall.length() == digit.valueOf();
    }

    private boolean notContainZero (final String numberBall){
        return !numberBall.contains(ZERO);
    }

    private boolean checkDuplicate (final String numberBall){
        Set<Character> numberSet = new HashSet<>();

        for(char number : numberBall.toCharArray()){
            numberSet.add(number);
        }

        return numberSet.size() == digit.valueOf();
    }
}
