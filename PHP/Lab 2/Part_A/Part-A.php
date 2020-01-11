<!Doctype html>
<html>

    <head>

        <title>Lab 2: Part-A</title>

    </head>

    <body>

        <h3>Step 1: Write a PHP function</h3>
        <?php
            for ($i=1;$i<=7;$i++)
            {
                printHeading("A Brown Fox Quickly Jumped Over A Lazy Dog",$i);
            }

            function printHeading ($string, $number)
            {
                if($number<=6)
                {
                    echo "<h$number>$string</h$number>";
                }
                else
                    echo "Error!!!";
            }
        ?>

        <br>
        <br>

        <h3>Step 2: Pass variables to PHP functions by both Reference and Value.</h3>
        <?php
            $stringVariable = "Hello, World";
            echo "<p>$stringVariable</p>";

            Variablebyvalue($stringVariable);
            echo "<p>$stringVariable</p>";

            Variablebyreference($stringVariable);
            echo "<p>$stringVariable</p>";


            function Variablebyvalue($string)
            {
                $string.="...blah";
            }

            function Variablebyreference(&$string)
            {
                $string.="...blah";
            }
        ?>

        <br>

        <h3>Step 3: Use a global variable in a function.</h3>
        <?php
            $GlobalVariable = 25;

            usingGlobalvariable();

            function usingGlobalvariable()
            {
                global $GlobalVariable;
                echo "<h1>you are ".$GlobalVariable." years old</h1>";
            }
        ?>

    </body>
</html>

