#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Auto_Insurance
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!

    #Function that determine the insurance rate if the user is a male
    def insurance_Male (age):

        #pre-assigned value for insurance rate for different age range
        above15M=25
        above25M=17
        above40M=10

        #determine insurance rate based on  age range of user.
        if age>=15 and age<25:
            insuranceRate=above15M
        elif age>=25 and age<40:
            insuranceRate=above25M
        elif age>=40 and age<70:
            insuranceRate=above40M
        return insuranceRate

    #Function that determine the insurance rate if the user is a female
    def insurance_Female (age):
        #pre-assigned value for insurance rate for different age range
        above15F=20
        above25F=15
        above40F=10
        
        #determine insurance rate based on  age range of user.
        if age>=15 and age<25:
            insuranceRate=above15F
        elif age>=25 and age<40:
            insuranceRate=above25F
        elif age>=40 and age<70:
            insuranceRate=above40F
        return insuranceRate

    #function that calculate monthly insurance by determining insurance rate by determining 
    #if the user is male or female and calling the appropiate function
    def monthlyInsurance (gender,age,vehiclepurchasePrice):
        if gender=="M" or gender=="MALE":
            insuranceRate=insurance_Male(age)
        elif gender=="F" or gender=="FEMALE":
            insuranceRate=insurance_Female(age)
        monthlyInsurance=vehiclepurchasePrice*insuranceRate/(100*12)
        return monthlyInsurance
    
    
    #Ask user for gender.
    gender=input("Enter yout gender (M/F): ").upper()

    #Check the input from the user.
    if gender=="M" or gender=="MALE" or gender=="F" or gender=="FEMALE":

        #if input for gender is correct ask user for his/her age
        age=int(input("Your age?: "))

        #Check if the user has valid age to be eligible for the insurance
        if age>=15 and age<70:
            #if user has valid age ask for vehicle price.
            vehiclepurchasePrice=float(input("Enter the purchase price of the vehicle: $"))
            #Calculate monthly insurance
            monthlyInsurance= monthlyInsurance (gender,age,vehiclepurchasePrice)
            print("Your monthly insurance will be: ${0:.2f}".format(monthlyInsurance))
        else:
            #if user's age if not within eligible age range
            print("You are not eligible as per our insurance policy")
    else:
        #When input by user for gender is not correct.
        print("Your input for gender is incorrect. Please try again with correction.")

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()