package yu.iterator;

public class BookShelfIterator implements Itetator{
	private BookShelf bookShelf;
	private int index;
	public BookShelfIterator(BookShelf bookShelf){
		this.bookShelf = bookShelf;
	}
	
	
	public boolean hasNext() {
		if(index<bookShelf.getLength()){
			return true;
		}else{
			return false;
		}
		
	}

	public Object next() {
		Book book = bookShelf.getBookAt(index);
		index++;
		return book;
	}

}
