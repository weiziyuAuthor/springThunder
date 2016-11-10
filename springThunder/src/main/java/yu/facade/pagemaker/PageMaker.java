package yu.facade.pagemaker;

import java.io.FileWriter;
import java.io.IOException;

public class PageMaker {
	private PageMaker(){
		
	}
	
	public static void makeWelcomePage(String mailaddr,String filename){
		try {
			java.util.Properties mailprop = Database.getProperties("maildata");
			String username = mailprop.getProperty(mailaddr);
			HtmlWriter writer = new HtmlWriter(new FileWriter(filename));
			writer.title("welcome to "+username+"'s page!");
			writer.paragraph("等你来信哦！");
			writer.mailto(mailaddr, username);
			writer.close();
			System.out.println(filename+" is created for "+mailaddr+" ("+username+")");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
