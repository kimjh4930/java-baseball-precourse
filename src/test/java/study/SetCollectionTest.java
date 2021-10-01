package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetCollectionTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp (){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @DisplayName("Numbers의 크기를 확인한다.")
    @Test
    void size (){
        //given
        int expectedSize = 3;

        //when

        //then
        assertThat(numbers.size()).isEqualTo(expectedSize);
    }

    @DisplayName("Set의 원소를 확인한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains (int value){
        //given

        //when

        //then
        assertThat(numbers.contains(value)).isTrue();
    }

    @DisplayName("원소가 포함되어있으면 True, 그렇지 않으면 False를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
    void containsOrNot (int input, boolean expected){
        //given

        //when

        //then
        assertThat(numbers.contains(input)).isEqualTo(expected);
    }
}
