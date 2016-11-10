package yu.decorator;

public class StringDisplay extends Display {
	private String string;
	public StringDisplay(String string){
		this.string = string;
	}
	
	@Override
	public int getColumns() {
		return string.getBytes().length;
	}

	@Override
	public String getRowText(int row) {
		if(row == 0){
			return string;
		}else{
			return null;	
		}
		
	}

	@Override
	public int getRows() {
		return 1;
	}

}
