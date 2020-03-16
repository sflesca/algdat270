package esempifacili;

import java.util.Arrays;

public class Lezione1 {

	public Lezione1() {
		// TODO Auto-generated constructor stub
	}

	
	// lato matrice n
	// dimensioni interi b
	// dimensione dell'input b * n^2
	// parametro rappresentativo della dimensione dell'input n
	public static int[][] sommaMatriciQuadrate(int[][] A, int[][] B){
		if((A.length!=A[0].length)||(A.length!=B.length)||(A[0].length!=B[0].length))
			throw new RuntimeException();
		int[][] res = new int[A.length][A[0].length];
		for(int i = 0; i<A.length; i++) // proporzionali a n
			for(int j = 0;j<A[0].length;j++) // proporzionali a n
				res[i][j] = A[i][j]+B[i][j]; // proporzionale a n*n complessità theta(n^2)
		return res;
	}
	
	// lato matrice n
	// dimensioni interi b
	// dimensione dell'input b * n^2 D = n^2 => n=D^(1/2) theta(n^3) => theta((D^(1/2))^3) = theta(D^(3/2))
	// parametro rappresentativo della dimensione dell'input n
	public static int[][] prodottoMatriciQuadrate(int[][] A, int[][] B){
		if((A.length!=A[0].length)||(A.length!=B.length)||(A[0].length!=B[0].length))
			throw new RuntimeException();
		int[][] res = new int[A.length][A[0].length];
		for(int i = 0; i<A.length; i++) // proporzionali a n
			for(int j = 0;j<B[0].length;j++) { // proporzionali a n
				res[i][j] =0;
				for(int k=0; k<A.length;k++) // proporzionali a n complessità theta(n^3)
					res[i][j] += A[i][k]*B[k][j];
			}
		return res;
	}
	
	
	// n (dimensione dell'input) è il numero di celle in v
	// caso migliore 4 istruzioni Theta(1)
	// caso peggiore 3 + 3 *n Theta(n)----- theta(n)
	public static boolean presente(int[] v, int x){ 
		for(int i =0; i<v.length; i++) 
			if(v[i]==x)
				return true;
		return false;
	}
	
	
	// dim input D = lg_2(n) => n = 2^D
	// complessità spaziale theta(n) => theta(2^D)
	public static int fatt(int n){
		if (n<=1) return 1;
		return n* fatt(n-1);
	}
	
	public static int fattIt(int n){
		int fatt = 1;                     //theta(1)
		for (int i=1;i<=n;i++)	          //theta(lg(n) ) -> theta(n * lg(n))
			fatt= fatt*i;                 //theta(lg(fatt)) -> theta(n^2 * lg(n))
		return fatt;                      //theta(lg(fatt))
	}
	
	public static int fibRic(int n){
		if(n<=1) return 1;
		return fibRic(n-1)+fibRic(n-2);
	}
	
	public static boolean subsetSum(int[] v, int x){
		// genera primo sottoinsieme
		boolean[] vbol = new boolean[v.length];
		while(!tuttiveri(vbol)){
			if (somma(v,vbol)==x)return true;
			inc(vbol);
		}
		if (somma(v,vbol)==x)return true;
		return false;
	}
	
	private static void inc(boolean[] vbol) {
		boolean riporto= true;
		int i=0;
		while(riporto&&i<vbol.length){
			if(vbol[i])
				vbol[i]=false;
			else{
				vbol[i]=true;
				riporto=false;
			}
			i++;}
				
		
	}


	private static int somma(int[] v, boolean[] vbol) {
		int somma = 0;
		for(int i=0;i<vbol.length;i++)
			if(vbol[i])
				somma+=v[i];
		return somma;
	}


	private static boolean tuttiveri(boolean[] vbol) {
		for(int i=0;i<vbol.length;i++)
			if(!vbol[i])
				return false;
		return true;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		int f = fibRic(5);
		System.out.println(f);
		
//		int[][] A = {{0,1,2},
//					 {1,2,3},
//					 {2,3,4}};
//		int[][] B = {{0,1,2},
//					 {1,2,3},
//					 {2,3,4}};
//		
//		int[][] R = sommaMatriciQuadrate(A,B);
//		System.out.println(Arrays.deepToString(R));
//		
//		R = prodottoMatriciQuadrate(A,B);
//		System.out.println(Arrays.deepToString(R));
		
//		int[] v = {0,1,2,7,4,5};
//		System.out.println(subsetSum(v,6));
//		System.out.println(subsetSum(v,20));
	}

}
