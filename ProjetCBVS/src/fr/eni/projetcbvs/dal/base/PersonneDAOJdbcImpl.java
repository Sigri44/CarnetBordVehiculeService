package fr.eni.projetcbvs.dal.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.PersonneDAO;

public class PersonneDAOJdbcImpl implements PersonneDAO{
	
	private static final String SQL_SELECTBYID = "SELECT idPersonne, nom, prenom, email, motDePasse, niveau FROM Personne WHERE idPersonne = ?";
	private static final String SQL_SELECTALL = "SELECT idPersonne, nom, prenom, email, motDePasse, niveau FROM Personne";
	private static final String SQL_UPDATE = "UPDATE Personne SET nom=?,prenom=?,email=?,motDePasse=?,niveau=? WHERE idPersonne=?";
	private static final String SQL_INSERT = "INSERT INTO Personne(nom, prenom, email, motDePasse, niveau) VALUES(?,?,?,?,?)";
	private static final String SQL_DELETE = "DELETE FROM Personne WHERE idPersonne=?";
	private static final String SQL_VERIFUTILISATEUR = "SELECT idPersonne, nom, prenom, email, motDePasse, niveau FROM Personne WHERE email=? And motDePasse=?";
	
	// Constructeur
	public PersonneDAOJdbcImpl() {

	}
	
	@Override
	public void insert(Personne personne) throws DALException {
		Connection cnx=null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1,personne.getNom());
			rqt.setString(2,personne.getPrenom());
			rqt.setString(3,personne.getEmail());
			rqt.setString(4, personne.getMotDePasse());
			rqt.setInt(5,personne.getNiveau());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			personne.setIdPersonne(key.getInt(1));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if (cnx!=null){
				try {
					cnx.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void update(Personne personne) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, personne.getNom());
			rqt.setString(2, personne.getPrenom());
			rqt.setString(3, personne.getEmail());
			rqt.setString(4, personne.getMotDePasse());
			rqt.setInt(5, personne.getNiveau());
			rqt.setInt(6, personne.getIdPersonne());
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + personne, e);
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void delete(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, id);
			rqt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public Personne selectById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personne personne = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBYID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				personne = new Personne(rs.getInt("idPersonne"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"), rs.getString("motDePasse"),rs.getInt("niveau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personne;
	}

	@Override
	public List<Personne> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Personne> liste = new ArrayList<Personne>();
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SQL_SELECTALL);
			Personne personne = null;
			while (rs.next()) {
				personne = new Personne(rs.getInt("idPersonne"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"),rs.getString("motDePasse"),rs.getInt("niveau"));
				liste.add(personne);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return liste;
	}

	@Override
	public Personne selectByEmailAndPassword(String email, String password) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Personne personne = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_VERIFUTILISATEUR);
			rqt.setString(1, email);
			rqt.setString(2, password);
			rs = rqt.executeQuery();
			if (rs.next()) {
				personne = new Personne(rs.getInt("idPersonne"),rs.getString("nom"),rs.getString("prenom"),rs.getString("email"), rs.getString("motDePasse"),rs.getInt("niveau"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rqt != null) {
					rqt.close();
					cnx.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return personne;
	}
}
