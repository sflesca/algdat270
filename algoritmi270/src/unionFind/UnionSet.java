package unionFind;

import java.util.ArrayList;

public class UnionSet {
	private String name;
	protected ArrayList<Integer> figli = new ArrayList<Integer>();
	
	public UnionSet(int name) {
		super();
		this.name = "S"+name;
	}


	public int size(){
		return figli.size();
	}
	

	public void add(int i){
		figli.add(i);
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UnionSet [name=" + name + ", figli=" + figli.toString() + "]";
	}



	
}
