package dei;

public abstract class ProblemaDI {

	public SoluzioneDI risolviDI() {
		if (dimensioneBanale())
			return risolviDirettamente();
		ProblemaDI[] sottoproblemi = dividi();
		SoluzioneDI[] sottosoluzioni = new SoluzioneDI[sottoproblemi.length];
		for (int i = 0; i<sottoproblemi.length; i++)
			sottosoluzioni[i] = sottoproblemi[i].risolviDI();
		return combina(sottosoluzioni);
	}

	protected abstract SoluzioneDI combina(SoluzioneDI[] sottosoluzioni);

	protected abstract ProblemaDI[] dividi();

	protected abstract boolean dimensioneBanale();

	protected abstract SoluzioneDI risolviDirettamente();

}
