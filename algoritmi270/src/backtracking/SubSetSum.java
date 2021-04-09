package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SubSetSum extends ProblemaBack {
	
	private Integer[] set = {0};
	private int value;
	// in questo vettore si conserveranno le posizioni degli elementi selezionati in set
	private int[] sol;
	
	private Set<Integer> soluzione =  null;
	
	public SubSetSum(Set<Integer> s, int value) {
		set =  s.toArray(set);
		this.value = value;
		sol= new int[set.length];
		for (int i = 0; i<sol.length;i++)
			sol[i]=-1;
	}

	@Override
	protected boolean successivaScelta(int liv) {
		if(sol[liv]>=set.length-1)
			return false;
		sol[liv]++;
		return true;
	}

	@Override
	protected boolean solCompleta(int liv) {
		int somma = 0;
		for(int i=0; i<= liv; i++)
			somma+=set[sol[i]];
		if(somma==value) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean verificaVincoli(int liv) {
		int somma = 0;
		for(int i=0; i<= liv; i++)
			somma+=set[sol[i]];
		if(somma==value || (somma<value && liv<sol.length-1)) return true;
		return false;
	}

	@Override
	protected boolean primaScelta(int liv) {
		if(liv==0) {
			sol[liv]=0;
			return true;
		}
		if(sol[liv-1]>=set.length-1)
		 return false;
		sol[liv] = sol[liv-1]+1;
		return true;
	}

	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		set.add(0);
		set.add(2);
		set.add(5);
		set.add(3);
		set.add(8);
		set.add(1);
		set.add(9);
		int val = 22;
		SubSetSum Prob = new SubSetSum(set, val);
		Prob.risolvi();
		System.out.println(Arrays.toString(Prob.set));
		System.out.println(val);
		System.out.println((Prob.soluzione==null)?"nessuna soluzione":Arrays.toString(Prob.soluzione.toArray()));
	}

	@Override
	protected void costruisciSoluzione(int liv) {
		soluzione = new HashSet<Integer>();
		for(int i=0;i<=liv;i++)
			soluzione.add(set[sol[i]]);
		
	}

}
