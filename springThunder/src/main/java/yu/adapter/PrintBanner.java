package yu.adapter;

public class PrintBanner extends Banner implements Print{
	
	public PrintBanner(String string){
		super(string);
	}
	
	public void printStrong() {
		showWithAster();
	}

	public void printWeek() {
		showWithParen();
	}

}
