#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Auto_Insurance
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!print("Welcome to Emon's Landscape Care\n")

    print("Welcome to Landscape Calculator\n")
    houseNumber=input("Enter your House Number \t\t:")

    #Fuction that calculate the total cost.
    def totalCost (houseNumber):

        #Take input from the user for House Number, property length and width, grass type and number of trees.
        propertyLength=float(input("Enter the length of the House (feet) \t:"))
        propertyWidth=float(input("Enter the width of the House (feet) \t:"))
        grassType=input("Type of grass (fescue/bentgrass/campus)\t:").lower()
        numberofTrees= int(input("Enter the number of trees \t\t:"))

        #previously assigned values for base charge, rate for tree
        baseCharge=1000
        treeRate=100

        #calculate total area
        propertyArea= propertyLength*propertyWidth

        #Function that determine additional fee needed.
        def addlFee (propertyArea):
            addlFeelimit=5000
            overlimitFee=500
            if propertyArea>addlFeelimit:
                addlFee=overlimitFee
            else:
                addlFee=0
            return addlFee

        #function that determine grass cut rate.
        def grassRate (grassType):
            fescueRate=0.05
            bentgrassRate=0.02
            campusrate=0.01
            if grassType=="campus":
                grassRate=campusrate
            elif grassType=="bentgrass":
                grassRate=bentgrassRate
            elif grassType=="fescue":
                grassRate=fescueRate
            return grassRate

        #Call for a function for value for additional fee depending on property area.
        addlFee= addlFee (propertyArea)

        #Call for a function for value for grass cut rate depending on grass type.
        grassRate=grassRate (grassType)

        #calculate total cost for landscaping with input provided by user.
        totalCost=baseCharge+addlFee+propertyArea*grassRate+numberofTrees*treeRate

        #print total cost and house number
        print("\nTotal cost for your house {0} is \t:${1:.2f}".format(houseNumber,totalCost))
        return totalCost

    #Totalcost calls for a function named totalCost which actually calculate total cost.
    totalCost= totalCost (houseNumber)
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()