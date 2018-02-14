package fr.eni.projetcbvs.bo;

public class Ville {

	private int idVille;
	private String ville;
	private String adresse;
	
	public Ville(int idVille, String ville, String adresse) {
		this(ville,adresse);
		this.idVille = idVille;
	}
	
	public Ville(String ville, String adresse) {
		this.ville = ville;
		this.adresse = adresse;
	}
	
	public Ville() {
		
	}

	public int getIdVille() {
		return idVille;
	}

	public void setIdVille(int idVille) {
		this.idVille = idVille;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	
}
