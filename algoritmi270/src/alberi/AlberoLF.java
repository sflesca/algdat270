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
public class AlberoLF implements Albero {

	protected int numMaxFigli;
	protected AlberoLF[] figli;
	protected AlberoLF padre = null;
	protected int posFiglio = -1;
	protected Object val = null;
	
	/**
	 * 
	 */
	public AlberoLF(int numMaxFigli) {
		this.numMaxFigli = numMaxFigli;
		figli = new AlberoLF[numMaxFigli];
	}

	
	
	/**
	 * @param numMaxFigli
	 * @param val
	 */
	public AlberoLF(int numMaxFigli, Object val) {
		this.numMaxFigli = numMaxFigli;
		figli = new AlberoLF[numMaxFigli];
		this.val = val;
	}



	/* (non-Javadoc)
	 * @see alberi.Albero#val()
	 */
	@Override
	public Object val() {
		// TODO Auto-generated method stub
		return val;
	}
	
	public void setVal(Object val) {
		this.val = val;
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#padre()
	 */
	@Override
	public Albero padre() {
		// TODO Auto-generated method stub
		return padre;
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#figlio(int)
	 */
	@Override
	public Albero figlio(int pos) {
		if ((pos>= numMaxFigli)|| (pos<0))
			throw new ArrayIndexOutOfBoundsException();
		return figli[pos];
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#figli()
	 */
	@Override
	public Iterator<Albero> figli() {


		return new IteratorFigli();
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#grado()
	 */
	@Override
	public int grado() {
		int grado = 0;
		for(int i=0;i<figli.length; i++)
			if(figli[i]!=null) grado++;
		return grado;
	}

	/* (non-Javadoc)
	 * @see alberi.Albero#gradoMax()
	 */
	@Override
	public int gradoMax() {
		// TODO Auto-generated method stub
		return numMaxFigli;
	}
	
	
	public boolean setFiglio(AlberoLF a, int pos) throws AlberiDiversiException{
		if ((pos>= numMaxFigli)|| (pos<0))
			throw new ArrayIndexOutOfBoundsException();
		if (a==null) return true;
		if (a.gradoMax()!=gradoMax())
			throw new AlberiDiversiException();
		if (figlio(pos)!=null)
			return false;
		figli[pos] = a;
		AlberoLF aa = (AlberoLF) a;
		aa.padre = this;
		aa.posFiglio = pos;
		return true;
	}
	
	public void pota(){
		if (padre!=null){
			padre.figli[posFiglio]=null;
			padre=null;
			posFiglio=-1;
		}
	}
	
	
	protected class IteratorFigli implements Iterator{
		
		protected int curr = -1;
		protected boolean hasNext = false;
		
		public IteratorFigli(){
			succ();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return hasNext;
		}

		@Override
		public Object next() {
			if (!hasNext()) return null;
			Object tmp = figli[curr];
			succ();
			return tmp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
		private void succ(){
			for(curr++; curr<figli.length;curr++)
				if(figli[curr]!=null){
					hasNext=true;
					break;
				}
		}
	}


	@Override
	public List visitaAnticipata() {
		List l = new LinkedList();
		visitaAnticipata(l);
		return l;
	}
	
	private void visitaAnticipata(List l){
		Iterator<Albero> it = figli();
		while(it.hasNext()){
			((AlberoLF) it.next()).visitaAnticipata(l);
		}
		l.add(val());
	}



	@Override
	public List visitaPosticipata() {
		List l = new LinkedList();
		visitaPosticipata(l);
		return l;
	}

	private void visitaPosticipata(List l){
		Iterator<Albero> it = figli();
		l.add(val());
		while(it.hasNext()){
			((AlberoLF) it.next()).visitaAnticipata(l);
		}

	}

	@Override
	public List visitaLivelli() {
		List ris = new LinkedList();
		Queue<Albero> daVisitare = new LinkedList<Albero>();
		daVisitare.offer(this);
		while(!daVisitare.isEmpty()){
			Albero curr = daVisitare.poll();
			ris.add(curr.val());
			Iterator<Albero> itFigli = curr.figli();
			while(itFigli.hasNext())
				daVisitare.offer(itFigli.next());
		}
		return ris;
	}

}
