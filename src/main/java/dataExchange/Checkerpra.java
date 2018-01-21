package dataExchange;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

public class Checkerpra {
	private String ile;
	private String czas;
	private String dzname;

	public Checkerpra(String ile, String czas) {
		this.ile = ile;
		this.czas = czas;
		this.dzname = "";
	}

	public Checkerpra(String text, String text2, String string) {
		this.ile = text;
		this.czas = text2;
		this.dzname = string;// TODO Auto-generated constructor stub
	}

	public String getIle() {
		return ile;
	}

	public void setIle(String ile) {
		this.ile = ile;
	}

	public String getCzas() {
		return czas;
	}

	public void setCzas(String czas) {
		this.czas = czas;
	}

	public void setMesage(String mesege) {
		this.dzname = mesege;
	}

	public boolean check() {

		try {
			int liczba = Integer.parseInt(this.ile);
			if (liczba <= 0) {
				JOptionPane.showMessageDialog(null, "Blednie wpisana ilosc procownikow. ");
				return false;
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Blednie wpisana ilosc procownikow. ");
			return false;
		}

		try {
			int liczba = Integer.parseInt(this.czas);
			if (liczba <= 0) {
				JOptionPane.showMessageDialog(null, "Blednie wpisany czas. ");
				return false;
			}
		} catch (NumberFormatException e) {
			Pattern pattern = Pattern.compile("[0-9]{1,2}:[0-5][0-9]");
			Matcher matcher = pattern.matcher(this.czas);

			if (!matcher.matches()) {
				JOptionPane.showMessageDialog(null, "Blednie wpisany czas.Poprawny format  godziny : minuty. ");
				return false;
			}

		}

		return true;

	}

}
