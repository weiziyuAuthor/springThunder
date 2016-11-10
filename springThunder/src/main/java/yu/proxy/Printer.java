package yu.proxy;

public class Printer implements Printable {
	
	private String name;
	
	public Printer(){
		heavyJob("正在产生Printer的对象实例");
	}
	
	public Printer(String name){
		this.name = name;
		heavyJob("正在产生Printer对象实例("+name+")");
	}
	public String getPrinterName() {
		return name;
	}

	public void print(String string) {
		System.out.println("==="+name+"===");
		System.out.println(string);
	}

	public void setPrinterName(String name) {
		this.name = name;
	}
	
	private void heavyJob(String msg){
		System.out.print(msg);
		for(int i=0;i<5;i++){
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print(".");
		}
		System.out.println("完成.");
	}

}
