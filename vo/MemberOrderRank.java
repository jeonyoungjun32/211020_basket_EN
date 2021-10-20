package vo;

public class MemberOrderRank {
	
	private String name;
	private int serial_code;
	
	public MemberOrderRank() {}

	public MemberOrderRank(String name, int serial_code) {
		super();
		this.name = name;
		this.serial_code = serial_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSerial_code() {
		return serial_code;
	}

	public void setSerial_code(int serial_code) {
		this.serial_code = serial_code;
	}
	
}
