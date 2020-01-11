# Don't forget to rename this file after copying the template
# for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Tech Check- 1
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    
    originalBill = input ("Please enter the original amount of Bill: ")
    taxAmount =  int (originalBill) *0.15
    tipAmount = int (originalBill)*0.20
    totalAmount = int (originalBill)+taxAmount+tipAmount
    print("your original bill amount: {0}".format (originalBill) + "\ntax amount: {0}".format(taxAmount)+"\ntip amount: {0}".format(tipAmount)+ "\ntotal bill: {0}".format(totalAmount))

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()