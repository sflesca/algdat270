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
		if (coll==null) return;
		AlberoBinLF<T> tmp = (AlberoBinLF<T>) cercaNodo(x);
		if(tmp.val().equals(x)){
			while((tmp.sin()!=null)&&(tmp.des()!=null)){
				AlberoBinLF<T> tt = (AlberoBinLF<T>) tmp.des();
				while(tt.sin()!=null) tt = (AlberoBinLF<T>) tt.sin();
				tmp.setVal(tt.val());
				tmp=tt;
			}

			AlberoBinLF<T> padre = (AlberoBinLF<T>) tmp.padre();
			if(padre==null){
				if(tmp.sin()!=null){
					coll = tmp.sin();
					((AlberoBinLF<T>) tmp.sin()).pota();
				}else{
					coll = tmp.des();
					if (tmp.des()!=null) ((AlberoBinLF<T>) tmp.des()).pota();
				}
			}else{
				if((tmp.sin()==null)&&(tmp.des()==null))
					tmp.pota();
				else{
					AlberoBinLF<T> xx = (AlberoBinLF<T>) tmp.padre();
					if(xx.sin()==tmp){
						if(tmp.sin()!=null){
							tmp.pota();
							AlberoBinLF<T> sin = (AlberoBinLF<T>) tmp.sin();
							sin.pota();
							padre.setSin(sin);
						}else{
							tmp.pota();
							AlberoBinLF<T> des = (AlberoBinLF<T>) tmp.des();
							des.pota();
							padre.setSin(des);							
						}
					}else{
						if(tmp.sin()!=null){
							tmp.pota();
							AlberoBinLF<T> sin = (AlberoBinLF<T>) tmp.sin();
							sin.pota();
							padre.setDes(sin);
						}else{
							tmp.pota();
							AlberoBinLF<T> des = (AlberoBinLF<T>) tmp.des();
							des.pota();
							padre.setDes(des);							
						}						
					}
					
				}
			}
			
		}
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
