package fr.eni.projetcbvs.dal;

import java.util.List;

import fr.eni.projetcbvs.bo.Ville;

public interface VilleDAO {

	public void insert(Ville data) throws DALException;
	public void update(Ville data) throws DALException;	
	public void delete(int id) throws DALException;
	public Ville selectById(int id) throws DALException;
	public List<Ville> selectAll() throws DALException;
}
