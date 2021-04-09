/**
 * 
 */
package alberi;

import java.util.*;

import alberi.ecccezioni.AlberiDiversiException;

/**
 * @author sflesca
 *
 */
public class AlberoLF<T> implements Albero<T> {

	protected int numMaxFigli;
	protected Vettore<AlberoLF<T>> figli;

	protected AlberoLF<T> padre = null;
	protected int posFiglio = -1;
	protected T val = null;
	
	/**
	 * 
	 */
	public AlberoLF(int numMaxFigli) {
		this.numMaxFigli = numMaxFigli;
		figli = new Vettore<AlberoLF<T>>(numMaxFigli);
	}

	
	
	/**
	 * @param numMaxFigli
	 * @param val
	 */
	public AlberoLF(int numMaxFigli, T val) {
		this.numMaxFigli = numMaxFigli;
		figli = new Vettore<AlberoLF<T>>(numMaxFigli);
		this.val = val;
	}



	/* (non-Javadoc)
	 * @see alberi.Albero#val()
	 */
	@Override
	public T val() {
		// TODO Auto-generated method stub
		return val;
	}
	
	public void setVal(T val) {
		this.val = val;
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#padre()
	 */
	@Override
	public Albero<T> padre() {
		// TODO Auto-generated method stub
		return padre;
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#figlio(int)
	 */
	@Override
	public Albero<T> figlio(int pos) {
		if ((pos>= numMaxFigli)|| (pos<0))
			throw new ArrayIndexOutOfBoundsException();
		return figli.get(pos);
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#figli()
	 */
	@Override
	public Iterator<Albero<T>> figli() {


		return new IteratorFigli(figli.iterator());
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#grado()
	 */
	@Override
	public int grado() {
		return figli.size();
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#gradoMax()
	 */
	@Override
	public int gradoMax() {
		// TODO Auto-generated method stub
		return numMaxFigli;
	}
	
	
	public boolean setFiglio(AlberoLF<T> a, int pos) throws AlberiDiversiException{
		if ((pos>= numMaxFigli)|| (pos<0))
			throw new ArrayIndexOutOfBoundsException();
		if (a==null) return false;
		if (a.gradoMax()!=gradoMax())
			throw new AlberiDiversiException();
		if (figlio(pos)!=null)
			return false;
		if (a.padre()!=null) 
			return false;
		figli.set(pos, a);
		a.padre = this;
		a.posFiglio = pos;
		return true;
	}
	
	public void pota(){
		if (padre!=null){
			padre.figli.remove(posFiglio);
			padre=null;
			posFiglio=-1;
		}
	}
	
	
	protected class IteratorFigli implements Iterator<Albero<T>>{
		
		protected Iterator<AlberoLF<T>> it; 
		
		public IteratorFigli(Iterator<AlberoLF<T>> it){
			this.it = it;
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return it.hasNext();
		}

		@Override
		public Albero<T> next() {
			AlberoLF<T> tmp = it.next();
			return tmp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}


	@Override
	public List<T> visitaAnticipata() {
		List<T> l = new LinkedList<T>();
		visitaAnticipata(l);
		return l;
	}
	
	private void visitaAnticipata(List<T> l){
		l.add(val());
		Iterator<Albero<T>> it = figli();
		while(it.hasNext()){
			((AlberoLF<T>) it.next()).visitaAnticipata(l);
		}
		
	}



	@Override
	public List<T> visitaPosticipata() {
		List<T> l = new LinkedList<T>();
		visitaPosticipata(l);
		return l;
	}

	private void visitaPosticipata(List<T> l){
		Iterator<Albero<T>> it = figli();
		while(it.hasNext()){
			((AlberoLF<T>) it.next()).visitaPosticipata(l);
		}
		l.add(val());
	}

	@Override
	public List<T> visitaLivelli() {
		List<T> ris = new LinkedList<T>();
		Queue<Albero<T>> daVisitare = new LinkedList<Albero<T>>();
		daVisitare.offer(this);
		while(!daVisitare.isEmpty()){
			Albero<T> curr = daVisitare.poll();
			ris.add(curr.val());
			Iterator<Albero<T>> itFigli = curr.figli();
			while(itFigli.hasNext())
				daVisitare.offer(itFigli.next());
		}
		return ris;
	}

}
