# -*- coding: utf-8 -*-

# Form implementation generated from reading ui file 'e:\PROG_SourceCode\GeoffRepo-PROG\GUI\LoadPeople_PRG\LoadPeople_PRG.ui'
#
# Created by: PyQt5 UI code generator 5.10.1
#
# WARNING! All changes made in this file will be lost!

from PyQt5 import QtCore, QtGui, QtWidgets

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        MainWindow.setObjectName("MainWindow")
        MainWindow.resize(738, 786)
        self.centralwidget = QtWidgets.QWidget(MainWindow)
        self.centralwidget.setObjectName("centralwidget")
        self.listWidgetPeople = QtWidgets.QListWidget(self.centralwidget)
        self.listWidgetPeople.setGeometry(QtCore.QRect(20, 40, 281, 401))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.listWidgetPeople.setFont(font)
        self.listWidgetPeople.setObjectName("listWidgetPeople")
        self.pushButtonShow = QtWidgets.QPushButton(self.centralwidget)
        self.pushButtonShow.setGeometry(QtCore.QRect(440, 370, 181, 51))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.pushButtonShow.setFont(font)
        self.pushButtonShow.setObjectName("pushButtonShow")
        self.frameDetails = QtWidgets.QFrame(self.centralwidget)
        self.frameDetails.setGeometry(QtCore.QRect(310, 40, 451, 261))
        self.frameDetails.setStyleSheet("background-color: \"red\"")
        self.frameDetails.setFrameShape(QtWidgets.QFrame.StyledPanel)
        self.frameDetails.setFrameShadow(QtWidgets.QFrame.Raised)
        self.frameDetails.setObjectName("frameDetails")
        self.pushButtonLoad = QtWidgets.QPushButton(self.frameDetails)
        self.pushButtonLoad.setEnabled(True)
        self.pushButtonLoad.setGeometry(QtCore.QRect(100, 170, 171, 91))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.pushButtonLoad.setFont(font)
        self.pushButtonLoad.setObjectName("pushButtonLoad")
        self.lineEditName = QtWidgets.QLineEdit(self.frameDetails)
        self.lineEditName.setGeometry(QtCore.QRect(150, 20, 271, 41))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.lineEditName.setFont(font)
        self.lineEditName.setStyleSheet("background-color: \"green\"")
        self.lineEditName.setObjectName("lineEditName")
        self.labelAge = QtWidgets.QLabel(self.frameDetails)
        self.labelAge.setGeometry(QtCore.QRect(50, 60, 61, 71))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.labelAge.setFont(font)
        self.labelAge.setStyleSheet("background-color: \"pink\"")
        self.labelAge.setObjectName("labelAge")
        self.labelName = QtWidgets.QLabel(self.frameDetails)
        self.labelName.setGeometry(QtCore.QRect(40, 0, 91, 61))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.labelName.setFont(font)
        self.labelName.setObjectName("labelName")
        self.lineEditAge = QtWidgets.QLineEdit(self.frameDetails)
        self.lineEditAge.setGeometry(QtCore.QRect(150, 80, 271, 41))
        font = QtGui.QFont()
        font.setPointSize(20)
        self.lineEditAge.setFont(font)
        self.lineEditAge.setObjectName("lineEditAge")
        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QtWidgets.QMenuBar(MainWindow)
        self.menubar.setGeometry(QtCore.QRect(0, 0, 738, 21))
        self.menubar.setObjectName("menubar")
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QtWidgets.QStatusBar(MainWindow)
        self.statusbar.setObjectName("statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)
        QtCore.QMetaObject.connectSlotsByName(MainWindow)

    def retranslateUi(self, MainWindow):
        _translate = QtCore.QCoreApplication.translate
        MainWindow.setWindowTitle(_translate("MainWindow", "Geoff\'s Awesome People Loader"))
        self.pushButtonShow.setText(_translate("MainWindow", "Show"))
        self.pushButtonLoad.setText(_translate("MainWindow", "Load People"))
        self.labelAge.setText(_translate("MainWindow", "Age:"))
        self.labelName.setText(_translate("MainWindow", "Name:"))

