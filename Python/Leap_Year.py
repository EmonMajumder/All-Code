#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Leap_year
"""
#Pseudocode
# 1. Define name of the function
# 2. Select variable name 
# 3. Assign values to 3 variable for input %4, 100 & 400
# 4. determine if input is devisible by 4, 100 and 400 as needed through if logic
# 5. return value from the function if leap year or not
# 6. Assign input to a variable for year to check
# 7. Call function and assign value to a variable
# 8. print the result

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    def leapyearteller (year):
        remainderFor4=year%4
        remainderFor100=year%100
        remainderFor400=year%400
        if remainderFor4==0 and remainderFor100>0:
            decision= "is a Leap year"
        elif remainderFor400==0:
            decision= "is a Leap year"  
        else:
            decision= "is not a Leap year"
        return decision

    yeartoCheck=int(input("Please enter the year that you want to check if it is a leap year: "))
    decision=leapyearteller (yeartoCheck)
    print("{0} {1}".format(yeartoCheck,decision))
     #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()