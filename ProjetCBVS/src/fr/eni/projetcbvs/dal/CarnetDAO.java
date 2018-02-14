package fr.eni.projetcbvs.dal;

import java.util.List;

public interface CarnetDAO {

	public void insert(int idDeplacement, int idVoiture) throws DALException;
	public void update(int idDeplacement, int idVoiture) throws DALException;	
	public void delete(int idDeplacement, int idVoiture) throws DALException;
	public int[] selectById(int idDeplacement, int idVoiture) throws DALException;
	public List<int[]> selectAll() throws DALException;
	
}
