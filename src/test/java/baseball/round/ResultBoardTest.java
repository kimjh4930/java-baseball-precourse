package baseball.round;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultBoardTest {
    private ResultBoard board;

    @BeforeEach
    void setUp (){
        board = new ResultBoard();
    }

    @DisplayName("3스트라이크")
    @Test
    void threeStrike (){
        assertThat(board.read(3, 0)).isEqualTo("3스트라이크");
    }

    @DisplayName("2스트라이크 1볼")
    @Test
    void twoStrikeOneBall (){
        assertThat(board.read(2, 1)).isEqualTo("2스트라이크 1볼");
    }

    @DisplayName("3볼")
    @Test
    void threeBall (){
        assertThat(board.read(0, 3)).isEqualTo("3볼");
    }

    @DisplayName("낫싱")
    @Test
    void nothing () {
        assertThat(board.read(0, 0)).isEqualTo("낫싱");
    }
}