<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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

<script>

</script>

</head>

<body>

  <div class="hero_area">

    <%@include file="navbar.jsp" %>

<div class="center-container my-5 mx-5">
  <a href="ajouter_blog.jsp"> <img src="plus.png" class="card-img-top" alt="..." style="height: 100px; width : 100px ; ">
</a> 
</div>

    <div class="container">
        <div class="row my-3">
        
        
            <div class="col-md-3 mx-5  "> 
                    <div class="card" style="width: 18rem; ">
                        <img src="pain.png" class="card-img-top" alt="..." style="height: 200px; ">
                        <div class="card-body">
                          <h5 class="card-title">Card title</h5>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item">An item</li>
                          <li class="list-group-item">A second item</li>
                          <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                          <a href="#" class="card-link">Les commentaires</a>
                         
                        </div>
                     </div>
                  </div>
                  
                  
                     <div class="col-md-3 mx-5  ">
                      <div class="card" style="width: 18rem; ">
                        <img src="pain.png" class="card-img-top" alt="..." style="height: 200px; ">
                        <div class="card-body">
                          <h5 class="card-title">Card title</h5>
                          <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        </div>
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item">An item</li>
                          <li class="list-group-item">A second item</li>
                          <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                          <a href="#" class="card-link">Les commentaires</a>
                        </div>
                      </div>
                   </div>
                   
                   
                    <%@ page import="dao.blog" %>

       
    
    <c:forEach items="${list}" var="li">
       
        
        <div class="col-md-3 mx-5 my-5 ">
                      <div class="card" style="width: 18rem; ">
                        <img src="${li.photo}" class="card-img-top" alt="..." style="height: 200px; ">
                        <div class="card-body">
                          <h5 class="card-title">${li.title}</h5>
                          <p class="card-text">${li.title}</p>
                        </div>
                        <ul class="list-group list-group-flush">
                          <li class="list-group-item">An item</li>
                          <li class="list-group-item">A second item</li>
                          <li class="list-group-item">A third item</li>
                        </ul>
                        <div class="card-body">
                          <a href="#" class="card-link">Les commentaires</a>
                        </div>
                      </div>
                   </div>
        
        
        
    </c:forEach>

                   
                   
                
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