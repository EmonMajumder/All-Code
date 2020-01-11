<?php
function checkIfLoggedIn()
{
    session_start();
    if(empty($_SESSION['username']))
    {
        header('location:Login/mainLogin.php');
    }
}
