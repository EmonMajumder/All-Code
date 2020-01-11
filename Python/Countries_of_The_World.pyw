#Pseudocode
#1. Start with designing the output layout in QTDesigner.
#2. Add a list widget to list country name.
#3. Add a label for country name.
#4. Add a label for flag.
#5. Add a line edit for population.
#6. Add a label for area.
#7. Add a label for population density.
#8. Add a label for world population percentage.
#9. Add a combo box to select area output in km or mile.
#10. Add 2 radio button for population density in per sq. km and sq. mile.
#11. Add a pushbutton to update any change made to population.
#12. Add a group box to hold all population density related widget.
#13. Except list widget put all other widget in a frame widget .
#14. Add Load,Save and Exit in menubar and name it as file.
#15. Load action load country name in the list widget.
#16. Save action will save any change made to the population line edit.
#17. Exit will close the program. If any change is made and not saved a 
# window pop up for confirmation if user want to save the change made.
#18. Frame is not visible at the begining of the program .
#19. After a country is selected from list widget it show informations in all related field.
#20. Calculate population density.
#21. Calculate total world population with a function.
#22. Calculate world population percentage for a country.
#23. Add functions for different widget to use. Add functions for Load and save from menubar, 
# Update population, radiobutton, combobox options.
#24. Add the functions that do the intended task for the button used.
#25. Add any related helper function to accomplish the task.

import sys

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox
from PyQt5 import QtGui

#ADD IMPORT STATEMENT FOR YOUR GENERATED UI.PY FILE HERE
import Ui_Countries_of_The_World
#      ^^^^^^^^^^^ Change this!

#CHANGE THE SECOND PARAMETER (Ui_ChangeMe) TO MATCH YOUR GENERATED UI.PY FILE
class MyForm(QMainWindow, Ui_Countries_of_The_World.Ui_MainWindow):
#                         ^^^^^^^^^^^  Change this!

    #a Globally scoped 2d list for countries,population and area
    CountryList = []
    unsavedChanges = False
    Areaunittype = 0
    Densityunittype = "mile"

    # DO NOT MODIFY THIS CODE
    def __init__(self, parent=None):
        super(MyForm, self).__init__(parent)
        self.setupUi(self)
    # END DO NOT MODIFY

        # ADD SLOTS HERE, indented to this level (ie. inside def __init__)

        #Hide all the informaton detail at the begining of the program by hiding the frame containing them
        self.FrameShowDetails.hide()

        #User click Load from the File dropdown to load name of countries
        self.actionLoad.triggered.connect(self.LoadAction_Triggered)

        #User click Save from the File dropdown to save changes made to the original file
        self.actionSave.triggered.connect(self.SaveAction_Triggered)

        #User click Exit from the File dropdown to exit from the program
        self.actionExit.triggered.connect(self.ExitAction_Triggered) 

        #User can select an option from list in list widget
        self.listCountry_List.currentRowChanged.connect(self.List_RowChanged)

        #User select options from combobox total area section
        self.comboAreaUnit.currentIndexChanged.connect(self.combo_IndexChanged)

        #User select sq. mile option through radio button from group box for population density
        self.radioSquareMile.clicked.connect(self.SquareMileRadioButton_Clicked)

        #User select sq. km options through radio button from group box for population density
        self.radioSquarekm.clicked.connect(self.SquarekmRadioButton_Clicked)

        #User change population in linr edit box and click update popilation push buttton
        self.pushButtonUpdatePopulation.clicked.connect(self.UpdatePopulationPushButton_Clicked)

        

    # ADD SLOT FUNCTIONS HERE
    # These are the functions your slots will point to
    # Indent to this level (ie. inside the class, at same level as def __init__)
    def LoadAction_Triggered(self):
        self.LoadDataFromFile()
        self.LoadDataIntoListWidget()

    #currentRowChanged signal from the list passes the index of the selected row as a parameter
    def List_RowChanged(self, ListIndex):

        #Show the frame that contain all the information boxes on the right of the list widget
        self.FrameShowDetails.show() 
	
        #After user selected a country, display country name, flag, population, area, Density and world population percentage for the selected item
        Name = self.CountryList[ListIndex][0]
        Population = self.CountryList[ListIndex][1]
        Area = self.CountryList[ListIndex][2]        

		#Set values in related field box
        self.labelCountryName.setText(Name)
        self.lineEditCountryPopulation.setText(Population)
        self.comboAreaUnit.setCurrentIndex(self.Areaunittype)
        self.combo_IndexChanged(self.Areaunittype)
        self.densityunitpreference()
        self.showCountryflag(Name)
        self.populationPercentage()
        self.changePopulationDensity()
    
    #currentIndexChanged signal from the combo passes the index of the selected row as a parameter.
    def combo_IndexChanged(self, ComboIndex):
        selectedCountryindex=self.listCountry_List.currentRow()
        Area=self.CountryList[selectedCountryindex][2]
        if ComboIndex==0:
            self.labelCountryArea.setText(Area)
            self.Areaunittype = 0
        elif ComboIndex==1:
            Miletokm=2.59
            Area=float(Area)*Miletokm
            self.labelCountryArea.setText("{0:.2f}".format(Area))
            self.Areaunittype = 1

    def densityunitpreference(self):
        if self.Densityunittype == "mile":
            self.radioSquareMile.setChecked(True)
            self.SquareMileRadioButton_Clicked()
        elif self.Densityunittype == "km":
            self.radioSquarekm.setChecked(True)
            self.SquarekmRadioButton_Clicked()
    #Function that is effective when radio button for area in sq. mile is clicked.
    def SquareMileRadioButton_Clicked(self):
        Miletokm=1
        #Call the function that set text in population density window.
        self.setPopulationDensity(Miletokm)
        self.Densityunittype="mile"

    #Function that is effective when radio button for area in sq. km is clicked.
    def SquarekmRadioButton_Clicked(self):
        #1 square mile=2.59 Square km
        Miletokm=2.59
        ##Call the function that set text in population density window.
        self.setPopulationDensity(Miletokm)
        self.Densityunittype="km"

    def UpdatePopulationPushButton_Clicked(self):
        try:
            p=int(self.lineEditCountryPopulation.text())
            self.saveinMemory()
            self.changePopulationDensity()
            self.populationPercentage()
            QMessageBox.information(self, "Save",
                                          "Successfully saved changes in memory.",
                                           QMessageBox.Ok)   
        except:
            selectedCountryindex=self.listCountry_List.currentRow()
            Population = self.CountryList[selectedCountryindex][1]
            self.lineEditCountryPopulation.setText(Population)
            QMessageBox.information(self, "Error!",
                                          "The changes you made seems is not valid. Please check.\nOperation not completed.",
                                           QMessageBox.Ok)

    def SaveAction_Triggered(self):
        #Pop up messag box when user select save from menu bar 
        reply = QMessageBox.question(self, "Countries of The World - Save file?","Do you Really want to save the changes you made?",QMessageBox.Yes, QMessageBox.No)
        
        if reply == QMessageBox.Yes:
            #Call function to save changes in original file
            self.SavetoOriginalFile()

    def ExitAction_Triggered(self, event):
        #This code closes all window in GUI
        #This triggers the "closeEvent", which is captured in the function below.
        QApplication.closeAllWindows()      

