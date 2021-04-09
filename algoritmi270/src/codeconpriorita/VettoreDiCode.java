package codeconpriorita;

import java.util.LinkedList;
import java.util.Queue;

public class VettoreDiCode<T> implements CodaPFixed<T> {
	
	Queue<T>[] code;

	public VettoreDiCode(int prMax) {
		code = (Queue<T>[]) new Queue[prMax];
		for(int i = 0; i<code.length;i++)
			code[i] = new LinkedList<T>();
	}

	@Override
	public T top() {
		// TODO Auto-generated method stub
		for(int i = 0;i<code.length;i++)
			if(!code[i].isEmpty())
				return code[i].peek();
		return null;
	}

	@Override
	public void in(T x, int priorita) {
		if((priorita<0) ||(priorita> code.length)) throw new RuntimeException();
		code[priorita].offer(x);
		
	}

	@Override
	public T out() {
		for(int i = 0;i<code.length;i++)
			if(!code[i].isEmpty())
				return code[i].poll();
		return null;
	}

	@Override
	public boolean vuota() {
		for(int i = 0;i<code.length;i++)
			if(!code[i].isEmpty())
				return false;
		return true;
	}

}
