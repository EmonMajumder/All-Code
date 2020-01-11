#Don't forget to rename this file after copying the template
#for a new program!
"""
Student Name: Emon Majumder  
Program Title: IT Programming  
Description: Grade_Calculator  
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
#Pseudocode
# 1.	Assign the letter input to a variable
# 2.	Assign the modifier to a variable
# 3.	Assign values to grade letter A, B, C, D, E
# 4.	If logic for the modifier. 
# 5.	Build function for value output.
# 6.	Print the result

    def gradePoint (letterSelect):
        if letterSelect=="A":
            numericValue=4.0
        elif letterSelect=="B":
            numericValue=3.0
        elif letterSelect=="C":
            numericValue=2.0
        elif letterSelect=="D":
            numericValue=1.0
        elif letterSelect=="F":
            numericValue=0
        else:
            numericValue="invalid"
        return numericValue
    
    print("Grade point Calculator\n")
    modifierSelect=" "
    letterSelect=input("Please enter a grade letter : ").upper()
    if letterSelect != "F":
        modifierSelect=input("Please enter a modifier (+, - or nothing) : ")
   
    gradeincrement=0.3
    numericValue= gradePoint (letterSelect)
    if numericValue != "invalid":
        if letterSelect != "F":
            if letterSelect != "A" and modifierSelect=="+":
                numericValue=numericValue+gradeincrement
            elif modifierSelect=="-":
                numericValue=numericValue-gradeincrement
        print("The numeric value is : {0}".format(numericValue))
    else:
        print("You entered an invalid letter Grade")

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()

