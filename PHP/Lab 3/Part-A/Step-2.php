<!Doctype html>
<html>
    <head>
        <title>Part-A: Step-2</title>
    </head>
    <body>
        <?php
            if(isset($_POST['UserInput']))
            {
//                $db = mysqli_connect("localhost","root", "inet2005", "sakila");
//
//                if(!$db)
//                {
//                    die("Could not connect to the Sakila Database: " . mysqli_connect_error());
//                }
                include "Step-3.php";
                $db = ConnectDatabase();

                $UserInput = $_POST['UserInput'];
                $result = mysqli_query($db,"select * from film where description like '%$UserInput%'");

                if(!$result)
                {
                    die("Could not retrieve records from the Database: " . mysqli_connect_error());
                }
        ?>

                <table border="1">

                    <?php
                    $i = 0;
                    while ($row = mysqli_fetch_assoc($result))
                    {
                        $i++;
                        if($i==1)
                        {
                    ?>
                            <tr>
                                <td align="center">Film Name</td>
                                <td align="center">Description</td>
                            </tr>
                            <?php } ?>
                        <tr>
                            <td> <?php echo $row["title"] ?></td>
                            <td> <?php echo $row["description"] ?></td>
                        </tr>
                    <?php
                    }
                    if($i==0)
                    {
                        echo "No Record found. Try other key words.";
                    }
                    ?>
                </table>
                <br>
            <?php
                //mysqli_close($db);
                DisconnectDatabase($db);
            }
            ?>

        <form action="<?php $_SERVER['PHP_SELF'] ?>"  method="post" name="Step-2">
            <label>Search: </label>
            <input type="text" name="UserInput">
            <br>
            <br>
            <input type="submit">
        </form>
    </body>
</html>















