#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Assignment- 1 (Hipster Local)

"""
def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    #1. Print name of shop
    #2. Input customer name
    #3. Input distance
    #4. Input cost of records
    #5. Assign value for tax rate and distance
    #6. Calculate delivery cost, purchase cost with tax and total cost
    #7. Print out put
    print ("Hipster's Local Vinyl Records- Customer Invoice")
    customerName= input ("\nCustomer's Name: ")
    distance= float (input ("Distance for Delivery (in Kilometers): "))
    costofRecords= float(input ("Cost of records purchased: "))
    deliveryCharge= int (15)
    salesTax= float (0.14)
    
    deliveryCost= distance*deliveryCharge
    purchaseCost=costofRecords*salesTax+costofRecords
    totalCost= deliveryCost+purchaseCost

    print ("\nPurchase summary for "+customerName.title ())
    print("Delivery Cost: \t${0:.2f}".format(deliveryCost)+"\nPurchase Cost: \t${0:.2f}".format(purchaseCost)+"\nTotal Cost   : \t${0:.2f}".format(totalCost))
#Do not change any of the code below!
if __name__ == "__main__":
    main()