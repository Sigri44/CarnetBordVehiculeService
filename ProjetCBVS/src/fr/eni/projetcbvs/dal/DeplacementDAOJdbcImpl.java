package fr.eni.projetcbvs.dal;

import java.util.List;

import fr.eni.projetcbvs.bo.Personne;

public class DeplacementDAOJdbcImpl implements DeplacementDAO{

	private static final String SQL_SELECTBYID = "select idDeplacement, dateDepart, dateRetour, lieuDepart, lieuRetour, montantCarburant, litreCarburant, commentaire, kmTotal, kmPlein, distanceParcouru from Deplacement where idDeplacement = ?";
	private static final String SQL_SELECTALL = "select idDeplacement, dateDepart, dateRetour, lieuDepart, lieuRetour, montantCarburant, litreCarburant, commentaire, kmTotal, kmPlein, distanceParcouru from Deplacement";
	private static final String SQL_UPDATE = "update Deplacement set dateDepart=?,dateRetour=?,lieuDepart=?,lieuRetour=?,montantCarburant=?,litreCarburant=?,commentaire=?,kmTotal=?,kmPlein=?,distanceParcouru=? where idDeplacement=?";
	private static final String SQL_INSERT = "insert into Deplacement(dateDepart, dateRetour, lieuDepart, lieuRetour, montantCarburant, litreCarburant, commentaire, kmTotal, kmPlein, distanceParcouru) values(?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "delete from Deplacement where idDeplacement=?";
	
	// Constructeur
	public DeplacementDAOJdbcImpl() {

	}
	
	/*@Override
	public void insert(Deplacement data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Deplacement data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Deplacement selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Deplacement> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}*/

	
}
