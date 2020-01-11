<?php

function ConnectDatabase()
{
    $db = mysqli_connect("localhost","emon", "emon", "employees");

    if(!$db)
    {
        die("Could not connect to the Database: " . mysqli_connect_error());
    }

    return $db;
}

function DisconnectDatabase($db)
{
    mysqli_close($db);
}