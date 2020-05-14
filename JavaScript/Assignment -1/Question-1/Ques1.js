"use strict"

/*
chech the first and last letter and Use the upper and lower case method similar
if both letter are same than reverse the letter using for loop
if both letter are not same than remove the first and last letter
*/

function stringChange(string)
{
    var changeWord ="";
    if(string[0].toUpperCase() === string[string.length-1].toUpperCase())
    {
        for(var i=(string.length-1); i>=0; i--)
        {
            changeWord += string[i];
        }

        console.log(changeWord);
    }
    else
    {
        for(var i=1;i<(string.length-1);i++)
        {
            changeWord += string[i];   
        }
        console.log(changeWord);
    }    
}

stringChange("Cracker");