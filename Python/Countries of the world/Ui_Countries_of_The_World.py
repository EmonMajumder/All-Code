# -*- coding: utf-8 -*- 

# Form implementation generated from reading ui file 'i:\Study Material\Programming\w0411567-MajumderE\Final Project\EmonMajumder_W0411567_section_FinalProject\Countries_of_The_World.ui'
#
# Created by: PyQt5 UI code generator 5.11.3
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(800, 600)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.listCountry_List = QtWidgets.QListWidget(self.centralwidget)
        self.listCountry_List.setGeometry(QtCore.QRect(20, 20, 231, 521))
        self.listCountry_List.setObjectName("listCountry_List")
        self.FrameShowDetails = QtWidgets.QFrame(self.centralwidget)
        self.FrameShowDetails.setGeometry(QtCore.QRect(280, 20, 511, 521))
        self.FrameShowDetails.setFrameShape(QtWidgets.QFrame.Box)
        self.FrameShowDetails.setFrameShadow(QtWidgets.QFrame.Raised)
        self.FrameShowDetails.setObjectName("FrameShowDetails")
        self.labelCountryName = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelCountryName.setGeometry(QtCore.QRect(30, 20, 411, 31))
        font = QtGui.QFont()
        font.setPointSize(15)
        font.setBold(True)
        font.setWeight(75)
        self.labelCountryName.setFont(font)
        self.labelCountryName.setText("")
        self.labelCountryName.setObjectName("labelCountryName")
        self.labelCountryFlag = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelCountryFlag.setGeometry(QtCore.QRect(30, 50, 271, 151))
        self.labelCountryFlag.setObjectName("labelCountryFlag")
        self.labelPopulation = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelPopulation.setGeometry(QtCore.QRect(30, 230, 101, 21))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.labelPopulation.setFont(font)
        self.labelPopulation.setObjectName("labelPopulation")
        self.lineEditCountryPopulation = QtWidgets.QLineEdit(self.FrameShowDetails)
        self.lineEditCountryPopulation.setGeometry(QtCore.QRect(130, 230, 201, 31))
        self.lineEditCountryPopulation.setObjectName("lineEditCountryPopulation")
        self.pushButtonUpdatePopulation = QtWidgets.QPushButton(self.FrameShowDetails)
        self.pushButtonUpdatePopulation.setGeometry(QtCore.QRect(360, 230, 121, 31))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setUnderline(False)
        font.setStrikeOut(False)
        font.setKerning(True)
        self.pushButtonUpdatePopulation.setFont(font)
        self.pushButtonUpdatePopulation.setObjectName("pushButtonUpdatePopulation")
        self.labelTotal_Area_in = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelTotal_Area_in.setGeometry(QtCore.QRect(30, 300, 111, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.labelTotal_Area_in.setFont(font)
        self.labelTotal_Area_in.setObjectName("labelTotal_Area_in")
        self.labelCountryArea = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelCountryArea.setGeometry(QtCore.QRect(310, 300, 201, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.labelCountryArea.setFont(font)
        self.labelCountryArea.setText("")
        self.labelCountryArea.setObjectName("labelCountryArea")
        self.groupPopulationDensity = QtWidgets.QGroupBox(self.FrameShowDetails)
        self.groupPopulationDensity.setEnabled(True)
        self.groupPopulationDensity.setGeometry(QtCore.QRect(30, 360, 291, 101))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.groupPopulationDensity.setFont(font)
        self.groupPopulationDensity.setObjectName("groupPopulationDensity")
        self.radioSquareMile = QtWidgets.QRadioButton(self.groupPopulationDensity)
        self.radioSquareMile.setGeometry(QtCore.QRect(20, 30, 121, 17))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(True)
        font.setWeight(75)
        self.radioSquareMile.setFont(font)
        self.radioSquareMile.setObjectName("radioSquareMile")
        self.radioSquarekm = QtWidgets.QRadioButton(self.groupPopulationDensity)
        self.radioSquarekm.setGeometry(QtCore.QRect(20, 60, 121, 17))
        font = QtGui.QFont()
        font.setPointSize(10)
        font.setBold(True)
        font.setWeight(75)
        font.setStrikeOut(False)
        font.setKerning(False)
        self.radioSquarekm.setFont(font)
        self.radioSquarekm.setObjectName("radioSquarekm")
        self.labelCountryPopulationDensity = QtWidgets.QLabel(self.groupPopulationDensity)
        self.labelCountryPopulationDensity.setGeometry(QtCore.QRect(170, 30, 121, 41))
        self.labelCountryPopulationDensity.setText("")
        self.labelCountryPopulationDensity.setObjectName("labelCountryPopulationDensity")
        self.labelPercentage_of_World_Population = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelPercentage_of_World_Population.setGeometry(QtCore.QRect(30, 470, 271, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.labelPercentage_of_World_Population.setFont(font)
        self.labelPercentage_of_World_Population.setObjectName("labelPercentage_of_World_Population")
        self.labelPercentage = QtWidgets.QLabel(self.FrameShowDetails)
        self.labelPercentage.setGeometry(QtCore.QRect(310, 470, 201, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.labelPercentage.setFont(font)
        self.labelPercentage.setText("")
        self.labelPercentage.setObjectName("labelPercentage")
        self.comboAreaUnit = QtWidgets.QComboBox(self.FrameShowDetails)
        self.comboAreaUnit.setGeometry(QtCore.QRect(140, 300, 151, 31))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.comboAreaUnit.setFont(font)
        self.comboAreaUnit.setObjectName("comboAreaUnit")
        self.comboAreaUnit.addItem("")
        self.comboAreaUnit.addItem("")
        self.label = QtWidgets.QLabel(self.FrameShowDetails)
        self.label.setGeometry(QtCore.QRect(296, 303, 41, 21))
        font = QtGui.QFont()
        font.setPointSize(12)
        font.setBold(True)
        font.setWeight(75)
        self.label.setFont(font)
        self.label.setObjectName("label")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 800, 21))
        self.menubar.setObjectName("menubar")
        self.File = QtWidgets.QMenu(self.menubar)
        self.File.setObjectName("File")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)
        self.actionLoad = QtWidgets.QAction(MainWindow)
        self.actionLoad.setObjectName("actionLoad")
        self.actionSave = QtWidgets.QAction(MainWindow)
        self.actionSave.setObjectName("actionSave")
        self.actionExit = QtWidgets.QAction(MainWindow)
        self.actionExit.setObjectName("actionExit")
        self.File.addAction(self.actionLoad)
        self.File.addAction(self.actionSave)
        self.File.addSeparator()
        self.File.addAction(self.actionExit)
        self.menubar.addAction(self.File.menuAction())

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "Countries_of_The_World"))
        self.labelCountryFlag.setText(_translate("MainWindow", "Flag Photo"))
        self.labelPopulation.setText(_translate("MainWindow", "Population:"))
        self.pushButtonUpdatePopulation.setText(_translate("MainWindow", "Update Population"))
        self.labelTotal_Area_in.setText(_translate("MainWindow", "Total Area in"))
        self.groupPopulationDensity.setTitle(_translate("MainWindow", "Population Density"))
        self.radioSquareMile.setText(_translate("MainWindow", "Per Square Mile"))
        self.radioSquarekm.setText(_translate("MainWindow", "Per Square Km"))
        self.labelPercentage_of_World_Population.setText(_translate("MainWindow", "Percentage of World Population:"))
        self.comboAreaUnit.setItemText(0, _translate("MainWindow", "sq. mile"))
        self.comboAreaUnit.setItemText(1, _translate("MainWindow", "sq. km"))
        self.label.setText(_translate("MainWindow", ":"))
        self.File.setTitle(_translate("MainWindow", "File"))
        self.actionLoad.setText(_translate("MainWindow", "Load"))
        self.actionSave.setText(_translate("MainWindow", "Save"))
        self.actionExit.setText(_translate("MainWindow", "Exit"))
