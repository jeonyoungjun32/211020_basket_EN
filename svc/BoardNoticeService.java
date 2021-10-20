package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.BoardDAO;
import vo.BoardNotice;

public class BoardNoticeService {

	//BoardNoticeInsertProAction
	public boolean insertBoardNotice(BoardNotice boardNotice , String id, String fileName) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int insertCount = boardDAO.insertBoardNotice(boardNotice, id, fileName);
		
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

	//BoardNoticeListAction
	public int getListCount() throws Exception {
		int listCount = 0;
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		listCount = boardDAO.selectNoticeListCount();
	
		close(con);
		
		return listCount;
	}

	//BoardNoticeListAction
	public ArrayList<BoardNotice> getBoardNoticeList(int page, int limit) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		ArrayList<BoardNotice> boardNoticeList = boardDAO.getPageBoardNotice(page,limit);
		
		close(con);
		
		return boardNoticeList;
	}

	//BoardNoticeDetailProAction
	public BoardNotice getNoticeDetail(int notice_num) throws Exception {
		
		BoardNotice boardNotice = null;
		
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int readCount = boardDAO.readCount(notice_num);
		
		if(readCount > 0) {
			commit(con);
		}else {
			rollback(con);
		}

		boardNotice = boardDAO.getSelectDeatil(notice_num);
		
		close(con);
		
		return boardNotice;
	}

	//BoardNoticeDeleteProAction
	public boolean deleteBoardNotice(int notice_num) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int deleteCount = boardDAO.deleteBoardNotice(notice_num);
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

	//BoardNoticeUpdateProAction
	public boolean UpdateNotice(BoardNotice boardNotice, int Notice_num, String Notice_title, String Notice_contents) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		boolean isUpdateSuccess = false;
		
		int updateCount = boardDAO.updateNotice(boardNotice,Notice_num,Notice_title,Notice_contents);
		
		if(updateCount > 0){
			commit(con);
			isUpdateSuccess=true;
		}
		else{
			rollback(con);
		}
		
		close(con);
		
		return isUpdateSuccess;
	}

	//BoardNoticeUpdateFormAction
	public BoardNotice UpdateList(int notice_num) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardNotice boardNotice = boardDAO.getUpdateList(notice_num);
		
		close(con);
		
		return boardNotice;
	}

	//BoardFileUpdateProAction
	public boolean UpdateFile(String file, int notice_num) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		int boardNotice = boardDAO.UpdateFile(file,notice_num);
		
		boolean UpdateSuccess = false;
		if(boardNotice > 0) {
			commit(con);
			UpdateSuccess = true;
		}
		else {
			rollback(con);
		}
		
		close(con);
		
		return UpdateSuccess;
	}

	//BoardFileUpdateFormAction
	public BoardNotice getBoardNotice(int notice_num) throws Exception {
		Connection con = getConnection();
		BoardDAO boardDAO = BoardDAO.getInstance();
		boardDAO.setConnection(con);
		
		BoardNotice boardNotice = boardDAO.getBoardNotice(notice_num);
		
		close(con);
		
		return boardNotice;
	}
	
}
