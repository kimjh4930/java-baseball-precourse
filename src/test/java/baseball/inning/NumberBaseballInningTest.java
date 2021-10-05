package baseball.inning;

import baseball.inning.role.Computer;
import baseball.inning.role.Player;
import baseball.rule.ThreeNumbersRule;
import baseball.ui.Inning;
import nextstep.test.NSTest;
import nextstep.utils.Randoms;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mockStatic;

class NumberBaseballInningTest extends NSTest {
    private Inning inning;

    @BeforeEach
    void beforeEach () {
        this.setUp();
    }

    @Override
    protected void setUp() {
        super.setUp();
        inning = RoundTestConfig.inning();
    }

    @DisplayName("라운드 정상종료")
    @Test
    void 라운드_정상종료 (){
        try(final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)){
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(5, 8, 9);
            run("597", "589");
            verify("3스트라이크", "1스트라이크 1볼", "게임 끝");
        }
    }

    @DisplayName("에러발생")
    @Test
    void 에러발생(){
        try (final MockedStatic<Randoms> mockRandoms = mockStatic(Randoms.class)) {
            mockRandoms.when(() -> Randoms.pickNumberInRange(anyInt(), anyInt()))
                    .thenReturn(5, 8, 9);
            running("12");
            verify("ERROR");
        }
    }

    @Override
    public void runMain() {
        inning.play();
    }

    @AfterEach
    void tearDown(){
        outputStandard();
    }

    static class RoundTestConfig {
        static Inning inning (){
            return new NumberBaseballInning(referee(), pitcher(), hitter());
        }

        static Referee referee () {
            return new Referee(rule());
        }

        static Pitcher pitcher (){
            return new Computer(rule());
        }

        static Hitter hitter (){
            return new Player(rule());
        }

        static Rule rule (){
            return new ThreeNumbersRule();
        }
    }

}