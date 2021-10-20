package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import static db.Jdbcutil.*;

import vo.BoardNotice;
import vo.BoardQuestion;
import vo.Member;

public class BoardDAO {
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	String sql = "";
	private static BoardDAO boardDAO;
	
	public static BoardDAO getInstance() {
		if(boardDAO == null) {
			boardDAO = new BoardDAO();
		}
		
		return boardDAO;
	}
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	/*문의글 등록*/
	public int insertBoardQuestion(BoardQuestion boardQuestion, String id, String fileName) {
		int board_num=0;
		int insertCount = 0;
		try {
			pstmt = con.prepareStatement("select IFNULL(max(board_num),0)+1 from board_question");
			rs = pstmt.executeQuery();
			
			if(rs.next()) board_num = rs.getInt(1);
			
			sql = "insert into board_question values(?,?,?,?,?,?,?,?,?,now(),?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, board_num);
			pstmt.setString(2, boardQuestion.getBoard_choice());
			pstmt.setString(3, boardQuestion.getQ_choice());
			pstmt.setString(4, boardQuestion.getBoard_subject());
			pstmt.setString(5, boardQuestion.getBoard_content());
			pstmt.setString(6, fileName);
			pstmt.setInt(7, board_num);
			pstmt.setInt(8, 0);
			pstmt.setInt(9, 0);
			pstmt.setString(10, id);
			
			insertCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("insertBoardQuestion 오류: "+e);
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	/*문의게시판 글전체 보기*/
	public ArrayList<BoardQuestion> getPageBoardQuestion(int page,int limit) {
		sql = "select * from board_question order by board_re desc, board_re_seq asc limit ?,10";
		ArrayList<BoardQuestion> boardQuestionPageList = new ArrayList<BoardQuestion>();
		BoardQuestion boardQuestion = null;
		int startrow = (page-1)*10;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
					boardQuestion = new BoardQuestion();
					
					boardQuestion.setBoard_num(rs.getInt("board_num"));
					boardQuestion.setId(rs.getString("id"));
					boardQuestion.setBoard_choice(rs.getString("board_choice"));
					boardQuestion.setQ_choice(rs.getString("q_choice"));
					boardQuestion.setBoard_subject(rs.getString("board_subject"));
					boardQuestion.setBoard_content(rs.getString("board_content"));
					boardQuestion.setBoard_file(rs.getString("board_file"));
					boardQuestion.setBoard_re(rs.getInt("board_re"));
					boardQuestion.setBoard_re_loc(rs.getInt("board_re_loc"));
					boardQuestion.setBoard_re_seq(rs.getInt("board_re_seq"));
					boardQuestion.setBoard_date(rs.getString("board_date"));
					
					boardQuestionPageList.add(boardQuestion);
				}
		}catch(Exception e) {
			System.out.println("getInfoBoardQuestion 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardQuestionPageList;
	}
	
	/*문의글 상세보기 */
	public BoardQuestion getDetailBoardQuestion(int board_num) {
		sql = "select board_num, id, board_choice, q_choice, board_subject, board_content, board_file, board_re,board_re_loc, board_re_seq,board_date from board_question where board_num=?";
		BoardQuestion boardQuestion = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
					boardQuestion = new BoardQuestion();
					boardQuestion.setBoard_num(rs.getInt("board_num"));
					boardQuestion.setId(rs.getString("id"));
					boardQuestion.setBoard_choice(rs.getString("board_choice"));
					boardQuestion.setQ_choice(rs.getString("q_choice"));
					boardQuestion.setBoard_subject(rs.getString("board_subject"));
					boardQuestion.setBoard_content(rs.getString("board_content"));
					boardQuestion.setBoard_re(rs.getInt("board_re"));
					boardQuestion.setBoard_re_loc(rs.getInt("board_re_loc"));
					boardQuestion.setBoard_re_seq(rs.getInt("board_re_seq"));
					boardQuestion.setBoard_file(rs.getString("board_file"));
					boardQuestion.setBoard_date(rs.getString("board_date"));
			}
		}catch(Exception e) {
			System.out.println("getDetailBoardQuestion 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardQuestion;
		
	}
	/*답변글 등록 폼 요청*/
	public BoardQuestion getAdminQuestionForm(int board_num) {
		sql = "select * from board_question where board_num=? ";
		BoardQuestion boardQuestion = null;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
					boardQuestion = new BoardQuestion();
					boardQuestion.setBoard_num(rs.getInt("board_num"));
					boardQuestion.setId(rs.getString("id"));
					boardQuestion.setBoard_choice(rs.getString("board_choice"));
					boardQuestion.setQ_choice(rs.getString("q_choice"));
					boardQuestion.setBoard_subject(rs.getString("board_subject"));
					boardQuestion.setBoard_content(rs.getString("board_content"));
					boardQuestion.setBoard_file(rs.getString("board_file"));
					boardQuestion.setBoard_re(rs.getInt("board_re"));
					boardQuestion.setBoard_re_loc(rs.getInt("board_re_loc"));
					boardQuestion.setBoard_re_seq(rs.getInt("board_re_seq"));
					boardQuestion.setBoard_date(rs.getString("board_date"));
			}
		}catch(Exception e) {
			System.out.println("getAdminQuestionForm 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardQuestion;
	}
	/*관리자 답변등록*/
	public int adminQuestionInsert(BoardQuestion boardQuestion, String id, String q_choice, String board_choice) {
		sql = "select max(board_num)+1 from board_question";
		int result=0;
		int board_num=0;
		int insertCount = 0;
		int updateCount=0;
		int board_re = boardQuestion.getBoard_re();
		int board_re_loc = boardQuestion.getBoard_re_loc();
		int board_re_seq = boardQuestion.getBoard_re_seq();
		
		
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) board_num = rs.getInt(1);
			sql = "update board_question set board_re_seq=board_re_seq+1 where board_re=? and board_re_seq > ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_re);
			pstmt.setInt(2, board_re_seq);
			
			updateCount = pstmt.executeUpdate();
			System.out.println("수정 : "+updateCount);

			}catch(Exception e) {
				System.out.println("updateadminQuestionInsert 오류 :"+e);
			}
		
			try {
				
			board_re_loc = board_re_loc +1;
			board_re_seq = board_re_seq+1;
			
			sql = "insert into board_question(board_num, id, board_choice, q_choice, board_subject, board_content, board_file, board_re, board_re_loc, board_re_seq, board_date) values(?,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, id);
			pstmt.setString(3, board_choice);
			pstmt.setString(4, q_choice);
			pstmt.setString(5, boardQuestion.getBoard_subject());
			pstmt.setString(6, boardQuestion.getBoard_content());
			pstmt.setString(7, "");
			pstmt.setInt(8, board_re);
			pstmt.setInt(9, board_re_loc);
			pstmt.setInt(10, board_re_seq);
			
			insertCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("adminQuestionInsert 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		System.out.println("등록 : "+insertCount);
		
		if(updateCount >= 0 && insertCount > 0) {
			result=1;
		}
		
		return result;
	}
	/*문의글 삭제*/
	
	public int deleteBoard(int board_num) {
		
		sql="delete from board_question where board_num=? or board_re=?";
		
		int deleteCount =0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setInt(2, board_num);
			deleteCount = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("deleteBoard 오류"+ e);
		}finally {
			close(pstmt);
			close(rs);
		}
				
		
				
		return deleteCount;
	}

	public int selectListCount() {
		
		int listCount = 0;
		sql = "select count(*) from board_question";
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		}catch(Exception e) {
			System.out.println("selectListCount 오류"+e);
		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	public BoardQuestion getBoardQuestionList(int board_num) {
		BoardQuestion boardQuestion = new BoardQuestion();
		System.out.println(board_num);
		

		try {
			
			sql = "select * from board_question where board_num=?+1 and board_re=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setInt(2, board_num);
			rs=pstmt.executeQuery();
			
			
			if(rs.next()) {
					
					boardQuestion.setBoard_num(rs.getInt("board_num"));
					boardQuestion.setId(rs.getString("id"));
					boardQuestion.setBoard_choice(rs.getString("board_choice"));
					boardQuestion.setQ_choice(rs.getString("q_choice"));
					boardQuestion.setBoard_subject(rs.getString("board_subject"));
					boardQuestion.setBoard_content(rs.getString("board_content"));
					boardQuestion.setBoard_file(rs.getString("board_file"));
					boardQuestion.setBoard_re(rs.getInt("board_re"));
					boardQuestion.setBoard_re_loc(rs.getInt("board_re_loc"));
					boardQuestion.setBoard_re_seq(rs.getInt("board_re_seq"));
					boardQuestion.setBoard_date(rs.getString("board_date"));
			}
		}catch(Exception e) {
			System.out.println("getBoardQuestionList 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return boardQuestion;
	}

	public int insertBoardNotice(BoardNotice boardNotice, String id, String fileName) {
		int insertCount = 0;
		int Notice_num = 0;
		sql="select IFNULL(max(Notice_num),0)+1 from Notice";
		
		
		try {
			pstmt = con.prepareStatement(sql);
			rs= pstmt.executeQuery();
			
			if(rs.next()) Notice_num = rs.getInt(1);
			
			sql="insert into Notice values(?,?,?,?,now(),?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Notice_num);
			pstmt.setString(2, boardNotice.getNotice_title());
			pstmt.setString(3, boardNotice.getNotice_contents());
			pstmt.setInt(4, boardNotice.getNotice_readcount());
			pstmt.setString(5, fileName);
			pstmt.setString(6, id);
			
			 insertCount = pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			System.out.println("getBoardQuestionList 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		return insertCount;
	}

	public int selectNoticeListCount() {
		int listCount = 0;
		sql = "select count(*) from Notice";
		try {
			pstmt=con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
			
		}catch(Exception e) {
			System.out.println("selectNoticeListCount 오류"+e);
		}finally{
			close(rs);
			close(pstmt);
		}

		return listCount;

	}

	public ArrayList<BoardNotice> getPageBoardNotice(int page, int limit) {
		sql = "select * from Notice order by Notice_num desc limit ?,10";
		ArrayList<BoardNotice> boardNoticeList = new ArrayList<BoardNotice>();
		BoardNotice boardNotice = null;
		int startrow = (page-1)*10;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startrow);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
			 		do{
				boardNotice = new BoardNotice();
					
					boardNotice.setNotice_num(rs.getInt("Notice_num"));
					boardNotice.setNotice_title(rs.getString("Notice_title"));
					boardNotice.setNotice_contents(rs.getString("Notice_contents"));
					boardNotice.setNotice_readcount(rs.getInt("Notice_readcount"));
					boardNotice.setNotice_date(rs.getString("Notice_date"));
					boardNotice.setNotice_file(rs.getString("Notice_file"));
					boardNotice.setId(rs.getString("id"));
					
					boardNoticeList.add(boardNotice);
				}while(rs.next());
			}
		}catch(Exception e) {
			System.out.println("getPageBoardNotice 오류 :"+e);
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return boardNoticeList;
	}

	public BoardNotice getSelectDeatil(int notice_num) {
		BoardNotice boardNotice = null;
		sql = "select * from Notice where Notice_num=?";
		
		try{
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				boardNotice = new BoardNotice();
				boardNotice.setNotice_num(rs.getInt("Notice_num"));
				boardNotice.setNotice_title(rs.getString("Notice_title"));
				boardNotice.setNotice_contents(rs.getString("Notice_contents"));
				boardNotice.setNotice_readcount(rs.getInt("Notice_readcount"));
				boardNotice.setNotice_date(rs.getString("Notice_date"));
				boardNotice.setNotice_file(rs.getString("Notice_file"));
				boardNotice.setId(rs.getString("id"));
				
			}
			
		}catch(Exception e) {
			System.out.println("getSelectDeatil 오류 " + e);
		}finally{
			close(rs);
			close(pstmt);
		}
		
		return boardNotice;
	}

	public int readCount(int notice_num) {
		int readCount = 0;
		sql = "update Notice set Notice_readcount= Notice_readcount+1 where Notice_num =?";
		try{
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			readCount = pstmt.executeUpdate();
		}catch(Exception e){
			System.out.println("readCount 오류 "+e);
		}
		finally{
			close(pstmt);

		}

		return readCount;
		
	}

	public int deleteBoardNotice(int notice_num) {
	sql="delete from Notice where Notice_num=?";
		
		int deleteCount =0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			deleteCount = pstmt.executeUpdate();
					
		}catch(Exception e) {
			System.out.println("deleteBoardNotice 오류"+ e);
		}finally {
			close(pstmt);
			close(rs);
		}
				
		return deleteCount;
	}

	public int updateNotice(BoardNotice boardNotice, int Notice_num, String Notice_title, String Notice_contents) {
		int updateCount = 0;
		try {
			
			sql = "update Notice set Notice_title=?,Notice_contents=? where Notice_num=? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Notice_title);
			pstmt.setString(2, Notice_contents);
			pstmt.setInt(3, Notice_num);
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("updateNotice 오류"+ e);
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return updateCount;
	}

	public BoardNotice getUpdateList(int notice_num) {
		BoardNotice boardNotice = null;
		
		sql="select * from Notice where Notice_num=?";
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				boardNotice = new BoardNotice();
				boardNotice.setNotice_num(rs.getInt("Notice_num"));
				boardNotice.setNotice_title(rs.getString("Notice_title"));
				boardNotice.setNotice_contents(rs.getString("Notice_contents"));
				boardNotice.setNotice_readcount(rs.getInt("Notice_readcount"));
				boardNotice.setNotice_date(rs.getString("Notice_date"));
				boardNotice.setNotice_file(rs.getString("Notice_file"));
				boardNotice.setId(rs.getString("id"));
			}
			
			
		}catch(Exception e) {
			System.out.println("updateNoticeList 오류"+ e);
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return boardNotice;
	}

	public int UpdateFile(String file, int notice_num) {
		
		int updateCount = 0;
		try {
			
			sql = "update Notice set Notice_file=? where Notice_num=?";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, file);
			pstmt.setInt(2, notice_num);
			updateCount = pstmt.executeUpdate();
			
		}catch(Exception e) {
			System.out.println("UpdateFile 오류"+ e);
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return updateCount;
		
	}

	public BoardNotice getBoardNotice(int notice_num) {
		BoardNotice boardNotice = null;
		try {
			sql = "select * from Notice where Notice_num=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, notice_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				boardNotice = new BoardNotice();
				boardNotice.setNotice_num(rs.getInt("Notice_num"));
				boardNotice.setNotice_title(rs.getString("Notice_title"));
				boardNotice.setNotice_contents(rs.getString("Notice_contents"));
				boardNotice.setNotice_readcount(rs.getInt("Notice_readcount"));
				boardNotice.setNotice_date(rs.getString("Notice_date"));
				boardNotice.setNotice_file(rs.getString("Notice_file"));
				boardNotice.setId(rs.getString("id"));
			}
			
			
		}catch(Exception e) {
			System.out.println("getBoardNotice 오류"+ e);
		}finally {
			close(pstmt);
			close(rs);
		}
		
		return boardNotice;
	}	
	
}
