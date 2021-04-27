package grafi;

import java.util.ArrayList;
import java.util.Iterator;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo<ArcoPesato> g = new GrafoMA<ArcoPesato>(5);
		g.aggiungiArco(new ArcoPesato(0,1,1));
		g.aggiungiArco(new ArcoPesato(0,2,2));
		g.aggiungiArco(new ArcoPesato(0,3,1));
		g.aggiungiArco(new ArcoPesato(1,2,3));
		g.aggiungiArco(new ArcoPesato(1,3,2));
		g.aggiungiArco(new ArcoPesato(2,3,1));
		g.aggiungiArco(new ArcoPesato(2,4,4));// aggiungo archi;
		
		ArrayList<ArcoPesato> archi = g.generaArchiOrdinati();
		System.out.println(archi);
		System.out.println(g.kruskalUF());
	}

}
