package fr.eni.projetcbvs.bo;

import java.util.GregorianCalendar;
import java.util.List;

public class Deplacement {
	
	private int idDeplacement;
	private GregorianCalendar dateDepart;
	private GregorianCalendar dateRetour;
	private int lieuDepart;
	private int lieuRetour;
	private String natureDeplacement;
	private float montantCarburant;
	private int litreCarburant;
	private String commentaire;
	private int kmTotal;
	private int kmPlein;
	private int distanceParcouru;
	private List<Personne> conducteurs;
	
	public Deplacement(int idDeplacement, GregorianCalendar dateDepart, GregorianCalendar dateRetour, int lieuDepart,
			int lieuRetour,String natureDeplacement, float montantCarburant, int litreCarburant, String commentaire, int kmTotal, int kmPlein,
			int distanceParcouru, List<Personne> conducteurs) {
		this(dateDepart,dateRetour,lieuDepart,lieuRetour,natureDeplacement,montantCarburant,litreCarburant,commentaire,kmTotal,kmPlein,distanceParcouru,conducteurs);
		this.idDeplacement = idDeplacement;
	}
	
	public Deplacement(GregorianCalendar dateDepart, GregorianCalendar dateRetour, int lieuDepart,
			int lieuRetour,String natureDeplacement, float montantCarburant, int litreCarburant, String commentaire, int kmTotal, int kmPlein,
			int distanceParcouru, List<Personne> conducteurs) {
		this.dateDepart = dateDepart;
		this.dateRetour = dateRetour;
		this.lieuDepart = lieuDepart;
		this.lieuRetour = lieuRetour;
		this.montantCarburant = montantCarburant;
		this.litreCarburant = litreCarburant;
		this.commentaire = commentaire;
		this.kmTotal = kmTotal;
		this.kmPlein = kmPlein;
		this.distanceParcouru = distanceParcouru;
		this.conducteurs = conducteurs;
	}
	
	public Deplacement() {
		
	}

	public int getIdDeplacement() {
		return idDeplacement;
	}

	public void setIdDeplacement(int idDeplacement) {
		this.idDeplacement = idDeplacement;
	}

	public GregorianCalendar getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(GregorianCalendar dateDepart) {
		this.dateDepart = dateDepart;
	}

	public GregorianCalendar getDateRetour() {
		return dateRetour;
	}

	public void setDateRetour(GregorianCalendar dateRetour) {
		this.dateRetour = dateRetour;
	}

	public int getLieuDepart() {
		return lieuDepart;
	}

	public void setLieuDepart(int lieuDepart) {
		this.lieuDepart = lieuDepart;
	}

	public int getLieuRetour() {
		return lieuRetour;
	}

	public void setLieuRetour(int lieuRetour) {
		this.lieuRetour = lieuRetour;
	}

	public float getMontantCarburant() {
		return montantCarburant;
	}

	public void setMontantCarburant(float montantCarburant) {
		this.montantCarburant = montantCarburant;
	}

	public int getLitreCarburant() {
		return litreCarburant;
	}

	public void setLitreCarburant(int litreCarburant) {
		this.litreCarburant = litreCarburant;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public int getKmTotal() {
		return kmTotal;
	}

	public void setKmTotal(int kmTotal) {
		this.kmTotal = kmTotal;
	}

	public int getKmPlein() {
		return kmPlein;
	}

	public void setKmPlein(int kmPlein) {
		this.kmPlein = kmPlein;
	}

	public int getDistanceParcouru() {
		return distanceParcouru;
	}

	public void setDistanceParcouru(int distanceParcouru) {
		this.distanceParcouru = distanceParcouru;
	}

	public List<Personne> getConducteurs() {
		return conducteurs;
	}

	public void setConducteurs(List<Personne> conducteurs) {
		this.conducteurs = conducteurs;
	}
	
	public String getNatureDeplacement() {
		return natureDeplacement;
	}

	public void setNatureDeplacement(String natureDeplacement) {
		this.natureDeplacement = natureDeplacement;
	}

	@Override
	public String toString() {
		return "Deplacement [idDeplacement=" + idDeplacement + ", dateDepart=" + dateDepart + ", dateRetour="
				+ dateRetour + ", lieuDepart=" + lieuDepart + ", lieuRetour=" + lieuRetour + ", montantCarburant="
				+ montantCarburant + ", litreCarburant=" + litreCarburant + ", commentaire=" + commentaire
				+ ", kmTotal=" + kmTotal + ", kmPlein=" + kmPlein + ", distanceParcouru=" + distanceParcouru
				+ ", conducteurs=" + conducteurs + "]";
	}

	
	
}
