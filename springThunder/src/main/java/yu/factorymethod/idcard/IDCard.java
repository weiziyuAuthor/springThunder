package yu.factorymethod.idcard;

import yu.factorymethod.framework.Product;

public class IDCard extends Product {
	
	private String owner;
	IDCard(String owner){
		System.out.println("建立"+owner+"的卡。");
		this.owner = owner;
	}
	
	@Override
	public void use() {
		System.out.println("使用"+owner+"的卡。");
	}
	
	public String getOwner(){
		return owner;
	}

}
