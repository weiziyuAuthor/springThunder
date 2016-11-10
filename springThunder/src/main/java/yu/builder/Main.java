package yu.builder;

public class Main {
	public static void main(String args[]){
		if(args.length != 1){
			usage();
			System.exit(0);
		}
		if(args[0].equals("plain")){
			Director director = new Director(new TextBuilder());
			String result = (String)director.constructor();
			System.out.println(result);
		}else if(args[0].equals("html")){
			Director director = new Director(new HTMLBuilder());
			String fileName = (String)director.constructor();
			System.out.println("已产生"+fileName+".");
		}else{
			usage();
			System.exit(0);
		}
		
	}
	
	public static void usage(){
		System.out.println("Usage: java Main plain 产生一般格式的文件");
		System.out.println("Usage: java Main html 产生HTML格式的文件");
	}
}
