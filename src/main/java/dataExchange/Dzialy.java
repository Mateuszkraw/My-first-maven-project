package dataExchange;


import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Dzialy {

	FileReader fr = null;
	String linia = "";
	ArrayList<String> dzialy = new ArrayList<String>();
	
	
	public ArrayList<String> getDzialy() {
		
		try
		{
			fr = new FileReader("dzialy.txt");
		}
		catch(	FileNotFoundException e1)
		{
	        JOptionPane.showMessageDialog(null, "BLAD PRZY OTWIERANIU PLIKU dzialy.txt!");
	        System.exit(1);
		}

	    BufferedReader bfr = new BufferedReader(fr);
	    try 
	    {
	  	 
	      while((linia = bfr.readLine()) != null)
	      {
	      dzialy.add(linia);
	      }
	    }
	    catch (IOException e1) {
	  	   JOptionPane.showMessageDialog(null, "BLAD W Odczycie PLIKU dzialy.txt!");
	         System.exit(2);
	    }

	    // ZAMYKANIE PLIKU
	    try {
	      bfr.close();
	     } catch (IOException e) {
	  	   JOptionPane.showMessageDialog(null, "BLAD PRZY ZAMYKANIU PLIKU dzialy.txt!");
	          System.exit(3);
	         }

		
		return dzialy;
	}

	
	


}