# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'e:\Study Material\Programming\w0411567-MajumderE\Colors_Demo\Colors_Demo.ui'
#
# Created by: PyQt5 UI code generator 5.10.1
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(800, 600)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.Color_picker = QtWidgets.QGroupBox(self.centralwidget)
        self.Color_picker.setGeometry(QtCore.QRect(40, 30, 151, 131))
        self.Color_picker.setObjectName("Color_picker")
        self.radioRed = QtWidgets.QRadioButton(self.Color_picker)
        self.radioRed.setGeometry(QtCore.QRect(20, 30, 82, 17))
        self.radioRed.setObjectName("radioRed")
        self.radioBlue = QtWidgets.QRadioButton(self.Color_picker)
        self.radioBlue.setGeometry(QtCore.QRect(20, 60, 82, 17))
        self.radioBlue.setObjectName("radioBlue")
        self.radioGreen = QtWidgets.QRadioButton(self.Color_picker)
        self.radioGreen.setGeometry(QtCore.QRect(20, 90, 82, 17))
        self.radioGreen.setObjectName("radioGreen")
        self.User_Input = QtWidgets.QLineEdit(self.centralwidget)
        self.User_Input.setGeometry(QtCore.QRect(90, 180, 151, 21))
        self.User_Input.setInputMask("")
        self.User_Input.setText("")
        self.User_Input.setMaxLength(32767)
        self.User_Input.setObjectName("User_Input")
        self.Message_viewer = QtWidgets.QPushButton(self.centralwidget)
        self.Message_viewer.setGeometry(QtCore.QRect(40, 240, 151, 21))
        self.Message_viewer.setObjectName("Message_viewer")
        self.The_Text = QtWidgets.QLabel(self.centralwidget)
        self.The_Text.setGeometry(QtCore.QRect(90, 290, 141, 31))
        self.The_Text.setText("")
        self.The_Text.setObjectName("The_Text")
        self.label = QtWidgets.QLabel(self.centralwidget)
        self.label.setGeometry(QtCore.QRect(40, 180, 61, 20))
        self.label.setObjectName("label")
        self.label_2 = QtWidgets.QLabel(self.centralwidget)
        self.label_2.setGeometry(QtCore.QRect(40, 290, 51, 31))
        self.label_2.setObjectName("label_2")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 800, 21))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "MainWindow"))
        self.Color_picker.setTitle(_translate("MainWindow", "Colour_Choose"))
        self.radioRed.setText(_translate("MainWindow", "Red"))
        self.radioBlue.setText(_translate("MainWindow", "Blue"))
        self.radioGreen.setText(_translate("MainWindow", "Green"))
        self.Message_viewer.setText(_translate("MainWindow", "Display Text From User"))
        self.label.setText(_translate("MainWindow", "Enter Text"))
        self.label_2.setText(_translate("MainWindow", "Your Text"))

