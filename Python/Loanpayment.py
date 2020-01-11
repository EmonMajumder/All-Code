#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Assignment- 1 (Loan Payment)
"""
#1. Print name
#2. input loan amount
#3. input interest rate
#4. input years
#5. Calculate i
#6. caculate weekly loan payment amount
def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    print ("Weekly Loan Payment Calculator")
    loanAmount= float (input("\nEnter the amount of loan: "))
    interestRate= float (input("Enter interest Rate (%): "))
    numberofYears= float (input("Enter the number of years: "))
      
    i=interestRate/5200
    weeklyPayment= (i/(1-((1+i)**(-(52*numberofYears)))))*loanAmount
    print ("\nYour weekly payment will be: ${0:.2f}".format(weeklyPayment))
    
     #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()