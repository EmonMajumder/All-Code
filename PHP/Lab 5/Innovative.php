<?php
//----------------------------------------------------
session_start();
$_SESSION['intendpage'] = "Innovative.php";
require('Login/isLoggedIn.php');
checkIfLoggedIn();
//----------------------------------------------------
?>

<!Doctype html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Innovative</title>
    <link href="Innovative.css" rel="stylesheet" id="bootstrap-css">
    <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
    <script src="Formvalidation.js"></script>
</head>

<body>
<?php
include "ConnectDatabase.php";
$db = ConnectDatabase();
$recordperpage = 25;
$name="";
$sql = "select * from employees join Employeeslastsalary using (emp_no) where first_name like concat('%',:name,'%') or last_name like concat('%',:name,'%')";

if(isset($_POST['Page'])) {
    if ($_POST['nextorprev'] == "Next") {
        if ($_POST['Page'] < 499976) {
            $Page = $_POST['Page'] + $recordperpage;
        } else {
            $Page = $_POST['Page'];
        }
    } else if ($_POST['nextorprev'] == "Previous") {
        $Page = $_POST['Page'] - 25;
    } else if ($_POST['nextorprev'] == "none") {
        $Page = 0;
    }
    $name = $_POST["Searchfor"];

    if ($_POST["OrderbySalaryinput"] != "") {
        $sql .= $_POST['OrderbySalaryinput'];
    }
}
else
{
    $Page =0 ;
}
$sql .= " limit :Page,:recordperpage;";
$stmt=$db->prepare($sql);
$stmt->bindParam(":name",$name,PDO::PARAM_STR);
$stmt->bindParam(":Page",$Page,PDO::PARAM_INT);
$stmt->bindParam(":recordperpage",$recordperpage,PDO::PARAM_INT);
if (!$stmt->execute()) {
    die("Could not retrieve records from the Database."." ".$stmt->errorInfo());
}
?>
<div align="center">
    <form name="LogoutForm" action="AddEmployee.html" method="post">
        <input type="submit" name="AddRecord" value="Add Record"/>
    </form>
</div>
<br>
<div align="center">
    <table class="rtable">
        <thead>
            <tr>
                <td align="center">Employee ID</td>
                <td align="center">First Name</td>
                <td align="center">Last Name</td>
                <td align="center">Gender</td>
                <td align="center">Birthdate</td>
                <td align="center">Hiredate</td>
                <td align="center">Salary</td>
                <td align="center">Edit</td>
                <td align="center">Delete</td>
            </tr>
        </thead>
        <tbody>
            <?php
            $i=0;
            while($row=$stmt->fetch(PDO::FETCH_ASSOC))
            {
                ?>
                <tr>
                    <td> <?php echo $row["emp_no"] ?></td>
                    <td> <?php echo $row["first_name"] ?></td>
                    <td> <?php echo $row["last_name"] ?></td>
                    <td> <?php echo $row["gender"] ?></td>
                    <td> <?php echo $row["birth_date"] ?></td>
                    <td> <?php echo $row["hire_date"] ?></td>
                    <?php
                        $emp_noinsalaries=$row["emp_no"];
                        $sql="select emp_no,MAX(salary) from salaries where emp_no=:emp_noinsalaries;";
                        $newstmt=$db->prepare($sql);
                        $newstmt->bindParam(":emp_noinsalaries",$emp_noinsalaries,PDO::PARAM_INT);
                        if(!$newstmt->execute())
                        {
                            echo "<td>Error!!!</td>";
                        }
                        else
                        {
                            $rowsalary=$newstmt->fetch(PDO::FETCH_ASSOC);
                            if($rowsalary["MAX(salary)"]==0)
                            {
                                echo "<td>No Salary.</td>";
                            }
                            else
                            {
                                echo "<td>".$rowsalary["MAX(salary)"]."</td>";
                            }
                        }
                    ?>
                    <td>
                        <form action="Editemployeeinfo.php" onsubmit="return validateForm()" method="post">
                            <input hidden type= "text" name="Edit_emp_no" value="<?php echo $row["emp_no"] ?>"/>
                            <button type="submit">Edit</button>
                        </form>
                    </td>
                    <td>
                        <form action="Deleteemployeeinfo.php" onsubmit="return Alert()" method="post">
                            <input hidden type= "text" name="Dlt_emp_no" value="<?php echo $row["emp_no"] ?>"/>
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                </tr>
                <?php
                $i++;
            }
            ?>
        </tbody>
    </table>
</div>
<div align="center">
    <form id = "form1" action="<?php $_SERVER['PHP_SELF'] ?>"  method="post">
        <div>
            <label>Search: </label>
            <input type="text" name="Searchfor" value="<?php if (isset($name)) echo $name; ?>"/>
            <input type="submit" value="Search"/>
        </div>

        <br>
        <input hidden value="none" id ="Buttondetect" name="nextorprev"/>
        <input hidden value="<?php echo $Page ?>" name="Page" id="Page"/>
        <?php
        if($Page>=$recordperpage)
        {
            echo '<button type="submit" id="Previous" onclick="checknextorprev(this.id)">Previous</button>';
        }
        ?>
        <input hidden type="text" id="OrderbySalaryinput" name="OrderbySalaryinput" value="<?php
        if(isset($_POST['OrderbySalaryinput']))
            echo $_POST['OrderbySalaryinput'];
        else
            echo "";
        ?>"/>
        <input type="submit" onclick="orderbylowsalary()" name="OrderbylowSalary" value="Sort by Low Salary"/>
        <input type="submit" onclick="orderbyhighsalary()" name="OrderbyhighSalary" value="Sort by High Salary"/>
        <input type="submit" onclick="cancelorderbysalary()" name="CamcelOrderbySalary" value="Cancel Sorting"/>
        <?php
            if($i==25)
            {
            echo '<button type="submit" id="Next" onclick="checknextorprev(this.id)">Next</button>';
            }
        ?>
    </form>
</div>
<br>
<div align="center">
    <form name="LogoutForm" action="Login/logOut.php" method="post">
        <input type="submit" name="logoutButton" value="Log Out"/>
    </form>
</div>

</body>

<footer>
    Css style copied from <a href="https://bootsnipp.com/snippets/6XbX7">here</a>
</footer>
<?php
DisconnectDatabase($db);
//mysqli_close($db);
?>
</body>
</html>


<!--Css style copied from https://bootsnipp.com/snippets/6XbX7-->