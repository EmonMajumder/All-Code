<?php
include "../Part-A/Step-3.php";
$db=ConnectDatabase();

$idtodelete=$_POST['IDtoDelete'];
$result=mysqli_query($db,"delete from actor where actor_id=$idtodelete");

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

    echo "<p>Successfully deleted $affectedrecordnumber $record from database.</p>";
}
?>
<a href="Step-4(CheckRecord).php">Back to Actor list</a>
