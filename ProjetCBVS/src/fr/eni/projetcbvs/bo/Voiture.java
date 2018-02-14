package fr.eni.projetcbvs.bo;

public class Voiture {
	
	//Instantiation des variables
	private int idVoiture;
	private String immatriculation;
	private int kilometrage;
	
	//Constructeur
	public Voiture(int idVoiture, String immatriculation, int kilometrage) {
		this(immatriculation,kilometrage);
		this.idVoiture = idVoiture;
	}
	
	public Voiture(String immatriculation, int kilometrage) {
		this.immatriculation = immatriculation;
		this.kilometrage = kilometrage;
	}
	
	public Voiture() {
		
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


	public int getKilometrage() {
		return kilometrage;
	}


	public void setKilometrage(int kilometrage) {
		this.kilometrage = kilometrage;
	}
	
	
}
