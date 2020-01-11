<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Input php handling - Post</title>
    </head>
    <body>
        <?php
            $heightininch = (int)($_POST['heightininch']);
            $heightinfeet = (int)($_POST['heightinfeet']);
            $totalheight = ($heightinfeet*12)+$heightininch;
            $heightinmeter = $totalheight/39.37;
        ?>
        <p>Your first name is: <?php echo $_POST['fName']?> </p>
        <p>Your last name is: <?php echo $_POST['lName'] ?></p>
        <p>Your height in meter is: <?php echo round($heightinmeter,2)?></p>
    </body>
</html>