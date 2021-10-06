package baseball.rule;

public class Digit {
	private final int digit;

	public Digit(final int digit) {
		validateDigit(digit);
		this.digit = digit;
	}

	public void validateDigit(int digit) {
		if (digit <= 0) {
			throw new IllegalArgumentException("1 이상 입력하세요 : " + digit);
		}
	}

	public int valueOf() {
		return this.digit;
	}
}
