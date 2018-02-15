package fr.eni.projetcbvs.bll;

import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.DaoFactory;
import fr.eni.projetcbvs.dal.PersonneDAO;

public class CBVS {

	public static boolean verifAnim(int niveau){
		boolean animateur;
		if(niveau != 1){
			animateur=false;
		}else{
			animateur=true;
		}
		return animateur;
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