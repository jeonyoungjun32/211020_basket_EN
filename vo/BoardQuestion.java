package vo;

public class BoardQuestion {
	private int board_num;
	private String id;
	private String board_choice;
	private String q_choice;
	private String board_subject;
	private String board_content;
	private String board_file;
	private int board_re;
	private int board_re_loc;
	private int board_re_seq;
	private String board_date;
	
	public BoardQuestion() {}

	public BoardQuestion(int board_num, String id, String board_choice, String q_choice, String board_subject,
			String board_content, String board_file, int board_re, int board_re_loc, int board_re_seq,String board_date) {
		super();
		this.board_num = board_num;
		this.id = id;
		this.board_choice = board_choice;
		this.q_choice = q_choice;
		this.board_subject = board_subject;
		this.board_content = board_content;
		this.board_file = board_file;
		this.board_re = board_re;
		this.board_re_loc = board_re_loc;
		this.board_re_seq = board_re_seq;
		this.board_date = board_date;
	}

	
	public int getBoard_re_seq() {
		return board_re_seq;
	}

	public void setBoard_re_seq(int board_re_seq) {
		this.board_re_seq = board_re_seq;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBoard_choice() {
		return board_choice;
	}

	public void setBoard_choice(String board_choice) {
		this.board_choice = board_choice;
	}

	public String getQ_choice() {
		return q_choice;
	}

	public void setQ_choice(String q_choice) {
		this.q_choice = q_choice;
	}

	public String getBoard_subject() {
		return board_subject;
	}

	public void setBoard_subject(String board_subject) {
		this.board_subject = board_subject;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_file() {
		return board_file;
	}

	public void setBoard_file(String board_file) {
		this.board_file = board_file;
	}

	public int getBoard_re() {
		return board_re;
	}

	public void setBoard_re(int board_re) {
		this.board_re = board_re;
	}

	public int getBoard_re_loc() {
		return board_re_loc;
	}

	public void setBoard_re_loc(int board_re_loc) {
		this.board_re_loc = board_re_loc;
	}

	public String getBoard_date() {
		return board_date;
	}

	public void setBoard_date(String board_date) {
		this.board_date = board_date;
	}

		
}
