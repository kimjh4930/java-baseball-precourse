package baseball.rule;

import baseball.exception.InvalidInputException;
import baseball.inning.Rule;

import java.util.*;

public final class ThreeNumbersRule implements Rule {
	public final String ZERO = "0";
	public final Digit digit;

	/**
	 * 숫자야구게임의 규칙을 설정한다.
	 */
	public ThreeNumbersRule() {
		this.digit = new Digit(3);
	}

	public int getDigit() {
		return this.digit.valueOf();
	}

	/**
	 * @param  numberBall 숫자 문자열이 규칙에 맞게 작성되었는지 확인
	 * @return 규칙에 맞으면 true를 반환
	 * @throws InvalidInputException 규칙에 맞지 않으면, 발생한다.
	 */
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

	/**
	 * 숫자공의 위치와 값이 동일한 경우를 strike 라고 한다.
	 *
	 * @param pitchers 투수의 숫자공
	 * @param hitters  타자의 숫자공
	 * @return 스트라이크의 갯수
	 */

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

	/**
	 * 타자의 숫자공의 숫자가 투수의 숫자공에 몇개 존재하는지 확인 후, strike 수를 뺀다.
	 * ball의 개수 = contains 수 - strike의 개수
	 *
	 * @param pitchers 투수의 숫자공
	 * @param hitters  타자의 숫자공
	 * @return 볼의 갯수
	 */

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
