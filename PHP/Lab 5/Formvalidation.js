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
    var formelements = ["fName","lName","gender","birthdate","hiredate"];
    var validity = 0;

    formelements.forEach(check);
    function check(element, index, array)
    {
        var objectvalue = document.forms["myForm"][element].value;
        if(element == "fName" || element == "lName")
        {
            if(objectvalue.match(/^([A-Z]\w+)$/))
            {
                makeok(element);
            }
            else
            {
                makeboxred(element);
                validity++;
            }
        }
        else if(element === "gender")
        {
            if(objectvalue == "M" || objectvalue == "F")
            {
                makeok(element);
            }
            else if(objectvalue == "m")
            {
                document.getElementById(element).value = "M";
                makeok(element);
            }
            else if(objectvalue == "f")
            {
                document.getElementById(element).value = "F";
                makeok(element);
            }
            else
            {
                makeboxred(element);
                validity++;
            }
        }
        else if(element == "hiredate" || element == "birthdate" )
        {
            if(objectvalue.match(/^((19|20)\d{2})-((1(0|1|2))|(0([1-9]?))|[1-9])-(((1|2)\d{1})|((0)[1-9])|[1-9]|((3)(0|1)))$/))
            {
                makeok(element);
            }
            else
            {
                makeboxred(element);
                validity++;
            }
        }
    }

    if(validity>0)
    {
        return false;
    }
}

function makeboxred(id)
{
     var spanid = id.concat("warning");
     document.getElementById(id).style.borderColor = "red";
     document.getElementById(spanid).style.visibility = "visible";
}

function makeok(id)
{
    var spanid = id.concat("warning");
    document.getElementById(id).style.borderColor = "black";
    document.getElementById(spanid).style.visibility = "hidden";
}

function Alert() {
    if (confirm("Are you sure want to Delete this Record?")) {
        return true;
    } else {
        return false;
    }
}

function checknextorprev(id)
{
    var setbuttontype = document.getElementById("Buttondetect");
    setbuttontype.value = id;
}

// function Checklogin()
// {
//     var validity=0;
//     if(document.getElementById("username").value == "")
//     {
//         document.getElementById("username").style.borderColor = "red";
//         validity++;
//     }
//     else
//     {
//         document.getElementById("username").style.borderColor = "black";
//     }
//     if(document.getElementById("password").value == "")
//     {
//         document.getElementById("password").style.borderColor = "red";
//         validity++;
//     }
//     else
//     {
//         document.getElementById("password").style.borderColor = "black";
//     }
//     if(validity>0)
//     {
//         return false;
//     }
//     else
//         return true;
// }

function Checklogin()
{
    var validity=0;
    if(document.getElementById("username").value == "")
    {
        document.getElementById("username").style.borderColor = "red";
        validity++;
    }
    else
    {
        document.getElementById("username").style.borderColor = "black";
    }
    if(document.getElementById("password").value == "")
    {
        document.getElementById("password").style.borderColor = "red";
        validity++;
    }
    else
    {
        document.getElementById("password").style.borderColor = "black";
    }
    if(validity>0)
    {
        return false;
    }
    else
        return true;
}

function Checkregister()
{
    var validity=0;
    if(document.getElementById("username").value == document.getElementById("hiddenusername").value)
    {
        document.getElementById("username").style.borderColor = "red";
        document.getElementById("usernamehavespace").style.display = "none";
        try {
            document.getElementById("usernameinuse").style.display = "block";
        }catch (err) {

        }
        validity++;
    }
    else if(document.getElementById("username").value == "")
    {
        document.getElementById("username").style.borderColor = "red";
        document.getElementById("usernamehavespace").style.display = "none";
        try {
            document.getElementById("usernameinuse").style.display = "none";
        }catch (err) {

        }
        validity++;
    }
    else if (!document.getElementById("username").value.match(/^\S*$/))
    {
        document.getElementById("username").style.bordercolor = "red";
        document.getElementById("usernamehavespace").style.display = "block";
        try {
            document.getElementById("usernameinuse").style.display = "none";
        }catch (err) {

        }
        validity++;
    }
    else
    {
        document.getElementById("username").style.border = "none";
        document.getElementById("usernamehavespace").style.display = "none";
        try {
            document.getElementById("usernameinuse").style.display = "none";
        }catch (err) {

        }
    }

    if(document.getElementById("password").value == "")
    {
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("passwordhavespace").style.display = "none";
        document.getElementById("shortpassword").style.display = "none";
        validity++;
    }
    else if (!document.getElementById("password").value.match(/^\S*$/))
    {
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("shortpassword").style.display = "none";
        document.getElementById("passwordhavespace").style.display = "block";
        validity++;
    }
    else if (!document.getElementById("password").value.match(/^\S{8,}$/))
    {
        document.getElementById("password").style.borderColor = "red";
        document.getElementById("passwordhavespace").style.display = "none";
        document.getElementById("shortpassword").style.display = "block";
        validity++;
    }
    else
    {
        document.getElementById("password").style.border = "none";
        document.getElementById("passwordhavespace").style.display = "none";
        document.getElementById("shortpassword").style.display = "none";
    }

    if(validity>0)
        return false;
    else
        return true;
}

function orderbylowsalary()
{
    document.getElementById('OrderbySalaryinput').value = " order by Salary asc";
    document.getElementById("Page").value = 0;
}

function orderbyhighsalary()
{
    document.getElementById('OrderbySalaryinput').value = " order by Salary desc";
    document.getElementById("Page").value = 0;
}

function cancelorderbysalary()
{
    document.getElementById('OrderbySalaryinput').value = "";
    document.getElementById("Page").value = 0;
}
