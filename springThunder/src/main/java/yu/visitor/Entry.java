package yu.visitor;

import java.util.Iterator;


public abstract class Entry implements Acceptor {
	
	//取得文件名
	public abstract String getName();
	//取得文件容量
	public abstract int getSize();
	
	public Entry add(Entry entry) throws FileTreatmentException{
		//新增进入点
		throw new FileTreatmentException();
	}
	
	public Iterator iterator() throws FileTreatmentException{
		//产生Iterator
		throw new FileTreatmentException();
	}
	
	public String toString(){
		return getName()+" ("+getSize()+")";
	}
	
	/**
	 * 抽象类继承接口，可以不实现接口
	 */
//	public void acceptor(Visitor v) {
//
//	}

}
