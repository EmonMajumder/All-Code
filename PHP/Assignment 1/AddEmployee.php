<title>Insert Record into employee table</title>
<?php
    //----------------------------------------------------
    session_start();
    require('isLoggedIn.php');
    checkIfLoggedIn();
    //----------------------------------------------------
    include "ConnectDatabase.php";
    $db = ConnectDatabase();

    $fName = $_POST["fName"];
    $lName = $_POST["lName"];
    $Gender = $_POST["gender"];
    $Birthdate = $_POST["birthdate"];
    $Hiredate= $_POST["hiredate"];

    $result = mysqli_query($db,"select MAX(emp_no) as maxemp_no from employees.employees");
    $row = mysqli_fetch_assoc($result);
    $maxemp_no = $row['maxemp_no'];
    $emp_no = $maxemp_no+1;
    echo $maxemp_no;

    $result = mysqli_query($db,"INSERT INTO employees.employees (emp_no, first_name, last_name, gender, birth_date, hire_date) VALUES ('$emp_no','$fName','$lName','$Gender','$Birthdate','$Hiredate');");

    if(!$result)
    {
        die('Could not insert record into the Sakila Database: ' . mysqli_error($db));
    }
    else
    {
        $affectedrecordnumber = mysqli_affected_rows($db);
        echo "<p>New record inserted.</p><br>";
        echo "$affectedrecordnumber records affected<br>";
        echo $fName." ".$lName."<br>";
        echo $Gender."<br>";
        echo $Birthdate."<br>";
        echo $Hiredate."<br>";
    }
    if(isset($_SESSION['intendpage']))
    {
        $site = $_SESSION['intendpage'];
    }
    else
        $site= 'Innovative.php';
    DisconnectDatabase($db);
    ?>
<form action="<?php echo $site ?>" method="post">
    <button type="submit">Go Back</button>
</form>
<br>
<form name="LogoutForm" action="logOut.php" method="post">
    <input type="submit" name="logoutButton" value="Log Out"/>
</form>

