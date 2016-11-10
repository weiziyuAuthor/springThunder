package yu.proxy;

public interface Printable {
	//命名
	public abstract void setPrinterName(String name);
	
	//取得名称
	public abstract String getPrinterName();
	
	//输出字符串(打印)
	public abstract void print(String string);
}
