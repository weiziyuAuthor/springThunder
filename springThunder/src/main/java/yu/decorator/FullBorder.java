package yu.decorator;

public class FullBorder extends Border {
	
	public FullBorder(Display display){
		super(display);
	}
	
	//字数=内容字数+内容两边的装饰字符
	@Override
	public int getColumns() {
		return 1+display.getColumns()+1;
	}

	@Override
	public String getRowText(int row) {
		if(row==0){
			//外框顶端
			return "+"+makeLine('-',display.getColumns())+"+";
		}else if(row == display.getRows()+1){
			//外框底部
			return "+"+makeLine('-',display.getColumns())+"+";
		}else{
			return "|"+display.getRowText(row-1)+"|";
		}
	}
	
	private String makeLine(char ch,int count){
		//以字符ch，建立重复count次的连续字符串
		StringBuffer buf = new StringBuffer();
		for(int i=0;i<count;i++){
			buf.append(ch);
		}
		return buf.toString();
	}
	//行数=内容行数+上下的装饰字符
	@Override
	public int getRows() {
		return 1+display.getRows()+1;
	}

}
