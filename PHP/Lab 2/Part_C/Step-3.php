<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>File upload handling - Post</title>
    </head>
    <body>
        <?php
            $heightininch = (int)($_POST['heightininch']);
            $heightinfeet = (int)($_POST['heightinfeet']);
            $totalheight = ($heightinfeet*12)+$heightininch;
            $heightinmeter = $totalheight/39.37;

            $fileTmpName = $_FILES['myfile']['tmp_name'];
            $fileOrigName = $_FILES['myfile']['name'];
            $fileSize = $_FILES['myfile']['size'];
            $fileUploadError = $_FILES['userImage']['error'];
            $result = move_uploaded_file($fileTmpName,"uploadedfile/".$fileOrigName);
        ?>
        Your first name is: <?php echo $_POST['fName']?> <br>
        Your last name is: <?php echo $_POST['lName'] ?><br>
        Your height in meter is: <?php echo round($heightinmeter,2)?><br>
        <br>
        <?php

            if(!$fileUploadError)
            {
                echo "Tmp: ".$fileTmpName."<br>";
                echo "Orig: ".$fileOrigName."<br>";
                echo "Size: ".$fileSize."<br>";
                echo "Error: ".$fileUploadError;
                if($result)
                    echo "File was saved successfully.";
                else
                    echo "Error!!! Could not save file";
            }
            else
                echo "Error!!! Could not upload file."

        ?>
    </body>
</html>