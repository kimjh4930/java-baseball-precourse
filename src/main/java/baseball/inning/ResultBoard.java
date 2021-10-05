package baseball.inning;

public final class ResultBoard {
    public String read (int strike, int ball){
        if(strike == 0 && ball == 0){
            return "낫싱";
        }

        if(strike !=0 && ball == 0){
            return strike + "스트라이크";
        }

        if(strike == 0 && ball != 0){
            return ball + "볼";
        }

        return strike + "스트라이크 " + ball + "볼";
    }
}