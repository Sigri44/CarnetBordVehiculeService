package fr.eni.projetcbvs.dal;

import java.util.List;

public class CarnetDAOJdbcImpl implements CarnetDAO{

	private static final String SQL_SELECTBYID = "select idVoiture, idDeplacement from Carnet where idVoiture=? And idDeplacement=?";
	private static final String SQL_SELECTALL = "select idVoiture, idDeplacement from Carnet";
	private static final String SQL_UPDATE = "update Carnet set idVoiture=?,idDeplacement=? where idVoiture=? And idDeplacement=?";
	private static final String SQL_INSERT = "insert into Carnet(idVoiture, idDeplacement) values(?,?)";
	private static final String SQL_DELETE = "delete from Carnet where idVoiture=? And idDeplacement=?";

	// Constructeur
	public CarnetDAOJdbcImpl() {

	}

	@Override
	public void insert(int idDeplacement, int idVoiture) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int idDeplacement, int idVoiture) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idDeplacement, int idVoiture) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] selectById(int idDeplacement, int idVoiture) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<int[]> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
