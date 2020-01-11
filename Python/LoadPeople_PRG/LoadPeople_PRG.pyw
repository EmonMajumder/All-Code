import sys

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox

#ADD IMPORT STATEMENT FOR YOUR GENERATED UI.PY FILE HERE
import Ui_LoadPeople_PRG
#      ^^^^^^^^^^^ Change this!

#CHANGE THE SECOND PARAMETER (Ui_ChangeMe) TO MATCH YOUR GENERATED UI.PY FILE
class MyForm(QMainWindow, Ui_LoadPeople_PRG.Ui_MainWindow):
#                         ^^^^^^^^^^^   Change this!
    #a Globally scoped 2d list
    memoryPeopleList = []

    # DO NOT MODIFY THIS CODE
    def __init__(self, parent=None):
        super(MyForm, self).__init__(parent)
        self.setupUi(self)
    # END DO NOT MODIFY

        # ADD SLOTS HERE, indented to this level (ie. inside def __init__)
        #User can click Load button
        self.pushButtonLoad.clicked.connect(self.LoadButton_Clicked)
        #User can selected an item from list
        self.listWidgetPeople.currentRowChanged.connect(self.List_RowChanged)

		#Slot for button we added to show how to show/hide controls
        self.pushButtonShow.clicked.connect(self.ShowButton_Clicked)

    # ADD SLOT FUNCTIONS HERE
    # These are the functions your slots will point to
    # Indent to this level (ie. inside the class, at same level as def __init__)
    def LoadButton_Clicked(self):
	
		#Call the two functions to load data from file into memory, then from 
		#memory into the on-screen list widget
        self.LoadDataFromFile()
        self.LoadDataIntoListWidget()
        
        #Disable button after first click
        #self.pushButtonLoad.setEnabled(False)
        #self.pushButtonLoad.hide()


    def List_RowChanged(self, newIndex):
		#currentRowChanged signal from the list passes the index of the selected row as a parameter
	
        #When user selects a row, display name and age in textboxes for the selected item
        name = self.memoryPeopleList[newIndex][0]
        age = self.memoryPeopleList[newIndex][1]

		#Set values in the textboxes
        self.lineEditName.setText(name)
        self.lineEditAge.setText(age)

    def ShowButton_Clicked(self):
		#How to toggle visibility of the frame and change text on button
        if self.frameDetails.isVisible():
            self.frameDetails.hide()
            self.pushButtonShow.setText("Show")
        else:
            self.frameDetails.show()
            self.pushButtonShow.setText("Hide")

    #ADD HELPER FUNCTIONS HERE
    # These are the functions the slot functions will call, to 
    # contain the custom code that you'll write to make your progam work.
    # Indent to this level (ie. inside the class, at same level as def __init__)

    def LoadDataFromFile(self):
		#Standard csv-reading code
        import csv

        fileName = "People.txt"
        accessMode = "r"

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
            self.listWidgetPeople.addItem(personRow[0])
        

# DO NOT MODIFY THIS CODE
if __name__ == "__main__":
    app = QApplication(sys.argv)
    the_form = MyForm()
    the_form.show()
    sys.exit(app.exec_())
# END DO NOT MODIFY