package fr.eni.projetcbvs.bo;

public class Voiture {
	
	//Instantiation des variables
	private int idVoiture;
	private String immatriculation;
	private float kilometrage;
	
	//Constructeur
	public Voiture(int idVoiture, String immatriculation, float kilometrage) {
		super();
		this.idVoiture = idVoiture;
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
	}

	//Getters & Setters
	public int getIdVoiture() {
		return idVoiture;
	}


	public void setIdVoiture(int idVoiture) {
		this.idVoiture = idVoiture;
	}


	public String getImmatriculation() {
		return immatriculation;
	}


	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}


	public float getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(float kilometrage) {
		this.kilometrage = kilometrage;
	}
	
	
}
