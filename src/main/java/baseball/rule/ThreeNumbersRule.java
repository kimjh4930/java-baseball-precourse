package baseball.rule;

import baseball.exception.InvalidInputException;
import baseball.inning.Rule;

import java.util.*;

public final class ThreeNumbersRule implements Rule {
	public final String ZERO = "0";
	public final Digit digit;

	public int getDigit() {
		return this.digit.valueOf();
	}

	public ThreeNumbersRule() {
		this.digit = new Digit(3);
	}

	@Override
	public boolean validateOf(final String numberBall) {
		if (checkCondition(numberBall)) {
			return true;
		}

		throw new InvalidInputException("ERROR");
	}

	private boolean checkCondition(final String numberBall) {
		return checkLength(numberBall) && notContainZero(numberBall) && checkDuplicate(numberBall);
	}

	private boolean checkLength(final String numberBall) {
		return numberBall.length() == digit.valueOf();
	}

	private boolean notContainZero(final String numberBall) {
		return !numberBall.contains(ZERO);
	}

	private boolean checkDuplicate(final String numberBall) {
		Set<Character> numberSet = new HashSet<>();

		for (char number : numberBall.toCharArray()) {
			numberSet.add(number);
		}

		return numberSet.size() == digit.valueOf();
	}

	@Override
	public int strike(List<Integer> pitchers, List<Integer> hitters) {
		int strike = 0;

		for (int i = 0; i < getDigit(); i++) {
			strike += checkValueAndOrders(pitchers.get(i), hitters.get(i));
		}

		return strike;
	}

	private int checkValueAndOrders(int num1, int num2) {
		if (num1 == num2) {
			return 1;
		}
		return 0;
	}

	@Override
	public int ball(List<Integer> pitchers, List<Integer> hitters) {
		int contains = 0;

		for (int i = 0; i < getDigit(); ++i) {
			contains += checkContains(pitchers, hitters.get(i));
		}

		return Math.abs(this.strike(pitchers, hitters) - contains);
	}

	private int checkContains(List<Integer> pitchers, int num2) {
		if (pitchers.contains(num2)) {
			return 1;
		}
		return 0;
	}
}
