/**
 * 
 */
package alberi;

import java.util.List;

/**
 * @author sflesca
 *
 */
@SuppressWarnings("rawtypes")
public class ABR<T extends Comparable> implements Dizionario<T> {

	protected AlberoBin<T> coll=null;
	
	/**
	 * 
	 */
	public ABR() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see alberi.Dizionario#inserisci(java.lang.Comparable)
	 */
	@Override
	public void inserisci(T x) {
		AlberoBin<T> tmp = cercaNodo(x);
		if(tmp==null){
			// inserisco la radice
			coll= new AlberoBinLF<T>();
			((AlberoBinLF<T>) coll).setVal(x);
		}else if(!tmp.val().equals(x)){
			AlberoBinLF<T> figlio = new AlberoBinLF<T>();
			figlio.setVal(x);
			if(x.compareTo(tmp.val())<0){
				((AlberoBinLF<T>) tmp).setSin(figlio);
			}else{
				((AlberoBinLF<T>) tmp).setDes(figlio);
			}
		}

	}

	/* (non-Javadoc)
	 * @see alberi.Dizionario#rimuovi(java.lang.Comparable)
	 */
	@Override
	public void rimuovi(T x) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see alberi.Dizionario#cerca(java.lang.Comparable)
	 */
	@Override
	public T cerca(T x) {
		AlberoBin<T> tmp =cercaNodo(x);
		if(tmp==null) return null;
		if(tmp.val().equals(x))
			return tmp.val();
		return null;
	}

	protected AlberoBin<T> cercaNodo(T x){
		if(coll==null) return null;
		AlberoBin<T> curr = coll;
		while(!curr.val().equals(x)){
			if(curr.val().compareTo(x)<0){
				if(curr.des()==null) return curr;
				curr=curr.des();
			}else{
				if(curr.sin()==null) return curr;
				curr=curr.sin();
			}
		}
		return curr;
	}
	
	
	@Override
	public String toString(){
		List<T> valoriInf = coll.visitaInfissa();
		List<T> valoriAnt = coll.visitaAnticipata();
		List<T> valoriPos = coll.visitaPosticipata();
		List<T> valoriLiv = coll.visitaLivelli();
		return "inf="+valoriInf.toString()+" ant="+valoriAnt.toString()+" pos="+valoriPos.toString()+" liv="+valoriLiv.toString();
		
	}
}
