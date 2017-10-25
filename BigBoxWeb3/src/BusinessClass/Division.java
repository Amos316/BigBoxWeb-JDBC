package BusinessClass;

import java.io.Serializable;

public class Division extends Facility implements Serializable {

	// private Facility facility;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String divNum;

	public Division() {
		super();
		divNum = " ";
	}

	public Division(int id, String divNum, String inFacName, String inFacAddress, String inFacCity, String inFacState,
			String inFacZip) {
		super();
		setId(id);
		setDivNum(divNum);
		setName(inFacName);
		setAddress(inFacAddress);
		setCity(inFacCity);
		setState(inFacState);
		setZip(inFacZip);
	}

	public Division(String d) {
		setDivNum(d);
	}

	public String getDivNum() {
		return divNum;
	}

	public void setDivNum(String divNum) {
		this.divNum = divNum;
	}
	@Override
	public String toString() {
		return ("Division:  [Div#: "+ getDivNum() + "]\n" + super.toString());
	}
	}
