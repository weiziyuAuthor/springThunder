package yu.proxy;

public class PrinterProxy implements Printable {
	//命名
	private String name;
	//本人
	private Printer real;
	public PrinterProxy(String name){
		this.name = name;
	}
	
	public String getPrinterName() {
		return name;
	}

	public void print(String string) {
		realize();
		real.print(string);
	}

	public synchronized void setPrinterName(String name) {
		if(real!=null){
			//本人也要命名
			real.setPrinterName(name);
		}
		this.name = name;
	}
	
	//产生本人
	private synchronized void realize(){
		if(real==null){
			real = new Printer(name);
		}
	}

}
