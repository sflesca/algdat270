package alberi;

public class Tester {
	
	/**
	 * 
	 * @param a un albero binario che contiene Integer
	 * @return  vero se e solo se tutti i nodi non foglia
	 * hanno un valore che
	 * è uguale alla somma dei valori contenuti nel loro
	 * sottoalbero sinistro più la somma dei valori contenuti
	 * nel loro sottoalbero destro.
	 * 
	 */
	
	public static boolean verificaSomma(AlberoBin a){
		if(a==null) return true;
		if((a.sin()==null)&&(a.des()==null)) return true;
//		return (((Integer) a.val()).intValue()==somma(a.sin())
//				+somma(a.des()))&& 
//				verificaSomma(a.sin()) &&
//				verificaSomma(a.des());
		
		return verificaSomma(a.sin()) &&
				(((Integer) a.val()).intValue()==somma(a.sin())
				+somma(a.des())) &&
				verificaSomma(a.des());
		
	}
	
	/**
	 * 
	 * @param a un albero binario che contiene Integer
	 * @return  la somma dei valori contenuti nell'albero
	 * 
	 */
	
	public static int somma(AlberoBin a){
		if(a==null) return 0;
		return ((Integer) a.val()).intValue()+somma(a.sin())
				+somma(a.des());
	}
	
	/**
	 * 
	 * @param a un albero binario che contiene Integer
	 * @return  vero se e solo se a è simmetrico
	 * 
	 */
	
	public static boolean simmetrico(AlberoBin a){
		if(a==null) return true;
		return simmetrici(a.sin(),a.des());
	}
	
	private static boolean simmetrici(AlberoBin sin, AlberoBin des) {
		if((sin==null)&&(des==null)) return true;
		if((sin==null)||(des==null)) return false;
		return (sin.val().equals(des.val()))&&
				simmetrici(sin.sin(),des.des())&&
				simmetrici(sin.des(),des.sin());
	}

	/**
	 * 
	 * @param a un albero binario che contiene Integer
	 * @return  vero se e solo se tutti le foglie di a
	 * hanno valore maggiore o uguale a 0
	 * 
	 */
	
	public static boolean verificaFoglie(AlberoBin a){
		if (a==null)
			return true;
		if((a.sin()==null)&&(a.des()==null))
			return (((Integer) a.val()).intValue()>=0);
		return verificaFoglie(a.sin())&& verificaFoglie(a.des());
	}
	
	/**
	 * 
	 * @param a un albero binario che contiene Integer
	 * @param l
	 * @return  vero se e solo se tutti i nodi che 
	 * si trovano nell'albero ad un livello maggiore o uguale a
	 * l hanno valore maggiore o uguale a 0
	 * 
	 */
	
	public static boolean verifica(AlberoBin a, int l){
		if(a==null) return true;
		if (l<=0)
			return (((Integer) a.val()).intValue()>=0)&&
					verifica(a.sin(),l-1)&& verifica(a.des(),l-1);
		else
			return verifica(a.sin(),l-1)&& verifica(a.des(),l-1);
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AlberoBinLF a =  new AlberoBinLF();
		a.setVal(new Integer(-1));
		AlberoBinLF a1 =  new AlberoBinLF();
		a.setVal(new Integer(1));
		AlberoBinLF a2 =  new AlberoBinLF();
		a.setVal(new Integer(0));
		AlberoBinLF a3 =  new AlberoBinLF();
		a.setVal(new Integer(2));
		AlberoBinLF a4 =  new AlberoBinLF();
		a.setVal(new Integer(-33));
		AlberoBinLF a5 =  new AlberoBinLF();
		a.setVal(new Integer(4));
		
		a.setSin(a1);
		a.setDes(a2);
		a1.setSin(a3);
		a3.setSin(a4);
		a4.setDes(a5);
		
		System.out.println(verifica(a,2));
		

	}

}
