package backtracking;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

import grafi.Arco;
import grafi.Grafo;
import grafi.GrafoLista;
import grafi.GrafoMA;

public class NodiCover extends ProblemaBack {
	
	protected int[] removednodes;
	protected Grafo g;
	Set<Integer> nodicover = new LinkedHashSet<Integer>();

	public NodiCover(Grafo g, int maxnodes) {
		super();
		this.g = g;
		removednodes = new int[g.n()-maxnodes];
	}

	@Override
	protected boolean successivaScelta(int liv) {
		if(removednodes[liv]>=g.n()-1)
			return false;
		removednodes[liv]++;
		return true;
	}

	@Override
	protected boolean solCompleta(int liv) {
		// TODO Auto-generated method stub
		return liv==removednodes.length-1;
	}

	@Override
	protected boolean verificaVincoli(int liv) {
		boolean verificati = true;
		for(int i=0; i<=liv&& verificati;i++) {
			Iterator<Arco> it = g.adiacenti(removednodes[i]);
			boolean trovato = false;
			while(it.hasNext()&&!trovato){
				Arco a = it.next();
				int n = a.getFin();
				boolean tt = false;
				for(int j=0;j<liv&&!tt;j++)
					if(a.getFin()==removednodes[j])
						tt=true;
				trovato= !tt;
			}
			verificati=trovato;
		}
		return verificati;
	}

	@Override
	protected boolean primaScelta(int liv) {
		if(liv==0) {
			removednodes[liv]=0;
			return true;
		}
		if(removednodes[liv-1]>=g.n()-1)
		 return false;
		removednodes[liv] = removednodes[liv-1]+1;
		return true;
	}

	@Override
	protected void costruisciSoluzione(int liv) {
		for(int i = 0; i<g.n();i++) nodicover.add(i);
		for(int i = 0; i<=liv;i++)
			nodicover.remove(removednodes[i]);
		

	}

	public static void main(String[] args) {
		Grafo<Arco> g = new GrafoMA<Arco>(7);
		g.aggiungiArco(new Arco(0,1));
		g.aggiungiArco(new Arco(1,0));
		g.aggiungiArco(new Arco(0,2));
		g.aggiungiArco(new Arco(2,0));
		g.aggiungiArco(new Arco(2,1));
		g.aggiungiArco(new Arco(1,2));
		g.aggiungiArco(new Arco(0,4));
		g.aggiungiArco(new Arco(4,0));
		g.aggiungiArco(new Arco(5,6));
		g.aggiungiArco(new Arco(6,5));
		
		NodiCover p = new NodiCover(g,3);
		p.risolvi();
		System.out.println(Arrays.toString(p.removednodes));
		System.out.println(Arrays.toString(p.nodicover.toArray()));

	}

}
