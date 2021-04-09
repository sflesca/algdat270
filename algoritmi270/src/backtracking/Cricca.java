/**
 * 
 */
package backtracking;

import java.util.Arrays;

import grafi.*;

/**
 * @author sflesca
 *
 */
public class Cricca extends ProblemaBack {
	
	protected int[] nodes;
	protected Grafo g;

	/**
	 * 
	 */
	public Cricca(Grafo g, int k) {
		this.g=g;
		nodes = new int[k];
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#successivaScelta(int)
	 */
	@Override
	protected boolean successivaScelta(int liv) {
		if (nodes[liv]>=g.getN()-1)	return false;
		nodes[liv]++;
		return true;
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#solCompleta(int)
	 */
	@Override
	protected boolean solCompleta(int liv) {
		// TODO Auto-generated method stub
		return liv==nodes.length-1;
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#verificaVincoli(int)
	 */
	@Override
	protected boolean verificaVincoli(int liv) {
		System.out.println("VERIFICAVINCOLI"+Arrays.toString(nodes)+" LIV:"+liv);
		for(int i=0; i<liv; i++)
			if(!g.arco(nodes[i], nodes[liv]))
				return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see backtracking.ProblemaBack#primaScelta(int)
	 */
	@Override
	protected boolean primaScelta(int liv) {
		if(liv==0){
			nodes[liv]=0;
			return true;
		}
		if (nodes[liv-1]>=g.getN()-1) return false;
		nodes[liv]=nodes[liv-1]+1;
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grafo<Arco> g = new GrafoMA<Arco>(7);
		g.aggiungiArco(new Arco(0,6));
		g.aggiungiArco(new Arco(6,0));
		g.aggiungiArco(new Arco(0,5));
		g.aggiungiArco(new Arco(5,0));
		g.aggiungiArco(new Arco(5,6));
		g.aggiungiArco(new Arco(6,5));
		g.aggiungiArco(new Arco(0,4));
		g.aggiungiArco(new Arco(4,0));
		g.aggiungiArco(new Arco(2,1));
		g.aggiungiArco(new Arco(1,2));
		
		Cricca c = new Cricca(g,3);
		System.out.println("Esiste:"+c.risolvi());
		System.out.println(Arrays.toString(c.nodes));
	}

	@Override
	protected void costruisciSoluzione(int liv) {
		// TODO Auto-generated method stub
		return;
	}

}
