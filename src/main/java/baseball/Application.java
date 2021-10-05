package baseball;

import baseball.config.NumberBaseballAppConfig;
import baseball.ui.NumberBaseballGame;

public class Application {
    public static void main(String[] args) {
        NumberBaseballAppConfig config = new NumberBaseballAppConfig();

        NumberBaseballGame baseballGame = config.baseballGame();
        baseballGame.run();

        System.out.println("게임 종료");
    }

}
