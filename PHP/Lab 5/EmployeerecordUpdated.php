<?php

    //----------------------------------------------------
    session_start();
    require('Login/isLoggedIn.php');
    checkIfLoggedIn();
    //----------------------------------------------------

    include "ConnectDatabase.php";
    $db = ConnectDatabase();
    $emp_no = $_POST["emp_no"];
    $fName = $_POST["fName"];
    $lName = $_POST["lName"];
    $Gender = $_POST["gender"];
    $Birthdate = $_POST["birthdate"];
    $Hiredate= $_POST["hiredate"];

    $sql = "Call UpdateEmployee(:emp_no,:fName,:lName,:Gender,:Birthdate,:Hiredate);";
    $stmt=$db->prepare($sql);
    $stmt->bindParam(":emp_no",$emp_no,PDO::PARAM_INT);
    $stmt->bindParam(":fName",$fName,PDO::PARAM_STR);
    $stmt->bindParam(":lName",$lName,PDO::PARAM_STR);
    $stmt->bindParam(":Gender",$Gender,PDO::PARAM_STR);
    $stmt->bindParam(":Birthdate",$Birthdate,PDO::PARAM_STR);
    $stmt->bindParam(":Hiredate",$Hiredate,PDO::PARAM_STR);
    if (!$stmt->execute()) {
        die("Could not update record in the Database. ".$stmt->errorInfo());
    }

    $affectedrecordnumber = $stmt->rowCount();
    echo "<p>Record Updated.</p>";
    echo "$affectedrecordnumber records affected";
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
<form name="LogoutForm" action="Login/logOut.php" method="post">
    <input type="submit" name="logoutButton" value="Log Out"/>
</form>
