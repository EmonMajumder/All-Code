<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Part 2 (Step 2 - Step 6)</title>
    </head>
    <body>

        <h3>Step 2: Using a String Variable</h3>
        <?php
            $myname = "Emon Majumder";
            echo $myname;
        ?>

        <h3>Step 3: Using the Concatenation Operator</h3>
        <?php
            $myname = "Emon Majumder";
            $string2 = " is a";
            $string3 = " NSCC student";
            $string4 = " from";
            $laststring = $myname.$string2.$string3.$string4." Bangladesh.";

            echo $laststring;
        ?>

        <h3>Step 4: Using the Arithmetic Operators</h3>
        <?php
            $num1 = 32;
            $num2 = 14;
            $num3 = 83;
            $num4 = 1024;
            $num5 = 128;
            $num6 = 7;
            $num7 = 769;
            $num8 = 6;

            $numa = ($num1 * $num2)+$num3;
            $numb = ($num4/$num5)-$num6;
            $numc = $num7%$num8;

            echo "<p>a. $numa</p>";
            echo "<p>b. $numb</p>";
            echo "<p>c. $numc</p>";
        ?>

        <h3>Step 5: Use a loop</h3>
        <?php
            for ($i=10;$i>=1;$i--)
            {
                print "$i...";
            }
            print "Blast Off";
        ?>

        <h3>Step 5: Use a loop</h3>
        <?php

            $Colors = array("Red","Blue","Green","Yellow","Oragne","Pink","Violet");

            echo "<h4>a) For Loop</h4>";
            for ($i=0 ; $i<count($Colors) ; $i++)
            {
                echo $Colors[$i]."<br>";
            }

            echo "<h4>b) Foreach Loop</h4>";
            foreach ($Colors as $color)
            {
                echo $color."<br>";
            }

            echo "<h4>c) Any other Loop</h4>";
            $x = 0;
            while($x < count($Colors))
            {
                echo "$Colors[$x]<br>";
                $x++;
            }
        ?>
    </body>
</html>