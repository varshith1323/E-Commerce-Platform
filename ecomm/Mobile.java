package ecomm;

import ecomm.*;
import demo.*;
import java.util.*;
import java.io.*;
import java.nio.*;

public   class Mobile extends Product {

	private String category;
	private String productName;
	private String productID;
	private float price;
	private int count;

	Mobile(String category1, String productName1, String productID1, float price1, int count1)
	{
		category=category1;
		productName=productName1;
		productID=productID1;
		price=price1;
		count=count1;
	}

	// common queries to get category, unique name, price, and number available
    @Override
	public   String getCategory()
	{
		return category;
	}
    @Override
	public   String getName()
	{
		return productName;
	}
    @Override
	public   String getProductID()
	{
		return productID;
	}
    @Override
	public   float getPrice()
	{
		return price;
	}
    @Override
	public   int getQuantity()
	{
		return count;
	}
}


