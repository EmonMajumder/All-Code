<title>Get only the last 10 rows from the Actors Table</title>
<?php
include "../Part-A/Step-3.php";
$db=ConnectDatabase();

$result=mysqli_query($db,"select * from actor order by actor_id desc limit 10");

if(!$result)
{
    die('Could not get record from the Sakila Database.'. mysqli_error($db));
}
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
DisconnectDatabase($db);


