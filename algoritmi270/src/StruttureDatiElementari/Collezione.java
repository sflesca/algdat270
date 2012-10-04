package StruttureDatiElementari;

import java.util.Iterator;

/**
 * @author sflesca
 * 
 * DA COMPLETARE
 *
 */
public interface Collezione<T> {
	
	public void add(T o);
	
	public void addAll(Collezione<T> c);

	public boolean	contains(T o);
	
	public boolean	containsAll(Collezione<T> c);
	
	public boolean	isEmpty();
	
	public Iterator<T>	iterator();
	
	public boolean	remove(T o); 
	
	public int	size();
	
	public T[]	toArray();
}
