package codeconpriorita;

public class Util {

	public Util() {
		// TODO Auto-generated constructor stub
	}

	
	public static void ordina(Comparable[] v, boolean crescente){
		// creare una coda di priorità secondo l'ordinamento
		Heap<Comparable> heap = new Heap(v.length,crescente);
		//inserire tutti gli elementi nel vettore nella coda
		for(int i =0; i<v.length;i++)
			try {
				heap.in(v[i]);
			} catch (CodaPiena e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// togliere ad uno ad uno gli elementi e metterli nel vettore
		// dalla prima posizione verso l'ultima
		for(int i =0; i<v.length;i++)
			v[i]=heap.out();
	}
	
	public static void ordinaInPlace(Comparable[] v, boolean crescente){
		// creare una coda di priorità secondo l'ordinamento
		Heap<Comparable> heap = new Heap(v,!crescente);
		//inserire tutti gli elementi nel vettore nella coda
		for(int i =0; i<v.length;i++)
			try {
				heap.in(v[i]);
			} catch (CodaPiena e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		// togliere ad uno ad uno gli elementi e metterli nel vettore
		// dalla prima posizione verso l'ultima
		for(int i =v.length-1; i>=0;i--)
			v[i]=heap.out();
	}
}
