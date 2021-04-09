package codeconpriorita;

public interface CodaPFixed<T> {
	
	public T top();
	
	public void in(T x, int priorita);
	
	public T out();
	
	public boolean vuota();
	

}
