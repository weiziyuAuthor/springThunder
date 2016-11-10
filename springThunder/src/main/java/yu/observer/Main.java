package yu.observer;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		NumberGenerator generator = new RandomNumberGenerator();
		Observer o1 = new DigitObserver();
		Observer o2 = new GraphObserver();
		generator.addobserver(o1);
		generator.addobserver(o2);
		generator.execute();
	}

}
