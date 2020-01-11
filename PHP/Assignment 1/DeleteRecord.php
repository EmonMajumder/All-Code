<?php
//----------------------------------------------------
session_start();
$_SESSION['intendpage'] = "DeleteRecord.php";
require('isLoggedIn.php');
checkIfLoggedIn();
//----------------------------------------------------
?>

<!Doctype html>
<html>

    <head>
        <meta charset="UTF-8">
        <title>Delete Employee Record</title>
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
        else if($_POST['nextorprev'] == "none")
        {
            $Page=0;
        }
        $name=$_POST["Searchfor"];
        $result = mysqli_query($db, "select * from employees where (first_name like '%$name%') || (last_name like '%$name%') limit $Page,$recordperpage");
    }
    else
    {
        $Page =0 ;
        $result = mysqli_query($db, "select * from employees limit $Page,$recordperpage");
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
            <td align="center">Edit</td>
            <td align="center">Delete</td>
        </tr>

        <?php
        $i=0;
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
                <td>
                    <form action="Editemployeeinfo.php" onsubmit="return validateForm()" method="post">
                        <input hidden type= "text" name="Edit_emp_no" value="<?php echo $row["emp_no"] ?>">
                        <button type="submit">Edit</button>
                    </form>
                </td>
                <td>
                    <form action="Deleteemployeeinfo.php" onsubmit="return Alert()" method="post">
                        <input hidden type= "text" name="Dlt_emp_no" value="<?php echo $row["emp_no"] ?>">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
            <?php
            $i++;
        }
        ?>
    </table>

    <form id = "form1" action="<?php $_SERVER['PHP_SELF'] ?>"  method="post">
        <input hidden value="none" id ="Buttondetect" name="nextorprev">
        <input hidden value="<?php echo $Page ?>" name="Page" id="Page">
        <?php
        if($i==25)
        {
            echo '<button type="submit" id="Next" onclick="checknextorprev(this.id)">Next</button>';
        }
        if($Page>=$recordperpage)
        {
            echo '<button type="submit" id="Previous" onclick="checknextorprev(this.id)">Previous</button>';
        }
        ?>
        <label>Search: </label>
        <input type="text" name="Searchfor" value="<?php if (isset($name)) echo $name; ?>">
        <input type="submit">
    </form>
    <form name="LogoutForm" action="logOut.php" method="post">
        <input type="submit" name="logoutButton" value="Log Out"/>
    </form>
    <?php
    DisconnectDatabase($db);
    //mysqli_close($db);
    ?>
    </body>
</html>