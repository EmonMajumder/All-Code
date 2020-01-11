#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: The_Itsy_Bitsy_Aardvark
"""
import csv
def choiceletter(optionCounter):                #[This function counts the number of options 
                                                #availabe to the user to choose from.]
    alphabetList=["a","b","c","d","e","f","g","h","i","j","k","l",
    "m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    choiceLetter=alphabetList[optionCounter]
    return choiceLetter
def alphabets(position):                        #Function to check user input.
    alphabetList=["a","b","c","d","e","f","g","h","i","j","k","l",
    "m","n","o","p","q","r","s","t","u","v","w","x","y","z"]
    alphabetSelected=alphabetList[position]
    return alphabetSelected

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    print("\n-----The Itsy Bitsy Aardvark-----")
    
    #1. input from user for file name- The_Itsy_Bitsy_Aardvark.csv
    #primaryFile=input("File Name: ")[This line is to make the code 
    #flexible for future use to ask user for file name]
    primaryfileChoice="the_choices_file.csv"
    #fileDirectory=input("File path: ")[This line is to make the 
    #code flexible for future use to ask user for file directory path if not hard coded]
    #fileDirectory="I:\\Study Material\\Programming\\w0411567-MajumderE\\"
    #primaryfileChoice=fileDirectory+primaryfileChoice
    #accessMode=input("Access Mode: ").lower() #Access Mode: r (to read file)
    accessMode="r"
    chosenwords=[]
    with open(primaryfileChoice,accessMode) as secondaryFile: #File closes when 'with' function is over.
        wordChoiceList=csv.reader(secondaryFile)
        for row in wordChoiceList:
            print("\nPlease choose ",end="")
            optionCounter=-1
            for choices in row:
                if optionCounter==-1:
                    print (choices)
                    optionCounter+=1
                else:
                    choiceLetter=choiceletter(optionCounter)   
                    print("\t\t\t"+choiceLetter+") "+choices)   #Print options choices for user to choose.
                    optionCounter+=1
            whileterminator=0
            while whileterminator==0:
                wordchosen=input("Word chosen (a-{0}): ".format(choiceLetter))
                for letters in range(optionCounter):
                    if wordchosen.lower()==alphabets(letters):
                        chosenwords.append(row[letters+1])      #Create a list of words that has been chosen 
                                                                #by the user.
                        whileterminator+=1
                        break
                if whileterminator==0:
                    print("Invalid input. Please choose single letter only.")
        print("")
        
    primaryfileStory="the_story_file.txt"
    #filedirectoryStory=input("File path: ")[This line is to make the 
    #code flexible for future use to ask user for file directory path if not hard coded]
    #filedirectoryStory="I:\\Study Material\\Programming\\w0411567-MajumderE\\"
    #primaryfileChoice=filedirectoryStory+primaryfileStory
    #accessMode=input("Access Mode: ").lower() #Access Mode: r (to read file)
    accessmode="r"
    with open(primaryfileStory,accessmode) as secondaryfileStory:
        storywithblanks=secondaryfileStory.readline()
        outputfile="The_Itsy_Bitsy_Aardvark.txt"
        with open(outputfile,"w") as outputfilesave:
            while storywithblanks:
                storywithblankslist=storywithblanks.split()  #Convert the whole read text file from string to 
                                                             #list based on words. Each word from string 
                                                             #becomes a element of the list..
                for x in range(len(storywithblankslist)):
                    wordsList=list(storywithblankslist[x])   #Each word is converted to list of letters.
                    if wordsList[0]=="_":
                        replacewordnumber=int(wordsList[1])
                        storywithblankslist[x]=chosenwords[replacewordnumber-1].upper()  #Replace words chosen by user to the blanks. 
                storywithblanks=secondaryfileStory.readline()    
                finalstory=" ".join(storywithblankslist)      #A new string with chosen words in blank spaces. 
                print(finalstory)                             #Print the story on the screen with chosen words in blanks. 
                outputfilesave.write(finalstory+"\n")         #write the story to a new file with the words no blanks.

    #Your code ends on the line above
#Do not change any of the code below!
if __name__ == "__main__":
    main()