/**
 * 
 */
package alberi;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import alberi.ecccezioni.AlberiDiversiException;

/**
 * @author sflesca
 *
 */
public class AlberoBinLF extends AlberoLF implements AlberoBin{

	public AlberoBinLF() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AlberoBin padreBin() {
		// TODO Auto-generated method stub
		return (AlberoBin) padre;
	}

	@Override
	public AlberoBin sin() {
		// TODO Auto-generated method stub
		return (AlberoBin) figli[0];
	}

	@Override
	public AlberoBin des() {
		// TODO Auto-generated method stub
		return (AlberoBin) figli[1];
	}

	public void setDes(AlberoBinLF a){
		try {
			setFiglio(a,1);
		} catch (AlberiDiversiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setSin(AlberoBinLF a){
		try {
			setFiglio(a,0);
		} catch (AlberiDiversiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List visitaInfissa() {
		List l = new LinkedList();
		visitaInfissa(l);
		return l;
	}
	
	private void visitaInfissa(List l){
		AlberoBinLF s = (AlberoBinLF) sin();
		if (s!=null) s.visitaInfissa(l);
		l.add(val());
		AlberoBinLF d = (AlberoBinLF) des();
		if (s!=null) d.visitaInfissa(l);

	}

	@Override
	public Iterator iteratorVI() {
		
		return new IteratorVI(this);
	}
	
	protected class IteratorVI implements Iterator{
		
		protected static final int SIN = 0;
		protected static final int DES = 1;
		protected static final int SU = 2;
		protected static final int STOP = 3;
		
		protected AlberoBin curr;
		protected boolean hasNext;
		
		public IteratorVI(AlberoBin a){
			curr=a;
			hasNext=true;
		}


		private void succ() {
			int dir = DES;
			while(dir!=STOP){
				switch (dir){
				case DES:
					if(curr.des()==null){
						dir=SU;
					}else{
						curr=curr.des();
						dir=SIN;
					}
					break;
				case SIN:
					if(curr.sin()==null){
						hasNext=true;
						dir=STOP;
					}else{
						curr= curr.sin();
						dir=SIN;
					}
					break;
				case SU:
					if(curr.padre()==null){
						hasNext=false;
						dir=STOP;
					}else{
						if(((AlberoBin) curr.padre()).sin() ==curr){
							curr=(AlberoBin) curr.padre();
							hasNext=true;
							dir=STOP;
						}else{
							curr=(AlberoBin) curr.padre();
							dir = SU;
						}
					}
					break;
				}
			}
			
		}

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return hasNext;
		}

		@Override
		public Object next() {
			if(!hasNext()) return null;
			Object tmp = curr.val();
			succ();
			return tmp;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
}
