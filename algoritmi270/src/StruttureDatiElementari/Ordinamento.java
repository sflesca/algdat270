package StruttureDatiElementari;

/**
 * @author sflesca
 *
 */

public class Ordinamento {

	public Ordinamento() {
		// TODO Auto-generated constructor stub
	}
	
	public static void mergeSort(int[] v){
		if (v!= null)
			mergeSort(v,0,v.length-1);
	}

	/**
	 * @param v riveve un vettore di interi non nullo
	 * @param i
	 * @param j
	 */
	private static void mergeSort(int[] v, int in, int fin) {
		if(fin<=in)
			return;
		int med = (in+fin)/2;
		mergeSort(v, in, med);
		mergeSort(v, med+1,fin);
		merge(v,in,med,fin);
		
	}

	private static void merge(int[] v, int in, int med, int fin) {
		int[] stage = new int[fin-in+1];
		int i=in,j=med+1, st=0;
		while((i<=med)&(j<=fin)){
			if(v[i]<v[j])
				stage[st++]=v[i++];
			else
				stage[st++]=v[j++];
		}
		for(;i<=med;i++)
			stage[st++]=v[i];
		for(;j<=fin;j++)
			stage[st++]=v[j];
		for(int k=0; k<stage.length;k++)
			v[in+k]=stage[k];
		
	}

}
