<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="UTF-8">
        <title>Delete an Actor (Checking)</title>
    </head>
    <body>
        <?php
        include "../Part-A/Step-3.php";
        $db=ConnectDatabase();
        $result=mysqli_query($db,"select * from actor");

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
        ?>
    </body>
</html>
