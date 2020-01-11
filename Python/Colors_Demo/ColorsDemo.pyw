import sys

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox

#ADD IMPORT STATEMENT FOR YOUR GENERATED UI.PY FILE HERE
import Ui_Colors_Demo
#      ^^^^^^^^^^^ Change this!

#CHANGE THE SECOND PARAMETER (Ui_ChangeMe) TO MATCH YOUR GENERATED UI.PY FILE
class MyForm(QMainWindow, Ui_Colors_Demo.Ui_MainWindow):
#                         ^^^^^^^^^^^   Change this!

    # DO NOT MODIFY THIS CODE
    def __init__(self, parent=None):
        super(MyForm, self).__init__(parent)
        self.setupUi(self)
    # END DO NOT MODIFY

        # ADD SLOTS HERE, indented to this level (ie. inside def __init__)
        #one slot for each red, blue, green clicked, one for display button clicked 
        self.radioRed.clicked.connect(self.RadioRed_Clicked)
        self.radioBlue.clicked.connect(self.RadioBlue_Clicked)
        self.radioGreen.clicked.connect(self.RadioGreen_Clicked)

        self.Message_viewer.clicked.connect(self.DisplayButton_Clicked)


    # ADD SLOT FUNCTIONS HERE
    # These are the functions your slots will point to
    # Indent to this level (ie. inside the class, at same level as def __init__)
    def RadioRed_Clicked(self):
       self.SetBackGroundColor("red")

    def RadioBlue_Clicked(self):
       self.SetBackGroundColor("blue")

    def RadioGreen_Clicked(self):
       self.SetBackGroundColor("green") 

    def DisplayButton_Clicked(self):
        message=self.User_Input.text()
        self.SetMessageText(message)

#Example Slot Function
#   def SaveButton_Clicked(self):
#       Make a call to the Save() helper function here

    #ADD HELPER FUNCTIONS HERE
    # These are the functions the slot functions will call, to 
    # contain the custom code that you'll write to make your progam work.
    # Indent to this level (ie. inside the class, at same level as def __init__)
    def SetBackGroundColor(self,color):
        self.Color_picker.setStyleSheet("background-color: {0}".format(color))

    def SetMessageText(self,msg):
        self.The_Text.setText(msg)

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