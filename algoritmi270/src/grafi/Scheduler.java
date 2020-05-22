/**
 * 
 */
package grafi;

import java.util.*;

/**
 * @author sflesca
 *
 */
public class Scheduler {

	Grafo<Arco> g;
	int[] activityTimes;
	
	/**
	 * 
	 */
	public Scheduler(Grafo<Arco> g, int[] activityTimes) {
		this.g=g;
		this.activityTimes = activityTimes;
	}
	
	int[] schedule(){
		int[] startTimes = new int[g.getN()];
		Arrays.fill(startTimes, 0);
		int[] gradi = calcolaGradiEntrata();
		boolean[] eseguiti = new boolean[g.getN()];
		Arrays.fill(eseguiti, false);
		Queue<Integer> darimuovere = new LinkedList<Integer>();
		for(int i= 0; i<gradi.length; i++)
			if(gradi[i]==0)
				darimuovere.offer(i);
		while(!darimuovere.isEmpty()){
			int a = darimuovere.poll();
			eseguiti[a]=true;
			Iterator<Arco> it = g.adiacenti(a);
			while (it.hasNext()){
				Arco succAtt = it.next();
				if(startTimes[succAtt.getFin()]<startTimes[a]+activityTimes[a])
					startTimes[succAtt.getFin()]=startTimes[a]+activityTimes[a];
				gradi[succAtt.getFin()]--;
				if (gradi[succAtt.getFin()]==0)
					darimuovere.offer(succAtt.getFin());
			}
			
		}
		if(!tuttoVero(eseguiti))
			return null;
		return startTimes;
	}
	
	private boolean tuttoVero(boolean[] eseguiti) {
		for(boolean b:eseguiti)
			if(!b) return false;
		return true;
	}

	private int[] calcolaGradiEntrata() {
		int[] gradi = new int[g.getN()];
		Iterator<Arco> it = g.archi();
		while(it.hasNext())
			gradi[it.next().getFin()]++;
		return gradi;
	}

	public static void main(String[] args){
		Grafo<Arco> g = new GrafoLista<Arco>(5);
		g.aggiungiArco(new Arco(0,1));
		g.aggiungiArco(new Arco(0,4));
		g.aggiungiArco(new Arco(1,4));
		g.aggiungiArco(new Arco(2,0));
		g.aggiungiArco(new Arco(3,0));
		g.aggiungiArco(new Arco(3,1));
		//g.aggiungiArco(new Arco(1,3));
		int[] tempi = {2, 4, 5, 1, 2 };
		Scheduler s = new Scheduler(g,tempi);
		int[] tempipartenza = s.schedule();
		if (tempipartenza!=null)
			System.out.println(Arrays.toString(tempipartenza));
		else System.out.println("Propedeuticità cicliche");
	}

}
