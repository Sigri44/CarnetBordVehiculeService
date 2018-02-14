package fr.eni.projetcbvs.bo;

import java.util.List;

public class Carnet {

	private int idVoiture;
	private List<Deplacement> deplacement;
	
	public Carnet(int idVoiture, List<Deplacement> deplacement) {
		super();
		this.idVoiture = idVoiture;
		this.deplacement = deplacement;
	}
	
	public Carnet() {
		
	}

	public int getIdVoiture() {
		return idVoiture;
	}

	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}

	public List<Deplacement> getDeplacement() {
		return deplacement;
	}

	public void setDeplacement(List<Deplacement> deplacement) {
		this.deplacement = deplacement;
	}
	
	
	
}
