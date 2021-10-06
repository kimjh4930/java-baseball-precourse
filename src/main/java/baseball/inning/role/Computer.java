package baseball.inning.role;

import baseball.inning.NumbersBall;
import baseball.inning.Pitcher;
import baseball.inning.Rule;
import nextstep.utils.Randoms;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public final class Computer implements Pitcher {
	private final int MIN = 1;
	private final int MAX = 9;

	private final Rule rule;

	public Computer(Rule rule) {
		this.rule = rule;
	}

	public NumbersBall pitching() {
		return new NumbersBall(randomNumbers());
	}

	/**{@link}
	 * <p>
	 * {@link Rule#getDigit()}
	 * 규칙에서 정한 Digit 값과 동일한 갯수만큼 임의의 숫자를 뽑는다.
	 * </p>
	 * @return {@link ArrayList}
	 */

	private List<Integer> randomNumbers() {
		Set<Integer> pickedNumbers = new LinkedHashSet<>();

		while (pickedNumbers.size() != rule.getDigit()) {
			pickedNumbers.add(Randoms.pickNumberInRange(MIN, MAX));
		}

		return new ArrayList<>(pickedNumbers);
	}
}
