package fr.eni.projetcbvs.dal;

import java.util.List;

public class ConducteurDAOJdbcImpl implements ConducteurDAO{
	
	private static final String SQL_SELECTBYID = "select idPersonne, idDeplacement from Conducteur where idPersonne=? And idDeplacement=?";
	private static final String SQL_SELECTALL = "select idPersonne, idDeplacement from Conducteur";
	private static final String SQL_UPDATE = "update Conducteur set idPersonne=?,idDeplacement=? where idPersonne=? And idDeplacement=?";
	private static final String SQL_INSERT = "insert into Conducteur(idPersonne, idDeplacement) values(?,?)";
	private static final String SQL_DELETE = "delete from Conducteur where idPersonne=? And idDeplacement=?";
	
	public ConducteurDAOJdbcImpl() {

	}

	@Override
	public void insert(int idDeplacement, int idPersonne) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(int idDeplacement, int idPersonne) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int idDeplacement, int idPersonne) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int[] selectById(int idDeplacement, int idPersonne) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<int[]> selectAll() throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
