<?php
//----------------------------------------------------
session_start();
require('Login/isLoggedIn.php');
checkIfLoggedIn();
//----------------------------------------------------
include "ConnectDatabase.php";
$db = ConnectDatabase();
$emp_no = $_POST["Dlt_emp_no"];
$sql = "CALL DeleteEmployeebyID(:emp_no);";
$stmt=$db->prepare($sql);
$stmt->bindParam(":emp_no",$emp_no,PDO::PARAM_INT);

if(!$stmt->execute())
{
    die('Could not Delete record from the Database. '.$stmt->errorInfo());
}

$affectedrecordnumber = $stmt->rowCount();
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
<form name="LogoutForm" action="Login/logOut.php" method="post">
    <input type="submit" name="logoutButton" value="Log Out"/>
</form>