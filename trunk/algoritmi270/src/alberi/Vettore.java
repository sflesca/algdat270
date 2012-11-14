package alberi;

import java.util.Iterator;

public class Vettore<T> {
	
	Object[] items;

	public Vettore(int sizeMax) {
		items =  new Object[sizeMax];
	}

	public void remove(int pos) {
		items[pos]= null;
		
	}
	
	public void set(int pos, T t) {
		items[pos]=t;
		
	}

	public T get(int pos) {
		return (T) items[pos];
	}

	public Iterator<T> iterator() {
		
		return null;
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}



}
