package fr.eni.projetcbvs.dal.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import fr.eni.projetcbvs.bo.Deplacement;
import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.bo.Ville;
import fr.eni.projetcbvs.dal.ConducteurDAO;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.DaoFactory;
import fr.eni.projetcbvs.dal.DeplacementDAO;

public class DeplacementDAOJdbcImpl implements DeplacementDAO{

	private static final String SQL_SELECTBYID = "select idDeplacement, dateDepart, dateRetour, lieuDepart, lieuRetour, natureDeplacement, montantCarburant, litreCarburant, commentaire, kmTotal, kmPlein, distanceParcouru from Deplacement where idDeplacement = ?";
	private static final String SQL_SELECTALL = "select idDeplacement, dateDepart, dateRetour, lieuDepart, lieuRetour, natureDeplacement, montantCarburant, litreCarburant, commentaire, kmTotal, kmPlein, distanceParcouru from Deplacement";
	private static final String SQL_UPDATE = "update Deplacement set dateDepart=?,dateRetour=?,lieuDepart=?,lieuRetour=?,natureDeplacement=?,montantCarburant=?,litreCarburant=?,commentaire=?,kmTotal=?,kmPlein=?,distanceParcouru=? where idDeplacement=?";
	private static final String SQL_INSERT = "insert into Deplacement(dateDepart, dateRetour, lieuDepart, lieuRetour, natureDeplacement, montantCarburant, litreCarburant, commentaire, kmTotal, kmPlein, distanceParcouru) values(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String SQL_DELETE = "delete from Deplacement where idDeplacement=?";
	
	// Constructeur
	public DeplacementDAOJdbcImpl() {

	}

	@Override
	public int insert(Deplacement deplacement) throws DALException {
		Connection cnx=null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
			rqt.setDate(1,new Date (deplacement.getDateDepart().getTimeInMillis()));
			rqt.setDate(2,new Date (deplacement.getDateRetour().getTimeInMillis()));
			rqt.setInt(3,deplacement.getLieuDepart());
			rqt.setInt(4,deplacement.getLieuRetour());
			rqt.setString(5,deplacement.getNatureDeplacement());
			rqt.setFloat(6,deplacement.getMontantCarburant());
			rqt.setInt(7,deplacement.getLitreCarburant());
			rqt.setString(8,deplacement.getCommentaire());
			rqt.setInt(9,deplacement.getKmTotal());
			rqt.setInt(10,deplacement.getKmPlein());
			rqt.setInt(11,deplacement.getDistanceParcouru());
			rqt.executeUpdate();
			ResultSet key = rqt.getGeneratedKeys();
			key.next();
			deplacement.setIdDeplacement(key.getInt(1));
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
		return deplacement.getIdDeplacement();
	}

	@Override
	public int update(Deplacement deplacement) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_UPDATE);
			rqt.setDate(1,new Date (deplacement.getDateDepart().getTimeInMillis()));
			rqt.setDate(2,new Date (deplacement.getDateRetour().getTimeInMillis()));
			rqt.setInt(3,deplacement.getLieuDepart());
			rqt.setInt(4,deplacement.getLieuRetour());
			rqt.setString(5,deplacement.getNatureDeplacement());
			rqt.setFloat(6,deplacement.getMontantCarburant());
			rqt.setInt(7,deplacement.getLitreCarburant());
			rqt.setString(8,deplacement.getCommentaire());
			rqt.setInt(9,deplacement.getKmTotal());
			rqt.setInt(10,deplacement.getKmPlein());
			rqt.setInt(11,deplacement.getDistanceParcouru());
			rqt.setInt(12,deplacement.getIdDeplacement());
			rqt.executeUpdate();

		} catch (SQLException e) {
			throw new DALException("Update article failed - " + deplacement, e);
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
		return deplacement.getIdDeplacement();
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
	public Deplacement selectById(int id) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		ResultSet rs = null;
		Deplacement deplacement = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_SELECTBYID);
			rqt.setInt(1, id);
			rs = rqt.executeQuery();
			List<Personne> listeP = new ArrayList<Personne>();
			ConducteurDAO conducteurDAO = DaoFactory.getConducteurDAO();
			if (rs.next()) {
				GregorianCalendar dateDepart = new GregorianCalendar();
				GregorianCalendar dateRetour = new GregorianCalendar();
				dateDepart.setTime(rs.getDate("dateDepart"));
				dateRetour.setTime(rs.getDate("dateRetour"));
				listeP = conducteurDAO.selectConducteurbyDeplacement(rs.getInt("idDeplacement"));
				deplacement = new Deplacement(rs.getInt("idDeplacement"),dateDepart,dateRetour,rs.getInt("lieuDepart"),rs.getInt("lieuRetour"),rs.getString("natureDeplacement"),rs.getFloat("montantCarburant"),rs.getInt("litreCarburant"),rs.getString("commentaire"),rs.getInt("kmTotal"),rs.getInt("kmPlein"),rs.getInt("distanceParcouru"),listeP);
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
		return deplacement;
	}

	@Override
	public List<Deplacement> selectAll() throws DALException {
		Connection cnx = null;
		Statement rqt = null;
		ResultSet rs = null;
		List<Deplacement> liste = new ArrayList<Deplacement>();
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.createStatement();
			rs = rqt.executeQuery(SQL_SELECTALL);
			Deplacement deplacement = null;
			List<Personne> listeP = new ArrayList<Personne>();
			ConducteurDAO conducteurDAO = DaoFactory.getConducteurDAO();
			while (rs.next()) {
				GregorianCalendar dateDepart = new GregorianCalendar();
				GregorianCalendar dateRetour = new GregorianCalendar();
				dateDepart.setTime(rs.getDate("dateDepart"));
				dateRetour.setTime(rs.getDate("dateRetour"));
				listeP = conducteurDAO.selectConducteurbyDeplacement(rs.getInt("idDeplacement"));
				deplacement = new Deplacement(rs.getInt("idDeplacement"),dateDepart,dateRetour,rs.getInt("lieuDepart"),rs.getInt("lieuRetour"),rs.getString("natureDeplacement"),rs.getFloat("montantCarburant"),rs.getInt("litreCarburant"),rs.getString("commentaire"),rs.getInt("kmTotal"),rs.getInt("kmPlein"),rs.getInt("distanceParcouru"),listeP);
				liste.add(deplacement);
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
