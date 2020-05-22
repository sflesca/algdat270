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
	
	public abstract Iterator<A> archi();//MATRICE: theta(n^2) 
										//LISTA: theta(n+m)
	
	public abstract Iterator<A> adiacenti(int v); 	//MATRICE: theta(n) 
													//LISTA: theta(gout(v))

	public abstract void aggiungiArco(A a);// MATRICE: theta(1)

	public abstract boolean rimuoviArco(A a);// MATRICE: theta(1)

	public abstract boolean arco(A a);// MATRICE: theta(1) 

	public abstract boolean arco(int v1, int v2);// MATRICE: theta(1)


	// SPAZIALE O(n)
	public List<Integer> depthFirstSearch(int nodoPartenza)
	{	List<Integer> risultato=new ArrayList<Integer>();
		boolean[] marcati=new boolean[n];
		for(int i=0;i<n;i++)
			marcati[i]=false;
		depthFirstSearch(nodoPartenza, risultato, marcati);
		return risultato;
	}
	
	
	// MATR. Theta(n^2) LISTA Theta(m)
	// SPAZIALE Theta(n)
	protected void depthFirstSearch(int nodoPartenza, List<Integer> risultato, 
			boolean[] visitati)
	{	risultato.add(nodoPartenza);  							//theta(1)
		visitati[nodoPartenza]=true;  							//theta(1)
		Iterator<A> itAdiacenti=adiacenti(nodoPartenza);		//theta(1)
		while(itAdiacenti.hasNext())							// MATR. Theta(n) LISTA Theta(gout(n))
		{	int ad=itAdiacenti.next().getFin();
			if(!visitati[ad])
				depthFirstSearch(ad,risultato,visitati);
		}
	}
	
	// MATR. Theta(n^2) LISTA Theta(m)
	// SPAZIALE O(n)
	public List<Integer> breadthFirstSearch(int nodoPartenza)
	{	ArrayList<Integer> risultato=new ArrayList<Integer>();
		boolean[] visitati=new boolean[n];
		for(int i=0;i<n;i++)
			visitati[i]=false;
		Queue<Integer> coda=new LinkedList<Integer>();
		risultato.add(nodoPartenza);
		visitati[nodoPartenza]=true;
		coda.offer(nodoPartenza);
		while(!coda.isEmpty())  // viene iterato n volte
		{	int nodo=coda.poll();
			Iterator<A> itAdiacenti=adiacenti(nodo);
			while(itAdiacenti.hasNext())						// MATR. Theta(n) LISTA Theta(gout(n))
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
	
	
	//Theta(n^2)
	//SPAZIALE  Theta(n)
	public boolean eAciclicoGO(){ 
		int[] gradi = calcolaGradiEntrata(); // MATR. theta(n^2) LISTA Theta(n+m)
		boolean[] rimossi = new boolean[n()]; 
		int daRimuovere = cercaNodoGradoZeroNonRimosso(gradi, rimossi); //Theta(n)
		while(daRimuovere!=-1){ // per tutti i nodi - n volte  //Theta(n^2)
			//RIMUOVIAMO IL NODO daRimuovere
			rimossi[daRimuovere]= true;
			Iterator<A> it = adiacenti(daRimuovere);
			while (it.hasNext())							// MATR. Theta(n) LISTA Theta(gout(daTrimuovere))
				gradi[it.next().getFin()]--; 
			
			//CERCHIAMO IL PROX NODO DA RIMUOVERE
			daRimuovere = cercaNodoGradoZeroNonRimosso(gradi, rimossi); // Theta(n)
		}
		if (tuttiRimossi(rimossi))	// theta(n)
			return true;
		return false;
	}
	
	private int[] calcolaGradiEntrata() {
		int[] gradi = new int[n()];
		Iterator<A> it = archi();
		while (it.hasNext())
			gradi[it.next().getFin()]++;
		return gradi;
	}

	private boolean tuttiRimossi(boolean[] rimossi) {
		for(int i=0; i<rimossi.length;i++)
			if(!rimossi[i])
				return false;
		return true;
	}

	private int cercaNodoGradoZeroNonRimosso(int[] gradi, boolean[] rimossi) {
		for(int i= 0; i<gradi.length; i++)
			if(!rimossi[i]&&(gradi[i]==0))
				return i;
		return -1;
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
					if(nuovaDist<distanze[a.getFin()]){
						distanze[a.getFin()]=nuovaDist;
						padri[a.getFin()]=nodoCorrente;
					}
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
	
	public Grafo<ArcoPesato> kruskal(){ // theta( m n) || (union find) theta(m lg n)
		ArcoPesato[] archi = generaArchiOrdinati(); // theta(m lg n) || theta(n^2 + m lg n)
		int inseriti = 0;
		GrafoLista<ArcoPesato> albero = new GrafoLista<ArcoPesato>(n());
		// creare union find - theta(n)
		
		//theta (m + n lg n)
		for(int i=0; (i<archi.length)&& (inseriti<n()-1); i++){ // m volte
			List<Integer> lista = albero.depthFirstSearch(archi[i].getIn()); // theta(n) || theta (n^2)
			// 2 find theta(1)
			if (!lista.contains(archi[i].getFin())){ // theta(1)
				albero.aggiungiArco(archi[i]); // theta(1)
				inseriti++; // theta(1)
				// union degli insiemi che contengono archi[i].getFin()
				// e archi[i].getIn() - theta(n)
				// complessivamente facciamo n-1 union che hanno un costo theta(n lg n)
			}
		}
		if (inseriti==n()-1)
			return albero;
		return null;
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
