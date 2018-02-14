package fr.eni.projetcbvs.dal;

import java.util.List;


public interface CarnetDAO {

	public void insert(int idDeplacement, int idVoiture) throws DALException;	
	public void delete(int idDeplacement, int idVoiture) throws DALException;
	
}
