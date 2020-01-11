<title>Insert a Record into the Actor table</title>
<?php
include "../Part-A/Step-3.php";
$db=ConnectDatabase();
$firstName = $_POST["fName"];
$lastName=$_POST["lName"];

$result = mysqli_query($db,"INSERT INTO actor (first_name, last_name) VALUES ('$firstName','$lastName');");

if(!$result)
{
    die('Could not insert record into the Sakila Database: ' . mysqli_error($db));
}
else
{
    echo "<p>New record inserted.</p><br>";

    $result=mysqli_query($db,"select * from actor");
?>
<table border="1">
    <?php
    while($row = mysqli_fetch_assoc($result))
    {
    ?>
    <tr>
        <td><?php echo $row["actor_id"] ?></td>
        <td><?php echo $row["first_name"] ?></td>
        <td><?php echo $row["last_name"] ?></td>
        <td><?php echo $row["last_update"] ?></td>
    </tr>
    <?php
    }
    ?>

</table>

    <?php
}
DisconnectDatabase($db);
