package yu.abstractfactory.factory;

public abstract class Factory {
	public static Factory getFactory(String className){
		Factory factory = null;
		try {
			Class.forName(className).newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("找不到类："+className);
			e.printStackTrace();
		}
		return factory;
	}
	
	public abstract Link createLink(String caption,String url);
	public abstract Tray createTray(String caption);
	public abstract Page createPage(String title,String author);
}
