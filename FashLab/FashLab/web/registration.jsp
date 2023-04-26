<%-- 
    Document   : registration
    Created on : Apr 26, 2023, 9:39:08 AM
    Author     : ThanhMai
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Registration Form</title>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

        <!-- Popper JS -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

        <!-- Bootstrap JS -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-6">
                    <div class="card shadow-lg border-0 rounded-lg mt-5">
                        <div class="card-header"><h3 class="text-center font-weight-light my-4">Create Account</h3></div>
                        <div class="card-body">
                            <form action="MainController" method="POST" class="register-form" id="register-form"> 
                                <div class="form-group">
                                    <label for="name" class="small mb-1">Name</label>
                                    <input type="text" name="txtname" id="name" class="form-control py-4" placeholder="Enter your name" />
                                </div>
                                <div class="form-group">
                                    <label for="email" class="small mb-1">Email</label>
                                    <input type="email" name="txtemail" id="email" class="form-control py-4" placeholder="Enter your email" />
                                </div>
                                <div class="form-group">
                                    <label for="pass" class="small mb-1">Password</label>
                                    <input type="password" name="txtpassword" id="pass" class="form-control py-4" placeholder="Enter your password" />
                                </div>
                                <div class="form-group">
                                    <label for="phone" class="small mb-1">Phone Number</label>
                                    <input type="phone" name="txtphone" id="phone" class="form-control py-4" placeholder="Enter your phone number" />
                                </div>
                                <div class="form-group">
                                    <div class="custom-control custom-checkbox">
                                        <input type="checkbox" class="custom-control-input" name="agree-term" id="agree-term">
                                        <label class="custom-control-label" for="agree-term">I agree to the <a href="#" class="term-service">terms of service</a></label>
                                    </div>
                                </div>
                                <div class="form-group d-flex align-items-center justify-content-center mt-4 mb-0 text-center">
                                    <button type="submit" name="action" id="signup" class="btn btn-primary" value="Sign up">Sign up</button>
                                </div>
                            </form>
                            <div class="card-footer mt-2 mb-0 text-center">
                                <div class="small"><a href="#">Forgot Password?</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRJa" crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.0.17/dist/sweetalert2.min.js"></script>
    </body>
</html>

