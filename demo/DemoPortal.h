#include "Portal.h"

#include <iostream>
#include <stdio.h>

#include<string>
#include <string.h>
#include<sstream>
#include<vector>
using namespace std;

class DemoPortal : public Portal {
    public:
    void processUserCommand(string command);
    void checkResponse();
};
