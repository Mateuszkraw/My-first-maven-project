package dataExchange;

public class PRA {


	@Override
	public String toString() {
		return  ilosc + "," + hour + "," + dzname;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PRA other = (PRA) obj;
		if (dzname == null) {
			if (other.dzname != null)
				return false;
		} else if (!dzname.equals(other.dzname))
			return false;
		if (Double.doubleToLongBits(hour) != Double.doubleToLongBits(other.hour))
			return false;
		if (ilosc != other.ilosc)
			return false;
		return true;
	}

	private int ilosc;
	private double hour;
	private String dzname;

	public int getIlosc() {
		return ilosc;
	}

	public void setIlosc(int ilosc) {
		this.ilosc = ilosc;
	}

	public double getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}



	public String getDzial() {
		return dzname;
	}

	public void setDzial(String min) {
		this.dzname = min;
	}

	public PRA(int ilosc, double o,String dzname) {
		super();
		this.ilosc = ilosc;
		this.hour = o;
		
		this.dzname=dzname;
	}

}
