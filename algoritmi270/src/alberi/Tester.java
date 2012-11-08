package alberi;

public class Tester {
	
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
		
		
		return false;
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
