#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Hogwarts Sorting hat
"""
import random
def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    print("Welcome to Hogwarts")

    yourNumber= random.randint(1,4)

    if yourNumber==1:
        print("\nyou belong to Gryffindor!!")
    elif yourNumber==2:
        print("\nyou belong to Hufflepuff!!")
    elif yourNumber==2:
        print("\nyou belong to Ravenclaw!!")
    else:
        print("\nyou belong to Slytherin!!")

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()