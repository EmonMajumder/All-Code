<?php
include 'ConnectDatabase.php';
$db = ConnectDatabase();
if(isset($_POST['usernamereg'],$_POST['passwordreg']))
{
    $Name=$_POST['usernamereg'];
    $password=$_POST['passwordreg'];
    $hashpass = password_hash($password,PASSWORD_DEFAULT);
    $result = mysqli_query($db, "INSERT INTO employees.User (username,password) VALUES ('$Name','$hashpass')");
    if(!$result)
    {
        echo "Failed";
    }
    header("location:mainLogin.html");
}
?>
<html>
    <head>
        <title>Login</title>
        <script src="Formvalidation.js"></script>
    </head>
    <body>
        <form action="<?php $_SERVER['PHP_SELF'] ?>" onsubmit="return CheckRegistar()" method="post">
            <label>
                <input type="text" name="usernamereg" id="usernamereg" placeholder="Username">
            </label>
            <label>
                <input type="text" name="passwordreg" id="passwordreg" placeholder="Password">
            </label>
            <input type="submit">
        </form>
    </body>
</html>
