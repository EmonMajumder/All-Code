function randomFunction()
{
    var randomNumbers=[];

    for(var i=0;i<10;i++)
    {
        randomNumbers.push(Math.floor(Math.random() * 100) + 1);
    }

    function test_prime(n)
    {    
        if (n === 1)
        {
            return "yes";
        }
        else if(n === 2)
        {
            return "yes";
        }
        else
        {
            for(var x = 2; x < n; x++)
            {
                if(n % x === 0)
                {
                    return "no";
                }
            }
            return "yes";  
        }
    }

    var output = "";

    for(i=0; i<randomNumbers.length; i++)
    {
        if(i != randomNumbers.length-1)
        {
            output += randomNumbers[i]+"-"+test_prime(randomNumbers[i])+", ";
        }
        else
        {
            output += randomNumbers[i]+"-"+test_prime(randomNumbers[i]);
        }
    }

    console.log(output);    
}

randomFunction();