<!Doctype html>
<html>

    <head>

        <title>Films.php</title>

    </head>

    <body>

        <?php

//            $db = mysqli_connect("localhost","root","inet2005","sakila");
//
//            if(!$db)
//            {
//                die("Could not connect to the Sakila Database: " . mysqli_connect_error());
//            }

            include "Step-3.php";
            $db = ConnectDatabase();

            $result = mysqli_query($db,"select * from film limit 0,10");
            if(!$result)
            {
                die("Could not retrieve records from the Database: " . mysqli_connect_error());
            }
        ?>

        <table border="1">

            <tr>
                <td align="center">Film Name</td>
                <td align="center">Description</td>
            </tr>

            <?php

                while($row=mysqli_fetch_assoc($result))
                {
            ?>
            <tr>
                    <td> <?php echo $row["title"] ?></td>
                    <td> <?php echo $row["description"] ?></td>
            </tr>

            <?php
                }
            ?>
        </table>

        <?php
            DisconnectDatabase($db);
            //mysqli_close($db);
        ?>

    </body>

</html>