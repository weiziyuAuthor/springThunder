package yu.abstractfactory.factory.listfactory;

import yu.abstractfactory.factory.Factory;
import yu.abstractfactory.factory.Link;
import yu.abstractfactory.factory.Page;
import yu.abstractfactory.factory.Tray;

public class ListFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		return new ListLink(caption,url);
	}

	@Override
	public Page createPage(String title, String author) {
		return new ListPage(title,author);
	}

	@Override
	public Tray createTray(String caption) {
		return new ListTray(caption);
	}

}
