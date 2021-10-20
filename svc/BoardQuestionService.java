package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardQuestion;

public class BoardQuestionService {
	
	/*문의게시판등록*/
	//MemberBoardQuestionInsertProAction
	public boolean insertBoardQuestion(BoardQuestion boardQuestion, String id, String fileName) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int insertCount = boardDAO.insertBoardQuestion(boardQuestion, id, fileName);
		
		boolean isInsertSuccess = false;
		if(insertCount > 0) {
			commit(con);
			isInsertSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return isInsertSuccess;
	}
	
	/*문의 게시판 페이지 뷰*/
	//BoardQuestionViewAction
	public ArrayList<BoardQuestion> getPageBoardQuestion(int page, int limit) throws Exception{

		ArrayList<BoardQuestion> boardQuestionPageList = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		boardQuestionPageList = boardDAO.getPageBoardQuestion(page, limit);
		close(con);
		return boardQuestionPageList;
	}
	
	/*문의글 상세보기*/	
	public BoardQuestion getDetailBoardQuestion(int board_num) throws Exception{

		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);

		BoardQuestion boardQuestion = boardDAO.getDetailBoardQuestion(board_num);
		close(con);
		return boardQuestion;
	}
	
	/*답변글 등록폼*/
	//AdminQuestionInsertFromAction
	public BoardQuestion getAdminQuestionForm(int board_num) throws Exception{
		BoardQuestion boardQuestion = null;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);

		boardQuestion = boardDAO.getAdminQuestionForm(board_num);
		close(con);
		return boardQuestion;
	}
	
	/*답변글 등록*/
	//AdminQuestionInsertProAction
	public boolean adminQuestionInsert(BoardQuestion boardQuestion, String id, String q_choice, String board_choice) throws Exception{
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int insertCount = boardDAO.adminQuestionInsert(boardQuestion, id, q_choice, board_choice);
		boolean isInsertSuccess = false;
		if(insertCount > 0) {
			commit(con);
			isInsertSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return isInsertSuccess;
		
	}
	
	//AdminQuestionDeleteProAction
	public boolean deleteBoard(int board_num) throws Exception{
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int deleteCount = boardDAO.deleteBoard(board_num);
		boolean isDeleteSuccess = false;
		if(deleteCount > 0) {
			commit(con);
			isDeleteSuccess = true;
		}else {
			rollback(con);
		}
		close(con);
		
		return isDeleteSuccess;
		
	}
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		listCount = boardDAO.selectListCount();
	
		close(con);
		
		return listCount;
	}
	//BoardQuestionDetailAction
	public BoardQuestion getBoardQuestionList(int board_num) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);

		BoardQuestion boardQuestion = boardDAO.getBoardQuestionList(board_num);
		
		close(con);
		
		return boardQuestion;
		
	}
	
	
}
