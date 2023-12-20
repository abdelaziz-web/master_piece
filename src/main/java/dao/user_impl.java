package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOException;



public   class user_impl  implements  user_interface  {
	
		private DAOFactory        daoFactory;
		

	    public user_impl( DAOFactory daoFactory ) {
	        this.daoFactory = daoFactory;
	        
	    }
	    
		public user_impl() {
			// TODO Auto-generated constructor stub
		}

		 
		  	    private static user map( ResultSet resultSet ) throws SQLException {
	    	   
               user user_1 = new user()  ;
	    	   
	    	   user_1.setId((int)resultSet.getInt( "user_id" ));
	    	   user_1.setFull_name(resultSet.getString("full_name") );
	    	   user_1.setEmail( resultSet.getString("email") );
	    	   user_1.setPassword( resultSet.getString( "password" ) );
	    	   user_1.setPhone_number( resultSet.getString( "phone_number" ) );
	    	   user_1.setDate_of_birth( resultSet.getString( "date_of_birth" ) );
	    	   user_1.setPhoto( resultSet.getString( "photo_path" ) );
	    	   user_1.setUsername( resultSet.getString( "username" ) );
	    	   
	    	
	   		return user_1;
	   		}
	       
	       
	   	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
	   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
	   	    for ( int i = 0; i < objets.length; i++ ) {
	   	        preparedStatement.setObject( i + 1, objets[i] );
	   	    }
	   	    return preparedStatement;
	   	}

		
	   	
	   	@Override
		public Boolean create(user user_1) throws DAOException {
			
			  final String SQL_INSERT = "INSERT INTO  users (full_name,email ,password,phone_number	,date_of_birth,username) VALUES (?,?,?,?,?,?) ;"  ;
   			
			  Boolean email_valider = true ;	
			  
				Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			   // ResultSet resultSet = null;
			    
			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_INSERT
			        		,user_1.getFull_name()
			        		,user_1.getEmail()
			        		,user_1.getPassword()
			                ,user_1.getPassword()
			                ,user_1.getDate_of_birth()
			                ,user_1.getUsername());
			       preparedStatement.execute();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        
			    } catch ( SQLException e ) {
			    	
			    	if (e instanceof SQLIntegrityConstraintViolationException) {
			            if (e.getMessage().contains("Duplicate entry")) {
			                // Gérer le cas de duplication, par exemple, afficher un message à l'utilisateur
			                System.out.println("L'utilisateur avec cet email existe déjà.");
			                
			                email_valider = false ;
			            }else {
			            	
			            	throw new DAOException( e );	
			            }
			    	}
			    	} finally {
			    	 //ClosingAll( resultSet, preparedStatement, connexion );	
			    }
	
			return email_valider;
		}
	   	

		
		
		@Override
		public user find(String email, String mot_pass) throws DAOException {
						  
			    user user_1 =  new user()  ;
			
			    final String SQL_SELECT_PAR_NOM = "SELECT * FROM users WHERE email = ? and password = ? ; ";
			    Connection connexion = null;
			    PreparedStatement preparedStatement = null;
			    ResultSet resultSet = null;
			 //   PersonBean personBean = null;

			    try {
			        /* Récupération d'une connexion depuis la Factory */
			        connexion = daoFactory.getConnection();
			        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_PAR_NOM, email, mot_pass );
			        resultSet = preparedStatement.executeQuery();
			        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
			        if ( resultSet.next() ) {
			        	user_1 = map( resultSet );     
			        }else {
			        	user_1 = null ;
			        }
			    } catch ( SQLException e ) {
			        throw new DAOException( e );
			    } finally {
			        //ClosingAll( resultSet, preparedStatement, connexion );
			    }

			    return user_1;       
		}
	

		@Override
		public List<user> getall() throws DAOException {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void update(user user_1) throws DAOException {
			// TODO Auto-generated method stub
			
			final String SQL_SELECT_Update = "UPDATE blogs SET full_name = ?, username = ?, email"
					+ " phone_number = ? ,date_of_birth = ?, photo_path  =  ?, password = ?   WHERE user_id = ? ;";
			
			
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		   // ResultSet resultSet = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_Update ,
		        		user_1.getFull_name(),
		        		user_1.getUsername(),
		                user_1.getEmail(),
		                user_1.getPhone_number(),
		                user_1.getDate_of_birth(),
		                user_1.getPhoto(),
		                user_1.getPassword() 
		                );
		        preparedStatement.execute();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
			
			
			
		}

		@Override
		public void delete(int id) throws DAOException {
			// TODO Auto-generated method stub
		
			final String SQL_SELECT_DELETE = "DELETE FROM users WHERE user_id = ?" ;
			
			
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		   // ResultSet resultSet = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_DELETE,
		        String.valueOf(id) );
		        preparedStatement.execute();
		       	        
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }
			
		}

		}
