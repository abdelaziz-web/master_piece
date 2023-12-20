<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Animated Login Form</title>
	<link rel="stylesheet" type="text/css" href="Css_1/style.css">
	<link href="https://fonts.googleapis.com/css?family=Poppins:600&display=swap" rel="stylesheet">
	<script src="https://kit.fontawesome.com/a81368914c.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<style>
		.rounded-image {
		  border-radius: 20px; /* Vous pouvez ajuster la valeur selon vos préférences */
		  overflow: hidden;   /* Assurez-vous que les coins arrondis sont visibles */
		}
	  </style>
</head>
<body>
	<img class="wave" src="img/wave.png">
	<div class="container">
		<div class="img">
			<div class="rounded-image">
			<img src="Paincare1.png" class="rounded">
		</div>
		</div>
		<div class="login-content">
			<form action="auth_serv" method="post">
				<img src="mns.png" width="100" height="300" >
				<h2 class="title">Bienvenue :</h2>
           		<div class="input-div one">
           		   <div class="i">
           		   		<i class="fas fa-user"></i>
           		   </div>
           		   <div class="div">
           		   		<h5>email :</h5>
           		   		<input type="text" class="input" name="email">
           		   </div>
           		</div>
           		<div class="input-div pass">
           		   <div class="i"> 
           		    	<i class="fas fa-lock"></i>
           		   </div>
           		   <div class="div">
           		    	<h5>Mot de pass :</h5>
           		    	<input type="password" class="input" name ="password">
            	   </div>
            	</div>
            	
            	 <% String valide = (String) request.getAttribute("valide"); %>

                 <%-- Utiliser out.println pour afficher le message --%>
              <% if (valide != null && !valide.isEmpty()) { %>
                
                <div class="alert alert-danger" role="alert">
                 <p class="alert alert-danger"  > <%= valide %></p>
                 </div>
        
              <% } %>
                 
            	
            	<input type="submit" class="btn" value="Login">
            </form>
        </div>
    </div>
    <button type="button" >Primary</button>

    <script type="text/javascript" src="js_1/main.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</body>
</html>
