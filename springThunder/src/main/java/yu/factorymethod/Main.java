package yu.factorymethod;

import yu.factorymethod.framework.Factory;
import yu.factorymethod.framework.Product;
import yu.factorymethod.idcard.IDCardFactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Factory factory = new IDCardFactory();
		Product card1 = factory.create("Gary Wei");
		Product card2 = factory.create("Mumu");
		Product card3 = factory.create("Baby");
		card1.use();
		card2.use();
		card3.use();
	}

}
