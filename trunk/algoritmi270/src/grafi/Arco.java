package grafi;

public class Arco {
	protected int in;
	protected int fin;
	
	
	
	/**
	 * @param in
	 * @param fin
	 */
	public Arco(int in, int fin) {
		super();
		this.in = in;
		this.fin = fin;
	}
	
	
	public int getIn() {
		return in;
	}
	public void setIn(int in) {
		this.in = in;
	}
	public int getFin() {
		return fin;
	}
	public void setFin(int fin) {
		this.fin = fin;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + fin;
		result = prime * result + in;
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Arco))
			return false;
		Arco other = (Arco) obj;
		if (fin != other.fin)
			return false;
		if (in != other.in)
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "[Arco (" + in + "," + fin + ")]";
	}
	
	
}
