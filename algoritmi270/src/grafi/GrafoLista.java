package grafi;
import java.util.*;


public class GrafoLista<A extends Arco> extends Grafo<A> {

	protected ArrayList<Set<A>> M;
	
	public GrafoLista(int n) {
		super(n);
		M = new ArrayList<Set<A>>(n);
		for(int i=0; i<n;i++)
			M.add(i, new HashSet<A>());
	}

	@Override
	public Iterator<A> archi() {
		// TODO Auto-generated method stub
		return new IteratorMio();
	}

	@Override
	public Iterator<A> adiacenti(int v) {
		// TODO Auto-generated method stub
		return M.get(v).iterator();
	}

	@Override
	public void aggiungiArco(A a) {
		boolean aggiunto=M.get(a.getIn()).add(a);
		if(aggiunto)
			m++;
	}

	@Override
	public boolean rimuoviArco(A a) {
		// TODO Auto-generated method stub
		boolean presente=M.get(a.getIn()).remove(a);
		if(presente)
			m--;
		return presente;
	}

	@Override
	public boolean arco(A a) {
		// TODO Auto-generated method stub
		return M.get(a.getIn()).contains(a);
	}

	@Override
	public boolean arco(int v1,int v2) {
		// TODO Auto-generated method stub
		return M.get(v1).contains(new Arco(v1,v2));
	}

	protected class IteratorMio implements Iterator<A>{
		
		Iterator<Set<A>> it = M.iterator();
		Iterator<A> it2 = null;
		boolean hasNext = true;
		A curr = null;
		
		public IteratorMio(){
			if(!it.hasNext()){
				hasNext=false;
			}else{
				it2=it.next().iterator();
			}		
			if(hasNext) avanza();
		}
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return hasNext;
		}

		@Override
		public A next() {
			if(!hasNext) return null;
			A tmp = curr;
			avanza();
			return tmp;
		}
		
		private void avanza(){
			if(it2.hasNext())
				curr = it2.next();
			else{
				while(!it2.hasNext())
					if(it.hasNext()){
						it2 = it.next().iterator();
					}else{
						hasNext=false;
						curr = null;
						return;
					}
				curr = it2.next();
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();			
		}
		;
	};
}
