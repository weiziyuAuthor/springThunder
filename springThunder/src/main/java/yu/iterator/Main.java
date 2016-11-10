package yu.iterator;

public class Main {
	public static void main(String args[]){
		BookShelf bookShelf = new BookShelf(4);
		bookShelf.appendBook(new Book("hello book"));
		bookShelf.appendBook(new Book("Flash"));
		bookShelf.appendBook(new Book("Cinderella"));
		bookShelf.appendBook(new Book("Daddy-Long-legs"));
		
		Itetator it = bookShelf.iterator();
		while(it.hasNext()){
			Book book = (Book)it.next();
			System.out.println(""+book.getName());
		}
		
	}
}
