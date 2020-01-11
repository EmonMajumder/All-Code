<?php
    //----------------------------------------------------
    session_start();
    require('Login/isLoggedIn.php');
    checkIfLoggedIn();
    //----------------------------------------------------
    if(isset($_POST['Edit_emp_no'])) {
        $emp_no = $_POST['Edit_emp_no'];
        include "ConnectDatabase.php";
        $db = ConnectDatabase();

        $sql = "select * from employees where employees.emp_no = :emp_no;";
        $stmt=$db->prepare($sql);
        $stmt->bindParam(":emp_no",$emp_no,PDO::PARAM_INT);
        if (!$stmt->execute()) {
            die("Could not retrieve records from the Database."." ".$stmt->errorInfo());
        }
        else
        {
            $row = $stmt->fetch(PDO::FETCH_ASSOC);
            $firstname = $row['first_name'];
            $lastname = $row['last_name'];
            $gender = $row['gender'];
            $birthdate = $row['birth_date'];
            $hiredate = $row['hire_date'];
        }
        ?>
        <!DOCTYPE html>
        <html lang="en">
        <head>
            <meta charset="UTF-8">
            <title>Edit Employee Record</title>
            <script src="Formvalidation.js"></script>
        </head>
        <body>
        <form name="myForm" action="EmployeerecordUpdated.php" onsubmit="return validateForm()" method="post">
            <p>
                Employee ID: <?php echo $emp_no ?>
                <label hidden id="emp_no_label">
                    <input type="text" name="emp_no" id="emp_no" onfocusin='cngin(this.id);'
                           onfocusout='cngout(this.id);' value="<?php echo $emp_no ?>">
                </label>
            </p>
            <p>
                <label id="fName_label">First Name:
                    <input type="text" name="fName" id="fName"  onfocusin='cngin(this.id);' onfocusout='cngout(this.id);' value="<?php echo $firstname ?>">
                    <span id="fNamewarning" style="visibility:hidden">&nbsp&nbsp&nbspInvalid first name</span>
                </label>
            </p>
            <p>
                <label id="lName_label">Last Name:
                    <input type="text" name="lName" id="lName"  onfocusin='cngin(this.id);' onfocusout='cngout(this.id);' value="<?php echo $lastname ?>">
                    <span id="lNamewarning" style="visibility:hidden">&nbsp&nbsp&nbspInvalid last name</span>
                </label>
            </p>
            <p>
                <label id="Gender_label">Gender:
                    <input type="text" name="gender" id="gender"  onfocusin='cngin(this.id);' onfocusout='cngout(this.id);' placeholder="M/F" value="<?php echo $gender ?>">
                    <span id="genderwarning" style="visibility:hidden">&nbsp&nbsp&nbspInvalid gender name</span>
                </label>
            </p>
            <p>
                <label id="Birthdate_label">Birthdate:
                    <input type="text" name="birthdate" id="birthdate"  onfocusin='cngin(this.id);' onfocusout='cngout(this.id);' placeholder="yyyy-mm-dd" value="<?php echo $birthdate ?>">
                    <span id="birthdatewarning" style="visibility:hidden">&nbsp&nbsp&nbspInvalid date format</span>
                </label>
            </p>
            <p>
                <label id="Hiredate_label">Hiredate:
                    <input type="text" name="hiredate" id="hiredate"  onfocusin='cngin(this.id);' onfocusout='cngout(this.id);' placeholder="yyyy-mm-dd" value="<?php echo $hiredate ?>">
                    <span id="hiredatewarning" style="visibility:hidden">&nbsp&nbsp&nbspInvalid date format</span>
                </label>
            </p>

            <input type="submit">
        </form>
        <form name="LogoutForm" action="Login/logOut.php" method="post">
            <input type="submit" name="logoutButton" value="Log Out"/>
        </form>
        </body>
        </html>

        <?php
    }
    else
        echo "Error!!!";
    DisconnectDatabase($db);
    //mysqli_close($db);
?>


