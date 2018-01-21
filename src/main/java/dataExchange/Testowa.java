package dataExchange;

import java.io.File;
import java.util.Scanner;

import javax.swing.JOptionPane;
 
public class Testowa {
	String linia ;
    public  boolean check(String line) {
this.linia=line;
            File file = new File(linia);
            if (file.exists()) {
                if(file.isDirectory()) 
                { 
                    if (file.canWrite()) {
                        return true;
                    } else {
                    	JOptionPane.showMessageDialog(null, "Nie masz uprawnien do zapisu na serwer. Kopia raportu zostanie zpisana na dysku.");
                        return false;
                    }
                }
            } else { //jesli plik nie istnieje

                boolean ok = file.mkdirs();
                if (ok) {
                   
                    return true;
                } else {
                   
                    JOptionPane.showMessageDialog(null, "Nie masz uprawnien do tworzenia folderu na serwerze.. Kopia raportu zostanie zpisana na dysku.");
                    return false;
                }
            }
			return false;

    }}