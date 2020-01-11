#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Tax_Calculator
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    print("Welcome to Emon's online shop")
    totalBill=float(input("\nPlease enter your total bill amount: $"))
    country= input("Which country you are from?: ")
    if country.lower()=="canada":
        province=input("Which province you are from?: ")
        if province.upper()=="AB" or province.upper()=="ALBERTA":
            totalBill=totalBill*1.05
            print("\n5% gst added")
        else:
            if province.upper()=="ON" or province.upper()=="ONTARIO" or province.upper()=="NB" or province.upper()=="NEW BRUNSWICK" or province.upper()=="NS" or province.upper()=="NOVA SCOTIA":
                totalBill=totalBill*1.15
                print("\n5% gst and 10% provincial tax added")
            else:
                totalBill=totalBill*1.11
                print("\n5% gst and 6% provincial tax added")
    else:
        print(" ")

    print("your total bill is ${0:.2f}".format(totalBill))
    
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()