package baseball.inning;

public class Referee {
    private final Rule rule;

    private ResultBoard board;
    private NumbersBall pitchersBall;
    private NumbersBall hittersBall;

    public Referee (Rule rule){
        this.rule = rule;
        board = new ResultBoard();
    }

    public void getPitchersBall (NumbersBall pitchersBall){
        this.pitchersBall = pitchersBall;
    }

    public boolean judge (NumbersBall hittersBall){
        this.hittersBall = hittersBall;
        int strike = strike();
        int ball = ball();

        call(strike, ball);

        return nextBall(strike);
    }

    private void call (int strike, int ball){
        System.out.println(board.read(strike, ball));
    }

    private int strike (){
        return rule.strike(pitchersBall.toList(), hittersBall.toList());
    }

    private int ball (){
        return rule.ball(pitchersBall.toList(), hittersBall.toList());
    }

    private boolean nextBall (int strike){
        return strike != rule.getDigit();
    }
}
