CC=g++

portal: PortalMain.o DemoPortal.o
	$(CC) PortalMain.o DemoPortal.o -o portal

PortalMain.o: PortalMain.cpp Portal.h
	$(CC) -c PortalMain.cpp

DemoPortal.o: DemoPortal.cpp DemoPortal.h Portal.h
	$(CC) -c DemoPortal.cpp


clean:
	rm *.o test
