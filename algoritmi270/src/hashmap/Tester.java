package hashmap;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TabellaHash<Integer,Integer> tab = new TabellaHash<Integer, Integer>();
		for (int i = 0;i<1000;i++)
			tab.inserisci(i, i);
		System.out.println(tab.toString());
		for (int i = 100;i<1000;i++)
			tab.rimuovi(i);
		System.out.println(tab.toString());
	}

}
