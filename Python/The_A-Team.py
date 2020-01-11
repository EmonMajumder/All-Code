#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: The A-Team
"""
# Pseudocode
# 1. open file in read mode.
# 2. save whole text file as string in a variable
# 3. print whole text.
# 4. open a new file in write mode to write the data from text file.
# 5. open the original file again in read mode.
# 6. count total number of lines inside the text file by calling a function.
# 7. read text from the file line by line and save as string.
# 8. convert string to list considering each letter a list member.
# 9. count members of list.
# 10. logic for printing in lower case and uppercase considering number 
# of character in the line. write the line to new file at the same time.
# 11. don't print a line for line number given by random function. w
# rite "\n" to new file at the same time.
# 12. close file opened in write mode.

import random            #To use random function.
def linecount(primaryFile,accessMode):          #this function gives total number of lines in a text file. 
    with open(primaryFile,accessMode) as secondFile:
        newText=secondFile.readline()
        totalLine=0
        while newText:
            newText=secondFile.readline()
            totalLine+=1
        return totalLine

def main(): #<-- Don't change this line!
    #Write your code below. It must be indented!
    #1. input from user for file name- ateam_Original.txt
    #primaryFile=input("File Name: ")[This line is to make the code 
    #flexible for future use to ask user for file name]
    primaryFile="ateam_Original.txt"
    #fileDirectory=input("File path: ")[This line is to make the 
    #code flexible for future use to ask user for file directory path if not hard coded]
    #fileDirectory="I:\\Study Material\\Programming\\w0411567-MajumderE\\"
    #primaryFile=fileDirectory+primaryFile
    #accessMode=input("Access Mode: ").lower() #Access Mode: r (to read file)
    accessMode="r"
    secondaryFile=open(primaryFile,accessMode)
    originalText=secondaryFile.read()
    print("----------------------------\nOriginal Text:\n----------------------------")
    print (originalText)
    #------------------------------------------------------------------------
    #Alternative way to print the original text using a 2D list
    #------------------------------------------------------------------------
    # originalTextwordlist=[]
    # originalTextsentencelist=originalText.split("\n")
    # for sentence in originalTextsentencelist:
    #     wordlist=sentence.split(" ")
    #     originalTextwordlist.append(wordlist)
    # for sentence in originalTextwordlist:
    #     for word in sentence:
    #         print(word+" ",end="")
    #     print("")
    #-------------------------------------------------------------------------
    secondaryFile.close()  #close file after session is over for future use.

    print("\n----------------------------\nAltered Text:\n----------------------------")
    #saveas=input("Full path to save the new file: ")
    saveas="ateam_altered.txt"
    newaccessMode="w" 
    savealteredText=open(saveas,newaccessMode)
    totalLine=linecount(primaryFile,accessMode)         #Caling a function that 
                                                        #calculate the total number of line inside the text file.
    with open(primaryFile,accessMode) as secondaryFile:    #It auto close the file after use.
        alteredText=secondaryFile.readline()
        limitUppercase=20
        limitLowercase=20
        lineNumber=1
        omitedlineNumber=random.randint(1,totalLine)    #randint gives random integer.
        while alteredText:
            charactercount=list(alteredText)
            if len(charactercount)>limitLowercase:
                alteredText=alteredText.lower()
            elif len(charactercount)<=limitUppercase:
                alteredText=alteredText.upper()
            if lineNumber==omitedlineNumber:
                print("")
                savealteredText.write("\n")
            else:           
                print ("{0}: {1}".format(lineNumber,alteredText),end="")
                savealteredText.write("{0}: {1}".format(lineNumber,alteredText))
            alteredText=secondaryFile.readline()
            lineNumber+=1
    savealteredText.close()        

    #Your code ends on the line above

#Do not change any of the code below!
if __name__ == "__main__":
    main()