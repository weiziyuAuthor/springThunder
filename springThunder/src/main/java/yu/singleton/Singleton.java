package yu.singleton;

public class Singleton {
	private static Singleton singleton = new Singleton();
	private Singleton(){
		System.out.println("object instance has been created");
	}
	
	public static Singleton getInstance(){
		return singleton;
	}
}
