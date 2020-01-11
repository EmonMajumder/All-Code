<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="UTF-8">
        <title>Update or delete an Actor</title>
    </head>
    <body>
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
        <br>
        <form action="Step-4(delete).php" method="post">
            <label for="IDtoDelete">ID to Delete: </label>
            <input type="text" name="IDtoDelete">
            <button type="submit">Delete</button>
        </form>
        <br>
        <form action="Step-5(update).php" method="post">
            <label for="IDtoUpdate">ID to Update: </label>
            <input type="text" name="IDtoUpdate">
            <button type="submit">Update</button>
        </form>

        <?php
        DisconnectDatabase($db);
        ?>
    </body>
</html>