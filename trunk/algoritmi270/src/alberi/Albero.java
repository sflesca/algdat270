/**
 * 
 */
package alberi;

import java.util.Iterator;
import java.util.List;

/**
 * @author sflesca
 *
 */
public interface Albero<T> {
	
	public T val();
	
	public Albero<T> padre();
	
	public Albero<T> figlio(int pos);
	
	public Iterator<Albero<T>> figli();
	
	public int grado();
	
	public int gradoMax();
	
	public List<T> visitaAnticipata();
	
	public List<T> visitaPosticipata();
	
	public List<T> visitaLivelli();

}
