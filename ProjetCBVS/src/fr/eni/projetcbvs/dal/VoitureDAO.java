package fr.eni.projetcbvs.dal;

import java.util.List;
import fr.eni.projetcbvs.bo.Voiture;

public interface VoitureDAO {
	public void insert(Voiture data) throws DALException;
	public void update(Voiture data) throws DALException;	
	public void delete(int id) throws DALException;
	public Voiture selectById(int id) throws DALException;
	public List<Voiture> selectAll() throws DALException;
}
