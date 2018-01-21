package dataExchange;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

public class Save {

	private boolean save = false;
	private boolean save2 = false;
	private ArrayList<ZPC> listazpc;
	private ArrayList<PRA> listapra;
	private ArrayList<String> dzialy;
	private String zmiana;
	private String sciezka;
	private LocalDate data;
	WritableWorkbook myFirstWbook = null;
	
	
	
	public Save(boolean save, ArrayList<ZPC> listazpc, ArrayList<PRA> listapra, ArrayList<String> dzialy, String zmiana,
			String sciezka,boolean save2,LocalDate data) {

		this.save = save;
		this.save2 = save2;
		this.listazpc = listazpc;
		this.listapra = listapra;
		this.dzialy = dzialy;
		this.zmiana = zmiana;
		this.sciezka = sciezka;
this.data=data;
	}

	public void save() throws BiffException, IOException, RowsExceededException, WriteException {
		String dzial;
		StringBuilder filename = new StringBuilder(sciezka);
		filename.append("\\" + data.getYear() + "\\" );
		boolean success = (new File(filename.toString())).mkdirs();
		filename.append(zmiana+"_" + data
				+  ".xls");
		String EXCEL_FILE_LOCATION = filename.toString();
		File file = new File(EXCEL_FILE_LOCATION);
		if (save == true) {
			
			
			
			try {
				myFirstWbook = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION));
				WritableSheet excelSheet = myFirstWbook.createSheet("raport", 0);
				Label label = new Label(0, 0,zmiana);
				excelSheet.addCell(label);
				label = new Label(0, 1, data.toString());
				excelSheet.addCell(label);
				label = new Label(3, 0,"Zapisana:"+LocalDate.now().toString()+ " "+LocalTime.now());
				excelSheet.addCell(label);/////////////////////////////////////////////////////////////////////////////
				label = new Label(0, 2, "Dzial");
				excelSheet.addCell(label);
				label = new Label(1, 2, "Produkty");
				excelSheet.addCell(label);
				label = new Label(2, 2, "Zlecenie");
				excelSheet.addCell(label);
				label = new Label(3, 2, "Ilosc");
				excelSheet.addCell(label);

				label = new Label(4,2, "Czas pracy dzialu");
				excelSheet.addCell(label);
				
			
			
	///////////////////////////////////////////////////////////////////////////////////		
			int licznik =2;
			for (int k = 1; k < dzialy.size(); k++) {
				licznik++;
				dzial = dzialy.get(k);
				label = new Label(0, licznik, dzial);
				excelSheet.addCell(label);
//Workbook existingWorkbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));					
//WritableWorkbook workbookCopy = Workbook.createWorkbook(new File(EXCEL_FILE_LOCATION),existingWorkbook);
					
					
					int il = 0;
					Number number;
					double licznik2=0;
					
					for (int i = 0; i < listapra.size(); i++) {
						if (listapra.get(i).getDzial().equals(dzial)) {
							licznik2 = licznik2+(listapra.get(i).getHour())*(listapra.get(i).getIlosc());
						}
					}number= new Number(4, licznik, licznik2);
					excelSheet.addCell(number);

					for (int i = 0; i < listazpc.size(); i++) {
						if (listazpc.get(i).getDzial().equals(dzial)) {
							label = new Label(0, licznik, dzial);
							excelSheet.addCell(label);
						label = new Label(1, licznik, listazpc.get(i).getName());
						excelSheet.addCell(label);
						label = new Label(2, licznik, listazpc.get(i).getZpname());
						excelSheet.addCell(label);
						number = new Number(3, licznik, listazpc.get(i).getNumber());
						excelSheet.addCell(number);
						licznik++;}
						
					}
					
					
				//	workbookCopy.write();
					// workbookCopy.close();
					// existingWorkbook.close();
					 if (licznik2==0) {licznik++;}
					
			}
			myFirstWbook.write();
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				myFirstWbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (WriteException e) {
				e.printStackTrace();
			}
					///////////////////////////////////////////////////////////////////////////////////////
			
			
			

		      
			if( file.exists() & save2 ) {
				  {JOptionPane.showMessageDialog(null, "Raport zapisano pomyslnie na serwer. ");}
				} else if ( file.exists()&(!save2) ) {
				  {JOptionPane.showMessageDialog(null, "Kopie raportu zapisano na dysk lokalny. ");}
				} else {
					if(save2) {JOptionPane.showMessageDialog(null, "Wystapil nieoczekiwany blad zapisu na serwer");}
					if(!save2) {JOptionPane.showMessageDialog(null, "Wystapil nieoczekiwany blad zapisu na dysk");}
				}
			
			
			
			
			
			
			
			
			
			
			
			

	}
		if (save == false) {
			
			 filename = new StringBuilder(sciezka);
			filename.append("zpc_"+ data+ zmiana +".txt");
			String FILE_LOCATION = filename.toString();
			file = new File(FILE_LOCATION);
			StringBuilder filename2 = new StringBuilder(sciezka);
			filename2.append("pr_"+data+ zmiana +".txt");
			String FILE_LOCATION2 = filename2.toString();
			File file2 = new File(FILE_LOCATION2);
			try {

		        String content = "";
		        StringBuilder dan = new StringBuilder("");
		        PrintWriter zapis = new PrintWriter(FILE_LOCATION);
		        if (!file.exists()) {
		            file.createNewFile();
		        }
		        for(ZPC zp:listazpc) {
				//dan.append(zp.toString());
		        zapis.println(zp.toString());
		        }
		         zapis.close();
		       
		         PrintWriter zapis2= new PrintWriter(FILE_LOCATION2);
			        if (!file2.exists()) {
			            file2.createNewFile();
			        }
			        for(PRA pr:listapra) {
					
			        zapis2.println(pr.toString());
			        }
			         zapis2.close();
		        

		    } catch (IOException e) {
		        e.printStackTrace();
		    }

}}}
