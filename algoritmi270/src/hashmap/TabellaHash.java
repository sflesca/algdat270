package hashmap;

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
	}
	
	Pair<PK,T>[] buckets; 
	
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
