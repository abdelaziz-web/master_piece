package dao;

import java.util.List;


public interface user_interface {
	 public Boolean create( user user_1  ) throws DAOException;
	 public user find (String email, String mot_pass) throws DAOException ;
	 List<user> getall() throws DAOException;
	 void update( user user_1) throws DAOException;
	 void delete( int id) throws DAOException;
	  
}



