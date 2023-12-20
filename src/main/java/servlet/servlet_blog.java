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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import dao.DAOFactory;
import dao.blog;
import dao.blog_impl;
import dao.user;
import java.nio.file.Paths;

/**
 * Servlet implementation class servlet_blog
 */

@MultipartConfig
public class servlet_blog extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final int TAILLE_TAMPON = 10240 ;
    public static final String CHEMIN_FICHIER = "C:\\Users\\hp\\Desktop\\aa\\" ;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    

    public servlet_blog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String titre = request.getParameter("titre");
        String description = request.getParameter("description");
        int author_id = Integer.parseInt( request.getParameter("author_id")); 
       
        
     
  
        Part filePart = request.getPart("plan");
        
        
        
        String fileName = getFileName(filePart);;
      //  private String getFileName(final Part part) {
	       
        LocalDate currentDate = LocalDate.now();

        // Créez un objet DateTimeFormatter avec le format souhaité
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Formatez la date actuelle en tant que chaîne
        String formattedDate = currentDate.format(formatter);
        
        blog blog_1=  new blog(titre,formattedDate,author_id,description,CHEMIN_FICHIER+fileName) ;
       	        
        blog_impl blog_im = new blog_impl(DAOFactory.getInstance()) ;
        
        blog_im.create(blog_1) ;
        
        ecrire_fichier(filePart,fileName,CHEMIN_FICHIER) ;
        
        request.setAttribute("message", "l'élement a bien éte enregisterer") ;
     
      //  HttpSession session = request.getSession();
        
      //   user user_1 =   (user) session.getAttribute("user");
         
     //    System.out.println(user_1.getId());
        
       this.getServletContext().getRequestDispatcher("/ajouter_blog.jsp").forward( request, response ); 
	
	
		
		
	}
	



private void ecrire_fichier(Part part ,String fileName,String chemin_final)throws IOException {
	
	BufferedInputStream entre = null ;
	BufferedOutputStream sortie  =null;
	
	String fullPath = CHEMIN_FICHIER+fileName  ;
	
	try {
		entre = new BufferedInputStream(part.getInputStream(), TAILLE_TAMPON ) ;
		sortie = new BufferedOutputStream(new FileOutputStream(fullPath ),TAILLE_TAMPON) ;
		
		
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

private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    for (String content : partHeader.split(";")) {
      if (content.trim().startsWith("filename")) {
          return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
      }
  }
   return null;
 } 
	

public static String generateRandomName(int NAME_LENGTH) {
    Random random = new Random();
    String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < NAME_LENGTH; i++) {
        int index = random.nextInt(ALPHABET.length());
        char randomChar = ALPHABET.charAt(index);
        sb.append(randomChar);
    }

 return sb.toString();
 
 
}



}
