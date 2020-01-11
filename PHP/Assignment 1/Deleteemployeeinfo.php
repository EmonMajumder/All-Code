<?php
//----------------------------------------------------
session_start();
require('isLoggedIn.php');
checkIfLoggedIn();
//----------------------------------------------------
include "ConnectDatabase.php";
$db = ConnectDatabase();
$emp_no = $_POST["Dlt_emp_no"];

$result = mysqli_query($db,"Delete from employees.employees where emp_no = $emp_no;");

if(!$result)
{
    die('Could not update record in the Sakila Database: ' . mysqli_error($db));
}

$affectedrecordnumber = mysqli_affected_rows($db);
echo "$affectedrecordnumber Record Deleted.";
if(isset($_SESSION['intendpage']))
{
    $site = $_SESSION['intendpage'];
}

DisconnectDatabase($db);
?>
<form action="<?php echo $site ?>" method="post">
    <button type="submit">Go Back</button>
</form>
<form name="LogoutForm" action="logOut.php" method="post">
    <input type="submit" name="logoutButton" value="Log Out"/>
</form>