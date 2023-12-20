package dao;

import java.util.List;

public interface blog_interface {

	 public void create( blog blog_1  ) throws DAOException;
	
	 List<blog> getall() throws DAOException;
	 
	 void update( blog blog_1) throws DAOException;
	 
	 void delete( int id) throws DAOException;
	 
	 List<blog> blog_by_id(int id) throws DAOException;
	
	
}
