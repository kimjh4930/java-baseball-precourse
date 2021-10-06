package baseball.ui;

public enum Coin {
	INSERT(1),
	EXIT(2);

	private static final int INSERT_VALUE = 1;
	private static final int EXIT_VALUE = 2;

	private final int value;

	Coin (int value){
		this.value = value;
	}

	protected static Coin get(int value){
		if(value == INSERT_VALUE){
			return INSERT;
		}

		if(value == EXIT_VALUE){
			return EXIT;
		}
		return null;
	}
}
