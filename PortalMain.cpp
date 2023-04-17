#include "Portal.h"
#include "DemoPortal.h"

#include <iostream>
#include <stdio.h>
#include<string>
#include <string.h>
#include<sstream>
#include<vector>
using namespace std;



	int main() 
	{
        string inputStr;
		cin>>inputStr;
        while (inputStr!="End") //when user commands end
        {
            if(inputStr=="Check") //when user wants to check
		    {
				Portal *poObj333; //pointer object
				poObj333=new DemoPortal(); 
				poObj333->checkResponse(); //calling function to check responses in file
		    }
		}
	}

