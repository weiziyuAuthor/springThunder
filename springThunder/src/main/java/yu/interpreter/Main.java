package yu.interpreter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			java.io.BufferedReader br = new BufferedReader(new FileReader("E:\\workspace\\PATTERNS\\src\\yu\\interpreter\\program.txt"));
			String text;
			while((text = br.readLine())!= null){
				System.out.println("text = \""+text+"\"");
				Node node = new ProgramNode();
				node.parse(new Context(text));
				System.out.println("node = "+node);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}

}
