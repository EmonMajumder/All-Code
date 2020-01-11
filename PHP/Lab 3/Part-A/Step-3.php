<?php

function ConnectDatabase()
{
    $db = mysqli_connect("localhost","root", "inet2005", "sakila");

    if(!$db)
    {
        die("Could not connect to the Sakila Database: " . mysqli_connect_error());
    }

    return $db;
}

function DisconnectDatabase($db)
{
    mysqli_close($db);
}
