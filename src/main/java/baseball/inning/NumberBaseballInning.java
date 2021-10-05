package baseball.inning;

import baseball.ui.Inning;

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
        referee.getPitchersBall(pitcher.pitching());
        do{
            System.out.print("숫자를 입력해주세요 : ");
        }while(referee.judge(hitter.hitting()));

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝");
    }
}