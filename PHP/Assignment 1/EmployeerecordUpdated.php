<?php

    //----------------------------------------------------
    session_start();
    require('isLoggedIn.php');
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

    $result = mysqli_query($db,"update employees.employees set first_name='$fName', last_name='$lName', gender='$Gender', birth_date='$Birthdate', hire_date='$Hiredate' where emp_no = $emp_no;");

    if(!$result)
    {
        die('Could not update record in the Sakila Database: ' . mysqli_error($db));
    }
    $affectedrecordnumber = mysqli_affected_rows($db);
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
<form name="LogoutForm" action="logOut.php" method="post">
    <input type="submit" name="logoutButton" value="Log Out"/>
</form>
