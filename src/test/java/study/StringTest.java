package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

	@DisplayName("\"1,2\"을 ',' 으로 분리할 수 있다.")
	@Test
	void splitTest() {
		//given
		String chunk = "1,2";

		//when
		String[] splited = chunk.split(",");

		//then
		assertThat(splited).contains("2", "1");
		assertThat(splited).containsExactly("1", "2");
	}

	@DisplayName("\"1\"을 , 분리하면 \"1\"을 반환한다.")
	@Test
	void splitTestWithoutComma() {
		//given
		String chunk = "1";

		//when
		String[] splited = chunk.split(",");

		//then
		assertThat(splited).containsExactly("1");
	}

	@DisplayName("소괄호를 제거한다.")
	@Test
	void substringParentheses() {
		//given
		String chunk = "(1,2)";

		//when
		String parenthesesRemoved = chunk.substring(1, 4);

		//then
		assertThat(parenthesesRemoved).isEqualTo("1,2");
	}

	@DisplayName("charAt() 으로 특정 위치의 문자를 가져올 수 있다.")
	@Test
	void getCharacterUsing_charAt() {
		//given
		String stringValue = "abc";
		int index = 2;
		char expected = 'c';

		//when
		char select = stringValue.charAt(index);

		//then
		assertThat(select).isEqualTo(expected);

		//        assertThatThrownBy(() -> {
		//            character.charAt(index);
		//        }).isInstanceOf(StringIndexOutOfBoundsException.class)
		//                .hasMessage("String index out of range: " + index);
		//        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
		//                .isThrownBy(() -> character.charAt(5))
		//                .withMessage("String index out of range: ");
		//        assertThatThrownBy(() -> {
		//            character.charAt(5);
		//        }).isInstanceOf(StringIndexOutOfBoundsException.class)
		//                .hasMessageContaining("Index: 2, Size: 2");
	}

	@DisplayName("String index 를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
	@Test
	void getCharacterOutOfIndex() {
		//given
		String stringValue = "abc";
		int index = stringValue.length() + 1;

		//when, then
		assertThatThrownBy(() -> {
			stringValue.charAt(index);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessage("String index out of range: " + index);
	}
}
