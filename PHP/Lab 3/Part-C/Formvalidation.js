function cngin(id)
{
    var cng = document.getElementById(id);
    cng.style.backgroundColor = "yellow";
    cng.style.fontStyle = "italic";
    var labelid = id.concat("_label");
    var label = document.getElementById(labelid);
    label.style.textDecoration = "underline";
}

function cngout(id)
{
    var cng = document.getElementById(id);
    cng.style.backgroundColor = "white";
    cng.style.fontStyle = "normal";
    var labelid = id.concat("_label");
    var label = document.getElementById(labelid);
    label.style.textDecoration = "none";
}

function validateForm()
{
    var formelements = ["fName","lName","Address1","Address2","email"];
    validity = 0;

    formelements.forEach(check);
    function check(element, index, array)
    {
        var elementvalue = document.forms["myForm"][element].value;
        if(elementvalue == "")
        {
            makeboxred(document.getElementById(element));
            validity++;
        }
    }
    if(document.getElementById("terms").checked === false)
    {
        var warning = document.getElementById("warning");
        warning.style.color = "red";
        warning.style.visibility = "visible";
        validity++;
    }

    if(validity>0)
    {
       return false;
    }
}

function makeboxred(id)
{
    id.style.borderColor = "red";
}


