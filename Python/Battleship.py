#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Battleship
"""
#Pseudocode
#A function to count number of total target.
#Make 2 list for indentifying co-ordinates of the target.
#Write a text file that combine co-ordinate identifier and basic map file.
#Write or create a csv type txt file from previous text file. 
#Print the map on screen with only Co-ordinates no target points.
#Ask user for a co-ordinate to attack ship.  
#Check user input for validation.
#Show the map with only co-ordinates hit by user. 
#Let user know if it was hit or miss.
#Keep a count for number of hits.
#Count total hit on target.
#When all target is hit end the game with user winning.
#Compare target point and hit on target for win or lose and print accordingly on screen.

import csv
def targetcounter(gamelayoutList,objecttocount):  #Function that count number of target.
	targetPointcounter=0
	j=0
	for point in gamelayoutList:
		for j in range(len(point)):
			if j>0:
				if point[j]==objecttocount:
					targetPointcounter+=1
	return targetPointcounter		

def main(): #<-- Don't change this line!
	#Write your code below. It must be indented!

	#baseFile=input("File Name: ")[This line is to make the code 
	#flexible for future use to ask user for file name]
	baseFile="map.txt"
	#fileDirectory=input("File path: ")[This line is to make the 
	#code flexible for future use to ask user for file directory path if not hard coded]
	#fileDirectory="I:\\Study Material\\Programming\\w0411567-MajumderE\\"
	#primaryfileChoice=fileDirectory+primaryfileChoice
	#accessMode=input("Access Mode: ").lower() #Access Mode: r (to read file)
	accessMode="r"
	Columns=[" ","A","B","C","D","E","F","G","H","I","J"]   #This is for marking the column.
	Rows=[1,2,3,4,5,6,7,8,9,10]								#This is for marking the rows.
	gameFinallayout="gameFinallayout.txt"					
	gameFinallayoutforgame="gameFinallayoutforgame.txt"
	gameSavefile="gameSavefile.txt"
	print("BATTLESHIP: The Rise of a Destroyer\n")
	missileCount=30											#Count the attempt that can be taken by a user.
	numberofShip=5											#Number of ships in map.
	hitCount=0
	print("You have {0} missiles to sink all {1} ships".format(missileCount,numberofShip))
	with open (gameFinallayout,"w") as finalLayout:			#Write a text file with just column and row
															#position endicator along with map co-ordinte
															#provided in map.txt file.
		layoutFirstrow=" ".join(Columns)
		finalLayout.write(layoutFirstrow)
		with open(baseFile,accessMode) as secondaryFile:	#Open the map file to read the content and 
															#then write to a new file.
			gamelayout=csv.reader(secondaryFile)
			for number in Rows: 
				for row in gamelayout:
					finalLayout.write("\n"+str(number)+" "+" ".join(row))
					break

	with open(gameFinallayout,accessMode) as secondaryFile:
		n=0
		gamelayout=secondaryFile.readline()
		while gamelayout:
			gamelayoutList=list(gamelayout)					#Convert the string from the txt file to list.
															#and print on the screen the map layout without 
															#co-ordinate.
			for position in gamelayoutList:
				if n==len(Rows):
					print(position,end="")
					n+=1
				elif n>0:
					print(position)
					break
				else:
					print(position,end="")
			n+=1
			gamelayout=secondaryFile.readline()

	with open (gameFinallayoutforgame,"w") as finalLayout:  #The string file from text is written to a 
															#new txt file that support csv file format.
															#This file is used fo the game.
		layoutFirstrow=",".join(Columns)
		finalLayout.write(layoutFirstrow)
		with open(baseFile,accessMode) as secondaryFile:
			gamelayout=csv.reader(secondaryFile)
			for number in Rows:
				for row in gamelayout:
					finalLayout.write("\n"+str(number)+","+",".join(row))
					break

	with open(gameFinallayoutforgame,accessMode) as secondaryFile:
		gamelayout=csv.reader(secondaryFile)
		gamelayoutList=[]
		for lines in gamelayout:							#The string from text based csv file is turned 
															#into a 2D-list.															#
			gamelayoutList.append(lines)
		objecttocount="1"									#counting number of target on the map.
		targetPointcounter=targetcounter(gamelayoutList,objecttocount)
		while targetPointcounter>hitCount and missileCount>0:
			positionChooselist=[]
			positionChoose=input("Choose your target position: ")
			positionChooselist=list(positionChoose)			
			if len(positionChooselist)==2 or len(positionChooselist)==3:
				try:										#Check user input for both rows and column position.
					x_position=Columns.index(positionChooselist[0].upper())
					numberedpositionlist=[]
					for digit in range(1,len(positionChooselist)):
						numberedpositionlist.append(positionChooselist[digit])
					numberedposition="".join(numberedpositionlist)				
					y_position=int(numberedposition)
					if y_position>=1 and y_position<=10:
						if gamelayoutList[y_position][x_position]=="1":
							print("!!!* HIT *!!!")
							gamelayoutList[y_position][x_position]="X"
							hitCount+=1 
						elif gamelayoutList[y_position][x_position]=="X":
							print("!!!* HIT *!!!")							
						else:
							print("Miss")
							gamelayoutList[y_position][x_position]="O"
						missileCount-=1						#Number of attempt left count.
						print("Number of Missiles remain: {0}\n".format(missileCount))
						a=0
						b=0
						for xaxis in gamelayoutList:        #Print the layout on screen with points 
															#hit by the user.
							for yaxis in xaxis:
								if a==1 and b==0:
									print(yaxis,end=" ")
									b=1
								elif yaxis!="1" and yaxis!="0":
									print(yaxis,end=" ")
								else:
									print(" ",end=" ") 
							a+=1
							print("")
					else:
						print("invalid entry. Y-coordinate out of range. Try again.")
				except:
					print("invalid entry. Try again.")
			else:
				print("invalid entry. Too many characters. Try again.")
		print("")		
		if targetPointcounter==hitCount:					#Final output on screen for win or lose. 
			print("Hurrah....You have won the game. All ship destroyed. You got all {0} targets.\n".format(hitCount))
		else:
			print("You did well. you got {0} targets out of {1}. Better luck next time.\n".format(hitCount,targetPointcounter))
			
	#Your code ends on the line above

		#Do not change any of the code below!
if __name__ == "__main__":
	main()