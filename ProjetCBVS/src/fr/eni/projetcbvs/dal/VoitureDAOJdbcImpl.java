package fr.eni.projetcbvs.dal;

import java.util.List;

import fr.eni.projetcbvs.bo.Voiture;

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
		public void insert(Voiture data) throws DALException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void update(Voiture data) throws DALException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void delete(int id) throws DALException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Voiture selectById(int id) throws DALException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<Voiture> selectAll() throws DALException {
			// TODO Auto-generated method stub
			return null;
		}
}
