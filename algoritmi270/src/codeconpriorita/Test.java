package codeconpriorita;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CodaPFixed<String> coda = new VettoreDiCode<String>(10);
		coda.in("ciao", 2);
		coda.in("ciao1", 2);
		coda.in("Sergio", 0);
		while(!coda.vuota())
			System.out.println(coda.out());
	}

}
