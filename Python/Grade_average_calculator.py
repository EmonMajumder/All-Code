############################################
#Grade_average_calculator- Tech Check 4
############################################

#FUNCTION
def main():

    print("Grade Point Average Calculator\n")
    print("Valid letter grades that can be entered: A, B, C, D, F.")
    print("Valid grade modifiers are +, - or nothing.")
    print("All letter grades except F can include a + or - symbol.")
    print("Calculated grade point value cannot exceed 4.0.\n")

    numericGrade = 0.0

    # Determine base numeric value of the grade
    def gradepoint(letterGrade,modifier):
        if letterGrade == "A":
            numericGrade = 4.0
        elif letterGrade == "B":
            numericGrade = 3.0
        elif letterGrade == "C":
            numericGrade = 2.0
        elif letterGrade == "D":
            numericGrade = 1.0
        elif letterGrade == "F":
            numericGrade = 0.0
        else:
            #If an invalid entry is made
            print("You entered an invalid letter grade.")
        
        # Determine whether to apply a modifier
        if modifier == "+":
            if letterGrade != "A" and letterGrade != "F": # Plus is not valid on A or F
                numericGrade += 0.3
        elif modifier == "-":
            if letterGrade != "F":     # Minus is not valid on F
                numericGrade -= 0.3
        return numericGrade

    #Gather user inputs
    def subject_grade (subject):
        letterGrade = input("\nPlease enter a letter grade for {0}: ".format(subject)).upper()
        modifier = input("Please enter a modifier (+, - or nothing) : ")
        numericGrade= gradepoint(letterGrade,modifier)
        return numericGrade

    #Call function for input and calculate numeric value

    gradepoint_PROG1700= subject_grade("PROG1700")
    gradepoint_NETW1700= subject_grade("NETW1700")
    gradepoint_OSYS1200= subject_grade("OSYS1200")
    gradepoint_WEBD1000= subject_grade("WEBD1000")
    gradepoint_COMM1700= subject_grade("COMM1700")
    gradepoint_DBAS1007= subject_grade("DBAS1007")

    # Output final message and result, with formatting
    subject="PROG1700"
    print("\n\nThe numeric value for {0} is: {1:.1f}".format(subject,gradepoint_PROG1700))
    subject="NETW1700"
    print("The numeric value for {0} is: {1:.1f}".format(subject,gradepoint_NETW1700))
    subject="OSYS1200"
    print("The numeric value for {0} is: {1:.1f}".format(subject,gradepoint_OSYS1200))
    subject="WEBD1000"
    print("The numeric value for {0} is: {1:.1f}".format(subject,gradepoint_WEBD1000))
    subject="COMM1700"
    print("The numeric value for {0} is: {1:.1f}".format(subject,gradepoint_COMM1700))
    subject="DBAS1007"
    print("The numeric value for {0} is: {1:.1f}".format(subject,gradepoint_DBAS1007))

    average=(gradepoint_PROG1700+gradepoint_NETW1700+gradepoint_OSYS1200+gradepoint_WEBD1000+gradepoint_COMM1700+gradepoint_DBAS1007)/6
    print("\nyour grade point average for the semester is : {0:.1f}".format(average))
        

#PROGRAM STARTS HERE
if __name__ == "__main__":
    main()