package baseball.inning;

import baseball.exception.InvalidInputException;
import baseball.game.Inning;

public class NumberBaseballInning implements Inning {
    private final Referee referee;
    private final Pitcher pitcher;
    private final Hitter hitter;

    public NumberBaseballInning(Referee referee, Pitcher pitcher, Hitter hitter) {
        this.referee = referee;
        this.pitcher = pitcher;
        this.hitter = hitter;
    }

    @Override
    public void play(){
        pitching();
        hitting();

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }

    private void pitching (){
        referee.getPitchersBall(pitcher.pitching());
    }

    private void hitting (){
        boolean readyForNextBall = true;

        while(readyForNextBall){
            System.out.print("숫자를 입력해주세요 : ");
            NumbersBall hittersBall = getBall();

            readyForNextBall = nextBall(hittersBall) || referee.judge(hittersBall);
        }
    }

    private NumbersBall getBall () {
        NumbersBall ball = null;
        try {
            ball = hitter.hitting();
        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }
        return ball;
    }

    private boolean nextBall (NumbersBall ball){
        return ball == null;
    }
}