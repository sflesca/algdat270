package hashmap;

import java.util.LinkedList;

public class TabellaHash<PK,T> {
	
	protected class Pair <PK, T>{
		PK key;
		T obj;
		
		public Pair(PK key, T obj) {
			super();
			this.key = key;
			this.obj = obj;
		}
		
		public Pair() {
			super();
		}

		public PK getKey() {
			return key;
		}
		public void setKey(PK key) {
			this.key = key;
		}
		public T getObj() {
			return obj;
		}
		public void setObj(T obj) {
			this.obj = obj;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((key == null) ? 0 : key.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Pair other = (Pair) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (key == null) {
				if (other.key != null)
					return false;
			} else if (!key.equals(other.key))
				return false;
			return true;
		}

		private TabellaHash<PK,T> getOuterType() {
			return (TabellaHash<PK, T>) TabellaHash.this;
		}
	}
	
	LinkedList<Pair<PK,T>>[] buckets; 
	
	int size=0;

	public T cerca(PK key) {
		return null;
	}
	
	public boolean rimuovi(PK key){
		return false;
	}
	
	public boolean inserisci(PK key, T o){
		return false;
	}
}
