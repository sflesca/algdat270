package hashmap;

import java.util.Arrays;
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

		@Override
		public String toString() {
			return "Pair [key=" + key + ", obj=" + obj + "]";
		}
	}

	private static final int INITIALSIZE = 100;
	
	LinkedList<Pair<PK,T>>[] buckets=new LinkedList[INITIALSIZE]; 
	
	int size=0;

	private double FCMAX=1.1;

	public TabellaHash() {
		super();
	}

	public T cerca(PK key) {
		Pair<PK,T> p = new Pair<PK,T>(key,null);
		int hs = p.hashCode();
		if(buckets[hs%buckets.length]==null)return null;
		for(Pair<PK,T> p1 : buckets[hs%buckets.length])
			if(p1.equals(p))
				return p1.getObj();
		return null;
	}
	
	public boolean rimuovi(PK key){
		if (cerca(key)==null)
			return false;
		size--;
		Pair<PK,T> p = new Pair<PK,T>(key, null);
		buckets[p.hashCode()%buckets.length].remove(p);
		if(size<buckets.length/4*FCMAX)
			decreaseSize();
		return true;
	}
	
	private void decreaseSize() {
		LinkedList<Pair<PK,T>>[] oldBuckets = buckets;
		buckets = new LinkedList[oldBuckets.length/2];
		size=0;
		for(int i=0;i<oldBuckets.length;i++)
			if(oldBuckets[i]!=null)
				for(Pair<PK,T> p : oldBuckets[i])
					inserisci(p.getKey(),p.getObj());
	}

	public boolean inserisci(PK key, T o){
		if (cerca(key)!=null)
			return false;
		if (size>=buckets.length*FCMAX)
			increaseSize();
		size++;
		Pair<PK,T> p = new Pair<PK,T>(key,o);
		int hs = p.hashCode();
		if (buckets[hs%buckets.length]==null)
			buckets[hs%buckets.length]= new LinkedList<Pair<PK,T>>();
		buckets[hs%buckets.length].add(p);
		return true;
	}

	private void increaseSize() {
		LinkedList<Pair<PK,T>>[] oldBuckets = buckets;
		buckets = new LinkedList[oldBuckets.length*2];
		size=0;
		for(int i=0;i<oldBuckets.length;i++)
			if(oldBuckets[i]!=null)
				for(Pair<PK,T> p : oldBuckets[i])
					inserisci(p.getKey(),p.getObj());
		
	}

	@Override
	public String toString() {
		return "TabellaHash [buckets=" + Arrays.toString(buckets) + ", size=" + size + "]";
	}
}
