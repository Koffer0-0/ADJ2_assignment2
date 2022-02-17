<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="icon" href="/images/favicon.png" type="image/x-icon">
  <link rel="shortcut icon" href="/images/favicon.png" type="image/x-icon">
  <title>Login</title>
  <!-- Google font-->
  <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
  <!-- Font Awesome-->
  <link rel="stylesheet" type="text/css" href="/css/fontawesome.css">
  <!-- ico-font-->
  <link rel="stylesheet" type="text/css" href="/css/icofont.css">
  <!-- Themify icon-->
  <link rel="stylesheet" type="text/css" href="/css/themify.css">
  <!-- Feather icon-->
  <link rel="stylesheet" type="text/css" href="/css/feather-icon.css">
  <link rel="stylesheet" type="text/css" href="/css/animate.css">
  <!-- Plugins css start-->
  <!-- Plugins css Ends-->
  <!-- Bootstrap css-->
  <link rel="stylesheet" type="text/css" href="/css/bootstrap.css">
  <!-- App css-->
  <link rel="stylesheet" type="text/css" href="/css/style.css">
  <link id="color" rel="stylesheet" href="/css/color-1.css" media="screen">
  <!-- Responsive css-->
  <link rel="stylesheet" type="text/css" href="/css/responsive.css">
</head>
<body>
<!-- page-wrapper Start-->
<div class="page-wrapper">
  <div class="container-fluid p-0">
    <!-- login page start-->
    <div class="authentication-main">
      <div class="row">
        <div class="col-md-12">
          <div class="auth-innerright">
            <div class="authentication-box">
              <div class="card-body p-0">
                <div class="cont text-center">
                  <div>
                    <form class="theme-form" method="POST" action="/login">
                      <h4>Login</h4>
                      <#if message??>
                        <h4 class="mb-3 text-center" style="{color: green !important;}">
                          ${message}
                        </h4>
                      </#if>
                      <h6>Enter your Username and Password</h6>
                      <div class="form-group">
                        <label class="col-form-label pt-0">Username</label>
                        <input class="form-control" name="username" type="text" required=""/>
                      </div>
                      <div class="form-group">
                        <label class="col-form-label">Password</label>
                        <input class="form-control" name="password" type="password" required=""/>
                      </div>
                      <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                      <div class="form-group form-row mt-3 mb-0">
                        <button class="btn btn-primary btn-block" type="submit">LOGIN</button>
                      </div>
                      <div class="col-sm-12">
                        <div class="text-left mt-2 m-l-20">Are you already user?  <a class="btn-link text-capitalize" href="./registration">Registration</a></div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- login page end-->
  </div>
</div>
<!-- latest jquery-->
<script src="/js/jquery-3.5.1.min.js"></script>
<!-- Bootstrap js-->
<script src="/js/bootstrap/popper.min.js"></script>
<script src="/js/bootstrap/bootstrap.js"></script>
<!-- feather icon js-->
<script src="/js/icons/feather-icon/feather.min.js"></script>
<script src="/js/icons/feather-icon/feather-icon.js"></script>
<!-- Sidebar jquery-->
<script src="/js/sidebar-menu.js"></script>
<script src="/js/config.js"></script>
<!-- Plugins JS start-->
<script src="/js/login.js"></script>
<!-- Plugins JS Ends-->
<!-- Theme js-->
<script src="/js/script.js"></script>
<script src="/js/theme-customizer/customizer.js"></script>
<!-- login js-->
<!-- Plugin used-->
</body>
</html>