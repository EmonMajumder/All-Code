#Don't forget to rename this file after copying the template
#for a new program!
"""
Student Name: Emon Majumder  
Program Title: IT Programming  
Description: Decimal_To_Roman.py
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!

    decimalNumber=int(input("Give your number: "))
    romanNumber=[]
    while decimalNumber>0:
        if decimalNumber>=1000:
            romanNumber.append("M")
            decimalNumber=decimalNumber-1000
        elif decimalNumber>=900:
            romanNumber.append("CM")
            decimalNumber=decimalNumber-900
        elif decimalNumber>=500:
            romanNumber.append("D")
            decimalNumber=decimalNumber-500
        elif decimalNumber>=400:
            romanNumber.append("CD")
            decimalNumber=decimalNumber-400            
        elif decimalNumber>=100:
            romanNumber.append("C")
            decimalNumber=decimalNumber-100
        elif decimalNumber>=90:
            romanNumber.append("XC")
            decimalNumber=decimalNumber-90        
        elif decimalNumber>=50:
            romanNumber.append("L")
            decimalNumber=decimalNumber-50
        elif decimalNumber>=40:
            romanNumber.append("XL")
            decimalNumber=decimalNumber-40        
        elif decimalNumber>=10:
            romanNumber.append("X")
            decimalNumber=decimalNumber-10
        elif decimalNumber==9:
            romanNumber.append("IX")
            decimalNumber=decimalNumber-9            
        elif decimalNumber>=5:
            romanNumber.append("V")
            decimalNumber=decimalNumber-5
        elif decimalNumber>=1:
            romanNumber.append("I")
            decimalNumber=decimalNumber-1  
    finalromanNumber="".join(romanNumber)
    print(finalromanNumber)

    #Your code ends on the line above
#Do not change any of the code below!
if __name__ == "__main__":
    main()    
