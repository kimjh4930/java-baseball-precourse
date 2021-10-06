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
