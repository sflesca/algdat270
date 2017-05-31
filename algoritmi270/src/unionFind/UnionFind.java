package unionFind;

import java.util.HashMap;

public class UnionFind {
	private UnionSet[] elem2Set;
	
	public UnionFind(int n){
		elem2Set =  new UnionSet[n];
		for(int i=0;i<elem2Set.length;i++){
			elem2Set[i] = new UnionSet(i);
			elem2Set[i].add(i);
		}
	}
	
	public UnionSet find(int x){
		return elem2Set[x];
	}
	
	public UnionSet merge(UnionSet a, UnionSet b){
		if (a.size()<b.size()){
			UnionSet x= a;
			a=b;
			b=x;
		}
		for(int i:b.figli){
			a.add(i);
			elem2Set[i]=a;
		}

		return a;
	}

}
