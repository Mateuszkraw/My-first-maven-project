package dataExchange;

import javax.swing.*;


import java.awt.event.*;

public class Open extends JFrame implements ActionListener
{JFileChooser fc=new JFileChooser("c:\\temp\\ZPC\\");
JButton b1;
String path="";;
	Open(){
	 super("Dialogi");
	 
int wybor=fc.showOpenDialog(this);
if (wybor==JFileChooser.APPROVE_OPTION)

path=fc.getSelectedFile().toString();
	}



public String getPath() {
		return path;
	}



	public void setPath(String path) {
		this.path = path;
	}



@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	
}
} 