#Example Slot Function
#   def SaveButton_Clicked(self):
#       Make a call to the Save() helper function here

    #ADD HELPER FUNCTIONS HERE
    # These are the functions the slot functions will call, to 
    # contain the custom code that you'll write to make your progam work.
    # Indent to this level (ie. inside the class, at same level as def __init__)
    def LoadDataFromFile(self):
		#Standard csv-reading code
        import csv

        #If program file and required file are in different location 
        #fileDirectory= ""
        fileName = "countries.txt"

        #If program file and required file are in different location 
        #fileName=fileDirectory+fileName 
        accessMode = "r"

    	#Clear all items from the list in memory, so it will be empty every time file is loaded
		#It will prevents duplication of item in the list    
        self.CountryList.clear()

        #open the file and read it's contents into program and save in the list
        with open(fileName, accessMode) as fileRequired:
            countryData = csv.reader(fileRequired) 
            
            #Write data from test file to the 2d list
			#Go through each row in the text file and add them to CountryList as items
            count=1
            for rows in countryData:
                #A list for checking data
                checdatalist=[]
                try:
                    checdatalist.append(rows)
                    checkdata=int(checdatalist[0][1])
                    checkdata=float(checdatalist[0][2])
                    self.CountryList.append(rows)
                    count+=1
                except:
                    #If there is any eror in data except block will run, 
                    #and show this "Error" message on screen.
                    QMessageBox.information(self, "Error!",
                                          "There is an error in data File. Check row for "+checdatalist[0][0]+" for error.",
                                           QMessageBox.Ok)
                    QApplication.closeAllWindows()

    #Take data from the CountryList and show the names on the onscreen in listwidget
    def LoadDataIntoListWidget(self):
		#Clear items from the list widget, so it will be empty every time new item is loaded
		#from the CountryList. This will prevent duplication.
        self.listCountry_List.clear()

        #For every list item in CountryList, country name will be shown on screen
        for countryRows in self.CountryList:
            self.listCountry_List.addItem(countryRows[0])

    #Function that calculate total population. 
    def Worldpopulation(self):
        totalpopulation=0
        for allrows in self.CountryList:
            totalpopulation=totalpopulation+int(allrows[1])
        return totalpopulation

    def populationPercentage(self):
        totalWorldpopulation=self.Worldpopulation()
        Population=int(self.lineEditCountryPopulation.text())
        Percentage=(Population/totalWorldpopulation)*100

        if Percentage>=0.1:
            self.labelPercentage.setText("{0:.2f}%".format(Percentage))
        elif Percentage>=.01:
            self.labelPercentage.setText("{0:.3f}%".format(Percentage))
        elif Percentage>=.001:
            self.labelPercentage.setText("{0:.4f}%".format(Percentage))
        elif Percentage>=.0001:
            self.labelPercentage.setText("{0:.5f}%".format(Percentage))
        elif Percentage>=.00001:
            self.labelPercentage.setText("{0:.6f}%".format(Percentage))
        else:
            self.labelPercentage.setText("{0:.8f}%".format(Percentage))

    def showCountryflag(self, Name):
        try:
            self.labelCountryFlag.setPixmap(QtGui.QPixmap(self.fileImagelocation(Name)))
        except:
            QMessageBox.information(self, "File location Error!",
                        "Could not find Image file for flag of "+Name ,
                        QMessageBox.Ok)
    
    #Function that connect option selected and it's relevant image file
    def fileImagelocation(self, Name):
        #Image Directory is subject to change based on the location of folder for flags image.
        imageDirectory="Flags/"
        Imagenamelist=[]
        Imagenamelist=list(Name)
        for lettercount in range(len(Imagenamelist)):
            if Imagenamelist[lettercount]==" ":
                Imagenamelist[lettercount]="_"
        Imagename="".join(Imagenamelist)
        fileType=".png"
        imageLocation=imageDirectory+Imagename+fileType
        return imageLocation

    def saveinMemory(self):
        #Get edited user input (changed population)
        Population=self.lineEditCountryPopulation.text()

        #Get the current row's index
        selectedCountryindex=self.listCountry_List.currentRow()

        #Put the value into the memory list if value changed
        if self.CountryList[selectedCountryindex][1] != Population:
            self.CountryList[selectedCountryindex][1] = Population
            self.unsavedChanges = True

    def changePopulationDensity(self):
        if self.radioSquareMile.isChecked()==True:
            self.SquareMileRadioButton_Clicked()
        elif self.radioSquarekm.isChecked()==True:
            self.SquarekmRadioButton_Clicked()

    def SavetoOriginalFile(self):
        try:
            #Standard csv-reading code
            import csv

            #If program file and required file are in different location 
            #fileDirectory= ""
            fileName = "countries.txt"

            #If program file and required file are in different location 
            #fileName=fileDirectory+fileName
            accessMode = "w"

            #open the file and read it's contents into program and save in the list
            with open(fileName, accessMode) as fileRequired:            
                #Write data from test file to the 2d list
                for newrows in self.CountryList:
                    fileRequired.write(",".join(newrows)+"\n")
            
            #If user saved the file
            self.unsavedChanges = False

        except:
            #If any error occur during saving the changes except block will run, 
            #and show this "Error" message on screen.
            QMessageBox.information(self, "Error!",
                                          "An error occurred during saving the File. Could not complete saving.",
                                           QMessageBox.Ok)

    def closeEvent(self, event):
        #This check if the user has made any changes to data and have not saved. 
        # If so, a question messagebox pop up to let them decide.
        if self.unsavedChanges == True:
            reply = QMessageBox.question(self, "Countries of The World - Save file?", \
                                               "You did not save the changes you made.\nDo you want to save now?", \
                                               QMessageBox.Yes, QMessageBox.No)
            #If user want to save
            if reply == QMessageBox.Yes:
                self.unsavedChanges = False
                self.SavetoOriginalFile()

    def setPopulationDensity(self, Miletokm):
        selectedCountryindex=self.listCountry_List.currentRow()
        Area=float(self.CountryList[selectedCountryindex][2])*Miletokm
        try:
            Population=int(self.lineEditCountryPopulation.text())
            Density=Population/Area
            if Density>100:
                Density=str(round(Population/Area))
                self.labelCountryPopulationDensity.setText(Density)
            else:
                self.labelCountryPopulationDensity.setText("{0:.2f}".format(Density))
        except:
            QMessageBox.information(self, "Error!",
                                "Invalid changes in population.",
                                QMessageBox.Ok)

#Example Helper Function
#    def Save(self):
#       Implement the save functionality here

# DO NOT MODIFY THIS CODE
if __name__ == "__main__":
    app = QApplication(sys.argv)
    the_form = MyForm()
    the_form.show()
    sys.exit(app.exec_())
# END DO NOT MODIFY