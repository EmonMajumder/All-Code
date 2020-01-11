#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Wage calculator
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!

    print ("Welcome to the wage calculator")
    paymentRate=float(input("\nWhat is your hourly payment?: $"))
    totalHour=int(input("How many hours did you work?: "))
    if totalHour>40:
        totalPayment=paymentRate*(40)+paymentRate*1.5*(totalHour-40)
    if totalHour<=40:
        totalPayment=totalHour*paymentRate
    print ("Congratulation you have earned ${0:.2f}".format(totalPayment))

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()