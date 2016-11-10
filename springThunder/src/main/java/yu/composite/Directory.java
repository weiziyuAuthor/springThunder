package yu.composite;

import java.util.Iterator;
import java.util.Vector;

public class Directory extends Entry {

	private String name;
	private Vector directory = new Vector();
	
	public Directory(String name){
		this.name = name;
	}
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getSize() {
		int size = 0;
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			size = size+entry.getSize();
		}
		return size;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix+"/"+this);
		Iterator it = directory.iterator();
		while(it.hasNext()){
			Entry entry = (Entry)it.next();
			entry.printList(prefix+"/"+name);
		}
	}

}
