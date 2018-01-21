package dataExchange;

import java.io.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Wczytaj {


	private ArrayList<ZPC> listazpc;
	private ArrayList<PRA> listapra;

	private String EXCEL_FILE_LOCATION;
	
	public Wczytaj(String eXCEL_FILE_LOCATION) {
		super();
		this.listazpc = new ArrayList<ZPC>();
		   this.listapra = new ArrayList<PRA>();
		this.EXCEL_FILE_LOCATION = eXCEL_FILE_LOCATION;
	}

public void readzpc() throws IOException {
	 FileReader fileReader = new FileReader(EXCEL_FILE_LOCATION);
	  BufferedReader bufferedReader = new BufferedReader(fileReader);
	  
	  String textLine; 
	  ;
	  textLine = bufferedReader.readLine();
	  do {
		  String wynik[]=null ;
	    JOptionPane.showMessageDialog(null,textLine);
	    if (textLine!="" && textLine!=null) {
	    wynik = textLine.split(",", 4);
	    JOptionPane.showMessageDialog(null,wynik);
	    listazpc.add(new ZPC(wynik[0], wynik[1], Integer.parseInt(wynik[2]), wynik[3]));
	    textLine = bufferedReader.readLine();
	    }
	  } while(textLine != null);

	  bufferedReader.close();
	}
	
	
	
	
	

	


	public ArrayList<ZPC> getListazpc() {
		return listazpc;
	}

	public ArrayList<PRA> getListapra() {
		return listapra;
	}

	




}

    

				