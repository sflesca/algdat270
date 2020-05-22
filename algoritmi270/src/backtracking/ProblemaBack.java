package backtracking;

public abstract class ProblemaBack {

	public ProblemaBack() {
		// TODO Auto-generated constructor stub
	}

	
	public boolean risolvi(){
		int liv = 0;
		boolean rivedi = false;
		if (!primaScelta(liv)) return false;
		while (liv >=0){
			if(verificaVincoli(liv)){
				if(solCompleta(liv)) {
					costruisciSoluzione(liv);
					return true;
				}
				liv++;
				if(!primaScelta(liv)){
					rivedi= true;
				}
			}else{
				if(!successivaScelta(liv)){
					rivedi = true;
				}
			}
			while(rivedi&& liv>=0){
				liv--;
				if(liv>=0 && successivaScelta(liv))
					rivedi= false;
			}
		}
		return false;
	}
	
	protected abstract boolean successivaScelta(int liv);


	protected abstract boolean solCompleta(int liv);


	protected abstract boolean verificaVincoli(int liv);


	protected abstract boolean primaScelta(int liv);
	
	protected abstract void costruisciSoluzione(int liv);


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
