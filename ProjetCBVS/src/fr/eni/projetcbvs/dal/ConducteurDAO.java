package fr.eni.projetcbvs.dal;

import java.util.List;

public interface ConducteurDAO {
	
	public void insert(int idDeplacement, int idPersonne) throws DALException;
	public void update(int idDeplacement, int idPersonne) throws DALException;	
	public void delete(int idDeplacement, int idPersonne) throws DALException;
	public int[] selectById(int idDeplacement, int idPersonne) throws DALException;
	public List<int[]> selectAll() throws DALException;

}
