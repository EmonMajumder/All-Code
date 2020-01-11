<!Doctype html>
<html>

    <head>

        <title>Step 4: Use built-in functions</title>

    </head>

    <body>


        <button onclick="location.href = 'CelsiusConversionTable.php'">Celsius to Farhenheit </button>
        <button onclick="location.href = 'FahrenheitConversionTable.php'">Farhenheit to Celsius </button>

        <br><br>

        <table border="1">

            <tr bgcolor='gray'>
                <td >Farhenheit</td>
                <td >Celsius</td>
            </tr>

            <?php
                for ($i=0; $i<=100; $i++)
                {
                    $celsius = round((5*($i-32))/9);
                    if ($i%2)
                    {
                        echo "<tr bgcolor='gray'><td>$i</td><td>$celsius</td></tr>";
                    }
                    else
                        echo "<tr><td>$i</td><td>$celsius</td></tr>";
                }
            ?>

        </table>

    </body>

</html>