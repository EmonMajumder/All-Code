
#Tax Calculator
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Tech Check- 2
"""
#pseudocode
#1. Take input of weekly salary
#2. Take input for dependent number
#3. Assign values for 2 types of tax and 1 deduction
#4. calculate output for 2 types of tax amount separately, deduction, total withheld and take home amount.
def main(): 
    #<-- Don't change this line!
    #Write your code below. It must be indented!
    
    print ("Tax wirhholding Calculator")

    originalSalary = int (input ("Please enter the full amount of your weekly salary: $"))
    dependentNumber= int(input ("How many dependent do you have?: "))
    provincialTax = float (0.06)
    federalTax= float (0.25)
    dependentReductionrate= float (0.02)

    provincialtaxAmount= originalSalary*provincialTax
    federaltaxAmount= originalSalary*federalTax
    dependentReductionamount= originalSalary*dependentReductionrate*dependentNumber
    totalWithheld= provincialtaxAmount+federaltaxAmount-dependentReductionamount
    takeHome= originalSalary-totalWithheld
    print ("Provincial Tax withheld: ${0:.2f}".format(provincialtaxAmount)+"\nFederal Tax withheld: ${0:.2f}".format(federaltaxAmount)+"\nDependent Deduction for {0}".format(dependentNumber)+"dependents: ${0:.2f}".format(dependentReductionamount)+"\nTotal Withheld: ${0:.2f}".format(totalWithheld)+"\nTotal Take-Home Pay: ${0:.2f}".format(takeHome))

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()