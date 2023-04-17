import ecomm.*;
import demo.*;

import java.io.*;
import java.util.*;
import java.nio.*;

class PlatformMain {

	public static void main(String[] args) {

		 // replace with appropriate derived class

		Scanner sc = new Scanner(System.in);

		String nLine = sc.nextLine();

		while (!nLine.equals("End")) {


			if (!nLine.equals("Check")) {
				Platform pf = new DemoPlatform();
				try
				{
					pf.processRequests();
				}
				catch(Exception e)
				{}
				Seller s1 = new SellerVarshith("Seller1");
				s1.addPlatform(pf);

				Seller s2 = new SellerPuneet("Seller2");
				s2.addPlatform(pf);

				nLine = sc.nextLine();
			}

			// create a number of sellers (of different sub-types of Seller)
			// Assign a name (sellerID) to each of them.

			
		}

	}

}
