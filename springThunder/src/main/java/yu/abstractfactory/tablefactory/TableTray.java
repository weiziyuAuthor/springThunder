package yu.abstractfactory.tablefactory;

import java.util.Iterator;

import yu.abstractfactory.factory.Item;
import yu.abstractfactory.factory.Tray;

public class TableTray extends Tray {
	
	public TableTray(String caption){
		super(caption);
	}
	@Override
	public String makeHTML() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("<td>");
		buffer.append("<table with=\"100%\" border=\"1\"><tr>");
		buffer.append("<td bgcolor=\"#cccccc\" align=\"center\" colspan=\""+tray.size()+"\"><br>"+caption+"</b></td>");
		buffer.append("</tr>\n");
		buffer.append("<tr>\n");
		Iterator it = tray.iterator();
		while(it.hasNext()){
			Item item = (Item)it.next();
			buffer.append(item.makeHTML());
		}
		buffer.append("</tr></table>");
		buffer.append("</td>");
		return buffer.toString();
	}

}
