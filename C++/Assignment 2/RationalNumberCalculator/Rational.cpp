//
// Created by W0411567 on 10/17/2019.
//
#include <regex>
#include "Rational.h"
using namespace std;

//Default object with no argument passed.
Rational::Rational()
{
    this->numerator = 0;
    this->denominator = 1;
}

//Create rational object when a whole number is passed
Rational::Rational(int num)
{
    this->numerator = num;
    this->denominator = 1;
}

//create a rational number from 2 separate integer passed as numerator & denominator
Rational::Rational(int num, int num2)
{
    if(num2<0)
    {
        this->numerator = num*(-1);
        this->denominator = num2*(-1);
    }
    else
    {
        this->numerator = num;
        this->denominator = num2;
    }
}

Rational::Rational(string s)
{
    regex re("/");
    //Return string in 2 part based on position of regex passed(before and after regex match).
    sregex_token_iterator
            first{s.begin(), s.end(), re, -1},
            last;
    vector<string> numarray = {first,last};
    this->numerator=stoi(numarray[0]);
    this->denominator=stoi(numarray[1]);

    if(this->denominator<0)
    {
        this->numerator = this->numerator*(-1);
        this->denominator = this->denominator*(-1);
    }
}

int Rational::getnumerator()
{
    return this->numerator;
}

int Rational::getdenominator()
{
    return this->denominator;
}

void Rational::setnumerator(int num)
{
    this->numerator = num;
}

void Rational::setdenominator(int num)
{
    this->denominator = num;
}

//Function to express the rational number with smallest numerator and denominator.
void normalize(Rational &r)
{
    int rnumpos;
    int rnum=r.getnumerator();
    int rdeno=r.getdenominator();

    if(rnum<0)
        rnumpos=(-1)*rnum;
    else
        rnumpos=rnum;

    for(int j=2;(j<=rnumpos && j<=rdeno);j++)
    {
        if(rnum%j == 0)
        {
            if(rdeno%j==0)
            {
                r.setnumerator(rnum/j);
                r.setdenominator(rdeno/j);
            }
        }
    }
}

//Function to get the numerator and denominator from the expressions like a/b.
//vector<string> split(const string& input, const string& regexoperator)
//{
//    // passing -1 as the submatch index parameter performs splitting
//    regex re(regexoperator);
//
//    //Return string in 2 part based on position of regex passed(before and after regex match).
//    sregex_token_iterator
//            first{input.begin(), input.end(), re, -1},
//            last;
//    return {first, last};
//}

//Operator function to print a rational number on screen.
ostream & operator << (ostream &out, Rational &r)
{
    if(r.getdenominator()==0)
        out<<"Division by 0 error!!!";
    else if(r.getnumerator()== 0)
        out<<r.getnumerator()<<endl;
    else
        out<<r.getnumerator()<<"/"<<r.getdenominator()<<endl;
    return out;
}

//Operator function to take input a rational number, create a rational number object
//and validate the input.
bool operator >> (istream &in, Rational &rationalnum)
{
    string userinput;
    regex forrational("^-?(\\d+)$|^(-?\\d+/(-?\\d*[1-9]+\\d*))$"); //Regex for rational number
    regex forint("^-?\\d+$");                                      //Regx for integer.
    vector<string> numbersstr;
    in >> userinput;

    //Regex validation for int type number
    if(regex_match(userinput,forint))
    {
        Rational num(stoi(userinput));
        rationalnum = num;
        in.clear();
        return false;
    }

    //Regex validation for rational number
    else if(regex_match(userinput,forrational))
    {
        Rational num(userinput);
        rationalnum = num;
        in.clear();
        return false;
    }
    else
    {
        in.clear();
        return true;
    }
}

//Overloaded '==' operator function to compare two rational number.
bool operator == (Rational &r1, Rational &r2)
{
    return r1.numerator*r2.denominator== r1.denominator*r2.numerator;
}

//Overloaded '<' operator function to compare two rational number.
bool operator < (Rational &r1, Rational &r2)
{
    return r1.numerator*r2.denominator<r1.denominator*r2.numerator;
}

//Overloaded '>' operator function to compare two rational number.
bool operator > (Rational &r1, Rational &r2)
{
    return r1.numerator*r2.denominator>r1.denominator*r2.numerator;
}

//Overloaded '+' operator function to add two rational number.
Rational operator + (Rational &r1, Rational &r2)
{
    int rdeno = r1.denominator*r2.denominator;
    int rnum = r1.numerator*r2.denominator+r2.numerator*r1.denominator;
    Rational r3(rnum,rdeno);
    normalize(r3);
    cout<<"+ operator fired"<<endl;
    return r3;
}

//Overloaded '-' operator function to do subtraction between two rational number.
Rational operator - (Rational &r1, Rational &r2)
{
    int rdeno = r1.denominator*r2.denominator;
    int rnum = r1.numerator*r2.denominator-r2.numerator*r1.denominator;
    Rational r3(rnum,rdeno);
    normalize(r3);
    cout<<"- operator fired"<<endl;
    return r3;
}

//Overloaded '*' operator function to multiply two rational number.
Rational operator * (Rational &r1, Rational &r2)
{
    int rnum = r1.numerator*r2.numerator;
    int rdeno = r1.denominator*r2.denominator;
    Rational r3(rnum,rdeno);
    normalize(r3);
    cout<<"* operator fired"<<endl;
    return r3;
}

//Overloaded '/' operator function to do division between add two rational number.
Rational operator / (Rational &r1, Rational &r2)
{
    int rnum = r1.numerator*r2.denominator;
    int rdeno = r1.denominator*r2.numerator;
    Rational r3(rnum,rdeno);
    normalize(r3);
    cout<<"/ operator fired"<<endl;
    return r3;
}

//Increment a number by other number.
void operator += (Rational &r1, Rational &r2)
{
    Rational r = r1+r2;
    r1.numerator = r.numerator;
    r1.denominator = r.denominator;
    cout<<"+= operator fired"<<endl;
}

