function validate()
{
    var elements = ['diameter','length','width','base','height','areachangetriangle','areachangecircle'];
    var numregex = /^\s*(\d+|\.\d+|\d+\.\d+|\d+\.)?\s*$/;
    var validity = 0;

    for (id of elements)
    {
        if(!numregex.test(document.getElementById(id).value))
        {
            makeboxred(id);
            validity++;
        }
        else
            makeok(id);
    }

    if(validity>0)
        return false;
    else
        return true;
}

function makeboxred(id)
{
    document.getElementById(id).style.borderColor = "red";
}

function makeok(id)
{
    document.getElementById(id).style.borderColor = "black";
}