package fr.eni.projetcbvs.dal;

import java.util.List;

import fr.eni.projetcbvs.bo.Personne;

public class PersonneDAOJdbcImpl implements PersonneDAO{
	
	private static final String SQL_SELECTBYID = "select idPersonne, nom, prenom, email, motDePasse, niveau from Personne where idPersonne = ?";
	private static final String SQL_SELECTALL = "select idPersonne, nom, prenom, email, motDePasse, niveau from Personne";
	private static final String SQL_UPDATE = "update Personne set nom=?,prenom=?,email=?,motDePasse=?,niveau=? where idPersonne=?";
	private static final String SQL_INSERT = "insert into Personne(nom, prenom, email, motDePasse, niveau) values(?,?,?,?,?)";
	private static final String SQL_DELETE = "delete from Personne where idPersonne=?";
	
	// Constructeur
	public PersonneDAOJdbcImpl() {

	}
	
	@Override
	public void insert(Personne data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Personne data) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Personne selectById(int id) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Personne> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
