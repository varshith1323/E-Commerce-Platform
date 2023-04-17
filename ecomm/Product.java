package ecomm;
import java.util.*;
import java.io.*;
import java.nio.*;

public abstract class Product {

	// common queries to get category, unique name, price, and number available
	public abstract String getCategory();
	public abstract String getName();
	public abstract String getProductID();
	public abstract float getPrice();
	public abstract int getQuantity();
}


