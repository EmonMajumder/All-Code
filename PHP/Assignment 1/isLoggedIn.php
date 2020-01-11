<?php
function checkIfLoggedIn()
{
    session_start();
    if(empty($_SESSION['username']))
    {
        header('location:mainLogin.php');
    }
    else
        header('DeleteRecord.php');
}
