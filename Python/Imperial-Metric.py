#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Assignment- 1 (Imperial-Metric)
"""
#1. Print program name
#2. input tons, stones, pounds and ounces amount
#3. convert amount into kilos
#4. convert rest amount to grams
#5. print result

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    print ("Imperial To Metirc Conversion")

    tons= int (input("\nEnter number of tons: "))
    Stones= int (input("Enter number of stone: "))
    pounds= int (input("Enter number of pounds: "))
    ounces= float (input("Enter number of ounces: "))
    
    totalOunces= tons*35840+Stones*224+pounds*16+ounces
    totalKilos=totalOunces/35.274
    metricTon= int (totalKilos/1000)
    kilo= int (totalKilos- metricTon*1000)
    gram= float (((totalKilos-kilo-metricTon*1000)*1000))
    print ("\nThe metric weight is {0}".format(metricTon)+" metric tons, {0}".format(kilo)+" kilos, and {0:.1f}".format(gram)+ " grams")
    
     #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()