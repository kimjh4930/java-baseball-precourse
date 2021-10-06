package baseball.inning;

public class Referee {
    private final Rule rule;

    private NumbersBall pitchersBall;
    private NumbersBall hittersBall;

    public Referee (Rule rule){
        this.rule = rule;
    }

    public void getPitchersBall (NumbersBall pitchersBall){
        this.pitchersBall = pitchersBall;
    }

    public ResultBoard judge (NumbersBall hittersBall){
        this.hittersBall = hittersBall;
        int strike = strike();
        int ball = ball();

        return new ResultBoard(strike, ball, gameset(strike));
    }

    private int strike (){
        return rule.strike(pitchersBall.toList(), hittersBall.toList());
    }

    private int ball (){
        return rule.ball(pitchersBall.toList(), hittersBall.toList());
    }

    private boolean gameset (int strike){
        return strike == rule.getDigit();
    }
}
