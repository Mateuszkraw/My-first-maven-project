package dataExchange;

import java.io.*;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Sciezka {

	FileReader fr = null;
	String linia = "";
	
	public String getsciezka() {
		linia = "N:\\PRD\\Efektywnosc";
	
	return linia;}
	
	public String getsciezka2() {
		
		try
		{
			fr = new FileReader("sciezka.txt");
		}
		catch(	FileNotFoundException e1)
		{
	        JOptionPane.showMessageDialog(null, "BlaD PRZY OTWIERANIU PLIKU sciezka!");
	        System.exit(1);
		}

	    BufferedReader bfr = new BufferedReader(fr);
	    try 
	    {
	  	 
	    linia = bfr.readLine();

	    }
	    catch (IOException e1) {
	  	   JOptionPane.showMessageDialog(null, "BLADOdczycie PLIK sciezka!");
	         System.exit(2);
	    }

	    // ZAMYKANIE PLIKU
	    try {
	      bfr.close();
	     } catch (IOException e) {
	  	   JOptionPane.showMessageDialog(null, "BLAD PRZY ZAMYKANIU PLIKU sciezka!");
	          System.exit(3);
	         }

		
		return linia;
	}}