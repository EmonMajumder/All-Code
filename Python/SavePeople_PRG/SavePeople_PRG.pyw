import sys

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox

import Ui_SavePeople_PRG

class MyForm(QMainWindow, Ui_SavePeople_PRG.Ui_MainWindow):

    #A globally scoped 2d list
    memoryPeopleList = []                                                                  #

    #Global variable we added to track whether the user has
    #made changes to the data.
    unsavedChanges = False

    # DO NOT MODIFY THIS CODE
    def __init__(self, parent=None):
        super(MyForm, self).__init__(parent)
        self.setupUi(self)
    # END DO NOT MODIFY

        # ADD SLOTS HERE
        #Slot for the new Update button
        self.pushButtonUpdate.clicked.connect(self.UpdateButton_Clicked)                    #
        
        #User can selected an item from list
        self.listWidgetPeople.currentRowChanged.connect(self.List_RowChanged)               #

        #Slots for the three menu actions we added in the UI
        self.actionLoad_People.triggered.connect(self.LoadAction_Triggered)                 #
        self.actionSave_To_File.triggered.connect(self.SaveAction_Triggered)                #
        self.actionExit.triggered.connect(self.ExitAction_Triggered)                        #

		#Slot for button we added to show how to show/hide controls
        self.pushButtonShow.clicked.connect(self.ShowButton_Clicked)                        #

    # ADD SLOT FUNCTIONS HERE
    def ExitAction_Triggered(self, event):
        #CHANGED from in class demo
        #This code tells the whole GUI application to close
        #Note that this triggers the "closeEvent", which we
        #capture in the function below.
        QApplication.closeAllWindows()

    def SaveAction_Triggered(self):
        #Example of a "question" messagebox, which returns a value
        #representing which button (Yes/No) the user clicked
        reply = QMessageBox.question(self, "Save file?", \
                            "Do you REALLY want to save?", \
                            QMessageBox.Yes, QMessageBox.No)
        
        #Use the reply from the msgbox to determine whether or not to save
        if reply == QMessageBox.Yes:
            #Call our file save function
            self.SaveToFile()
            #Since the user just finished saving, set our changes flag to false
            self.unsavedChanges = False
        
    def UpdateButton_Clicked(self):
        #User just presumably made data changes, set our changes flag to True
        self.unsavedChanges = True

        #Call the memory save function
        self.SaveToMemory()

    def LoadAction_Triggered(self):
        self.LoadDataFromFile()
        self.LoadDataIntoListWidget()

    def List_RowChanged(self, newIndex):
		#currentRowChanged signal from the list passes the index of the selected row as a parameter
	
        #When user selects a row, display name and age in textboxes for the selected item
        name = self.memoryPeopleList[newIndex][0]
        age = self.memoryPeopleList[newIndex][1]

		#Set values in the textboxes
        self.lineEditName.setText(name)
        self.lineEditAge.setText(age)

    def ShowButton_Clicked(self):
        #Bit of "silly" functionality we added to play with show/hide
		#How to toggle visibility of the frame and change text on button
        if self.frameDetails.isVisible():
            self.frameDetails.hide()
            self.pushButtonShow.setText("Show")
        else:
            self.frameDetails.show()
            self.pushButtonShow.setText("Hide")

    #ADD HELPER FUNCTIONS HERE
    def closeEvent(self, event):
        #A function named exactly "closeEvent" will automatically be run
        #when the window is closed, whether from hitting the X or from the menu
        #It must take an event parameter
        
        #Check our changes flags to see if the user has made data
        # changes they have not saved. If so, prompt them to save using
        # a question messagebox
        if self.unsavedChanges == True:
            reply = QMessageBox.question(self, "Save file?", \
                                "There are unsaved changes, do you want to save before closing?", \
                                QMessageBox.Yes, QMessageBox.No)
            
            #If they want to save, do the save
            if reply == QMessageBox.Yes:
                self.unsavedChanges = False
                self.SaveToFile()

    def SaveToFile(self):
        
        #Good habit: Always put all file-interacting code inside a try/except
        try:
            #open the file
            with open("People.txt", "w") as fileConnect:
            #Loop through each row (name/age) and write each row to file
                for row in self.memoryPeopleList:
                    #write to file
                    fileConnect.write(",".join(row) + "\n")

            #Because it's the last line of code in a try block, this
            #msgbox will only ever run if the file code ran with no
            #errors. This popup will tell the user the save worked.
            QMessageBox.information(self, "File Saved", \
                        "Your data was saved to file successfully.", \
                        QMessageBox.Ok)
        except:
            #If an error occurred in the file code in the try block,
            #the code in this except block will run, which will
            #show this "Error" popup message.
            QMessageBox.information(self, "Error!", \
                    "Data not saved, an error occurred. (Boo hoo)", \
                    QMessageBox.Ok)          
      

    def SaveToMemory(self):
        #Get the user info (changed name/age)
        name = self.lineEditName.text()
        age = self.lineEditAge.text()

        #Get the current row's index
        selectedRowIndex = self.listWidgetPeople.currentRow()

        #Put the values into the RIGHT ROW in the memory list
        self.memoryPeopleList[selectedRowIndex][0] = name
        self.memoryPeopleList[selectedRowIndex][1] = age

        #Refresh the onscreen listwidget
        self.LoadDataIntoListWidget()
        self.listWidgetPeople.setCurrentRow(selectedRowIndex)

    def LoadDataFromFile(self):                                                                          #####
		#Standard csv-reading code
        import csv

        fileName ="People.txt"
        accessMode ="r"

		#Clear all items from the memory list, so it will be empty every time I refill it from file
		#Prevents duplicates being added to the list
        self.memoryPeopleList.clear()

        #open the file, read it's contents into my program
        with open(fileName, accessMode) as myFile:                                                       
            nameData = csv.reader(myFile) #2d list of the data
			#Go through each row in the csv reader and add them to MY list (memory list of people)
            for row in nameData:
                self.memoryPeopleList.append(row)

    def LoadDataIntoListWidget(self):
        #Take the data from the 2d list and put the names into the onscreen listwidget
		
		#Clear all items from the on-screen list widget, so it will be empty every time I refill it 
		#from the memory list. Prevents duplicates being added to the list
        self.listWidgetPeople.clear()
        for personRow in self.memoryPeopleList:
            self.listWidgetPeople.addItem(personRow[0])                                                  #####
        
# DO NOT MODIFY THIS CODE
if __name__ == "__main__":
    app = QApplication(sys.argv)
    the_form = MyForm()
    the_form.show()
    sys.exit(app.exec_())
# END DO NOT MODIFY