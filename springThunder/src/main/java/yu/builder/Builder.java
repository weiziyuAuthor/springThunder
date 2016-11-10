package yu.builder;

public abstract class Builder {
	public abstract void makeTitle(String titel);
	public abstract void makeString(String str);
	public abstract void makeItems(String[] items);
	public abstract Object getResult(); 
}
