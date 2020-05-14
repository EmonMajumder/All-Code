function magic8Ball()
{
    var wordList = ["Good day", "Bad day", "Super day", "Cold day","Hot day"];
    return wordList[Math.floor(Math.random()*5)];
}

function call8Ball()
{
    for(var i=0; i<10; i++)
    {
        console.log(magic8Ball());        
    }    
}

call8Ball();