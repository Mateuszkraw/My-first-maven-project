package dataExchange;

public class ZPC {
	@Override
	public String toString() {
		return  name + "," + zpname + "," + number + "," + dzname ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dzname == null) ? 0 : dzname.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		result = prime * result + ((zpname == null) ? 0 : zpname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ZPC other = (ZPC) obj;
		if (dzname == null) {
			if (other.dzname != null)
				return false;
		} else if (!dzname.equals(other.dzname))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		if (zpname == null) {
			if (other.zpname != null)
				return false;
		} else if (!zpname.equals(other.zpname))
			return false;
		return true;
	}

	private String name;
	private String zpname;
	private int number;
	private String dzname;

	public ZPC(String name, String zpname, int number,String dzname) {
		this.name = name;
		this.zpname = zpname;
		this.number = number;
		this.dzname = dzname;
	}

	public String getDzial() {
		return dzname;
	}

	public void setDzial(String dzial) {
		this.dzname = dzial;
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

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
