#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Tax_Calculator
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    #Pseudocode 
    #Assign values for GST, HST and PST.
    #Ask customer for input for country and purchase amout.
    # Assign value for country and purchase to 2 variable.
    # Compare country name if canada. 
    # Ask for province name if from canada.
    # Compare province name string in if statement.
    # If from alberta calculate total amount along with tax amount.
    # If from New Brunswick, Nova scotia or Ontario calculate tax and total amount accordingly.

    print("Welcome to Emon's online shop")

    gst=5
    hst=15
    pst=6

    totalBill=float(input("\nPlease enter your total bill amount: $"))
    country= input("Which country you are from?: ")

    if country.lower()=="canada":
        province=input("Which province you are from?: ")
        if province.upper()=="AB" or province.upper()=="ALBERTA":
            tax=totalBill*gst/100
            totalBill=totalBill+tax
            print("\n{0:.2f}% gst amouting ${1:.2f} added".format(gst,tax))
        elif province.upper()=="ON" or province.upper()=="ONTARIO" or province.upper()=="NB" or province.upper()=="NEW BRUNSWICK" or province.upper()=="NS" or province.upper()=="NOVA SCOTIA":
            tax=totalBill*hst/100
            totalBill=totalBill+tax
            print("\n{0:.2f}% Harmonized sales tax amouting ${1:.2f} added".format(hst,tax))
        else:
            tax=totalBill*(gst+pst)/100
            totalBill=totalBill+tax
            print("\n{0:.2f}% gst and {1:.2f}% provincial sales tax amouting ${2:.2f} added".format(gst,pst,tax))
    else:
        print(" ")

    print("your total bill is ${0:.2f}".format(totalBill))
    
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()