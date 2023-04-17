#ifndef PORTAL_H
#define PORTAL_H
#include "Portal.h"

#include <iostream>
#include <stdio.h>
#include<string>
#include <string.h>
#include<sstream>
#include<vector>
using namespace std;


class Portal {
    public:
    virtual void processUserCommand(string command);
	virtual void checkResponse();
};

#endif