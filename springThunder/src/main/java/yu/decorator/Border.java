package yu.decorator;

public abstract class Border extends Display {
	//指装饰框里面的“内容”
	protected Display display;
	protected Border(Display display){
		//在产生对象实例时，以参数指定“内容”
		this.display = display;
	}
}
