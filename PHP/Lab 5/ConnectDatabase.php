<?php

function ConnectDatabase()
{
    $dsn = "mysql:hostname=localhost;dbname=employees";
    $db = new PDO($dsn,"emon", "emon");

    if(!$db)
    {
        die("Could not connect to the Database employees" . $db->errorInfo());
    }

    return $db;
}

function DisconnectDatabase($db)
{
    $db=null;
}