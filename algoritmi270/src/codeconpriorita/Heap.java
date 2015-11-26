package codeconpriorita;

public class Heap<T extends Comparable> implements CodaP<T> {

	protected T[] elem;
	int pos;
	boolean crescente = true;
	
	public Heap(int size) {
		elem = (T[]) new Comparable[size];
		pos=0;
	}
	
	

	public Heap(T[] elem) {
		this.elem = elem;
		pos=0;
	}
	
	public Heap(int size, boolean cres) {
		elem = (T[]) new Comparable[size];
		pos=0;
		crescente=cres;
	}
	
	

	public Heap(T[] elem, boolean cres) {
		this.elem = elem;
		pos=0;
		crescente=cres;
	}



	@Override
	public T top() {
		if (pos==0)
			return null;
		return elem[0];
	}

	@Override
	public void in(T x) throws CodaPiena {
		if (pos>=elem.length)
			throw new CodaPiena();
		elem[pos]=x;
		pos++;
		int tmpPos=pos-1;
		while(tmpPos>0){
			if((crescente&&elem[tmpPos].compareTo(elem[padre(tmpPos)])>0)||
					(!crescente&&(elem[tmpPos].compareTo(elem[padre(tmpPos)])<0)))
					break;
			T tt = elem[tmpPos];
			elem[tmpPos]=elem[padre(tmpPos)];
			elem[padre(tmpPos)]=tt;
			tmpPos=padre(tmpPos);
		}

	}

	private int padre(int tmpPos) {
		return (tmpPos+1)/2-1;
	}



	@Override
	public T out() {
		if (pos==0)
			return null;
		T tmp = elem[0];
		pos--;
		elem[0]=elem[pos];
		elem[pos]=null;
		if (pos==0)
			return tmp;
		int tmpPos=0;
		while(posFiglioSin(tmpPos)<pos){
			int posMin  = figlioMinore(tmpPos);
			if((crescente&&elem[tmpPos].compareTo(elem[posMin])<0)||
					(!crescente&&(elem[tmpPos].compareTo(elem[posMin])>0)))
					break;
			T tt = elem[tmpPos];
			elem[tmpPos]=elem[posMin];
			elem[posMin]=tt;
			tmpPos=posMin;
		}
			
		return tmp;
	}

	private int figlioMinore(int tmpPos) {
		if (posFiglioDes(tmpPos)>=pos)
			return posFiglioSin(tmpPos);
		if (crescente)
			if (elem[posFiglioDes(tmpPos)]
				.compareTo(elem[posFiglioSin(tmpPos)])<0)
				return posFiglioDes(tmpPos);
			else
				return posFiglioSin(tmpPos);
		else
			if (elem[posFiglioDes(tmpPos)]
					.compareTo(elem[posFiglioSin(tmpPos)])>0)
					return posFiglioDes(tmpPos);
				else
					return posFiglioSin(tmpPos);
	}



	private int posFiglioDes(int tmpPos) {
		return (tmpPos+1)*2;
	}



	private int posFiglioSin(int tmpPos) {
		return (tmpPos+1)*2-1;
	}



	@Override
	public boolean piena() {
		return pos>=elem.length;
	}

	@Override
	public boolean vuota() {
		return pos==0;
	}

}
