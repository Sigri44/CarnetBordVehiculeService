package fr.eni.projetcbvs.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.bo.Ville;

public class ConducteurDAOJdbcImpl implements ConducteurDAO{
	
	private static final String SQL_INSERT = "insert into Conducteur(idPersonne, idDeplacement) values(?,?)";
	private static final String SQL_DELETE = "delete from Conducteur where idPersonne=? And idDeplacement=?";
	private static final String SQL_SELECTBYID_CONDUCTEUR = "select idPersonne where idDeplacement = ?";
	
	public ConducteurDAOJdbcImpl() {

	}

	@Override
	public void insert(int idDeplacement, int idPersonne) throws DALException {
		Connection cnx=null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SQL_INSERT);
			rqt.setInt(1,idPersonne);
			rqt.setInt(2,idDeplacement);
			rqt.executeUpdate();
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
	public void delete(int idDeplacement, int idPersonne) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, idPersonne);
			rqt.setInt(2, idDeplacement);
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
	public List<Personne> selectConducteurbyDeplacement(int idDeplacement) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		List<Personne> liste = new ArrayList<Personne>();
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBYID_CONDUCTEUR);
			rqt.setInt(1, idDeplacement);
			rs = rqt.executeQuery();
			PersonneDAO personneDAO = DaoFactory.getPersonneDAO();
			Personne personne = null;
			while (rs.next()) {
				personne = personneDAO.selectById(rs.getInt("idPersonne"));
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

}
