package yu.observer;

import java.util.Iterator;
import java.util.Vector;

public abstract class NumberGenerator {
	//存储observer
	private Vector observers = new Vector();
	//新增observer
	public void addobserver(Observer observer){
		observers.add(observer);
	}
	
	//删除observer
	public void deleteObserver(Observer observer){
		observers.remove(observer);
	}
	
	//通知observer
	public void notifyObservers(){
		Iterator it = observers.iterator();
		while(it.hasNext()){
			Observer o = (Observer)it.next();
			o.update(this);
		}
	}
	
	//取得数值
	public abstract int getNumber();
	
	//产生数值
	public abstract void execute();
}
