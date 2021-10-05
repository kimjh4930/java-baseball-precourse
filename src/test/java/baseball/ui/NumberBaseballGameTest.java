package baseball.ui;

import nextstep.test.NSTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberBaseballGameTest extends NSTest {
    private NumberBaseballGame numberBaseballGame;

    @Override
    public void runMain() {
        numberBaseballGame.run();
    }

    @BeforeEach
    void beforeEach (){
        super.setUp();

        numberBaseballGame = BaseballGameConfig.game();
    }

    @DisplayName("continue game")
    @Test
    void insertCoin (){
        running("1");
        verify("play!");
    }

    @DisplayName("ERROR")
    @Test
    void error (){
        running("3", "4");
        verify("ERROR");
    }

    @AfterEach
    void tearDown (){
        outputStandard();
    }

    static class BaseballGameConfig {
        static NumberBaseballGame game (){
            return new NumberBaseballGame (mockInning());
        }

        static Inning mockInning (){
            return () -> System.out.println("play!");
        }
    }

}