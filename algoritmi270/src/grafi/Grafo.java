package grafi;

import java.util.*;

/**
 * 
 */

/**
 * @author sflesca
 * 
 */
public abstract class Grafo<A extends Arco> {

	protected int n;
	protected int m;

	/**
	 * 
	 */
	public Grafo(int n) {
		this.n = n;
		this.m = 0;
	}
	
	public int n(){
		return n;
	}
	
	public int m(){
		return m;
	}
	
	public abstract Iterator<A> archi();

	public abstract Iterator<A> adiacenti(int v);

	public abstract void aggiungiArco(A a);

	public abstract boolean rimuoviArco(A a);

	public abstract boolean arco(A a);

	public abstract boolean arco(int v1, int v2);

	protected void depthFirstSearch(int nodoPartenza, List<Integer> risultato, boolean[] visitati)
	{	risultato.add(nodoPartenza);
		visitati[nodoPartenza]=true;
		Iterator<A> itAdiacenti=adiacenti(nodoPartenza);
		while(itAdiacenti.hasNext())
		{	int ad=itAdiacenti.next().getFin();
			if(!visitati[ad])
				depthFirstSearch(ad,risultato,visitati);
		}
	}
	
	public List<Integer> depthFirstSearch(int nodoPartenza)
	{	List<Integer> risultato=new ArrayList<Integer>();
		boolean[] marcati=new boolean[n];
		for(int i=0;i<n;i++)
			marcati[i]=false;
		depthFirstSearch(nodoPartenza, risultato, marcati);
		return risultato;
	}
	
	public List<Integer> breadthFirstSearch(int nodoPartenza)
	{	ArrayList<Integer> risultato=new ArrayList<Integer>();
		boolean[] visitati=new boolean[n];
		for(int i=0;i<n;i++)
			visitati[i]=false;
		Queue<Integer> coda=new LinkedList<Integer>();
		risultato.add(nodoPartenza);
		visitati[nodoPartenza]=true;
		coda.offer(nodoPartenza);
		while(!coda.isEmpty())
		{	int nodo=coda.poll();
			Iterator<A> itAdiacenti=adiacenti(nodo);
			while(itAdiacenti.hasNext())
			{	int ad=itAdiacenti.next().getFin();
				if(!visitati[ad])
				{	risultato.add(ad);
					visitati[ad]=true;
					coda.offer(ad);
				}
			}
		}
		return risultato;		
	}
	
	public List<Double> dijkstra(int nodoPartenza)
	{	Double[] distanze=new Double[n];
		for(int i=0;i<n;i++)
			distanze[i]=Double.POSITIVE_INFINITY;
		boolean[] raggiunti=new boolean[n];
		for(int i=0;i<n;i++)
			raggiunti[i]=false;
		distanze[nodoPartenza]=0.0;
		int nodoCorrente=nodoPartenza;
		while(nodoCorrente!=-1)
		{	raggiunti[nodoCorrente]=true;
			Iterator<A> adnn=adiacenti(nodoCorrente);
			while(adnn.hasNext())
			{	A a=adnn.next();
				if(!raggiunti[a.getFin()])
				{	double nuovaDist=distanze[nodoCorrente]+pesoArco(a);
					if(nuovaDist<distanze[a.getFin()])
						distanze[a.getFin()]=nuovaDist;
				}
			}
			nodoCorrente=-1;
			double minPeso=Double.POSITIVE_INFINITY;
			for(int i=0;i<n;i++)
				if(!raggiunti[i] && distanze[i]<minPeso)
				{	nodoCorrente=i;
					minPeso=distanze[i];
				}
		}
		return Arrays.asList(distanze);
	}
	
	public List<Double> prim()
	{	int nodoPartenza=0;
		Double[] distanze=new Double[n];
		for(int i=0;i<n;i++)
			distanze[i]=Double.POSITIVE_INFINITY;
		boolean[] raggiunti=new boolean[n];
		for(int i=0;i<n;i++)
			raggiunti[i]=false;
		int[] padri = new int[n()];
		distanze[nodoPartenza]=0.0;
		padri[0]=0;
		int nodoCorrente=nodoPartenza;
		while(nodoCorrente!=-1)
		{	raggiunti[nodoCorrente]=true;
			Iterator<A> adnn=adiacenti(nodoCorrente);
			while(adnn.hasNext())
			{	A a=adnn.next();
				if(!raggiunti[a.getFin()])
				{	double nuovaDist=pesoArco(a);
					if(nuovaDist<distanze[a.getFin()])
						distanze[a.getFin()]=nuovaDist;
						padri[a.getFin()]=nodoCorrente;
				}
			}
			nodoCorrente=-1;
			double minPeso=Double.POSITIVE_INFINITY;
			for(int i=0;i<n;i++)
				if(!raggiunti[i] && distanze[i]<minPeso)
				{	nodoCorrente=i;
					minPeso=distanze[i];
				}
		}
		return Arrays.asList(distanze);
	}
	
	public Grafo<ArcoPesato> kruskal(){
		ArcoPesato[] archi = generaArchiOrdinati();
		int inseriti = 0;
		GrafoLista<ArcoPesato> albero = new GrafoLista<ArcoPesato>(n());
		for(int i=0; (i<archi.length)&& (inseriti<n()-1); i++){
			List<Integer> lista = albero.depthFirstSearch(archi[i].getIn());
			if (!lista.contains(archi[i].getFin())){
				albero.aggiungiArco(archi[i]);
				inseriti++; 
			}
		}
		return albero;
	}
	
	private ArcoPesato[] generaArchiOrdinati() {
		// TODO Auto-generated method stub
		return null;
	}

	public double[][] floydWarshall()
	{	double[][] distanze=new double[n][n];
		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++)
				if(i==j)
					distanze[i][j]=0;
				else
					distanze[i][j]=Double.POSITIVE_INFINITY;
		Iterator<A> it=archi();
		while(it.hasNext())
		{	A a=it.next();
			distanze[a.getIn()][a.getFin()]=pesoArco(a);
		}
		for(int k=0;k<n;k++)
			for(int i=0;i<n;i++)
				for(int j=0;j<n;j++)
					if(distanze[i][j]>distanze[i][k]+distanze[k][j])
						distanze[i][j]=distanze[i][k]+distanze[k][j];
		return distanze;
	}
	
	protected double pesoArco(A a)
	{	if(a instanceof ArcoPesato)
			return ((ArcoPesato)a).getPeso();
		return 1.0;
	}

	public int getN() {
		return n;
	}

	public int getM() {
		return m;
	}
	
	
}
