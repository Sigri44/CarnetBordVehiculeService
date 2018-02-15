package fr.eni.projetcbvs.dal;

import java.util.List;
import fr.eni.projetcbvs.bo.Personne;

public interface PersonneDAO {
	public void insert(Personne data) throws DALException;
	public void update(Personne data) throws DALException;	
	public void delete(int id) throws DALException;
	public Personne selectById(int id) throws DALException;
	public List<Personne> selectAll() throws DALException;
	public Personne selectByEmailAndPassword(String email, String password) throws DALException;
}
