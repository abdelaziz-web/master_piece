package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import dao.user;
import dao.user_impl;
import dao.DAOFactory;
import dao.blog;
import dao.blog_impl;

/**
 * Servlet implementation class servlet_register
 */
@MultipartConfig
public class servlet_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240 ;
    public static final String CHEMIN_FICHIER = "C:\\Users\\hp\\Desktop\\java\\final\\" ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlet_register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    String titre = request.getParameter("titre");
	        String description = request.getParameter("description");
	        int author_id = Integer.parseInt(request.getParameter("author_id"));
          
       
	        Part filePart = request.getPart("file");
	        String fileName = getFileName(filePart);
	      //  InputStream fileContent = filePart.getInputStream();
	        LocalDate currentDate = LocalDate.now();

	        // Créez un objet DateTimeFormatter avec le format souhaité
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

	        // Formatez la date actuelle en tant que chaîne
	        String formattedDate = currentDate.format(formatter);
	        
	        blog blog_1=  new blog(titre,formattedDate,author_id,description,CHEMIN_FICHIER) ;
	       	        
	        blog_impl blog_im = new blog_impl(DAOFactory.getInstance()) ;
	        
	        blog_im.create(blog_1) ;
	        
	        ecrire_fichier(filePart,fileName,CHEMIN_FICHIER) ;
	        
	        request.setAttribute("message", "l'élement a bien éte enregisterer") ;
	     
	        HttpSession session = request.getSession();
	        
	         user user_1 =   (user) session.getAttribute("user");
	         
	         System.out.println(user_1.getId());
	        
	       this.getServletContext().getRequestDispatcher("/ajouter_blog.jsp").forward( request, response ); 
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		    int i = 0 ;
		
		    String fullname = request.getParameter("fname");
	        String username = request.getParameter("uname");
	        String email = request.getParameter("email");
	        String phone = request.getParameter("phone");
	        String password = request.getParameter("pass");
	        String confirmPassword = request.getParameter("co_pass");
	        String date = request.getParameter("date");
		
	        if (!password.equals(confirmPassword)) {
	            
	        	request.setAttribute("password","password is not confirmed");
	            i++ ;
	        }
	        
	        if(!isValid(fullname)) {
	        	
	        	request.setAttribute("fullname","fullname is non valid");
	        	i++ ;	
	        }
	        
	        if(!isValid(username)) {
	        	
	        	request.setAttribute("username","username is non valid");
        	    i++ ;
	        	
	        }
	        
	        if(!isValidPhone(phone)) {
	        	
	        	request.setAttribute("phone","phone is non valid");
	        	i++;
	        	
	        }
	        
	        if(!isValidEmail(email)) {
	        	
	        	request.setAttribute("email","email is non valid");
        	    i++ ;
	        	
	        }
	        
	      
	        if(i == 0) {
	        	
	        	
	        	user_impl user_1_impl = new  user_impl(DAOFactory.getInstance()) ;
	        	
	        	user user_1 = new user(fullname,email,password,phone,date,username);
	        	 
	        	if(user_1_impl.create(user_1)) {
	        		
	        		request.setAttribute("valider","vous avez bien enregistrer");
	        		
	        	}else {
	        		
	        		request.setAttribute("valider","email is non valid");
	        		
	        	}
	        	
	        }
	        	
	         request.getRequestDispatcher("/sign_up.jsp").forward(request, response);
	        	
	        
	        	
	      
	        
	}

	
	private boolean isValid(String name) {
	    // Vérifier si le nom contient uniquement des lettres et des chiffres
		 return name.matches("[a-zA-Z0-9\\s]+");
	}


	private boolean isValidPhone(String phone) {
	    // Vérifier si le numéro de téléphone suit un format basique (chiffres uniquement)
	    return phone.matches("\\d+");
	}
	
	private boolean isValidEmail(String email) {
	    // Vérifier si l'e-mail suit un format basique
	    return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
	}
	

    private String getFileName(final Part part) {
      final String partHeader = part.getHeader("content-disposition");
      for (String content : partHeader.split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
     return null;
   }  


    private void ecrire_fichier(Part part ,String fileName,String chemin_final)throws IOException {
		
		BufferedInputStream entre = null ;
		BufferedOutputStream sortie  =null;
		
		try {
			entre = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON ) ;
			sortie = new BufferedOutputStream(new FileOutputStream(CHEMIN_FICHIER + fileName ),TAILLE_TAMPON) ;
			
			
			byte[] tampan = new byte[TAILLE_TAMPON];
			int longueur ;
			while( (longueur = entre.read(tampan)) > 0 ) {
				sortie.write(tampan, 0, longueur);
				
			}
			
		}finally {
			try {
				sortie.close() ;
			}catch(IOException ignore) {
				
			}
			try	{
				entre.close() ;
			}catch(IOException ignore) {					
				
			}
			
			
		}
		
       
   }



		 
}


