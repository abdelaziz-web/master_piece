package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import dao.DAOException;



public class blog_impl implements blog_interface {

	
	
	
	
	private DAOFactory        daoFactory;
	

    public blog_impl( DAOFactory daoFactory ) {
        this.daoFactory = daoFactory;
        
    }
    
	public blog_impl() {
		// TODO Auto-generated constructor stub
	}

	 
	  	    private static blog map( ResultSet resultSet ) throws SQLException {
    	   
           blog  blog_1 = new blog()  ;
    	   
    	   blog_1.setBlog_id((int)resultSet.getInt( "blog_id" ));
    	   blog_1.setTitle(resultSet.getString("title") );
    	   blog_1.setDescription( resultSet.getString("description") );
    	   blog_1.setCreated_at( resultSet.getString( "created_at" ) );
    	   blog_1.setAuthor_id((int)resultSet.getInt( "author_id" ));
    	  
    	   
    	
   		   return blog_1;
   		}
       
       
   	public static PreparedStatement initRequestPrepare( Connection connexion, String sql, Object... objets ) throws SQLException {
   	    PreparedStatement preparedStatement = connexion.prepareStatement( sql );
   	    for ( int i = 0; i < objets.length; i++ ) {
   	        preparedStatement.setObject( i + 1, objets[i] );
   	    }
   	    return preparedStatement;
   	}


	
	@Override
	public void create(blog blog_1) throws DAOException {
	
		final String SQL_INSERT = "INSERT INTO  blogs (title ,description,author_id,photo) VALUES (?,?,?,?) ;"  ;
			
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		   // ResultSet resultSet = null;
		    
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_INSERT
		        		,blog_1.getTitle()
		        		,blog_1.getDescription()
		        		,blog_1.getAuthor_id()
		        		,blog_1.getPhoto()
		                 );
		       preparedStatement.execute();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        
		    } catch ( SQLException e ) {
		    	
		    	if (e instanceof SQLIntegrityConstraintViolationException) {
		            if (e.getMessage().contains("Duplicate entry")) {
		                // Gérer le cas de duplication, par exemple, afficher un message à l'utilisateur
		                System.out.println("L'utilisateur avec cet email existe déjà.");
		              
		            }else {
		            	
		            	throw new DAOException( e );	
		            }
		    	}
		    	} finally {
		    	 //ClosingAll( resultSet, preparedStatement, connexion );	
		    }
		
	}

	@Override
	public List<blog> getall() throws DAOException {
	
		 final String SQL_SELECT = "SELECT * FROM blogs " ;
			
			Connection connexion = null;
		    PreparedStatement preparedStatement = null;
		    ResultSet resultSet = null;
		   
		    ArrayList<blog> listeblog = new ArrayList<>();
		    try {
		        /* Récupération d'une connexion depuis la Factory */
		        connexion = daoFactory.getConnection();
		        preparedStatement = initRequestPrepare( connexion, SQL_SELECT);
		        resultSet = preparedStatement.executeQuery();
		        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
		        while ( resultSet.next() ) {
		            
		        	    int id = resultSet.getInt("blog_id");
		                String titre = resultSet.getString("title");
		                String description = resultSet.getString("description");
		                String created_at = resultSet.getString("created_at");
		                int author_id = resultSet.getInt("author_id");

		                String photo = resultSet.getString("photo");
		                blog blog_1 = new blog( id,author_id ,titre, description, created_at,photo); 
		               
		               listeblog.add(blog_1) ;  
		        	
		        }
		    } catch ( SQLException e ) {
		        throw new DAOException( e );
		    } finally {
		        //ClosingAll( resultSet, preparedStatement, connexion );
		    }

		 //   int nombreElements = listeInvestisseur.size();
		 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
		    
		    return listeblog ;
		
		
	}

	@Override
	public void update(blog blog_1) throws DAOException {

		final String SQL_SELECT_Update = "UPDATE blogs SET title = ?, description = ?, photo = ? WHERE blog_id = ? ;";
		
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	   // ResultSet resultSet = null;
	    
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT_Update ,
	        		blog_1.getTitle(),
	        		blog_1.getDescription(),
	                blog_1.getPhoto(),
	                blog_1.getBlog_id()
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

		final String SQL_SELECT_DELETE = "DELETE FROM blogs WHERE blog_id = ?" ;
		
		
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

	@Override
	public List<blog> blog_by_id(int id_1) throws DAOException {
		// TODO Auto-generated method stub
		
		final String SQL_SELECT = "SELECT * FROM blogs WHERE author_id = ?;" ;
		
		Connection connexion = null;
	    PreparedStatement preparedStatement = null;
	    ResultSet resultSet = null;
	   
	    ArrayList<blog> listeblog = new ArrayList<>();
	    try {
	        /* Récupération d'une connexion depuis la Factory */
	        connexion = daoFactory.getConnection();
	        preparedStatement = initRequestPrepare( connexion, SQL_SELECT, id_1);
	        resultSet = preparedStatement.executeQuery();
	        /* Parcours de la ligne de données de l'éventuel ResulSet retourné */
	        while ( resultSet.next() ) {
	            
	        	    int id = resultSet.getInt("blog_id");
	                String titre = resultSet.getString("title");
	                String description = resultSet.getString("description");
	                String created_at = resultSet.getString("created_at");
	                int author_id = resultSet.getInt("author_id");
	                String photo = resultSet.getString("photo");

	               blog blog_1 = new blog( id,author_id ,titre, description, created_at,photo); 
	               listeblog.add(blog_1) ;  
	        	
	        }
	    } catch ( SQLException e ) {
	        throw new DAOException( e );
	    } finally {
	        //ClosingAll( resultSet, preparedStatement, connexion );
	    }

	 //   int nombreElements = listeInvestisseur.size();
	 //   System.out.println("Le nombre d'éléments dans la liste est : " + nombreElements);
	    
	    return listeblog ;	

	
	}

}
