<%-- 
    Document   : Signup
    Created on : May 8, 2020, 4:08:34 PM
    Author     : spate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        
    <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
            
     
            
    </head>
    <body bgcolor="green"style="text-align: center;">
        <div class="container">
            <div class="row">
                <div class="col m6 offset-m3" >
                    <div class="card">
                        <div style="background: url(img/imgev.jpg);background-size: cover; background-attachment: fixed "class="card-content">
                            <h3 style="margin: 10px; padding:10px 10px 10px 10px;  ">Register Here!!!</h3>
                            <div class="form"style="text-align: center;" id="myform">
                                <form action="Register" method="post">
                                    <input type="text" name="username" placeholder="Enter user's name">
                                    <input type="password" name="password" placeholder="Enter user's password">
                                    <input type="email" name="email" placeholder="Enter user's email">
                                    <input type="text" name="phone" placeholder="Enter user's Phone number">
                                    <button type="submit"  class=" btn " > Submit</button>
                                
                            </div>
                            <div class="lodder " style="text-align: center;display: none" >
                                <div class="preloader-wrapper big active">
      <div class="spinner-layer spinner-blue">
        <div class="circle-clipper left">
          <div class="circle"></div>
        </div><div class="gap-patch">
          <div class="circle"></div>
        </div><div class="circle-clipper right">
          <div class="circle"></div>
        </div>
      </div>
                            </div>
                            <h5>Please wait..</h5>
                        </div>
                    </div>
                     
            </div>
            </div>
        </div>
        <script
  src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
  integrity="sha256-4+XzXVhsDmqanXGHaHvgh1gMQKX40OUvDEBTu8JcmNs="
  crossorigin="anonymous"></script>
  <script >
      $(document).ready(function(){
        console.log("page is ready..")
        $("#myform").on('submit', function (event){
            event.preventDefault();
            var f= $(this).serialize();
            console.log(f);
           // $.ajax({
             //   url:"Register",
            //    data:f,
            //    type:'POST',
             //   success: function (data, textStatus, jqXHR) {
               //         console.log(data);
              //          console.log("success...")
              //      },
               //     error: function (jqXHR, textStatus, errorThrown) {
                 //        console.log(data);
                  //      console.log("error...")
                    },
            })
        })
      })
  </script>
    </body>
</html>
