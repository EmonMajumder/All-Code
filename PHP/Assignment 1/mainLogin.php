<?php
session_start();
?>
<html>
    <head>
        <title>Login</title>
        <link rel="stylesheet" href="Loginpage.css" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="Formvalidation.js"></script>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form action="checkLogin.php" onsubmit="return Checklogin()" method="post">
                    <input type="text" class="fadeIn second" name="username" id="username" placeholder="Username">
                    <input type="password" class="fadeIn second" name="password" id="password" placeholder="password">
                    <input type="submit" class="fadeIn fourth" value="Log In">
                </form>
                <div id="formFooter">
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
        </div>
    </body>
</html>