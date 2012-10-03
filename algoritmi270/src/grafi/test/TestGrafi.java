/**
 * 
 */
package grafi.test;

import java.util.Iterator;

import grafi.*;

/**
 * @author sflesca
 *
 */
public class TestGrafi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Grafo<Arco> g = new GrafoMA<Arco>(5);
		g.aggiungiArco(new Arco(0,1));
		g.aggiungiArco(new Arco(0,4));
		g.aggiungiArco(new Arco(1,4));
		g.aggiungiArco(new Arco(2,0));
		g.aggiungiArco(new Arco(3,0));
		g.aggiungiArco(new Arco(3,1));
		
//		Iterator<Arco> it = g.adiacenti(0);
//		while(it.hasNext())
//			System.out.println(it.next().toString());
		Iterator<Arco> it = g.archi();
		while(it.hasNext())
			System.out.println(it.next());
		//System.out.println(g.depthFirstSearch(3));
		//System.out.println(g.breadthFirstSearch(3));
		System.out.println(g.dijkstra(3));
		double[][] dist=g.floydWarshall();
		for(int i=0;i<5;i++)
		{	for(int j=0;j<5;j++)
				System.out.print(dist[i][j]+" ");
			System.out.println();
		}
//		
//		Grafo<ArcoPesato> gp = new GrafoLista<ArcoPesato>(5);
//		gp.aggiungiArco(new ArcoPesato(0,1,2.0));
//		gp.aggiungiArco(new ArcoPesato(0,4,3.5));
//		gp.aggiungiArco(new ArcoPesato(1,4,5.5));
//		gp.aggiungiArco(new ArcoPesato(2,0,7.5));
//		gp.aggiungiArco(new ArcoPesato(3,0,1.5));
//		gp.aggiungiArco(new ArcoPesato(3,1,4.0));
//		
//		Iterator<ArcoPesato> itp = gp.archi();
//		while(itp.hasNext())
//			System.out.println(itp.next());
//		
//		System.out.println(gp.depthFirstSearch(3));
//		System.out.println(gp.breadthFirstSearch(3));
//		System.out.println(gp.dijkstra(3));
	}

}
