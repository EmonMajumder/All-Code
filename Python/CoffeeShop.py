#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Coffeeshop
"""

def main():

    while True:
        try:
            originalBill = float(input("What is your original bill amount?: "))
            break
        except:
            print("Please give number only")

    taxAmount =  originalBill *0.15
    tipAmount = originalBill*0.20
    totalAmount = originalBill+taxAmount+tipAmount

    print("Your original bill amount: {0:.2f}\nTax amount: {1:.2f}\nTip amount: {2:.2f}\nTotal bill: {3:.2f}".format (originalBill,taxAmount,tipAmount,totalAmount))

     #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()