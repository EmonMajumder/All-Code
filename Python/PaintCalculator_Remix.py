#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: PaintCalculator_Remix
"""
#Paint Shop Calculator
#Program to calculate the number of gallons of paint required to paint a room, if provided the room dimensions

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!


#Import the math class, for using ceiling rounding
    import math

#Declare variable for # of sq. ft. covered by one gallon of paint
    square_feet_per_gallon = 150.0

#Intro messages
    print("Welcome to the Paint Shop!")
    print("This program will help you calculate how many cans of paint you need to buy, based on the dimensions of your room.")

#INPUT
#Get Dimensions of the room
    length = float(input("\nEnter the length of the room, in feet: "))
    width = float(input("Enter the width of the room, in feet: "))
    height = float(input("Enter the height of the room, in feet: "))

#PROCESSING
#Calculate the area of the walls
#Divide the area by 150 square feet and
#round number of gallons up to the nearest whole number
    def gallons_of_paint (length, height, width): 
        totalArea = 2*height*(length+width)
        gallons_of_paint = math.ceil(totalArea / square_feet_per_gallon)
        print("\nThe total wall area of your room is {0} square feet.".format(totalArea))
        return gallons_of_paint

    gallons_of_paint= gallons_of_paint (length, height, width)
    
    #OUTPUT - Display number of gallons needed
    print("You will need {0} gallon(s) of paint. \n\nHappy Painting!".format(gallons_of_paint))

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()















