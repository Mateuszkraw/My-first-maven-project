package dataExchange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Checkerzp {
	private String name;
	private String zpname;
	private String number;

	public Checkerzp(String name, String zpname, String number) {
		super();
		this.name = name;
		this.zpname = zpname;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getZpname() {
		return zpname;
	}

	public void setZpname(String zpname) {
		this.zpname = zpname;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean check() {

		try {
			int liczba = Integer.parseInt(this.number);

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Blednie wpisana ilosc produktow.");
			return false;
		}

		Pattern pattern = Pattern.compile(".{2,9}");
		this.name = this.name.toUpperCase();
		Matcher matcher = pattern.matcher(this.name);

		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(null, "Bledne wpisane nazwa produktu.");
			return false;
		}

		pattern = Pattern.compile("ZP[0-9]{5}");
		this.zpname = this.zpname.toUpperCase();
		matcher = pattern.matcher(this.zpname);

		if (!matcher.matches()) {
			JOptionPane.showMessageDialog(null, "Bledne wpisane pole zlecenia.");
			return false;
		}

		return true;

	}

}
