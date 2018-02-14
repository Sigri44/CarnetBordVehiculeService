package fr.eni.projetcbvs.dal;

public class VilleDAOJdbcImpl implements DeplacementDAO{

	private static final String SQL_SELECTBYID = "select idVille, Ville, adresse from Ville where idVille = ?";
	private static final String SQL_SELECTALL = "select idVille, Ville, adresse from Ville";
	private static final String SQL_UPDATE = "update Ville set Ville=?,adresse=? where idDeplacement=?";
	private static final String SQL_INSERT = "insert into Ville(Ville, adresse) values(?,?)";
	private static final String SQL_DELETE = "delete from Ville where idVille=?";

	// Constructeur
	public VilleDAOJdbcImpl() {

	}

	/*@Override
		public void insert(Ville data) throws DALException {
			// TODO Auto-generated method stub

		}

		@Override
		public void update(Ville data) throws DALException {
			// TODO Auto-generated method stub

		}

		@Override
		public void delete(int id) throws DALException {
			// TODO Auto-generated method stub

		}

		@Override
		public Ville selectById(int id) throws DALException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Ville> selectAll() throws DALException {
			// TODO Auto-generated method stub
			return null;
		}*/

}
