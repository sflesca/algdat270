package grafi;

public class ArcoPesato extends Arco implements Comparable {

	private double peso;
	
	public ArcoPesato(int in, int fin, double peso) {
		super(in,fin);
		this.peso = peso;
	}
	
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
	public String toString() {
		return "[Arco pesato (" + in + "," + fin + ","+peso+")]";
	}

	@Override
	public int compareTo(Object o) {
		ArcoPesato a =(ArcoPesato) o;
		if (a.peso==peso) return 0;
		else if (a.peso<peso) return 1;
		return -1;
	}


	
}
