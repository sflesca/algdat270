/**
 * 
 */
package alberi;

import java.util.*;

/**
 * @author sflesca
 *
 */
public interface AlberoBin extends Albero{
	
	public AlberoBin padreBin();
	
	public AlberoBin sin();
	
	public AlberoBin des();
	
	public List visitaInfissa();
	
	public Iterator iteratorVI();

}
