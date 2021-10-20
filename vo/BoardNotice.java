package vo;

public class BoardNotice {

	private int Notice_num;
	private String Notice_title;
	private String Notice_contents;
	private int Notice_readcount;
	private String Notice_date;
	private String Notice_file;
	private String id;
	
	public BoardNotice () {}
	
	

	public BoardNotice(int notice_num, String notice_title, String notice_contents, int notice_readcount,
			String notice_date, String notice_file, String id) {
		super();
		Notice_num = notice_num;
		Notice_title = notice_title;
		Notice_contents = notice_contents;
		Notice_readcount = notice_readcount;
		Notice_date = notice_date;
		Notice_file = notice_file;
		this.id = id;
	}



	public int getNotice_num() {
		return Notice_num;
	}



	public void setNotice_num(int notice_num) {
		Notice_num = notice_num;
	}



	public String getNotice_title() {
		return Notice_title;
	}



	public void setNotice_title(String notice_title) {
		Notice_title = notice_title;
	}



	public String getNotice_contents() {
		return Notice_contents;
	}



	public void setNotice_contents(String notice_contents) {
		Notice_contents = notice_contents;
	}



	public int getNotice_readcount() {
		return Notice_readcount;
	}



	public void setNotice_readcount(int notice_readcount) {
		Notice_readcount = notice_readcount;
	}



	public String getNotice_date() {
		return Notice_date;
	}



	public void setNotice_date(String notice_date) {
		Notice_date = notice_date;
	}



	public String getNotice_file() {
		return Notice_file;
	}



	public void setNotice_file(String notice_file) {
		Notice_file = notice_file;
	}



	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	}
