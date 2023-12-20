<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Register Form</title>
    <link rel="stylesheet" href="style.css" />
    <script
      src="https://kit.fontawesome.com/64d58efce2.js"
      crossorigin="anonymous"
    ></script>

 
  </head>
  <body>
  
  
  <% String myMessage_0 = (String) request.getAttribute("valider"); %>

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (myMessage_0 != null && !myMessage_0.isEmpty()) { %>
              <div class="alert alert-danger" role="alert">
              <%= myMessage_0 %>
              </div>
        
              <% } %> 
  
        
  
  
    <div class="container">
      <span class="big-circle"></span>
      <img src="shape.png" class="square" alt="" />
      <div class="form">
        

        <div class="contact-form">
          <span class="circle one"></span>
          <span class="circle two"></span>

          <form action="servlet_register" method="post">
            <h3 class="title"> Register </h3>
            
            <div class="input-container">
              <input type="text" name="fname" class="input" required />
              <label for="">Fullname</label>
              <span>Fullname</span>
              <% String myMessage_1 = (String) request.getAttribute("fullname"); %>

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (myMessage_1 != null && !myMessage_1.isEmpty()) { %>
              <p><%= myMessage_1 %></p>
        
              <% } %>    
            </div>
            <div class="input-container">
              <input type="text" name="uname" class="input" required />
              <label for="">Username</label>
              <span>Username</span>
              <% String myMessage_2 = (String) request.getAttribute("username"); %>

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (myMessage_2 != null && !myMessage_2.isEmpty()) { %>
              <p><%= myMessage_2 %></p>
        
              <% } %> 
            </div>
            <div class="input-container">
              <input type="email" name="email" class="input" required />
              <label for="">Email</label>
              <span>Email</span>
              <% String myMessage_3 = (String) request.getAttribute("email"); %>

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (myMessage_3 != null && !myMessage_3.isEmpty()) { %>
              <p><%= myMessage_3 %></p>
        
              <% } %>
            </div>
            <div class="input-container">
              <input type="tel" name="phone" class="input" required/>
              <label for="">Phone</label>
              <span>Phone</span>
               <% String myMessage_4 = (String) request.getAttribute("phone"); %>

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (myMessage_4 != null && !myMessage_4.isEmpty()) { %>
              <p><%= myMessage_4 %></p>
        
              <% } %>
            </div>
            <div class="input-container textarea">
              <input type="password" name="pass" class="input"  required/>
              <label for="">Password</label>
              <span>Mot de passe </span>
            </div>
            <div class="input-container textarea">
              <input type="password" name="co_pass" class="input"  required/>
              <label for="">Confirme password</label>
              <span>Confirme password</span>
            </div>
            
            <% String myMessage_5 = (String) request.getAttribute("password"); %>

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (myMessage_5 != null && !myMessage_5.isEmpty()) { %>
              <p><%= myMessage_5 %></p>
        
              <% } %>
                 
              <div class="input-container textarea">
              <input type="date" name="date" class="input"   required/>
              <span>Date de naissance :</span>
            </div>
            
            <input type="submit" value="Registre" class="btn" />
          </form>
        </div>

          <img src="paincare_2.png" alt="Pain Care"  width= 410px height=600px >

      </div>
    </div>

    <script src="app.js"></script>
   
  </body>
</html>
    