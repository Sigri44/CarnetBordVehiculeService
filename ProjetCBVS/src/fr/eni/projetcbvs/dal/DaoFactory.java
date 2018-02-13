package fr.eni.projetcbvs.dal;

public class DaoFactory {
	
	public static VoitureDAO getVoitureDAO(){
		VoitureDAO voitureDAO = null;
		voitureDAO = new VoitureDAOJdbcImpl();
		return voitureDAO;
	}
	
	public static PersonneDAO getPersonneDAO(){
		PersonneDAO personneDAO = null;
		personneDAO = new PersonneDAOJdbcImpl();
		return personneDAO;
	}
	
	public static DeplacementDAO getDeplacementDAO(){
		DeplacementDAO deplacementDAO = null;
		deplacementDAO = new DeplacementDAOJdbcImpl();
		return deplacementDAO;
	}
}
