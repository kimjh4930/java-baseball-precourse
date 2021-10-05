package baseball.game;

import nextstep.utils.Console;

public class NumberBaseballGame {
    private final int INSERT_COIN = 1;
    private final int EXIT = 2;

    private final Inning inning;

    public NumberBaseballGame(final Inning inning){
        this.inning = inning;
    }

    public void run (){
        int choice = INSERT_COIN;

        while(choice == INSERT_COIN){
            inning.play();
            choice = choiceNextGameOrExit();
        }
    }

    private int choiceNextGameOrExit (){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = select();

        while(outOfBound(choice)){
            choice = select();
        }

        return choice;
    }

    private boolean outOfBound (int choice){
        boolean invalid = !(choice == INSERT_COIN || choice == EXIT);

        if(invalid){
            System.out.println("ERROR");
        }

        return invalid;
    }

    private int select (){
        return Integer.parseInt(Console.readLine());
    }
}
