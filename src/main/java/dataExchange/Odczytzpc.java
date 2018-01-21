package dataExchange;


import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import javax.swing.JOptionPane;

public class Odczytzpc {

	FileReader fr = null;
	String linia = "";
	ArrayList<String> dzialy = new ArrayList<String>();
	private ArrayList<String> listazpc2=new ArrayList<String>();;
	private ArrayList<String> listapra2;
	private ArrayList<ZPC> listazpc;
	private ArrayList<PRA> listapra;

	private String EXCEL_FILE_LOCATION;
	
	public Odczytzpc(String eXCEL_FILE_LOCATION) {
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
	      listazpc2.add(linia);
	      }
	    }
	    catch (IOException e1) {
	  	   JOptionPane.showMessageDialog(null, "BLAD PLIKU Z DANYMI!");
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

	public ArrayList<ZPC> konwersja()
	{
		String wynik[]=null ;
	  
	   for(String textLine:listazpc2) {
	    wynik = textLine.split(",", 4);

	   
	    listazpc.add(new ZPC(wynik[0], wynik[1], Integer.parseInt(wynik[2]), wynik[3]));
	    
	   }
	return listazpc;}
	


}
