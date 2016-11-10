package yu.abstractfactory.factory.listfactory;

import java.util.Iterator;

import yu.abstractfactory.factory.Item;
import yu.abstractfactory.factory.Tray;

public class ListTray extends Tray {
	
	//In superclass,there isn't default construct method
	public ListTray(String caption){
		super(caption);
	}
	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<li>\n");
		buffer.append(caption+"\n");
		buffer.append("<ul>\n");
		Iterator it = tray.iterator();
		while(it.hasNext()){
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</ul>\n");
		buffer.append("</li>\n");
		
		return buffer.toString();
	}

}
