package yu.abstractfactory.tablefactory;

import yu.abstractfactory.factory.Factory;
import yu.abstractfactory.factory.Link;
import yu.abstractfactory.factory.Page;
import yu.abstractfactory.factory.Tray;

public class TableFactory extends Factory {

	@Override
	public Link createLink(String caption, String url) {
		return new TableLink(caption,url);
	}

	@Override
	public Page createPage(String title, String author) {
		return new TablePage(title,author);
	}

	@Override
	public Tray createTray(String caption) {
		return new TableTray(caption);
	}

}
