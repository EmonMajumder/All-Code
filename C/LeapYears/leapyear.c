//
// Created by student on 13/02/19.
//
#include <stdbool.h>
#include "leapyear.h"

bool leapyear (int year) {              //Value passed to the function is saved in year.
    int rm4 = 4;
    int rm100 = 100;
    int rm400 = 400;

    if ((year % rm4 == 0 && year % rm100 != 0) || year % rm400 == 0)  //Boolean table to determine lead year or not.
        return true;
    else
        return false;
}