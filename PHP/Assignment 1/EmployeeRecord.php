<?php
//----------------------------------------------------
session_start();
$_SESSION['intendpage'] = "EmployeeRecord.php";
require('isLoggedIn.php');
checkIfLoggedIn();
//----------------------------------------------------
?>
<!Doctype html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Employee Record</title>
        <script src="Formvalidation.js"></script>
    </head>

    <body>
        <?php
            include "ConnectDatabase.php";
            $db = ConnectDatabase();
            $recordperpage = 25;

            if(isset($_POST['Page'])) {
                if($_POST['nextorprev'] == "Next")
                {
                    if($_POST['Page']<499976)
                    {
                        $Page = $_POST['Page']+$recordperpage;
                    }
                    else
                    {
                        $Page = $_POST['Page'];
                    }
                }
                else if($_POST['nextorprev'] == "Previous")
                {
                    $Page = $_POST['Page'] -25;
                }
                $result = mysqli_query($db, "select * from employees limit $Page,$recordperpage");
            }
            else
            {
                $page =0;
                $result = mysqli_query($db, "select * from employees limit $recordperpage");
            }
            if (!$result) {
                die("Could not retrieve records from the Database: " . mysqli_connect_error());
            }
        ?>

        <table border="1">

            <tr>
                <td align="center">Employee ID</td>
                <td align="center">First Name</td>
                <td align="center">Last Name</td>
                <td align="center">Gender</td>
                <td align="center">Birthdate</td>
                <td align="center">Hiredate</td>
            </tr>

            <?php
            while($row=mysqli_fetch_assoc($result))
            {
            ?>
                <tr>
                    <td> <?php echo $row["emp_no"] ?></td>
                    <td> <?php echo $row["first_name"] ?></td>
                    <td> <?php echo $row["last_name"] ?></td>
                    <td> <?php echo $row["gender"] ?></td>
                    <td> <?php echo $row["birth_date"] ?></td>
                    <td> <?php echo $row["hire_date"] ?></td>
                </tr>

            <?php
            }
            ?>
        </table>

        <form action="<?php $_SERVER['PHP_SELF'] ?>"  method="post">
            <input hidden value="" id ="Buttondetect" name="nextorprev">
            <input hidden value="<?php echo $Page ?>" name="Page" id="Page">
            <button type="submit" id="Next" onclick="checknextorprev(this.id)">Next</button>
            <?php
                if($Page>=25)
                {
                    echo '<button type=\"submit" id="Previous" onclick="checknextorprev(this.id)">Previous</button>';
                }
            ?>
        </form>

        <form action="<?php $_SERVER['PHP_SELF'] ?>"  method="post">
            <label>Search: </label>
            <input type="text" name="Searchfor">
            <input type="submit">
        </form>

        <?php
        DisconnectDatabase($db);
        //mysqli_close($db);
        ?>
    </body>
</html>