package backtracking;

public abstract class ProblemaBack {

	public ProblemaBack() {
		// TODO Auto-generated constructor stub
	}

	
	public void risolvi(){
		int liv = 0;
		boolean rivedi = false;
		if (!primaScelta(liv)) return;
		while (liv >=0){
			if(verificaVincoli(liv)){
				if(solCompleta(liv)) return;
				liv++;
				if(!primaScelta(liv)){
					rivedi= true;
				}
			}else{
				if(!successivaScelta(liv)){
					rivedi = true;
				}
			}
			while(rivedi&& liv>0){
				liv--;
				if(successivaScelta(liv))
					rivedi= false;
			}
		}
	}
	
	protected abstract boolean successivaScelta(int liv);


	protected abstract boolean solCompleta(int liv);


	protected abstract boolean verificaVincoli(int liv);


	protected abstract boolean primaScelta(int liv);


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
