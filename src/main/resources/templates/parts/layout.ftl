<#macro page>

    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="icon" href="/images/favicon.png" type="image/x-icon">
        <link rel="shortcut icon" href="/images/favicon.png" type="image/x-icon">
        <title>Team app</title>
        <!-- Google font-->
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
              rel="stylesheet">
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
        <link rel="stylesheet" type="text/css" href="/css/chartist.css">
        <link rel="stylesheet" type="text/css" href="/css/date-picker.css">
        <link rel="stylesheet" type="text/css" href="/css/prism.css">
        <link rel="stylesheet" type="text/css" href="/css/pe7-icon.css">
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
        <!-- Page Header Start-->
        <div class="page-main-header">
            <div class="main-header-right">
                <div class="main-header-left text-center">
                    <div class="logo-wrapper"><a href="/"><img src="/images/logo/logo.png" alt=""></a></div>
                </div>
                <div class="mobile-sidebar">
                    <div class="media-body text-right switch-sm">
                        <label class="switch ml-3">
                            <i class="font-primary" id="sidebar-toggle" data-feather="align-center"></i></label>
                    </div>
                </div>
                <div class="vertical-mobile-sidebar">
                    <i class="fa fa-bars sidebar-bar">

                    </i>
                </div>
                <div class="nav-right col pull-right right-menu">
                    <ul class="nav-menus">
                        <li></li>
                        <li class="onhover-dropdown"><span class="media user-header">
                        <img src="/images/dashboard/user.png" alt=""></span>
                            <ul class="onhover-show-div profile-dropdown">
                                <li class="gradient-primary">
                                    <h5 class="f-w-600 mb-0">
                                        ${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.username)!"Unknown"}
                                    </h5><span>User</span>
                                </li>
                                <li><i data-feather="user"> </i><a href="/profile">Profile</a></li>
                                <#if (Session.SPRING_SECURITY_CONTEXT.authentication.principal.username)??>
                                    <li><i data-feather="logout"> </i>
                                        <a href="/logout">Logout</a>
                                    </li>
                                <#else>
                                    <li><i data-feather="login"></i>
                                        <a href="/login">Login</a>
                                    </li>
                                </#if>
                            </ul>
                        </li>
                    </ul>
                    <div class="d-lg-none mobile-toggle pull-right"><i data-feather="more-horizontal"></i></div>
                </div>
                <script id="result-template" type="text/x-handlebars-template">
                    <div class="ProfileCard u-cf">
                        <div class="ProfileCard-avatar"><i class="pe-7s-home"></i></div>
                        <div class="ProfileCard-details">
                            <div class="ProfileCard-realName">${(Session.SPRING_SECURITY_CONTEXT.authentication.principal.username)!"Unknown"}</div>
                        </div>
                    </div>
                </script>
                <script id="empty-template" type="text/x-handlebars-template">
                    <div class="EmptyMessage">Your search turned up 0 results. This most likely means the backend is
                        down, yikes!
                    </div></script>
            </div>
        </div>
        <!-- Page Header Ends-->
        <!-- Page Body Start-->
        <div class="page-body-wrapper">
            <!-- Page Sidebar Start-->
            <div class="iconsidebar-menu">
                <div class="sidebar">
                    <ul class="iconMenu-bar custom-scrollbar">
                        <li><a class="bar-icons" href="javascript:void(0)">
                                <!--img(src='/images/menu/home.png' alt='')--><i
                                        class="pe-7s-home"></i><span>General    </span></a>
                            <ul class="iconbar-mainmenu custom-scrollbar">
                                <li class="iconbar-header">Dashboard</li>
                                <li><a href="/">Blog</a></li>
                                <li><a href="/add-post">Add blog</a></li>
                                <li><a href="/users">Friends</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <#nested>
            <!-- footer start-->
            <footer class="footer">
                <div class="container-fluid">
                    <div class="row">
                        <div class="col-md-6 footer-copyright">
                            <p class="mb-0">Copyright © 2021 Poco theme. All rights reserved.</p>
                        </div>
                        <div class="col-md-6">
                            <p class="pull-right mb-0">Hand-crafted & made with<i class="fa fa-heart"></i></p>
                        </div>
                    </div>
                </div>
            </footer>
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
    <script src="/js/typeahead/handlebars.js"></script>
    <script src="/js/typeahead/typeahead.bundle.js"></script>
    <script src="/js/typeahead/typeahead.custom.js"></script>
    <script src="/js/typeahead-search/handlebars.js"></script>
    <script src="/js/typeahead-search/typeahead-custom.js"></script>
    <script src="/js/chart/chartist/chartist.js"></script>
    <script src="/js/chart/chartist/chartist-plugin-tooltip.js"></script>
    <script src="/js/chart/apex-chart/apex-chart.js"></script>
    <script src="/js/chart/apex-chart/stock-prices.js"></script>
    <script src="/js/prism/prism.min.js"></script>
    <script src="/js/clipboard/clipboard.min.js"></script>
    <script src="/js/counter/jquery.waypoints.min.js"></script>
    <script src="/js/counter/jquery.counterup.min.js"></script>
    <script src="/js/counter/counter-custom.js"></script>
    <script src="/js/custom-card/custom-card.js"></script>
    <script src="/js/notify/bootstrap-notify.min.js"></script>
    <script src="/js/dashboard/default.js"></script>
    <script src="/js/notify/index.js"></script>
    <script src="/js/datepicker/date-picker/datepicker.js"></script>
    <script src="/js/datepicker/date-picker/datepicker.en.js"></script>
    <script src="/js/datepicker/date-picker/datepicker.custom.js"></script>
    <script src="/js/chat-menu.js"></script>
    <!-- Plugins JS Ends-->
    <!-- login js-->
    <!-- Plugin used-->
    </body>
    </html>

</#macro>