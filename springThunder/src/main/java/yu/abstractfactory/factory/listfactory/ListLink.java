package yu.abstractfactory.factory.listfactory;

import yu.abstractfactory.factory.Link;

public class ListLink extends Link {
	//In superclass,there isn't default construct method
	public ListLink(String caption,String url){
		super(caption,url);
	}
	@Override
	public String makeHTML() {
		return " <li><a href=\""+url+"\">"+caption+"</a></li>\n";
	}

}
