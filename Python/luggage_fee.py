#Don't forget to rename this file after copying the template
#for a new program!
"""
Student Name: Emon Majumder  
Program Title: IT Programming
Description: Luggage_fee   
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!

    print("Welcome to the Luggage check-in counter")
    maxAllowed=50
    luggageWeight=float(input("\nWhat is the weight of your luggage (in lbs)?: "))
    if luggageWeight>maxAllowed:
        print("You need to pay $25 as surcharge")
    if luggageWeight<=maxAllowed:
        print("No surcharge applied")
    print ("\nWish you a safe journey")
    
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()