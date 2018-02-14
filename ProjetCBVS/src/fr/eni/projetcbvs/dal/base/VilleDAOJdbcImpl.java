package fr.eni.projetcbvs.dal.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetcbvs.bo.Ville;
import fr.eni.projetcbvs.bo.Voiture;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.VilleDAO;

public class VilleDAOJdbcImpl implements VilleDAO{

	private static final String SQL_SELECTBYID = "select idVille, Ville, adresse from Ville where idVille = ?";
	private static final String SQL_SELECTALL = "select idVille, Ville, adresse from Ville";
	private static final String SQL_UPDATE = "update Ville set Ville=?,adresse=? where idDeplacement=?";
	private static final String SQL_INSERT = "insert into Ville(Ville, adresse) values(?,?)";
	private static final String SQL_DELETE = "delete from Ville where idVille=?";

	// Constructeur
	public VilleDAOJdbcImpl() {

	}

	@Override
	public void insert(Ville ville) throws DALException {
		Connection cnx=null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setString(1,ville.getVille());
			rqt.setString(2,ville.getAdresse());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			ville.setIdVille(key.getInt(1));
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
	public void update(Ville ville) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setString(1, ville.getVille());
			rqt.setString(2, ville.getAdresse());
			rqt.setInt(3, ville.getIdVille());
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + ville, e);
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
	public Ville selectById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Ville ville = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBYID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			if (rs.next()) {
				ville = new Ville(rs.getInt("idVille"),rs.getString("Ville"),rs.getString("adresse"));
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
		return ville;
	}

	@Override
	public List<Ville> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Ville> liste = new ArrayList<Ville>();
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SQL_SELECTALL);
			Ville ville = null;
			while (rs.next()) {
				ville = new Ville(rs.getInt("idVille"),rs.getString("Ville"),rs.getString("adresse"));
				liste.add(ville);
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

}
