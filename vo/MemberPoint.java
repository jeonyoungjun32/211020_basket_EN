package vo;

public class MemberPoint {
	private int point_number;
	private int point;
	private String point_status;
	private String point_date;
	private String id;
	private int serial_code;
	
	private String name;
	
	public MemberPoint() {}

	public MemberPoint(int point_number, int point, String point_status, String point_date, String id,
			int serial_code) {
		super();
		this.point_number = point_number;
		this.point = point;
		this.point_status = point_status;
		this.point_date = point_date;
		this.id = id;
		this.serial_code = serial_code;
	}

	public int getPoint_number() {
		return point_number;
	}

	public void setPoint_number(int point_number) {
		this.point_number = point_number;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getPoint_status() {
		return point_status;
	}

	public void setPoint_status(String point_status) {
		this.point_status = point_status;
	}

	public String getPoint_date() {
		return point_date;
	}

	public void setPoint_date(String point_date) {
		this.point_date = point_date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getSerial_code() {
		return serial_code;
	}

	public void setSerial_code(int serial_code) {
		this.serial_code = serial_code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
}
