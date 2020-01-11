<!Doctype html>
<html>

    <head>

        <title>Step 4: Use built-in functions</title>

    </head>

    <body>

        <button onclick="location.href = 'CelsiusConversionTable.php';">Celsius to Farhenheit </button>
        <button onclick="location.href = 'FahrenheitConversionTable.php';">Farhenheit to Celsius </button>

        <br><br>

        <table border="1">

            <tr bgcolor='gray'>
                <td>Celsius</td>
                <td>Farhenheit</td>
            </tr>

            <?php
                for ($i=0; $i<=100; $i++)
                {
                    $farhenheit = round(((9*$i)/5)+32);

                    if ($i%2)
                    {
                        echo "<tr style='background:red;'><td>$i</td><td>$farhenheit</td></tr>";
                    }
                    else
                        echo "<tr><td>$i</td><td>$farhenheit</td></tr>";
                }
            ?>

        </table>

    </body>

</html>