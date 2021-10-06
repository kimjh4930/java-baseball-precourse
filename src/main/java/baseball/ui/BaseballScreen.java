package baseball.ui;

import baseball.exception.InvalidInputException;
import baseball.inning.NumbersBall;
import baseball.inning.ResultBoard;
import nextstep.utils.Console;

public class BaseballScreen {
	private final Inning inning;

	public BaseballScreen(Inning inning) {
		this.inning = inning;
	}

	/**
	 * 숫자야구게임 시작
	 *
	 * 투수가 숫자공을 제시하고, 타자가 투수의 숫자공을 맞출 때 까지를 "이닝"이라 한다.
	 */
	public void play() {
		Coin choice = Coin.INSERT;

		while (choice == Coin.INSERT) {
			inning();
			choice = insertCoin();
		}
	}

	private void inning() {
		pitching();
		hitting();

		print("3개의 숫자를 모두 맞히셨습니다! 게임 끝.");
	}

	private Coin insertCoin() {
		print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		int choice = select();

		while (outOfBound(choice)) {
			choice = select();
		}

		return Coin.get(choice);
	}

	private int select() {
		return Integer.parseInt(Console.readLine());
	}

	private boolean outOfBound(int choice) {
		Coin coin = Coin.get(choice);

		if (coin == null) {
			printWithoutNewLine("ERROR");
			System.out.println();
		}

		return coin == null;
	}

	private void pitching() {
		inning.pitching();
	}

	private void hitting() {
		boolean gameSet = false;

		while (!gameSet) {
			printWithoutNewLine("숫자를 입력해주세요 : ");
			NumbersBall hittersBall = getHitterBall();
			ResultBoard resultBoard = inning.judge(hittersBall);
			call(resultBoard);
			gameSet = gameSet(resultBoard);
		}
	}

	private NumbersBall getHitterBall() {
		NumbersBall ball = null;
		try {
			ball = inning.hitting(userInput());
		} catch (InvalidInputException e) {
			print(e.getMessage());
		}
		return ball;
	}

	private void call(ResultBoard board) {
		if (board == null) {
			return;
		}
		print(board.read());
	}

	private boolean gameSet(ResultBoard board) {
		if (board == null) {
			return false;
		}
		return board.gameSet();
	}

	private String userInput() {
		return Console.readLine();
	}

	private void print (String content){
		System.out.println(content);
	}

	private void printWithoutNewLine (String content){
		System.out.print(content);
	}

}
