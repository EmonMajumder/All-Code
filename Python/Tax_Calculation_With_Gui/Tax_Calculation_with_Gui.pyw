import sys

from PyQt5.QtWidgets import QApplication, QMainWindow, QMessageBox

#ADD IMPORT STATEMENT FOR YOUR GENERATED UI.PY FILE HERE
import Ui_Tax_Calculation_with_Gui
#      ^^^^^^^^^^^ Change this!

#CHANGE THE SECOND PARAMETER (Ui_ChangeMe) TO MATCH YOUR GENERATED UI.PY FILE
class MyForm(QMainWindow, Ui_Tax_Calculation_with_Gui.Ui_MainWindow):
#                         ^^^^^^^^^^^   Change this!

    # DO NOT MODIFY THIS CODE
    def __init__(self, parent=None):
        super(MyForm, self).__init__(parent)
        self.setupUi(self)
    # END DO NOT MODIFY

        # ADD SLOTS HERE, indented to this level (ie. inside def __init__)
        self.FrameShowDetails.hide()
        self.pushButtoncalculateTax.clicked.connect(self.calculateTaxButton_Clicked)


    # ADD SLOT FUNCTIONS HERE
    # These are the functions your slots will point to
    # Indent to this level (ie. inside the class, at same level as def __init__)
    def calculateTaxButton_Clicked(self):
        salary=float(self.lineEditsalaryInput.text())
        numberofDependent=int(self.lineEditnumberofDependent.text())

        P_tax=0.06
        F_tax=0.25
        D_deduction=0.02
        provincialTaxamount=salary*P_tax
        federalTaxamount=salary*F_tax
        dependentDeduction=salary*D_deduction*numberofDependent
        totalWithheld=provincialTaxamount+federalTaxamount-dependentDeduction
        takeHomepay=salary-totalWithheld

        self.FrameShowDetails.show()

        self.labeldependentdeduction.setText("Dependent Deduction for {0} dependents:".format(numberofDependent))
        self.labelprovincialTax.setText("{0:.2f}".format(provincialTaxamount))
        self.labelfederalTax.setText("{0:.2f}".format(federalTaxamount))
        self.labeldeductionforDependent.setText("{0:.2f}".format(dependentDeduction))
        self.labeltotalWithheld.setText("{0:.2f}".format(totalWithheld))
        self.labeltakeHomepay.setText("{0:.2f}".format(takeHomepay))

#Example Slot Function
#   def SaveButton_Clicked(self):
#       Make a call to the Save() helper function here

    #ADD HELPER FUNCTIONS HERE
    # These are the functions the slot functions will call, to 
    # contain the custom code that you'll write to make your progam work.
    # Indent to this level (ie. inside the class, at same level as def __init__)

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