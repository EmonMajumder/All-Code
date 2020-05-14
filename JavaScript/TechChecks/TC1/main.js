(function(testFunction){
/*
* PHONEWORDS
* Write a function that will take a phone word (vanity number) and return the correct telephone number.
* The number pad looks like the following:
* https://en.wikipedia.org/wiki/Telephone_keypad#/media/File:Telephone-keypad2.svg
*
* RULES
* Given a phoneword:
* 1. Remove any non-numeric characters (), -, etc.
* 2. Keep any digits
* 3. Resolve a number according to the keypad image
* 4. All your code must be contained in the section function below
*
*
* Final Grade	Requirement
* 10/10	Tech check is correct (passes all tests) and is completed within the allotted in-class time.
* 8/10	Tech check is correct (passes all tests) and is completed within a 12-hour grace period beginning immediately following the end of in-class time.
* 6/10	Tech check is correct (passes all tests) and is completed and submitted after the 12-hour grace period has elapsed.
* 0/10	Tech check is not submitted or does not pass all tests.
*/

// CHANGE ONLY CODE IN THIS SECTION

    function convertPhoneWord(phoneword) {
        var phonewordinput = phoneword;
        var phonewordoutput = "";
        var letters = /^[A-Za-z]$/;
        var numbers = /^[0-9]$/;
        if(phoneword != null || phoneword != undefined)
        {
            for(var i=0;i<phonewordinput.length;i++)
            {                
                if(phonewordinput[i].match(letters))
                {
                    var alphabet = phonewordinput[i].toUpperCase();                          
                    switch(alphabet)
                    {
                        case "A": case "B": case "C": var num = 2; phonewordoutput = phonewordoutput.concat(num); break;                   
                        case "D": case "E": case "F": var num = 3; phonewordoutput = phonewordoutput.concat(num); break;
                        case "G": case "H": case "I": var num = 4; phonewordoutput = phonewordoutput.concat(num); break;
                        case "J": case "K": case "L": var num = 5; phonewordoutput = phonewordoutput.concat(num); break;
                        case "M": case "N": case "O": var num = 6; phonewordoutput = phonewordoutput.concat(num); break;
                        case "P": case "Q": case "R": case "S": var num = 7; phonewordoutput = phonewordoutput.concat(num); break;
                        case "T": case "U": case "V": var num = 8; phonewordoutput = phonewordoutput.concat(num); break;
                        case "W": case "X": case "Y": case "Z": var num = 9; phonewordoutput = phonewordoutput.concat(num); break;
                    }                           
                }
                else if(phonewordinput[i].match(numbers))
                {
                    phonewordoutput = phonewordoutput.concat(phonewordinput[i]);             
                }
                else
                {
                    phonewordoutput = phonewordoutput.concat("");
                }                
            }                                                         
        }
        else
        {
            phonewordoutput = "";                
        }  
        return phonewordoutput;
    }

// DO NOT CHANGE ANY CODE AFTER THIS LINE.

    //Run tests on the function
    testFunction(convertPhoneWord); //DO NOT MODIFY

    
})(testFunction);