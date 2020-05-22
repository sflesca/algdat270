package StruttureDatiElementari;

public class RicercaBinaria {
	
	/**
	 * Riceve un vettore ordinato di interi v e un intero x e restituisce
	 * la posizione di x in v o -1 se non presente
	 */
	public static int ricercaBinariaRic(int[] v, int x) {
		return ricercaBinariaRic(v,x,0,v.length-1);
	}

	private static int ricercaBinariaRic(int[] v, int x, int inf, int sup) {
		if(sup>inf) return -1;
		int med = (inf+sup)/2;
		if (v[med]==x) return med;
		if (v[med]>x)
			return ricercaBinariaRic(v,x,inf,med-1);
		else
			return ricercaBinariaRic(v,x,med+1,sup);
	}

}
