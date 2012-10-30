/**
 * 
 */
package alberi;

import java.util.Iterator;

/**
 * @author sflesca
 *
 */
public interface Albero {
	
	public Object val();
	
	public Albero padre();
	
	public Albero figlio(int pos);
	
	public Iterator<Albero> figli();
	
	public int grado();
	
	public int gradoMax();

}
