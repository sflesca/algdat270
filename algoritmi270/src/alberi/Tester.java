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
	
	public static boolean verificaSomma(AlberoBin<Integer> a){
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
	
	public static int somma(AlberoBin<Integer> a){
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
	
	public static boolean simmetrico(AlberoBin<Integer> a){
		if(a==null) return true;
		return simmetrici(a.sin(),a.des());
	}
	
	private static boolean simmetrici(AlberoBin<Integer> sin, AlberoBin<Integer> des) {
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
	
	public static boolean verificaFoglie(AlberoBin<Integer> a){
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
	
	public static boolean verifica(AlberoBin<Integer> a, int l){
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
		
//		AlberoBinLF<Integer> a =  new AlberoBinLF<Integer>();
//		a.setVal(new Integer(-1));
//		AlberoBinLF<Integer> a1 =  new AlberoBinLF<Integer>();
//		a.setVal(new Integer(1));
//		AlberoBinLF<Integer> a2 =  new AlberoBinLF<Integer>();
//		a.setVal(new Integer(0));
//		AlberoBinLF<Integer> a3 =  new AlberoBinLF<Integer>();
//		a.setVal(new Integer(2));
//		AlberoBinLF<Integer> a4 =  new AlberoBinLF<Integer>();
//		a.setVal(new Integer(-33));
//		AlberoBinLF<Integer> a5 =  new AlberoBinLF<Integer>();
//		a.setVal(new Integer(4));
//		
//		a.setSin(a1);
//		a.setDes(a2);
//		a1.setSin(a3);
//		a3.setSin(a4);
//		a4.setDes(a5);
//		
//		System.out.println(verifica(a,2));
		
		ABR<Integer> a = new ABR<Integer>();
		a.inserisci(10);
		a.inserisci(18);
		a.inserisci(10);
		a.inserisci(19);
		a.inserisci(6);
		a.inserisci(13);
		
		System.out.println(a.toString());
		
	}

}
