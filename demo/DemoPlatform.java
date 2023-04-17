package demo;
import ecomm.*;
import demo.*;
import java.io.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

import ecomm.Globals;


public class DemoPlatform extends Platform
{
  public static int mobCount=0;//incremented while reading from product objects
  public static int bookCount=0; //incremented while reading from product objects
  public static String sortOrder;
	private static List<Seller> seller_list = new ArrayList<>(); // list of sellers
	// Used by Seller to attach to Platform
    @Override
    public void addSeller(Seller aSeller)
    {
        seller_list.add(aSeller);
    }

    
       

	
	// checks the incoming messages (in file PortalToPlatform.txt) 
	//   for unprocessed requests
	// Invokes methods on Sellers as needed and writes out responses 
	//   (into file PlatformToPortal.txt)
	// This could be invoked by main when processing command line or in a timer
  @Override
	public void processRequests() throws Exception
	{
		File file = new File("PortalToPlatform.txt");
		BufferedReader br333 = new BufferedReader(new FileReader(file));
		String myText;
    String[] tempArr;
    
        while ((myText = br333.readLine()) != null)
        {
           String finalStr;
            //read each line, split into array, and based on wht it is, send it to req func(start, buy, etc)
            //write tht into platformtoportal file
            tempArr=myText.split(" ");
            if(tempArr[2]=="Start")
            {
                if(mobCount>0 && bookCount>0)
                {
                    Path path = Paths.get("PlatformToPortal.txt");
                    String str = tempArr[0]+" "+tempArr[1]+" Book Mobile";; //when start is given and both books and mobiles are still available, we return categories.
                    Files.writeString(path, str,StandardCharsets.UTF_8);

                }

                else if(mobCount>0 && bookCount<=0)
                {
                  Path path = Paths.get("PlatformToPortal.txt");
                  String str = tempArr[0]+" "+tempArr[1]+" mobile";//when start is given and only mobiles are still available, we return mobile.
                  Files.writeString(path, str,StandardCharsets.UTF_8);
                }

                else if(mobCount<=0 && bookCount>0)
                {
                    Path path = Paths.get("PlatformToPortal.txt");
                    String str = tempArr[0]+" "+tempArr[1]+" book";
                    Files.writeString(path, str,StandardCharsets.UTF_8);
                }
            }

            else if(tempArr[2]=="List")
            {
             
                Path path = Paths.get("PlatformToPortal.txt");
				        Seller sellerObj=new SellerVarshith("1");
                ArrayList<Product>tempVectorList=new ArrayList<>();
                tempVectorList=sellerObj.findProducts(tempArr[3]); 
                sortOrder=tempArr[4];
                for(int i=0;i<tempVectorList.size();i++) 
                {
                  finalStr=tempArr[0]+" "+tempArr[1]+" "+(tempVectorList.get(i)).getName()+" "+(tempVectorList.get(i)).getProductID()+" "+(tempVectorList.get(i)).getPrice();
                  Files.writeString(path, finalStr,StandardCharsets.UTF_8);
                }
            }

            else if(tempArr[2]=="Buy")
            {
              Path path = Paths.get("PlatformToPortal.txt");
              Seller sellerObj=new SellerPuneet("1");
              finalStr=tempArr[0]+" "+tempArr[1]+" "+sellerObj.buyProduct(tempArr[3], Integer.parseInt(tempArr[4]));
              Files.writeString(path, finalStr,StandardCharsets.UTF_8);
            }

        }

	}
	// Should route requests to appropriate seller based on PortalID in the incoming message

    
	
}
