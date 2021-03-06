// Get all the keys from document
var keys = document.querySelectorAll('#calculator span');

// Add onclick event to all the keys and perform operations
for(var i = 0; i < keys.length; i++) {
	keys[i].onclick = function(e) {
		// Get the input and button values
		var input = document.querySelector('.screen');
		var inputVal = input.innerHTML;
		var btnVal = this.innerHTML;
		var newinnerHTML = "";
		
		// Now, just append the key values (btnValue) to the input string and finally use javascript's eval function to get the result
		// If clear key is pressed, erase everything
		if(btnVal == 'C') {
			input.innerHTML = '';
            btnVal = '';
		}
		
		// If eval key is pressed, calculate and display the result
		if(btnVal == '=') {
			var equation = inputVal;
			
			// Replace all instances of x and ? with * and / respectively. This can be done easily using regex and the 'g' tag which will replace all instances of the matched character/substring
            equation = equation.replace(/x/g, '*').replace(/÷/g, '/');
			
			if(equation) {
                input.innerHTML = eval(equation);
            }
		}		
		// if any other key is pressed, just append it
		else {
			if(btnVal == "+" || btnVal == "-" || btnVal == "÷" || btnVal == "x")
			{
				//If there was previous input in calculator.
				if(input.innerHTML!="")
				{
					if(input.innerHTML.charAt(input.innerHTML.length-1) == '.' && 
						(input.innerHTML.charAt(input.innerHTML.length-2) == "+" ||
						input.innerHTML.charAt(input.innerHTML.length-2) == "-" ||
						input.innerHTML.charAt(input.innerHTML.length-2) == "÷" ||
						input.innerHTML.charAt(input.innerHTML.length-2) == "x"))
					{
						newinnerHTML = input.innerHTML.slice(0,-2);
						if(newinnerHTML!="")
						{
							input.innerHTML = newinnerHTML+btnVal;
						}						
					}
					else if((input.innerHTML.charAt(input.innerHTML.length-1) == "+" ||
						input.innerHTML.charAt(input.innerHTML.length-1) == "-" ||
						input.innerHTML.charAt(input.innerHTML.length-1) == "÷" ||
						input.innerHTML.charAt(input.innerHTML.length-1) == "x" ||
						input.innerHTML.charAt(input.innerHTML.length-1) == '.'	) && input.innerHTML!="-" && input.innerHTML!=".")
					{
						input.innerHTML = input.innerHTML.slice(0,-1);
						input.innerHTML += btnVal;
					}
					else if(btnVal == "-" && input.innerHTML == ".")
					{
						input.innerHTML = input.innerHTML.slice(0,-1);
						input.innerHTML += btnVal;										
					}
					else if(input.innerHTML!="-" && input.innerHTML!=".")
					{
						input.innerHTML += btnVal;
					}
				}				
				else if(btnVal == "-")
				{
					input.innerHTML += btnVal;										
				}				
			}
			else if(btnVal == '.')
			{
				var s = input.innerHTML;
				if(!(/^\-*(\d*(\.\d)*(\+|\-|\x|\÷)*)*\d*\.\d*$/.test(s)))
				{
					input.innerHTML += btnVal;
				}
			}
			else
			{
				input.innerHTML += btnVal;
			}								
		}
	} 
}