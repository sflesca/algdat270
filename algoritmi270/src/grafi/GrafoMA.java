/**
 * 
 */
package grafi;

import grafi.exception.VerticeNonEsisteException;

import java.util.Iterator;
import java.util.Set;

/**
 * @author sflesca
 * 
 */
public class GrafoMA<A extends Arco> extends Grafo<A> {

	Arco[][] M;

	/**
	 * @param n
	 */
	public GrafoMA(int n) {
		super(n);
		M = new Arco[n][n];
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grafi.Grafo#archi()
	 */
	@Override
	public Iterator<A> archi() {
		// TODO Auto-generated method stub
		return new IteratorArchi();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grafi.Grafo#adiacenti(int)
	 */
	@Override
	public Iterator<A> adiacenti(int v) {
		if (!(v >= 0) && (v < M.length))
			throw new VerticeNonEsisteException();
		return new IteratorAdiacenti(v);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grafi.Grafo#aggiungiArco(grafi.Arco)
	 */
	@Override
	public void aggiungiArco(Arco a) {
		if(a==null) return;
		if (M[a.getIn()][a.getFin()] == null)
			m++;
		M[a.getIn()][a.getFin()] = a;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grafi.Grafo#rimuoviArco(grafi.Arco)
	 */
	@Override
	public boolean rimuoviArco(Arco a) {
		if(a==null) return false;
		if (M[a.getIn()][a.getFin()] != null) {
			M[a.getIn()][a.getFin()] = null;
			m--;
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grafi.Grafo#arco(grafi.Arco)
	 */
	@Override
	public boolean arco(Arco a) {
		return M[a.getIn()][a.getFin()] != null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see grafi.Grafo#arco(int, int)
	 */
	@Override
	public boolean arco(int v1, int v2) {
		// TODO Auto-generated method stub
		return M[v1][v2] != null;
	}

	protected class IteratorAdiacenti implements Iterator<A> {

		boolean hasNext = true;
		A curr = null;
		int curfin;
		int in;

		public IteratorAdiacenti(int in) {
			this.in = in;
			curfin = -1;
			avanza();
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return hasNext;
		}

		@Override
		public A next() {
			if (!hasNext)
				return null;
			A tmp = curr;
			avanza();
			return tmp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

		private void avanza() {
			for (curfin++; curfin < M[in].length; curfin++)
				if (M[in][curfin] != null)
					break;
			if (curfin < M[in].length)
				curr = (A) M[in][curfin];
			else
				hasNext = false;
		}
	}

	protected class IteratorArchi implements Iterator<A> {

		int currin = 0;
		Iterator<A> it = adiacenti(currin);
		boolean hasNext = true;
		A curr = null;

		/**
		 * 
		 */
		public IteratorArchi() {
			avanza();
		}

		@Override
		public boolean hasNext() {
			return hasNext;
		}

		@Override
		public A next() {
			if (!hasNext)
				return null;
			A tmp = curr;
			avanza();
			return tmp;
		}

		private void avanza() {
			if (it.hasNext())
				curr = it.next();
			else {
				for (currin++; currin < M.length; currin++) {
					it = adiacenti(currin);
					if (it.hasNext()) {
						curr = it.next();
						break;
					}
				}
				if (currin >= M.length) {
					hasNext = false;
					curr = null;
				}
			}
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}
}
