package Stringhe;

public class Distance {

	
	public static int levenshtein(String s1, String s2){
		int[][] dist = new int[s1.length()+1][s2.length()+1];
		int n = s1.length()+1;
		int m = s2.length()+1;
		for (int i=0;i<n;i++)
			dist[i][0]=i;
		for (int j=0;j<m;j++)
			dist[0][j]=j;
		for (int i=1;i<n;i++)
			for (int j=1;j<m;j++)
				dist[i][j]= Math.min(dist[i-1][j]+1, 
						Math.min(dist[i][j-1]+1, 
								dist[i-1][j-1]+
								((s1.charAt(i-1)==s2.charAt(j-1))?0:2)));
		return dist[n-1][m-1];
	}
	
	public static void main(String[] args){
		String s1 = "Pippo";
		String s2 = "Paupppo";
		System.out.println(levenshtein(s1,s2));
	}
}