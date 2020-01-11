<title>Insert Record into employee table</title>
<?php
    //----------------------------------------------------
    session_start();
    require('Login/isLoggedIn.php');
    checkIfLoggedIn();
    //----------------------------------------------------
    include "ConnectDatabase.php";
    $db = ConnectDatabase();

    $fName = $_POST["fName"];
    $lName = $_POST["lName"];
    $Gender = $_POST["gender"];
    $Birthdate = $_POST["birthdate"];
    $Hiredate= $_POST["hiredate"];

    $sql="CALL AddEmployee (:fName,:lName,:Gender,:Birthdate,:Hiredate);";
    $stmt=$db->prepare($sql);
    $stmt->bindParam(":fName",$fName,PDO::PARAM_STR);
    $stmt->bindParam(":lName",$lName,PDO::PARAM_STR);
    $stmt->bindParam(":Gender",$Gender,PDO::PARAM_STR);
    $stmt->bindParam(":Birthdate",$Birthdate,PDO::PARAM_STR);
    $stmt->bindParam(":Hiredate",$Hiredate,PDO::PARAM_STR);
    if(!$stmt->execute())
    {
        die("Could not add new record to employee database.".$stmt->errorInfo());
    }
    else
    {
        $affectedrecordnumber = $stmt->rowCount();
        echo "<p>New record inserted.</p><br>";
        echo "Created $affectedrecordnumber new record in database.<br>";
        echo $fName." ".$lName."<br>";
        echo $Gender."<br>";
        echo $Birthdate."<br>";
        echo $Hiredate."<br>";
    }
    if(isset($_SESSION['intendpage']))
    {
        $site = $_SESSION['intendpage'];
    }
    else
        $site= 'Innovative.php';

    DisconnectDatabase($db);

    ?>
<form action="<?php echo $site ?>" method="post">
    <button type="submit">Go Back</button>
</form>
<br>
<form name="LogoutForm" action="Login/logOut.php" method="post">
    <input type="submit" name="logoutButton" value="Log Out"/>
</form>

