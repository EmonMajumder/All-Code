<?php
session_start();
?>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="Loginpage.css" id="bootstrap-css">
        <script src="../Formvalidation.js"></script>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form action="checkLogin.php" onsubmit="return Checklogin()" method="post">
                    <input type="text" class="fadeIn second" name="username" id="username" placeholder="Username">
                    <input type="password" class="fadeIn second" name="password" id="password" placeholder="password">
                    <input type="submit" class="fadeIn fourth" value="Log In">
                    <div class="captcha_wrapper">
                        <div class="g-recaptcha" data-sitekey="YOUR_KEY"></div>
                    </div>
                </form>
                <div>
                    <a href="Registar.php">Register now</a>
                </div>
                <span>
                    <?php if( isset($_SESSION['Error']) )
                    {
                        echo $_SESSION['Error'];
                        unset($_SESSION['Error']);
                    }
                    ?>
                </span>
            </div>
        </div>
    </body>
</html>