package dataExchange;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.jdesktop.swingx.JXDatePicker;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import jxl.write.biff.RowsExceededException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.*;

public class TableSelectionDemo extends JPanel implements ActionListener {
	ArrayList<String> dzialy;
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextArea output;
	private static String aktualnazmiana;
	private static LocalDate aktualnadata;

	JPanel pane = new JPanel();
	JPanel pane2 = new JPanel();
	JPanel pane3 = new JPanel();

	JPanel pane4 = new JPanel();
	JPanel pane5 = new JPanel();
	JPanel pane6 = new JPanel();
	JScrollPane pane11;
	JScrollPane pane22;
	ArrayList<JButton> button = new ArrayList<JButton>();
	String localdzial;
	public ArrayList<ZPC> listazpc = new ArrayList<ZPC>();
	  public  ArrayList<PRA> listapra = new ArrayList<PRA>();
	   String path="c:\\temp\\ZPC\\";
	   String path2=new Sciezka().getsciezka();
	 
	   String path3="";
	   DefaultTableModel model = new DefaultTableModel();
		DefaultTableModel model2 = new DefaultTableModel();
		Object[] row = new Object[3];
		Object[] row2 = new Object[2];
		static JComboBox<String> combo;
		static String[] combot = new String[] {"Zmiana A", "Zmiana B",
	    "Zmiana C"};
		
		
	public TableSelectionDemo() throws IOException {
		super();
		

		setLayout(null);
		JMenuBar mbar = new JMenuBar();

		add(mbar);
		JMenu fileMenu = new JMenu("File");
		mbar.setBounds(0, 0, 1200, 23);
		mbar.add(fileMenu);
		JMenuItem connectItem1 = new JMenuItem("Wyslij raport na serwer.");
		connectItem1.addActionListener(new ConnectAction1());
		fileMenu.add(connectItem1);
	JMenuItem connectItem2 = new JMenuItem("Wczytaj dane.");
		//connectItem2.addActionListener(new ConnectAction2());
		fileMenu.add(connectItem2);
		JMenuItem exitItem = new JMenuItem("Zamknij ");
		exitItem.addActionListener(event -> System.exit(0));
		fileMenu.add(exitItem);

		// add(new JScrollPane(table), BorderLayout.CENTER);

		JTable table = new JTable();
		JTable table2 = new JTable();
		Object[] columns = { "Nazwa produktu", "Zlecenie", "Ilosc" };
		Object[] columns2 = { "Ilosc pracownikow", "Czas" };
		
		model.setColumnIdentifiers(columns);
		model2.setColumnIdentifiers(columns2);
		table.setModel(model);
		table2.setModel(model2);
		table.setBackground(Color.LIGHT_GRAY);
		table.setForeground(Color.black);
		table2.setBackground(Color.LIGHT_GRAY);
		table2.setForeground(Color.black);
		Font font = new Font("", 1, 12);
		table.setFont(font);
		table.setRowHeight(15);
		table2.setFont(font);
		table2.setRowHeight(15);
		pane11 = new JScrollPane(table);
		pane22 = new JScrollPane(table2);
		pane11.setBounds(25, 25, 450, 200);
		pane22.setBounds(480, 25, 300, 200);
		// FlowLayout(null);
		add(pane11);
		add(pane22);
		boolean success = (new File(path)).mkdirs();
		JLabel lab1=new JLabel ("Nazwa produktu:");
		JLabel lab2=new JLabel ("Zlecenie:");
		JLabel lab3=new JLabel ("Ilosc:");
		JLabel lab4=new JLabel ("Ilosc prac:");
		JLabel lab5=new JLabel ("Czas:");
		
		JTextField textId = new JTextField();
		JTextField textFname = new JTextField();
		JTextField textLname = new JTextField();
		JButton btnAdd = new JButton("Dodaj produkt");
		JButton btnDelete = new JButton("Usun produkt");
		lab1.setBounds(20, 240, 120, 25);
		lab2.setBounds(20, 270, 120, 25);
		lab3.setBounds(20, 300, 120, 25);
		textId.setBounds(120, 240, 120, 25);
		textFname.setBounds(120, 270, 120, 25);
		textLname.setBounds(120, 300, 120, 25);
		btnAdd.setBounds(260, 240, 150, 25);
		btnDelete.setBounds(260, 285, 150, 25);
		JTextField textId2 = new JTextField();
		JTextField textFname2 = new JTextField();
		JButton btnAdd2 = new JButton("Dodaj ");
		JButton btnDelete2 = new JButton("Usun");
		
		lab4.setBounds(450, 240, 120, 25);
		lab5.setBounds(450, 280, 120, 25);
		
		textId2.setBounds(510, 240, 120, 25);
		textFname2.setBounds(510, 280, 120, 25);
		btnAdd2.setBounds(645, 240, 100, 25);
		btnDelete2.setBounds(645, 280, 100, 25);
		add(textId);
		add(textFname);
		add(textLname);
		add(textId2);
		add(textFname2);
		add(btnAdd);
		add(btnDelete);
		
		add(btnAdd2);
		add(btnDelete2);
		add(lab1);
		add(lab2);
		add(lab3);
		add(lab4);
		add(lab5);
		textId.requestFocusInWindow();
		
		Dzialy dzial = new Dzialy();
		dzialy = dzial.getDzialy();
		JRadioButton[] butonki = new JRadioButton[dzialy.size()];
		if (!dzialy.isEmpty()) {
			butonki[1] = new JRadioButton(dzialy.get(1));
			butonki[1].setSelected(true);
			localdzial=dzialy.get(1);
			butonki[1].addActionListener(this);
			butonki[1].setBounds(800, 25, 150, 20);
			add(butonki[1]);
			ButtonGroup bG = new ButtonGroup();
			bG.add(butonki[1]);
			// buttonGroup.add(b);

			for (int i = 2; i < dzialy.size(); i++) {
				butonki[i] = new JRadioButton(dzialy.get(i));
				butonki[i].addActionListener(this);
				butonki[i].setBounds(800, i * 25, 150, 20);
				add(butonki[i]);
				bG.add(butonki[i]);
				butonki[1].setSelected(true);
			}
			
		
	
		}
		///////////////////////////////////////////////////////////////////////////////////////////////

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	    String ACTION_KEY = "theAction";
	    JButton buttonA = new JButton("Press control alt 7");
	    KeyStroke controlAlt7 = KeyStroke.getKeyStroke("control alt 7");
	    InputMap inputMap = buttonA.getInputMap();
	    inputMap.put(controlAlt7, ACTION_KEY);
	    ActionMap actionMap = buttonA.getActionMap();
	    
	    Action actionListener = new AbstractAction() {
	        public void actionPerformed(ActionEvent actionEvent) {
	          JButton source = (JButton) actionEvent.getSource();
	          //////////////////////////////tu ukryty kod wczytywania////////////////////////////////////////////////////////////////////////////////////////////////////
				
				StringBuilder path4 = new StringBuilder("c:\\temp\\ZPC\\");
				path4.append("zpc_"+aktualnadata+ aktualnazmiana +".txt");
				path3=path4.toString();
				File f = new File(path3);
				
				//JOptionPane.showMessageDialog(null,cokto);
				if(f.exists()){
					Odczytzpc aaa=new Odczytzpc(path3);
						aaa.wczytaj();
						
						//JOptionPane.showMessageDialog(null, "wczytalo ");
						listazpc.addAll(aaa.konwersja());
						
						model.setNumRows(0);
						for (ZPC sdsd:listazpc) {
						if (sdsd.getDzial().equals(dzialy.get(1))) {
						row[0] = sdsd.getName().toUpperCase();
						row[1] = sdsd.getZpname().toUpperCase();
						row[2] = sdsd.getNumber();
						// add row to the model
						model.addRow(row);
						}}}
				path4 = new StringBuilder("c:\\temp\\ZPC\\");
				path4.append("pr_"+aktualnadata+ aktualnazmiana +".txt");
				path3=path4.toString();
				f = new File(path3);
				if(f.exists()){
					Odczytpra aaa=new Odczytpra(path3);
						aaa.wczytaj();
						
						//JOptionPane.showMessageDialog(null, "wczytalo ");
						listapra.addAll(aaa.konwersja());
						
						model2.setNumRows(0);
						for (PRA sdsd:listapra) {
						if (sdsd.getDzial().equals(dzialy.get(1))) {
						row[0] = sdsd.getIlosc();
						row[1] = sdsd.getHour();
						
						// add row to the model
						model2.addRow(row);
						}}}
				
						
					
	          
	          /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	        }
	      };
	      actionMap.put(ACTION_KEY, actionListener);
	   add(buttonA);
	   buttonA.setBounds(2000, 10, 1, 1);
		
		
		
		
		
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	   connectItem2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event2) {
				path3=new Open().getPath();
				if (path3!="") {
				File f = new File(path3);
				String cokto=path3.substring(12, 14);
				//JOptionPane.showMessageDialog(null,cokto);
				if(cokto.equals("zp")){
				if(f.exists()){
					Odczytzpc aaa=new Odczytzpc(path3);
						aaa.wczytaj();
						
						//JOptionPane.showMessageDialog(null, "wczytalo ");
						listazpc.addAll(aaa.konwersja());
						
						model.setNumRows(0);
						for (ZPC sdsd:listazpc) {
						if (sdsd.getDzial().equals(dzialy.get(1))) {
						row[0] = sdsd.getName().toUpperCase();
						row[1] = sdsd.getZpname().toUpperCase();
						row[2] = sdsd.getNumber();
						// add row to the model
						model.addRow(row);
						}}}}
				if(cokto.equals("pr")){
				if(f.exists()){
					Odczytpra aaa=new Odczytpra(path3);
						aaa.wczytaj();
						
						//JOptionPane.showMessageDialog(null, "wczytalo ");
						listapra.addAll(aaa.konwersja());
						
						model2.setNumRows(0);
						for (PRA sdsd:listapra) {
						if (sdsd.getDzial().equals(dzialy.get(1))) {
						row[0] = sdsd.getIlosc();
						row[1] = sdsd.getHour();
						
						// add row to the model
						model2.addRow(row);
						}}}}
				
						
					}
			}
		});
		textId2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 37) { //lewo
					textId.requestFocusInWindow();
				    }
				    if (e.getKeyCode() == 38) {//gora
				    	table2.requestFocusInWindow();
				    }
				  
				    if (e.getKeyCode() == 40) {//dol
				    	textFname2.requestFocusInWindow();
				    }
			}

			@Override
			public void keyReleased(KeyEvent arg0) {	
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		textFname.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode() == 38) {//gora
				    	textId.requestFocusInWindow();
				    }
				    if (e.getKeyCode() == 39) { //prawo
				    	textFname2.requestFocusInWindow();
				    }
				    if (e.getKeyCode() == 40) {//dol
				    	textLname.requestFocusInWindow();
				    }
			}

			@Override
			public void keyReleased(KeyEvent arg0) {	
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		textFname2.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode() == 38) {//gora
				    	textId2.requestFocusInWindow();
				    }
				 
				    if (e.getKeyCode() == 37) {//lewo
				    	textFname.requestFocusInWindow();
				    }
			}

			@Override
			public void keyReleased(KeyEvent arg0) {	
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
		
	textId.addKeyListener(new KeyListener() {
			public void keyPressed(KeyEvent e) {
				    if (e.getKeyCode() == 38) {//gora
				    	table.requestFocusInWindow();
				    }
				    if (e.getKeyCode() == 39) { //prawo
				    	textId2.requestFocusInWindow();
				    }
				    if (e.getKeyCode() == 40) {//dol
				    	textFname.requestFocusInWindow();
				    }
			}

			@Override
			public void keyReleased(KeyEvent arg0) {	
			}

			@Override
			public void keyTyped(KeyEvent arg0) {
				
			}
		});
	
	textLname.addKeyListener(new KeyListener() {
		public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode() == 38) {//gora
			    	textFname.requestFocusInWindow();
			    }
			    if (e.getKeyCode() == 39) { //prawo
			    	textFname2.requestFocusInWindow();
			    }
			    
		}

		@Override
		public void keyReleased(KeyEvent arg0) {	
		}

		@Override
		public void keyTyped(KeyEvent arg0) {
			
		}
	});
	
	
	
	
	
	
	
	
	
		// zlecenia//////////////////////////////////////////////////////////////////////////////////
		btnAdd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if (new Checkerzp(textId.getText(), textFname.getText(), textLname.getText()).check()) {
					row[0] = textId.getText().toUpperCase();
					row[1] = textFname.getText().toUpperCase();
					row[2] = textLname.getText();
					// add row to the model
					model.addRow(row);
					listazpc.add(new ZPC(textId.getText().toUpperCase(), textFname.getText().toUpperCase(),Integer.parseInt(textLname.getText()), localdzial));
					try {
					new Save(false, listazpc, listapra, dzialy,aktualnazmiana, path,false,aktualnadata).save();
					} catch (RowsExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BiffException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textId.setText("");
					textFname.setText("");
					textLname.setText("");
					textId.requestFocusInWindow();
				}
			}
		});

		btnAdd2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				double o=0;
				
				if (new Checkerpra(textId2.getText(), textFname2.getText()).check()) {
					row2[0] = Integer.parseInt(textId2.getText());
				    	  Pattern pattern = Pattern.compile("[0-9]{2}:[0-9]{1,2}");
				          Matcher matcher = pattern.matcher(textFname2.getText());     	
				    	if (matcher.matches()) 
				    		o =((double)Integer.parseInt(textFname2.getText().substring(0,2))+Integer.parseInt(textFname2.getText().substring(3))/60.0) ;
				    	 pattern = Pattern.compile("[0-9]{1}:[0-9]{1,2}");
				     matcher = pattern.matcher(textFname2.getText());      	
				    	if (matcher.matches()) 
				    		o =(double)Integer.parseInt(textFname2.getText().substring(0,1))+ (double)(Integer.parseInt(textFname2.getText().substring(2)))/60.0 ;
				    	pattern = Pattern.compile("[0-9]{1,2}");
				    	matcher = pattern.matcher(textFname2.getText());      	
				    	if (matcher.matches()) 
				    		o =(double)Integer.parseInt(textFname2.getText());
				    	 o *= 100; 
				         o = Math.round(o);
				         o /= 100;
				         row2[1]=o;
				    	
					model2.addRow(row2);
		
					listapra.add(new PRA(Integer.parseInt(textId2.getText()),o, localdzial));
					try {
						new Save(false, listazpc, listapra, dzialy, aktualnazmiana, path,false,aktualnadata).save();
					} catch (RowsExceededException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (BiffException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (WriteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textId2.setText("");
					textFname2.setText("");
					textId2.requestFocusInWindow();
				}}});
		// usuwanie zlecenia///////////////////////////////////////////////////////////
		// button remove row
		btnDelete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				
				if (i >= 0) {
					// remove a row from jtable
					
					//setText(model.getValueAt(i, 1).toString());
				ZPC a=new ZPC(model.getValueAt(i, 0).toString(), model.getValueAt(i, 1).toString(),Integer.parseInt(model.getValueAt(i, 2).toString()), localdzial);
				for (int l=0;l<listazpc.size();l++ ) {
					if (listazpc.get(l).equals(a)) {listazpc.remove(l);model.removeRow(i);}
				}
					
					
					
					
					
					
				} else {
					JOptionPane.showMessageDialog(null, "Zaznacz wiersz w tabeli produkty.");
				}try {
					new Save(false, listazpc, listapra, dzialy, aktualnazmiana, path,false,aktualnadata).save();
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int i2 = table2.getSelectedRow();
				if (i2 >= 0) {
					PRA b=new PRA(Integer.parseInt(model2.getValueAt(i2, 0).toString()), Double.parseDouble( model2.getValueAt(i2, 1).toString()), localdzial);
					for (int l=0;l<listapra.size();l++ ) {
						if (listapra.get(l).equals(b)) {listapra.remove(l);model2.removeRow(i2);;}
					}
					
				} else {

					JOptionPane.showMessageDialog(null, "Zaznacz wiersz w tabeli pracownicy.");
				}try {
					new Save(false, listazpc, listapra, dzialy, aktualnazmiana, path,false,aktualnadata).save();
				} catch (RowsExceededException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (BiffException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WriteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
		});
		// get selected row data From table to textfields
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				textId.setText("");
				textFname.setText("");
				textLname.setText("");
			}
		});
		// get selected row data From table to textfields
		table2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i2 = table2.getSelectedRow();
				textId2.setText("");
				textFname2.setText("");
			}
		});
	}

	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		localdzial=command;
		//JOptionPane.showMessageDialog(null, command);
		
		model.setNumRows(0);
		model2.setNumRows(0);
		for (int l=0;l<listazpc.size();l++ ) {
			if (listazpc.get(l).getDzial().equals(localdzial)) {
				row[0] = listazpc.get(l).getName().toUpperCase();
				row[1] = listazpc.get(l).getZpname().toUpperCase();
				row[2] = listazpc.get(l).getNumber();
				model.addRow(row);}
		}
		for (int l=0;l<listapra.size();l++ ) {
			if (listapra.get(l).getDzial().equals(localdzial)) {
				row2[0] = listapra.get(l).getIlosc();
				row2[1] = listapra.get(l).getHour();
				model2.addRow(row2);}
		}
		
		
		
		
		
		
		//JRadioButton source = (JRadioButton) event.getSource();
		// source.setEnabled(false);

	}

	private void outputSelection() {
		output.append(String.format("Lead: %d, %d. ", table.getSelectionModel().getLeadSelectionIndex(),
				table.getColumnModel().getSelectionModel().getLeadSelectionIndex()));
		output.append("Rows:");
		for (int c : table.getSelectedRows()) {
			output.append(String.format(" %d", c));
		}
		output.append(". Columns:");
		for (int c : table.getSelectedColumns()) {
			output.append(String.format(" %d", c));
		}
		output.append(".\n");
	}

	private class RowListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent event) {
			if (event.getValueIsAdjusting()) {
				return;
			}
			output.append("ROW SELECTION EVENT. ");
			outputSelection();
		}
	}
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				final JFrame frame2 = new JFrame("KPI DATA");
				JLabel jlbPassword2 = new JLabel("Wybierz zmiane: ");
				

 combo = new JComboBox<>(combot);

