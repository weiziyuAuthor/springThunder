package yu.abstractfactory.factory;

public class Main {
	public static void main(String args[]){
		if(args.length != 1){
			System.out.println("Usage: java Main class.name.of.ConcreteFactory");
			System.out.println("Example 1: java Main listFactory.ListFactory");
			System.out.println("Example 2: java Main tableFactory.TableFactory");
			System.exit(0);
		}
		Factory factory = Factory.getFactory(args[0]);
		Link asahi = factory.createLink("朝日新闻", "http://www.asahi.com/");
		Link yomiuri = factory.createLink("读者新闻", "http://www.yomiuri.co.jp/");
		Link us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com/");
		Link jp_yahoo = factory.createLink("Yahoo!Japan", "http://www.yahoo.co.jp/");
		Link excite = factory.createLink("excite", "http://www.excite.com/");
		Link google = factory.createLink("google", "http://www.google.com.hk/");
		
		Tray traynews = factory.createTray("新闻");
		traynews.add(asahi);
		traynews.add(yomiuri);
		
		Tray trayyahoo = factory.createTray("Yahoo!");
		trayyahoo.add(us_yahoo);
		trayyahoo.add(jp_yahoo);
		
		Tray traysearch = factory.createTray("搜索引擎");
		traysearch.add(trayyahoo);
		traysearch.add(excite);
		traysearch.add(google);
		
		Page page = factory.createPage("LinkPage", "ziyu");
		page.add(traynews);
		page.add(traysearch);
		page.output();
		
	}	
}
