<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
  <!-- Basic -->
  <meta charset="utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge" />
  <!-- Mobile Metas -->
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
  <!-- Site Metas -->
  <meta name="keywords" content="" />
  <meta name="description" content="" />
  <meta name="author" content="" />

  <style>
  .image-arrondie {
    border-radius: 10%; 
    overflow: hidden;
    width: 500px; /* Largeur souhaitée */
    height: auto; 
  }
</style>

  <!-- bootstrap core css -->
  <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />

  <!-- fonts style -->
  <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700;900&display=swap" rel="stylesheet">

  <!--owl slider stylesheet -->
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/OwlCarousel2/2.3.4/assets/owl.carousel.min.css" />

  <!-- font awesome style -->
  <link href="css/font-awesome.min.css" rel="stylesheet" />
  <!-- nice select -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/jquery-nice-select/1.1.0/css/nice-select.min.css" integrity="sha256-mLBIhmBvigTFWPSCtvdu6a76T+3Xyt+K571hupeFLg4=" crossorigin="anonymous" />
  <!-- datepicker -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/css/datepicker.css">
  <!-- Custom styles for this template -->
  <link href="css/style.css" rel="stylesheet" />
  <!-- responsive style -->
  <link href="css/responsive.css" rel="stylesheet" />

</head>

<body>
<%@ page import="java.util.*" %>

<%@ page import="dao.user" %>
    <%
    // Récupérer la session à partir de l'objet implicite "session"
    HttpSession sess = request.getSession();

    // Utiliser la session comme nécessaire
    user user_1 = (user) sess.getAttribute("user");

    // Autres traitements...

    // Par exemple, afficher la valeur en session
    int id = user_1.getId() ;
%>
    




      <% String message = (String) request.getAttribute("message"); %>
    

              <%-- Utiliser out.println pour afficher le message --%>
              <% if (message != null && !message.isEmpty()) { %>
              <div class="alert alert-danger" role="alert">
             <button type="button" class="btn btn-primary btn-lg">   <%= message %>  </button>
              </div>
        
              <% } %> 
    

  <div class="hero_area">

    <%@include file="navbar.jsp" %>
<div class="container my-5">
    <div class="row">
        <div class="col-md-6 mx-auto text-center border border-success rounded p-4">
            
            <form action="servlet_blog" method="post"  enctype="multipart/form-data">
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label">Title :</label>
                    <input type="text" class="form-control" name="titre" id="exampleInputEmail1" aria-describedby="emailHelp" required>
                    
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">description :</label>
                    <input type="text" class="form-control"  name="description" id="exampleInputPassword1" required>
                </div>
                <div class="mb-3">
                <label for="exampleInputfile" class="form-label">business plan</label>
                <input type="file" class="form-control" id="exampleInputfile" name="plan">
                </div>
                <input type="hidden" name="author_id" value="<%= id %>">
                
                <button type="submit" class="btn btn-success">Submit</button>
            </form>
        </div>
    </div>
</div>

    


        <section class="info_section ">
          <div class="container">
            <div class="info_top">
              <div class="info_logo">
                <a href="">
                  <img src="pain.png" alt="" class="image-arrondie" >
                </a>
              </div>
             
            </div>
            <div class="info_bottom layout_padding2">
              <div class="row info_main_row">
                <div class="col-md-6 col-lg-3">
                  <h5>
                    Address
                  </h5>
                  <div class="info_contact">
                    <a href="">
                      <i class="fa fa-map-marker" aria-hidden="true"></i>
                      <span>
                        Location
                      </span>
                    </a>
                    <a href="">
                      <i class="fa fa-phone" aria-hidden="true"></i>
                      <span>
                        Call +01 1234567890
                      </span>
                    </a>
                    <a href="">
                      <i class="fa fa-envelope"></i>
                      <span>
                        demo@gmail.com
                      </span>
                    </a>
                  </div>
                  <div class="social_box">
                    <a href="">
                      <i class="fa fa-facebook" aria-hidden="true"></i>
                    </a>
                    <a href="">
                      <i class="fa fa-twitter" aria-hidden="true"></i>
                    </a>
                    <a href="">
                      <i class="fa fa-linkedin" aria-hidden="true"></i>
                    </a>
                    <a href="">
                      <i class="fa fa-instagram" aria-hidden="true"></i>
                    </a>
                  </div>
                </div>
                <div class="col-md-6 col-lg-3">
                  <div class="info_links">
                    <h5>
                      Useful link
                    </h5>
                    <div class="info_links_menu">
                      <a class="active" href="index.html">
                        Home
                      </a>
                      <a href="about.html">
                        About
                      </a>
                      <a href="treatment.html">
                        Treatment
                      </a>
                      <a href="doctor.html">
                        Doctors
                      </a>
                      <a href="testimonial.html">
                        Testimonial
                      </a>
                      <a href="contact.html">
                        Contact us
                      </a>
                    </div>
                  </div>
                </div>
                
               
                </div>
              </div>
            </div>
          </div>
        </section>
        <!-- end info_section -->
      
      
        <!-- footer section -->
        <footer class="footer_section">
          <div class="container">
            <p>
              &copy; <span id="displayYear"></span> All Rights Reserved By
              <a href="https://html.design/">Free Html Templates</a>
            </p>
          </div>
        </footer>
        <!-- footer section -->



<script src="https://cdn.rawgit.com/image-resizer/resizer/master/src/resizer.js"></script>
<!-- À la fin de la balise body -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js" integrity="sha384-Xgcf1dLEq3Rnxn5ZrzCzjL3U2w8LUjZPfwz1uxHv3HKaC0ft56E7m3Lvzr5UJo4K" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" integrity="sha384-B4gt1jrGC7Jh4AgTPSdUtOBvfO8sh+WyL/JqIcF5k9UJeg6KfNUAtGUKRveJ8Z9W" crossorigin="anonymous"></script>
<!-- Votre fichier JavaScript personnalisé peut être ajouté ici -->

</body>