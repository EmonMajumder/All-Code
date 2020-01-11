<?php
include "../Part-A/Step-3.php";
$db=ConnectDatabase();

$idtoupdate=$_POST['IDtoupdate'];
$updatedfirstname=$_POST['firstnametoupdate'];
$updatedlastname=$_POST['lastnametoupdate'];
$result=mysqli_query($db,"update actor set first_name='$updatedfirstname', last_name='$updatedlastname' where actor_id=$idtoupdate");

if(!$result)
{
    die('Could not delete record from the Sakila Database.'. mysqli_error($db));
}
else
{
    $affectedrecordnumber=mysqli_affected_rows($db);
    $record = "records";
    if($affectedrecordnumber=1)
        $record = "record";

    echo "<p>Successfully updated $affectedrecordnumber $record from database.</p>";
}
?>
<a href="Step-4(CheckRecord).php">Back to Actor list</a>
