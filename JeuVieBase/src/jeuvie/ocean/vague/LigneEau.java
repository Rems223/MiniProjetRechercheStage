package jeuvie.ocean.vague;

import java.util.List;

import jeuvie.ocean.vague.casemer.ICase;

public abstract class LigneEau implements ILigneEau {

	protected List<ICase> lesCases;

	protected abstract void remplirDeCasesVides();

	public ICase get(int i) {
		//TODO
		return null;
	}

	public int getNbColonnes() {
		//TODO
		return 0;
	}

	protected boolean add(ICase element){
		//TODO
		return true;
	}


}
