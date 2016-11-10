package yu.factorymethod.idcard;

import java.util.Vector;

import yu.factorymethod.framework.Factory;
import yu.factorymethod.framework.Product;

public class IDCardFactory extends Factory {
	private Vector owners = new Vector();
	@Override
	protected Product createProduct(String owner) {
		
		return new IDCard(owner);
	}

	@Override
	protected void registerProduct(Product product) {
		owners.add(((IDCard)product).getOwner());
	}
	
	public Vector getOwners(){
		return owners;
	}
}
