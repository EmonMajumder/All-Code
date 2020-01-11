#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Highest Common Divisor
"""

def getHighestCommonDivisor(firstNumber,secondNumber):
    HighestCommonDivisor=1
    if firstNumber>secondNumber:
        for number in range(1,secondNumber+1):
            if secondNumber%number==0:
                if firstNumber%number==0:
                    HighestCommonDivisor=number
    else:
        for number in range(1,firstNumber+1):
            if secondNumber%number==0:
                if firstNumber%number==0:
                    HighestCommonDivisor=number
    return (HighestCommonDivisor)

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    x=0
    while x==0:
        m=0
        while m==0:
            firstNumber=input("Enter the first number: ")
            try:
                firstNumber=int(firstNumber)
                if firstNumber!=0:
                    break
                else:
                    print("'0' is an invalid input. please try again.")
            except:
                print("Invalid input. please try again.")
        while m==0:
            secondNumber=input("Enter the second number: ")
            try:
                secondNumber=int(secondNumber)
                if secondNumber!=0:
                    break
                else:
                    print("'0' is an invalid input. please try again.")
            except:
                print("Invalid input. please try again.")
        HighestCommonDivisor=getHighestCommonDivisor(firstNumber,secondNumber)
        print("The Highest common divisor of {0} and {1} is {2}".format(firstNumber,secondNumber,HighestCommonDivisor))
        y=0
        while y==0:
            nextTry=input("What to try more numbers? (Y/N): ").lower()
            if nextTry=="y" or nextTry=="yes":
                y=1
            elif nextTry=="n" or nextTry=="no":
                x=1
                y=1
            else:
                print("Input not recognized. Please enter yes (Y) or no (N) only") 

    
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()