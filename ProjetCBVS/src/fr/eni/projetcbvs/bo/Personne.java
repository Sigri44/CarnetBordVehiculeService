package fr.eni.projetcbvs.bo;

public class Personne {
	//instantiation des variables
 private int idPersonne;
 private String nom;
 private String prenom;
 private String motDePasse;
 private String email;
 private int niveau;
 
 //Constructeur
public Personne(int idPersonne, String nom, String prenom, String motDePasse, String email,int niveau) {
	this(nom, prenom, motDePasse, email, niveau);
	this.idPersonne = idPersonne;
}

public Personne(String nom, String prenom, String motDePasse, String email,int niveau) {
	super();
	this.nom = nom;
	this.prenom = prenom;
	this.motDePasse = motDePasse;
	this.email = email;
	this.niveau = niveau;
}

public Personne(){
	
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

public int getNiveau() {
	return niveau;
}

public void setNiveau(int niveau) {
	this.niveau = niveau;
}

 
}
