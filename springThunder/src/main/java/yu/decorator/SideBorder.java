package yu.decorator;

public class SideBorder extends Border {
    /**
     * 父类中显示声明了构造方法，子类必须写自己的构造方法
     */
	//装饰字符
	private char borderChar;
	//以构造函数指定Display和装饰字符
	public SideBorder(Display display,char ch){
		super(display);
		this.borderChar = ch;
	}
	@Override
	public int getColumns() {
		return 1+display.getColumns()+1;
	}

	@Override
	public String getRowText(int row) {
		return borderChar +display.getRowText(row)+borderChar;
	}

	@Override
	public int getRows() {
		return display.getRows();
	}

}
