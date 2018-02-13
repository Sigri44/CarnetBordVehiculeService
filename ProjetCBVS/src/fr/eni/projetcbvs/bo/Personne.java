package fr.eni.projetcbvs.bo;

public class Personne {
	//instantiation des variables
 private int idPersonne;
 private String nom;
 private String prenom;
 private String motDePasse;
 private String email;
 
 //Constructeur
public Personne(int idPersonne, String nom, String prenom, String motDePasse, String email) {
	super();
	this.idPersonne = idPersonne;
	this.nom = nom;
	this.prenom = prenom;
	this.motDePasse = motDePasse;
	this.email = email;
}

//Getter & Setter
public int getIdPersonne() {
	return idPersonne;
}

public void setIdPersonne(int idPersonne) {
	this.idPersonne = idPersonne;
}

public String getNom() {
	return nom;
}

public void setNom(String nom) {
	this.nom = nom;
}

public String getPrenom() {
	return prenom;
}

public void setPrenom(String prenom) {
	this.prenom = prenom;
}

public String getMotDePasse() {
	return motDePasse;
}

public void setMotDePasse(String motDePasse) {
	this.motDePasse = motDePasse;
}
public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}
 
}
