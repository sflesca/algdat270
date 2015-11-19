package alberi;

import java.util.Iterator;

public class Vettore<T> {

	Object[] items;

	public Vettore(int sizeMax) {
		items = new Object[sizeMax];
	}

	public void remove(int pos) {
		items[pos] = null;

	}

	public void set(int pos, T t) {
		items[pos] = t;

	}

	public T get(int pos) {
		return (T) items[pos];
	}

	public Iterator<T> iterator() {

		return new IteratorNonNulli();
	}

	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	private class IteratorNonNulli implements Iterator<T> {

		protected boolean hasNext;
		protected int pos = -1;

		public IteratorNonNulli() {
			succ();
		}

		public T next() {
			if(!hasNext()) return null;
			Object tmp = items[pos];
			succ();
			return (T) tmp;
		}

		public boolean hasNext() {
			return hasNext;
		}

		public void remove() {
			throw new UnsupportedOperationException();
		}

		private void succ() {
			hasNext = false;
			pos++;
			while (pos < items.length) {
				if (items[pos] != null) {
					hasNext = true;
					return;
				}
				pos++;
			}
		}
	}

}
