package ecomm;
import ecomm.*;
import demo.*;
import java.util.*;
import java.io.*;
import java.nio.*;

public class SellerPuneet extends Seller {
	private ArrayList<Product> books=new ArrayList<>();
	private ArrayList<Product> mobile=new ArrayList<>();
	


	// id is passed in by the class that instantiates sub-type of seller
	public SellerPuneet(String id) 
	{
		myID = id;
	}
	
	// ID of seller. 
	public String getID() { 
		return myID;
	}
	
	
	// Platform it is being added to.
	// Should in turn add itself to the Platform (with addSeller)
    @Override
	public void addPlatform(Platform thePlatform)
	{
		thePlatform.addSeller(this);
	}

	public void parameterSort() 
	{
		/*
		// sort start
		ArrayList<Product> sorted_books = new ArrayList<>();
		ArrayList<Product> sorted_mobile = new ArrayList<>();
		sorted_books = books;
		sorted_mobile = mobile;

		// Call sort() method
		if ((DemoPlatform.sortOrder).equals("Price")) {
			Collections.sort(sorted_books, new Comparator<Product>() {
				@Override
				public float compare(Product p1, Product p2) {
					return p1.getPrice() - p2.getPrice();
				}
			});
		} else if ((DemoPlatform.sortOrder).equals("Name")) {
			Collections.sort(sorted_books, new Comparator<Product>() {
				@Override
				public float compare(Product p1, Product p2) {
					return p1.getName().compareTo(p2.getName());
				}
			});
		}
		// sort end
		*/
	}
	
	// Seller to return listing of Products of specified Category
    @Override
	public ArrayList<Product> findProducts(String whichOne) throws Exception
	{

		File file_seller2 = new File("/Users/praveenak/Downloads/Seller2.txt");
 
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)

        // Creating an object of BufferedReader class
        BufferedReader br2 = new BufferedReader(new FileReader(file_seller2));
 		String st_seller2;
        // Condition holds true till
        // there is character in a string
		String[] tempArr3={};
        while ((st_seller2 = br2.readLine()) != null)
		{
            tempArr3=st_seller2.split(" ");
            
			if(whichOne.equals("Book"))
			{
				DemoPlatform.bookCount++;
				Product prObj2=new Book(tempArr3[0],tempArr3[1],tempArr3[2],Float.parseFloat(tempArr3[3]),Integer.parseInt(tempArr3[4]));
				books.add(prObj2);
			}

			else if(whichOne.equals("Mobile"))
			{
				DemoPlatform.mobCount++;
				Product prObj2=new Mobile(tempArr3[0],tempArr3[1],tempArr3[2],Float.parseFloat(tempArr3[3]),Integer.parseInt(tempArr3[4]));
				mobile.add(prObj2);
			}
		}

		parameterSort();
 
		if(whichOne.equals("Book"))
		{
			return books;
		}

		else if(whichOne.equals("Mobile"))
		{
			return mobile;
		}

		return null;
	}
	// User wants to buy specified quantity of productID
	// Return true if transaction succeeds, false otherwise. 
	// Transaction fails if incorrect productID or quantity exceeds available inventory
    @Override
	public boolean buyProduct(String productID, int quantity)
	{
		for(int i=0;i<books.size();i++)
		{
			if(((books.get(i)).getProductID()).equals(productID))
			{
				if(((books.get(i)).getQuantity())>=quantity)
				{
					return true;
				}
			}
		}

		for(int i=0;i<mobile.size();i++)
		{
			if(((mobile.get(i)).getProductID()).equals(productID))
			{
				if(((mobile.get(i)).getQuantity())>=quantity)
				{
					return true;
				}
			}
		}

		return false;
	}
	
	private String myID;
}
