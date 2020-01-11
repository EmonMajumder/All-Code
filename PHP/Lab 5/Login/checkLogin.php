<?php
session_start();
//ob_start();
require('../ConnectDatabase.php');
$db=ConnectDatabase();
$username=$_POST['username'];
$password=$_POST['password'];

$response = $_POST["g-recaptcha-response"];
$url = 'https://www.google.com/recaptcha/api/siteverify';
$data = array(
    'secret' => 'YOUR_SECRET',
    'response' => $_POST["g-recaptcha-response"]
);
$options = array(
    'http' => array (
        'method' => 'POST',
        'content' => http_build_query($data)
    )
);
$context  = stream_context_create($options);
$verify = file_get_contents($url, false, $context);
$captcha_success=json_decode($verify);
if ($captcha_success->success==false) {
    echo "<p>You are a bot! Go away!</p>";
}
else if ($captcha_success->success==true)
{
    $sql="call GetUserbyName(:username);";
    $stmt=$db->prepare($sql);
    $stmt->bindParam(":username",$username,PDO::PARAM_STR);

    if (!$stmt->execute())
    {
        die("Could not retrieve records from the Database" ." ".$stmt->errorInfo());
    }

    $count=$stmt->rowCount();

    if($count==1)
    {
        $row = $stmt->fetch(PDO::FETCH_ASSOC);
        $hash = $row['password'];
        $site = '../Innovative.php';
        if(password_verify($password, $hash)) {
            $_SESSION['username'] = $username;
            if(isset($_SESSION['intendpage']))
            {
                $site = $_SESSION['intendpage'];
            }
            header("location:../$site");
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
}



ob_end_flush();

DisconnectDatabase($db);