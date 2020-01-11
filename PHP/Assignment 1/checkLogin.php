<?php
session_start();
//ob_start();
require('ConnectDatabase.php');
$db=ConnectDatabase();
$username=$_POST['username'];
$password=$_POST['password'];

$username=stripslashes($username);
$username=mysqli_real_escape_string($db,$username);

$sql="select * from employees.User where username='$username'";

$result=mysqli_query($db,$sql);

if (!$result) {
    die("Could not retrieve records from the Database: " . mysqli_connect_error());
}

$count=mysqli_num_rows($result);

DisconnectDatabase($db);

if($count==1)
{
    $row = mysqli_fetch_assoc($result);
    $hash = $row['password'];
    $site = 'DeleteRecord.php';
    if(password_verify($password, $hash)) {
        $_SESSION['username'] = $username;
        if(isset($_SESSION['intendpage']))
        {
            $site = $_SESSION['intendpage'];
        }
        header("location:$site");
    }
    else
    {
        $_SESSION['Error'] = "Incorrect Password";
        header("location:mainLogin.php");
    }
}
else
{
    $_SESSION['Error'] = "Incorrect username or Password";
    header("location:mainLogin.php");
}

ob_end_flush();
?>