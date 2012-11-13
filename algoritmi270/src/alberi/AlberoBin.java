/**
 * 
 */
package alberi;

import java.util.*;

/**
 * @author sflesca
 *
 */
public interface AlberoBin<T> extends Albero<T>{
	
	public AlberoBin<T> padreBin();
	
	public AlberoBin<T> sin();
	
	public AlberoBin<T> des();
	
	public List<T> visitaInfissa();
	
	public Iterator<T> iteratorVI();

}
