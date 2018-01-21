package dataExchange;



import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Odczytpra {

	FileReader fr = null;
	String linia = "";
	private ArrayList<String> listapra2=new ArrayList<String>();;
	private ArrayList<ZPC> listazpc;
	private ArrayList<PRA> listapra;

	private String EXCEL_FILE_LOCATION;
	
	public Odczytpra(String eXCEL_FILE_LOCATION) {
		super();
		this.listazpc = new ArrayList<ZPC>();
		   this.listapra = new ArrayList<PRA>();
		this.EXCEL_FILE_LOCATION = eXCEL_FILE_LOCATION;
	}
	public void wczytaj() {
		
		try
		{
			fr = new FileReader(EXCEL_FILE_LOCATION);
		}
		catch(	FileNotFoundException e1)
		{
	        JOptionPane.showMessageDialog(null, "BLAD PRZY OTWIERANIU PLIKU Z DANYMI!");
	        System.exit(1);
		}

	    BufferedReader bfr = new BufferedReader(fr);
	    try 
	    {
	  	 
	      while((linia = bfr.readLine()) != null)
	      {
	      listapra2.add(linia);
	      }
	    }
	    catch (IOException e1) {
	  	   JOptionPane.showMessageDialog(null, "BLAD W ODCZYCIE PLIKU Z DANYMI!");
	         System.exit(2);
	    }

	    // ZAMYKANIE PLIKU
	    try {
	      bfr.close();
	     } catch (IOException e) {
	  	   JOptionPane.showMessageDialog(null, "BLAD PRZY ZAMYKANIU PLIKU Z DANYMI!");
	          System.exit(3);
	         }

		
		return ;
	}

	public ArrayList<PRA> konwersja()
	{
		String wynik[]=null ;
	  
	   for(String textLine:listapra2) {
	    wynik = textLine.split(",", 3);
	    listapra.add(new PRA(Integer.parseInt(wynik[0]),Double.parseDouble(wynik[1]),wynik[2] ));
	    
	   }
	return listapra;}
	


}
