#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Girl Guide Cookie Sell-of
"""
def guideNumbertaker():                                         #Function for guide number input and datatype verification.
    while 1<2:
        guideNumber=input("Enter the number of guides: ")
        try:
            guideNumber=int(guideNumber)                        #Check if input is integer.
            break                                               #If input is a integer while loop ends.
        except:
            print("Please input a number")
    return (guideNumber)

def boxsoldList(numberofBoxessold,nameInput):
    while 1<2:
        boxesSoldinput=input("Enter number of boxes sold by {0} : ".format(nameInput))
        try:
            boxesSoldinput=int(boxesSoldinput)
            numberofBoxessold.append(boxesSoldinput)            #Check if input is integer.
            break                                               #If input is a integer while loop ends.
        except:                                                 #If input is not a integer ask user for input again.
            print("Please input a number")
    return(numberofBoxessold)

def main():#<-- Don't change this line!
    #Write your code below. It must be indented!
    guideNumber=guideNumbertaker()                              #Call function for user input.
    numberofBoxessold=[]                                        #Initiaize variable as list.
    namesofGuides=[]                                            #Initiaize variable as list.
    for i in range (guideNumber):
        nameInput=input("\nEnter the name of guide #{0} : ".format(i+1))
        namesofGuides.append(nameInput)                         #Add names to list.
        numberofBoxessold=boxsoldList(numberofBoxessold,nameInput) #Function call. List number of boxes sold.
    totalBoxessold=sum(numberofBoxessold)                       #Calculate summation of all list elements.
    averageBoxnumber=totalBoxessold/guideNumber                 #Calculate average.
    print("\nThe average number of boxes sold by each guide was {0:.2f}".format(averageBoxnumber))
    print("\nGuide\t\tPrizes Won")
    maxcookiessold=max(numberofBoxessold)                       #Find max value in the list.
    for j in range(guideNumber):                                #Check with each values for prize.
        print(namesofGuides[j]+"\t\t-",end="")
        if numberofBoxessold[j]==maxcookiessold and numberofBoxessold[j]!=0:
            print("Trip to Girl Guide Jamboree in Aruba")
        elif numberofBoxessold[j]>averageBoxnumber:
            print("Super seller Badge")
        elif numberofBoxessold[j]>=1:
            print("Left over cookies")
        else:
            print("")
            
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()