package yu.Prototype;

import yu.Prototype.framework.Product;

public class MessageBox implements Product {
	
	private char decochar;
	public MessageBox(char decochar){
		this.decochar = decochar;
	}
	
	
	public Product createClone() {
		Product p = null;
		try {
			p = (Product)clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}

	public void use(String s) {
		// TODO Auto-generated method stub
		int length = s.getBytes().length;
		for(int i = 0;i<length+4;i++){
			System.out.print(decochar);
		}
		System.out.println("");
		
		System.out.println(decochar +" " +s+ " "+decochar);
		for(int i=0;i<length+4;i++){
			System.out.print(decochar);
		}
		System.out.println("");
	}
	

}
