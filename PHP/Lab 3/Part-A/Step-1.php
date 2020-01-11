<title>Part-A: Step-1</title>

<?php
//    $db = mysqli_connect("localhost","root","inet2005","sakila");
//
//    if(!$db)
//    {
//        die("Could not connect to the Sakila Database: " . mysqli_connect_error());
//    }
    include "Step-3.php";
    $db = ConnectDatabase();

    $result = mysqli_query($db,"select * from film");
    if(!$result)
    {
        die('Could not retrieve records from the Database: ' . mysqli_connect_error());
    }

    while($row=mysqli_fetch_assoc($result))
    {
        echo $row["title"]." ".$row["description"];
        echo "<br>";
    }

    //mysqli_close($db);
    DisconnectDatabase($db);
