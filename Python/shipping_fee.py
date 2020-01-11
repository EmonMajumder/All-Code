#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Assignment- 1 (Hipster Local)
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    shippingCharge=10
    shippingFee=False
    print("Welcome to Emon's online shopping")
    totalPayment=float(input("\nPlease enter your total purchase amount: $"))

    if totalPayment<50:
        shippingFee=True
    if shippingFee:
        totalPayment=totalPayment+10
        print("\nYou need to pay additonal ${0:.2f}".format (shippingCharge)+" for shipping charge.\nYour total invoice is ${0:.2f}".format(totalPayment)+".")
    else:
        print("\nCongratulation, you don't need to pay any shipping charge.")
    
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()