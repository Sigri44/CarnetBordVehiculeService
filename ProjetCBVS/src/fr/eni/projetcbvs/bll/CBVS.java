package fr.eni.projetcbvs.bll;

import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.DaoFactory;
import fr.eni.projetcbvs.dal.PersonneDAO;

public class CBVS {

	public static boolean verifAnim(int niveau){
		boolean administrateur;
		if(niveau != 1){
			administrateur=false;
		}else{
			administrateur=true;
		}
		return administrateur;
	}
	
	public static int VerifConnexion(String email, String password){
		int niveau = 0;
		Personne personne = null;
		PersonneDAO personneDAO = DaoFactory.getPersonneDAO();
		try {
			personne = personneDAO.selectByEmailAndPassword(email, password);
			if(personne != null){
				niveau = personne.getNiveau();
			}
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return niveau;
	}
	
	
}