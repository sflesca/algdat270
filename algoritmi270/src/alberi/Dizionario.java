package alberi;

public interface Dizionario<T extends Comparable> {

	public void inserisci(T x);
	
	public void rimuovi(T x);
	
	public T cerca(T x);
}
