package baseball.inning.role;

import baseball.exception.InvalidInputException;
import baseball.inning.Hitter;
import baseball.inning.NumbersBall;
import baseball.inning.Rule;
import nextstep.utils.Console;

import java.util.*;

public final class Player implements Hitter {
	private final Rule rule;

	public Player(Rule rule) {
		this.rule = rule;
	}

	/**
	 * 사용자가 입력한 값이, 규칙을 따르는지 확인한다.
	 * 규칙에 맞는 값이면 숫자공으로 반환한다.
	 *
	 * @param ball : Player가 입력한 숫자.
	 * @return {@link NumbersBall}
	 * @throws InvalidInputException {@link Rule#validateOf(String)} 규칙에 맞지 않는 경우에 발생한다.
	 */

	public NumbersBall hitting(String ball) {
		if (!rule.validateOf(ball)) {
			throw new InvalidInputException(ball);
		}
		List<Integer> numbers = convertToList(ball);

		return new NumbersBall(numbers);
	}

	private List<Integer> convertToList(String numbers) {
		List<Integer> numberList = new ArrayList<>();

		for (char number : numbers.toCharArray()) {
			numberList.add(number - '0');
		}

		return Collections.unmodifiableList(numberList);
	}
}
