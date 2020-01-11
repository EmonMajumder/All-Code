<?php
    for ($i=0; $i<=100; $i++)
    {
        $celsius = round((5*($i-32))/9);
        echo "$i degree(s) of fahrenheit equals $celsius degrees of celsius";
        echo "<br>";
    }
?>