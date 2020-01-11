#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Battleship
"""
import csv
def main(): #<-- Don't change this line!
	#Write your code below. It must be indented!

        print("Welcome to Dungeon Attack")
        while True:
            playbutton=input("Hit any key to continue('Q' to quit): ")
            if playbutton=="Q" or playbutton=="q":
                break
            Hitpoint=input("What is your life point (1-200): ")
            try:
                initialHitpoint=int(Hitpoint)
                if initialHitpoint>=1 and initialHitpoint<=200:
                    with open("DungeonAttack.txt","r") as secondaryFile:
                        DungeonAttack=csv.reader(secondaryFile)
                        while initialHitpoint>0:                                          
                            for rows in DungeonAttack:                            
                                if initialHitpoint>0:
                                    n=0 
                                    for elements in rows:
                                        if n==0:
                                            print("you were attacked by a {0}".format(elements),end="")
                                            n+=1
                                        elif n==1:
                                            print(" with a {0} attack".format(elements),end="")
                                            n+=1
                                        else:
                                            print(" for {0} damage.".format(elements),end="")
                                            hitgot=int(elements)
                                            initialHitpoint=initialHitpoint-hitgot
                                            if initialHitpoint<0:
                                                initialHitpoint=0
                                            print(" Current Hitpoint {0}".format(initialHitpoint))
                            print("You are dead. Dead as hell !!!!!")                 
                else:
                    print("Your life is too short or too long")       
            except: 
                print("Invalid point entered for life. Give a number.")



     

	#Your code ends on the line above

		#Do not change any of the code below!
if __name__ == "__main__":
	main()