#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Message Redaction
"""
#This function ask user for input and check if user followed proper way to input at the same time .
def redactChecker ():
    while 1<2:
        k=0
        letterstoredact=input("\nType a comma-separated list of letters to redact:")
        letterstoredact=list(letterstoredact)#Input string is converted to list.
        for a in range(len(letterstoredact)):#len(letterstoredact) determines element number in list.
            if a%2==1: #check for ',' at even positions.
                if letterstoredact[a]!=",":
                    k+=1
        if k>0:
            print("Incorrect input. Please try again")
        else:
            break
    return(letterstoredact)
    
def messageReduct (enteredSetence,letterstoredact):
    numlettersReducted=0
    for i in range(0,len(letterstoredact),2): #Start checking  with first letter from letterstoredact list and check with letter at even positions.
        for j in range(len(enteredSetence)):
            if enteredSetence[j].lower()==letterstoredact[i].lower():
                enteredSetence[j]="_" # Replace matched value in sentence with '_'
                numlettersReducted+=1 #Counts letter replaced.
    enteredSetence=''.join(enteredSetence) #Convert list to string.
    print("\nNumbers of letters redacted:",numlettersReducted)
    return(enteredSetence)

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    #This while loop is for asking user for input continuously. 
    while 1<2:
        enteredSetence=input("Type your sentence (or quit to exit program): ")#User enter the sentence.
        if enteredSetence.lower()== "quit": #If user input "quit" is upper, lower or mix case program ends. 
            break
        enteredSetence=list(enteredSetence) #Input string is converted to list.
        letterstoredact=redactChecker()#Function call for input from contractor for letters to remove.
        print("Redacted phrase: "+messageReduct(enteredSetence,letterstoredact))#Print final result.
        print("")

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()