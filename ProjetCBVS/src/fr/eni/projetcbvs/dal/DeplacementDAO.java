package fr.eni.projetcbvs.dal;

import java.util.List;
import fr.eni.projetcbvs.bo.Deplacement;

public interface DeplacementDAO {
	public int insert(Deplacement data) throws DALException;
	public int update(Deplacement data) throws DALException;	
	public void delete(int id) throws DALException;
	public Deplacement selectById(int id) throws DALException;
	public List<Deplacement> selectAll() throws DALException;
}
