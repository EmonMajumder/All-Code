#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Time Sheet
"""
# Pseudocode
# 1. Take values for hourd for 5 days from user.
# 2. Verify input from user for datatype.
# 3. Build function for verified input from user.
# 4. Build function for finding days highest hour worked.
# 5. Find total hour.
# 6. Find average hour.
# 7. Find days slacked.

def workHourslist(workDays,workHours):          #Function for datatyoe verified input from user
    for counter in range(workDays):
        while 1<2:
            hours = input("Enter hours worked on Day #{0}: ".format(counter+1))
            try:                                #Check if the user input can be converted to 'int'
                hours=int(hours)
                if hours<=24:
                    workHours.append(hours)
                    break                       #If input is a integer and less than 24 hour while loop ends.
                else:
                    print("You can not work more than 24 hours. Please give valid input")                                   
            except:
                print("Please enter a numeric value")
    return(workHours)
                                                
def highestHourgiver (workHours):               #Function that gives days for highest hours.
    highestHour=max(workHours)                  #Find max value in the list.
    print("\nThe most hours worked was on:")
    x=0
    for i in range(len(workHours)):
        if workHours[i]==highestHour:
            if x!=0:
                print(", ",end="")              #'end' stops next print command to start a new line. 'end' Commad is for printing different print command in the same line.
            x+=1
            print("Day #{0}".format(i+1),end="")
    print(" when you worked {0} hours".format(highestHour))

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    workHours=[]
    workDays=5
    insufficientHour=7
    workHours=workHourslist(workDays,workHours)
    highestHourgiver(workHours)
    totalHours=sum(workHours)                   #Calculate summation of all list elements.
    averageHours=totalHours/len(workHours)      #Calculate average. 'len' determine number of element in alist.
    print("\nTotal number of hours you worked was:",totalHours)
    print("The average number of hours worked each day was: {0:.2f}".format(averageHours))
    print("\nDays you slacked off (i.e. worked less than 7 hours):")
    for j in range(workDays):
        if workHours[j]<insufficientHour:
            print("Day #",j+1,":",workHours[j],"hours")

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()