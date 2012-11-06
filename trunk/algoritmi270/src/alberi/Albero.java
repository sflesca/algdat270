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
public interface Albero {
	
	public Object val();
	
	public Albero padre();
	
	public Albero figlio(int pos);
	
	public Iterator<Albero> figli();
	
	public int grado();
	
	public int gradoMax();
	
	public List visitaAnticipata();
	
	public List visitaPosticipata();
	
	public List visitaLivelli();

}
