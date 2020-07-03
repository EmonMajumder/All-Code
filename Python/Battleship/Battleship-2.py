#Don't forget to rename this file after copying the template for a new program!
"""
Student Name: Emon Majumder
Program Title: IT Programming
Description: Battleship
"""
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
	baseFile="map-2.txt"
	#fileDirectory=input("File path: ")[This line is to make the 
	#code flexible for future use to ask user for file directory path if not hard coded]
	#fileDirectory="I:\\Study Material\\Programming\\w0411567-MajumderE\\"
	#primaryfileChoice=fileDirectory+primaryfileChoice
	#accessMode=input("Access Mode: ").lower() #Access Mode: r (to read file)
	accessMode="r"
	Columns=[" ","A","B","C","D","E","F","G","H","I","J"]
	Rows=[1,2,3,4,5,6,7,8,9,10]
	gameFinallayout="gameFinallayout.txt"
	gameFinallayoutforgame="gameFinallayoutforgame.txt"
	print("BATTLESHIP: The Rise of a Destroyer")
	missileCount=30
	numberofShip=5
	hitCount=0
	q=0
	print("You have {0} missiles to sink all {1} ships".format(missileCount,numberofShip))
	print("[Type 'rule' to know about game rules]")
	with open (gameFinallayout,"w") as finalLayout:
		layoutFirstrow=" ".join(Columns)
		finalLayout.write(layoutFirstrow)
		with open(baseFile,accessMode) as secondaryFile:
			gamelayout=csv.reader(secondaryFile)
			for number in Rows:
				for row in gamelayout:
					finalLayout.write("\n"+str(number)+" "+" ".join(row))
					break

	with open(gameFinallayout,accessMode) as secondaryFile:
		n=0
		gamelayout=secondaryFile.readline()
		while gamelayout:
			gamelayoutList=list(gamelayout)
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

	with open (gameFinallayoutforgame,"w") as finalLayout:
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
		for lines in gamelayout:
			gamelayoutList.append(lines)

		u="u"
		firstship=targetcounter(gamelayoutList,u)
		v="v"
		secondship=targetcounter(gamelayoutList,v)		
		w="w"
		thirdship=targetcounter(gamelayoutList,w)
		y="y"
		fourthship=targetcounter(gamelayoutList,y)
		z="z"
		fifthship=targetcounter(gamelayoutList,z)

		targetPointcounter=firstship+secondship+thirdship+fourthship+fifthship

		while targetPointcounter>hitCount and missileCount>0:
			positionChooselist=[]
			positionChoose=input("Choose your target position: ")
			if positionChoose.lower()=="rule":
				print("-------Game rules-------\nSink all 5 ships to win the game.\nEnter co-ordinate to hit the target.\nSelect from A-J for x co-ordinate and 1-10 for y co-ordinate.\nPut 2 co-ordinate together")
			else:
				positionChooselist=list(positionChoose)
				if len(positionChooselist)==2 or len(positionChooselist)==3:
					try:
						x_position=Columns.index(positionChooselist[0].upper())
						numberedpositionlist=[]
						for digit in range(1,len(positionChooselist)):
							numberedpositionlist.append(positionChooselist[digit])
						numberedposition="".join(numberedpositionlist)				
						y_position=int(numberedposition)
						if y_position>=1 and y_position<=10:
							if gamelayoutList[y_position][x_position]=="u":
								print("!!!* HIT *!!!")
								gamelayoutList[y_position][x_position]="X"
								firstship-=1
								hitCount+=1
								if firstship==0:
									q+=1
									print("{0} ship down".format(q))
							elif gamelayoutList[y_position][x_position]=="v":
								print("!!!* HIT *!!!")
								gamelayoutList[y_position][x_position]="X"
								secondship-=1
								hitCount+=1
								if secondship==0:
									q+=1
									print("{0} ship down".format(q))
							elif gamelayoutList[y_position][x_position]=="w":
								print("!!!* HIT *!!!")
								gamelayoutList[y_position][x_position]="X"
								thirdship-=1
								hitCount+=1
								if thirdship==0:
									q+=1
									print("{0} ship down".format(q))							
							elif gamelayoutList[y_position][x_position]=="y":
								print("!!!* HIT *!!!")
								gamelayoutList[y_position][x_position]="X"
								fourthship-=1
								hitCount+=1
								if fourthship==0:
									q+=1
									print("{0} ship down".format(q))
							elif gamelayoutList[y_position][x_position]=="z":
								print("!!!* HIT *!!!")
								gamelayoutList[y_position][x_position]="X"
								fifthship-=1
								hitCount+=1
								if fifthship==0:
									q+=1
									print("{0} ship down".format(q))																																	 
							elif gamelayoutList[y_position][x_position]=="X":
								print("!!!* HIT *!!!")							
							else:
								print("Miss")
								gamelayoutList[y_position][x_position]="O"
							missileCount-=1
							print("Number of Missiles remain: {0}\n".format(missileCount))
							a=0
							b=0 
							for xaxis in gamelayoutList:
								for yaxis in xaxis:
									if a==1 and b==0:
										print(yaxis,end=" ")
										b=1
									elif yaxis!="u" and yaxis!="0" and yaxis!="v" and yaxis!="w" and yaxis!="y" and yaxis!="z":
										print(yaxis,end=" ")
									else:
										print(" ",end=" ")
								a+=1
								print("")
						else:
							print("invalid entry. Try again.")
					except:
						print("invalid entry. Try again.")
				else:
					print("invalid entry. Try again.")
		print("")		
		if targetPointcounter==hitCount:
			print("Hurrah....You have won the game. All ship destroyed. You got all {0} targets.\n".format(hitCount))
		else:
			print("You did well. you got {0} targets out of {1} and got {2} ship down. Better luck next time.\n".format(hitCount,targetPointcounter,q))
			
	#Your code ends on the line above

		#Do not change any of the code below!
if __name__ == "__main__":
	main()