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
		int fatt = 1;
		for (int i=1;i<=n;i++)
			fatt= fatt*i;
		return fatt;
	}
	
	public static int fibRic(int n){
		if(n<1) return 1;
		return fibRic(n-1)+fibRic(n-2);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] v = {0,1,2,7,4,5};
		int x = fatt(6);
		System.out.println(x);
		int y = fibRic(7);
		System.out.println(y);
	}

}
