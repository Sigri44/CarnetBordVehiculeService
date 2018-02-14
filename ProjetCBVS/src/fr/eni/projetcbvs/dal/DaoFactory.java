package fr.eni.projetcbvs.dal;

import fr.eni.projetcbvs.dal.base.CarnetDAOJdbcImpl;
import fr.eni.projetcbvs.dal.base.ConducteurDAOJdbcImpl;
import fr.eni.projetcbvs.dal.base.DeplacementDAOJdbcImpl;
import fr.eni.projetcbvs.dal.base.PersonneDAOJdbcImpl;
import fr.eni.projetcbvs.dal.base.VilleDAOJdbcImpl;
import fr.eni.projetcbvs.dal.base.VoitureDAOJdbcImpl;

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
	
	public static VilleDAO getVilleDAO(){
		VilleDAO villeDAO = null;
		villeDAO = new VilleDAOJdbcImpl();
		return villeDAO;
	}
	
	public static ConducteurDAO getConducteurDAO(){
		ConducteurDAO conducteurDAO = null;
		conducteurDAO = new ConducteurDAOJdbcImpl();
		return conducteurDAO;
	}
	
	public static CarnetDAO getCarnetDAO(){
		CarnetDAO carnetDAO = null;
		carnetDAO = new CarnetDAOJdbcImpl();
		return carnetDAO;
	}
}
