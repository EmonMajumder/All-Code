<!Doctype html>
<html>

    <head>

        <title>Step 4: Use built-in functions</title>

    </head>

    <body>

        <?php
            echo "<h1>Your current PHP version: ". phpversion()."</h1>";

            echo "<h1>Your current Zend version: ". zend_version()."</h1>";

            echo "<h1>".ini_get("default_mimetype")."</h1>";
        ?>

    </body>

</html>