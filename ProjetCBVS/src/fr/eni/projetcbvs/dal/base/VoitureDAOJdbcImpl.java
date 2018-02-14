package fr.eni.projetcbvs.dal.base;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetcbvs.bo.Personne;
import fr.eni.projetcbvs.bo.Voiture;
import fr.eni.projetcbvs.dal.DALException;
import fr.eni.projetcbvs.dal.VoitureDAO;

public class VoitureDAOJdbcImpl implements VoitureDAO{

		private static final String SQL_SELECTBYID = "select idVoiture, immatriculation, kilometrage from Voiture where idVoiture = ?";
		private static final String SQL_SELECTALL = "select idVoiture, immatriculation, kilometrage from Voiture";
		private static final String SQL_UPDATE = "update Voiture set immatriculation=?,kilometrage=? where idVoiture=?";
		private static final String SQL_INSERT = "insert into Voiture(immatriculation, kilometrage) values(?,?)";
		private static final String SQL_DELETE = "delete from Voiture where idVoiture=?";
		
		// Constructeur
		public VoitureDAOJdbcImpl() {

		}

		@Override
		public void insert(Voiture voiture) throws DALException {
			Connection cnx=null;
			try {
				cnx = AccesBase.getConnection();
				PreparedStatement rqt = cnx.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS);
				rqt.setString(1,voiture.getImmatriculation());
				rqt.setInt(2,voiture.getKilometrage());
				rqt.executeUpdate();
				ResultSet key = rqt.getGeneratedKeys();
				key.next();
				voiture.setIdVoiture(key.getInt(1));
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
		public void update(Voiture voiture) throws DALException {
			Connection cnx = null;
			PreparedStatement rqt = null;
			try {
				cnx = AccesBase.getConnection();
				rqt = cnx.prepareStatement(SQL_UPDATE);
				rqt.setString(1, voiture.getImmatriculation());
				rqt.setInt(2, voiture.getKilometrage());
				rqt.setInt(3, voiture.getIdVoiture());
				rqt.executeUpdate();

			} catch (SQLException e) {
				throw new DALException("Update article failed - " + voiture, e);
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
		public Voiture selectById(int id) throws DALException {
			Connection cnx = null;
			PreparedStatement rqt = null;
			ResultSet rs = null;
			Voiture voiture = null;
			try {
				cnx = AccesBase.getConnection();
				rqt = cnx.prepareStatement(SQL_SELECTBYID);
				rqt.setInt(1, id);
				rs = rqt.executeQuery();
				if (rs.next()) {
					voiture = new Voiture(rs.getInt("idVoiture"),rs.getString("Immatriculation"),rs.getInt("kilometrage"));
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
			return voiture;
		}

		@Override
		public List<Voiture> selectAll() throws DALException {
			Connection cnx = null;
			Statement rqt = null;
			ResultSet rs = null;
			List<Voiture> liste = new ArrayList<Voiture>();
			try {
				cnx = AccesBase.getConnection();
				rqt = cnx.createStatement();
				rs = rqt.executeQuery(SQL_SELECTALL);
				Voiture voiture = null;
				while (rs.next()) {
					voiture = new Voiture(rs.getInt("idVoiture"),rs.getString("immatriculation"),rs.getInt("kilometrage"));
					liste.add(voiture);
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
