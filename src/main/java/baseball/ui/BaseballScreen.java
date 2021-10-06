package baseball.ui;

import baseball.exception.InvalidInputException;
import baseball.inning.NumbersBall;
import baseball.inning.ResultBoard;
import nextstep.utils.Console;

public class BaseballScreen {
    private final int INSERT_COIN = 1;
    private final int EXIT = 2;

    private final Inning inning;

    public BaseballScreen(Inning inning) {
        this.inning = inning;
    }

    public void play (){
        int choice = INSERT_COIN;

        while(choice == INSERT_COIN){
            inning();
            choice = choiceNextGameOrExit();
            System.out.println(choice);
        }
    }

    private void inning (){
        pitching();
        hitting();

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 끝.");
    }

    private int choiceNextGameOrExit (){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = select();

        while(outOfBound(choice)){
            choice = select();
        }

        return choice;
    }

    private int select (){
        return Integer.parseInt(Console.readLine());
    }

    private boolean outOfBound (int choice){
        boolean invalid = !(choice == INSERT_COIN || choice == EXIT);

        if(invalid){
            System.out.println("ERROR");
        }

        return invalid;
    }

    private void pitching(){
        inning.pitching();
    }

    private void hitting (){
        boolean gameSet = false;

        while(!gameSet) {
            System.out.print("숫자를 입력해주세요 : ");
            NumbersBall hittersBall = getHitterBall();
            ResultBoard resultBoard = inning.judge(hittersBall);
            call(resultBoard);
            gameSet = gameSet(resultBoard);
        }
    }

    private NumbersBall getHitterBall () {
        NumbersBall ball = null;
        try {
            ball = inning.hitting(userInput());
        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
        }
        return ball;
    }

    private void call (ResultBoard board){
        if(board == null){
            return;
        }
        System.out.println(board.read());
    }

    private boolean gameSet (ResultBoard board){
        if(board == null){
            return false;
        }
        return board.gameSet();
    }

    private String userInput (){
        return Console.readLine();
    }

}
