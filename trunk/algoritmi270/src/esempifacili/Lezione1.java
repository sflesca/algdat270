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
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] v = {0,1,2,7,4,5};
		System.out.println(presente(v,3));

	}

}
