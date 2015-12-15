package grafi;

import java.util.LinkedList;
import java.util.List;

public abstract class GrafoNO<A extends Arco> extends Grafo<A> {

	public GrafoNO(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public int nComponentiConnesseMassimali(){
		int k = 0;
		boolean[] visitati = new boolean[n()];
		List<Integer> l = new LinkedList<Integer>();
		for(int i=0; i<n();){
			k++;
			depthFirstSearch(i,l,visitati);
			for(i++;i<n()&&visitati[i];i++);
		}
		return k;
	}
	
	
	public boolean eAciclico(){
		int k = nComponentiConnesseMassimali();
		return n()==m()+k;
	}
	
	
	public boolean eAlbero(){
		return n()==m()+1&& eConnesso();
	}

	public boolean eConnesso() {
		// TODO Auto-generated method stub
		return false;
	}
	
	

}
