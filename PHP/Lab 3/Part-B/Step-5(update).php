<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/html">
    <head>
        <meta charset="UTF-8">
        <title>Update an Actor</title>
    </head>
    <body>
        <?php
        include "../Part-A/Step-3.php";
        $db=ConnectDatabase();

        $idtoupdate=$_POST['IDtoUpdate'];
        $result=mysqli_query($db,"select * from actor where actor_id=$idtoupdate");

        if(!$result)
        {
            die('Could not get record from the Sakila Database.'. mysqli_error($db));
        }
        $row=mysqli_fetch_assoc($result);
        $fName = $row["first_name"];
        $lName = $row["last_name"];
        ?>

        <form action="Step-5(updatedone).php" method="post">

            <label for="firstnametoupdate">First Name: </label>
            <input type="text" name="firstnametoupdate" value=<?php echo $fName ?>>
            <br><br>
            <label for="lastnametoupdate">Last Name: </label>
            <input type="text" name="lastnametoupdate" value=<?php echo $lName ?>>
            <br><br>
            <input hidden name="IDtoupdate" value=<?php echo $idtoupdate?>>
            <button type="submit">Update</button>
        </form>

        <?php
        DisconnectDatabase($db);
        ?>
    </body>
</html>
