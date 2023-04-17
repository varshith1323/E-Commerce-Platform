#include "Portal.h"
#include "DemoPortal.h"

#include <iostream>
#include <stdio.h>
#include <fstream>

#include<string>
#include <string.h>
#include<sstream>
#include<vector>

using namespace std;



	// Invoked by main or driver class
	// sends command to Platform (by writing to PortalToPlatform)
	// Each command line in the file should have a PortalID as the first token 
	// and a RequestID as second token. 
	// PortalID is unique to each instance of Portal
	// Each request from a portal should have a unique ID

	
	void DemoPortal::processUserCommand(string command)
	{
		ofstream file("PortalToPlatform.txt");
        file << command; //writing command into file

	}
	
	// checks for pending responses (in PortalToPlatform)
	// Displays response
	void DemoPortal::checkResponse()
	{
		//this is called when user says 'check'.
        string myText;
        ifstream MyReadFile("PlatformToPortal.txt");
        while (getline (MyReadFile, myText)) 
        {
        // Output the text from the file
            cout << myText;
        }
        // Close the file
        MyReadFile.close();
		
        //clearing data in file after each 'check'
        ofstream ofs;
        ofs.open("PlatformToPortal.txt", ofstream::out | ofstream::trunc);
        ofs.close();
	}

