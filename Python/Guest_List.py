#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Data_to_file
"""

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    fileName=input("File Name: ")
    accessMode=input("Access Mode: ")
    myfile=open(fileName,accessMode)
    while True:
        guestName=input("Please enter your name: ")
        myfile.write(guestName+" , ")
        while True:
            guestAge=input("Please enter your age: ")
            if guestAge.isnumeric()==True:
                guestAge=int(guestAge)
                if guestAge>0 and guestAge<150:
                    myfile.write("{0}\n".format(guestAge))
                    break
                else:
                    print("Incorrect input.")
            else:
                print("Incorrect input.")
        while True:
            decision=input("Want to leave? (yes/no): ")
            if decision.lower()=="yes" or decision.lower()=="no" or decision.lower()=="y" or decision.lower()=="n" :
                break
            else:
                print("please input yes or no only")
        if decision.lower()=="yes" or decision.lower()=="y":
            myfile.close()
            break
    
    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()