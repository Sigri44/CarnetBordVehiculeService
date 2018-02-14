package fr.eni.projetcbvs.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.projetcbvs.bo.Carnet;
import fr.eni.projetcbvs.bo.Ville;

public class CarnetDAOJdbcImpl implements CarnetDAO{

	private static final String SQL_INSERT = "insert into Carnet(idVoiture, idDeplacement) values(?,?)";
	private static final String SQL_DELETE = "delete from Carnet where idVoiture=? And idDeplacement=?";

	// Constructeur
	public CarnetDAOJdbcImpl() {

	}

	@Override
	public void insert(int idDeplacement, int idVoiture) throws DALException {
		Connection cnx=null;
		try {
			cnx = AccesBase.getConnection();
			PreparedStatement rqt = cnx.prepareStatement(SQL_INSERT);
			rqt.setInt(1,idVoiture);
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
	public void delete(int idDeplacement, int idVoiture) throws DALException {
		Connection cnx = null;
		PreparedStatement rqt = null;
		try {
			cnx = AccesBase.getConnection();
			rqt = cnx.prepareStatement(SQL_DELETE);
			rqt.setInt(1, idVoiture);
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

}
