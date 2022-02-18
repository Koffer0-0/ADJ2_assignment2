<!DOCTYPE html>
<html lang="en"><head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">
  <title>Login page</title>
  <!--===============================================================================================-->
  <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/vendor/bootstrap/css/bootstrap.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/vendor/animate/animate.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/vendor/css-hamburgers/hamburgers.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/vendor/animsition/css/animsition.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/vendor/select2/select2.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/vendor/daterangepicker/daterangepicker.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="/css/util.css">
  <link rel="stylesheet" type="text/css" href="/css/main.css">
  <!--===============================================================================================-->
</head>
<body data-new-gr-c-s-check-loaded="8.888.0" data-gr-ext-installed="">
<div class="limiter">
  <div class="container-login100" style="background-image: url('../static/images/bg-01.jpg');">
    <div class="wrap-login100 p-t-30 p-b-50">
				<span class="login100-form-title p-b-41">
					Account Login my template
				</span>
      <form class="login100-form validate-form p-b-33 p-t-5" method="post" action="/login">
        <h4 wrap-input100 validate-input>Login</h4>
        <#if message??>
          <h4 class="mb-3 text-center" style="{color: green !important;}">
            ${message}
          </h4>
        </#if>
        <h6>Enter your Username and Password</h6>
        <div class="wrap-input100 validate-input">
          <label class="col-form-label pt-0">Username</label>
          <input class="input100" name="username" type="text" required=""/>
        </div>
        <div class="wrap-input100 validate-input">
          <label class="col-form-label">Password</label>
          <input class="form-control" name="password" type="password" required=""/>
        </div>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="container-login100-form-btn m-t-32">
          <button class="btn btn-primary btn-block" type="submit">LOGIN</button>
        </div>
        <div class="wrap-input100 validate-input">
          <div class="text-left mt-2 m-l-20">Are you already user?  <a class="btn-link text-capitalize" href="./registration">Registration</a></div>
        </div>
      </form>

    </div>
  </div>
</div>

<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="/vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="/vendor/bootstrap/js/popper.js"></script>
<script src="/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="/vendor/daterangepicker/moment.min.js"></script>
<script src="/vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="/vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="/js/main.js"></script>
</body>
</html>