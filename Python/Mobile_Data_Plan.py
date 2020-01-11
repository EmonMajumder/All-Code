#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Mobile_Data_Plan
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!

    #Print a welcome message
    print("Welcome to Erewhon Mobile Data Plans")

    #Take input from the user
    dataUsed=int(input("\nEnter data usage (Mb) : "))

    def dataCharge (dataUsed):
        #Assign different rates to different variables
        minimum=20
        maximum=118
        upperminimumrate=0.105
        lowermaximumrate=0.110

        #Build a Logic flow chart with if, elif and else to return the total cost for data used 
        if dataUsed<=200:
            datacharge=minimum
        elif dataUsed>200 and dataUsed<=500:
            datacharge= dataUsed*upperminimumrate
        elif dataUsed>500 and dataUsed<=1024:
            datacharge= dataUsed*lowermaximumrate
        else:
            datacharge=maximum
        return datacharge

    #Call the function to calculate the data charge and assign the returned value to a variable.
    dataCharge= dataCharge (dataUsed)

    #print the final result
    print("Your total Datacharge is ${0:.2f}".format(dataCharge))
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()