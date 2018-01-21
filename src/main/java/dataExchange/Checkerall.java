package dataExchange;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Checkerall {
	ArrayList<ZPC> listazpc = new ArrayList<ZPC>();
	   ArrayList<PRA> listapra = new ArrayList<PRA>();
	   ArrayList<String> dzialy;
	public Checkerall(ArrayList<ZPC> listazpc, ArrayList<PRA> listapra, ArrayList<String> dzialy) {
		super();
		this.listazpc = listazpc;
		this.listapra = listapra;
		this.dzialy = dzialy;
	}
	 public boolean check()
	 {
	 boolean jcheck=false;
	 boolean kcheck=false;
		 
		 for (int i = 1; i < dzialy.size(); i++) {
			  jcheck=false;
			 kcheck=false;
			 for (int j = 0; j < listazpc.size(); j++) {
				 if(listazpc.get(j).getDzial().equals(dzialy.get(i))) {jcheck=true;break;}
				 
			 }
		
			 for (int k = 0; k < listapra.size(); k++) {
				 if(listapra.get(k).getDzial().equals(dzialy.get(i))) {kcheck=true; break;} 
 
			 }
			 if (!jcheck ||!kcheck) {
				 int dialogButton = JOptionPane.YES_NO_OPTION;
	               int response= JOptionPane.showConfirmDialog (null, "Dla dzialu "+dzialy.get(i)+" nie dodales wszystkich wymaganych danych. Kontynuowac momo to? ","Warning",dialogButton);

	                if(response == JOptionPane.NO_OPTION){return false;}
			 }
		

		 }
		 return true;
	 }
	   
}
