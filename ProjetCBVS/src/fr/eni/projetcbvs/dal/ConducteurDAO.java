package fr.eni.projetcbvs.dal;

import java.util.List;

import fr.eni.projetcbvs.bo.Personne;

public interface ConducteurDAO {
	
	public void insert(int idDeplacement, int idPersonne) throws DALException;
	public void delete(int idDeplacement, int idPersonne) throws DALException;
	public List<Personne>selectConducteurbyDeplacement(int idDeplacement) throws DALException;

}
