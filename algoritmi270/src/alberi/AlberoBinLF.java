/**
 * 
 */
package alberi;

import alberi.ecccezioni.AlberiDiversiException;

/**
 * @author sflesca
 *
 */
public class AlberoBinLF extends AlberoLF implements AlberoBin{

	public AlberoBinLF() {
		super(2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public AlberoBin padreBin() {
		// TODO Auto-generated method stub
		return (AlberoBin) padre;
	}

	@Override
	public AlberoBin sin() {
		// TODO Auto-generated method stub
		return (AlberoBin) figli[0];
	}

	@Override
	public AlberoBin des() {
		// TODO Auto-generated method stub
		return (AlberoBin) figli[1];
	}

	public void setDes(AlberoBinLF a){
		try {
			setFiglio(a,1);
		} catch (AlberiDiversiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setSin(AlberoBinLF a){
		try {
			setFiglio(a,0);
		} catch (AlberiDiversiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