//add to the parent container (e.g. a JFrame):


//get the selected item:
 JButton btnAdd = new JButton("Dodaj produkt");
				JLabel jlbPassword = new JLabel("Ustaw date: ");
				JButton jpwName = new JButton("OK");
				JXDatePicker picker = new JXDatePicker();
		        picker.setDate(Calendar.getInstance().getTime());
		        picker.setFormats(new SimpleDateFormat("dd.MM.yyyy"));
				jpwName.addActionListener(
						new ActionListener() {			public void actionPerformed(ActionEvent e) {
						
						
							if ((String) combo.getSelectedItem()==combot[0]) {
								setAktualnazmiana("A");}
									if ((String) combo.getSelectedItem()==combot[1]) {
										setAktualnazmiana("B");}
									if ((String) combo.getSelectedItem()==combot[2]) {
										setAktualnazmiana("C");}
									
									 setAktualnadata(picker.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
							
							
							
							
							frame2.setVisible(false);
							try {
								createAndShowGUI();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						 
					}
				});
				JPanel jplContentPane = new JPanel(new GridLayout(3,3));
				jplContentPane.setBorder(BorderFactory.createEmptyBorder(30, 35,
						20, 20));
				jplContentPane.add(jlbPassword2);
				jplContentPane.add(combo);
				jplContentPane.add(jlbPassword);
				jplContentPane.add(picker);
				jplContentPane.add(jpwName);
			
				
		        
		       
				
				
				frame2.setContentPane(jplContentPane);
				frame2.addWindowListener(new WindowAdapter() {

					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}
				});
				frame2.pack();
				frame2.setVisible(true);
			}
		});
	}
	

	
	public static void setAktualnazmiana(String aktual) {
		aktualnazmiana = aktual;
	}

	private static void createAndShowGUI() throws IOException {
		UIManager.put("swing.boldMetal", Boolean.FALSE);
		JFrame frame = new JFrame("Dane produkcyjne KPI. "+"Zmiana : "+aktualnazmiana+" z dnia: "+ aktualnadata);

		frame.setSize(1000, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.requestFocusInWindow();
	
		frame.setVisible(true);

		//new TableSelectionDemo();
		// newContentPane.setOpaque(true);
		frame.setContentPane(new TableSelectionDemo());

		frame.setVisible(true);
	
		
	}


	

	
	public static LocalDate getAktualnadata() {
		return aktualnadata;
	}

	public static void setAktualnadata(LocalDate aktualnadata) {
		TableSelectionDemo.aktualnadata = aktualnadata;
		
	}

	class ConnectAction1 implements ActionListener {
		
		public void actionPerformed(ActionEvent event) {
			if (new Checkerall(listazpc,listapra,dzialy).check()) {try {
				 if (new Testowa().check(path2)) {
				new Save(true, listazpc, listapra, dzialy, aktualnazmiana, path2,true,aktualnadata).save();}
			
				new Save(true, listazpc, listapra, dzialy, aktualnazmiana, "c:\\temp\\raports",false,aktualnadata).save();
				//JOptionPane.showMessageDialog(null, "Raport zapisano. ");
			} catch (RowsExceededException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (WriteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
			}

		}

	}
class ConnectAction2 implements ActionListener {
		
		public void actionPerformed(ActionEvent event2) {
		
		

		}

	}
}

      
  

