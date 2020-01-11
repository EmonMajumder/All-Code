<?php
include '../ConnectDatabase.php';
$db = ConnectDatabase();
$usernameerror="";
if(isset($_POST['usernamereg'],$_POST['passwordreg']))
{
    $Name=$_POST['usernamereg'];
    $password=$_POST['passwordreg'];

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
    else if ($captcha_success->success==true) {
        $sql = "call GetUserbyName(:Name);";
        $stmt = $db->prepare($sql);
        $stmt->bindParam(":Name", $Name, PDO::PARAM_STR);
        if (!$stmt->execute()) {
            die("Could not get user data" . $stmt->errorInfo());
        } else {
            if ($stmt->rowCount() >= 1) {
                $usernameerror = "Username in use.";
            } else {
                $hashpass = password_hash($password, PASSWORD_DEFAULT);
                $sql = "call AddUser(:Name,:password);";
                $stmt = $db->prepare($sql);
                $stmt->bindParam(":Name", $Name, PDO::PARAM_STR);
                $stmt->bindParam(":password", $hashpass, PDO::PARAM_STR);
                if (!$stmt->execute()) {
                    die("Could not add a new user to database" . " " . $stmt->errorInfo());
                } else
                    header("location:mainLogin.html");
            }
        }
    }
}
?>

<html>
    <head>
        <title>Register</title>
        <link rel="stylesheet" href="Loginpage.css" id="bootstrap-css">
        <script src="../Formvalidation.js"></script>
    </head>
    <body>
        <div class="wrapper fadeInDown">
            <div id="formContent">
                <form action="<?php $_SERVER['PHP_SELF'] ?>" onsubmit="return Checkregister()" method="post">
                    <input type="text" class="fadeIn second" name="usernamereg" id="username" placeholder="Username"
                           value="<?php if(isset($_POST['usernamereg'])) echo $_POST['usernamereg'];?>"><br>
                    <div id="usernamehavespace" style="display:none;">
                        User name can not have whitespace.
                    </div>
                    <input type="text" id="hiddenusername" name="hiddenusername" style="display:none" value="<?php if(isset($_POST['usernamereg'])) echo $_POST['usernamereg'];?>"/>
                    <?php
                        if($usernameerror=="Username in use.")
                        {
                              echo '<div id="usernameinuse" style="display:block;">
                                  This user name is in use. Choose another.
                              </div>';
                        }
                    ?>
                    <input type="text" class="fadeIn second" name="passwordreg" id="password" placeholder="password"><br>
                    <div id="passwordhavespace" style="display:none;">
                        Password can not have whitespace.
                    </div>
                    <div id="shortpassword" style="display:none;">
                        Password should be minimum 8 characters.
                    </div>
                    <input type="submit" class="fadeIn fourth" value="Register">
                    <div class="captcha_wrapper">
                        <div class="g-recaptcha" data-sitekey="YOUR_KEY"></div>
                    </div>
                </form>
                <div>
                    <a href="mainLogin.html">Already Registered? Log in.</a>
                </div>
            </div>
        </div>
    </body>
</html>