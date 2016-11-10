package yu.singleton;

public class Main {
	public static void main(String args[]){
		System.out.println("start.");
		Singleton obj1 = Singleton.getInstance();
		Singleton obj2 = Singleton.getInstance();
		if(obj1==obj2){
			System.out.println("obj1和obj2是同一对象实例。same");
		}else{
			System.out.println("obj1和obj2并非同一对象实例.different");
		}
		System.out.println("end.");
	}
}
