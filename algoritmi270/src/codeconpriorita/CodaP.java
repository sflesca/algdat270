package codeconpriorita;

public interface CodaP<T extends Comparable> {
	
	public T top();
	
	public void in(T x) throws CodaPiena;
	
	public T out();
	
	public boolean piena();
	
	public boolean vuota();

}
