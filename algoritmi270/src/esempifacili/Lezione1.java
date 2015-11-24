package esempifacili;

public class Lezione1 {

	public Lezione1() {
		// TODO Auto-generated constructor stub
	}

	
	public static boolean presente(int[] v, int x){
		for(int i =0; i<v.length; i++)
			if(v[i]==x)
				return true;
		return false;
		
	}
	
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
		int[] v = {0,1,2,7,4,5};
		System.out.println(subsetSum(v,6));
		System.out.println(subsetSum(v,20));
	}

}
