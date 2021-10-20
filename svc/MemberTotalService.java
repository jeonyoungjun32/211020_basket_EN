package svc;

import static db.Jdbcutil.*;

import java.sql.Connection;
import java.util.ArrayList;

import dao.MyPageDAO;
import vo.Member;
import vo.MemberPoint;

public class MemberTotalService {
	
	//MemberMypageMoneyProAction : 돈 충전
	public boolean setMoney(String money, String id) throws Exception {
		
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int MemberSetMoneyCount = myPageDAO.MemberSetMoney(money, id);
		
		boolean MemeberSetMoneySuccess = false;
		if(MemberSetMoneyCount> 0) {
			commit(con);
			MemeberSetMoneySuccess = true;
		} else {
			rollback(con);
		}
		close(con);
		
		return MemeberSetMoneySuccess;
	}

	//AdminOrderCancelProAction : 환불후 정보 새로고침
	//MemberMypageMoneyProAction : 돈 충전 한 아이디정보를 새로고침을 통해 member에 다시 담기위한 서비스
	public Member setMember(String id) throws Exception {
		
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		Member member = myPageDAO.MemberSelect(id);
		
		close(con);
		
		return member;
	}

	//MemberPointProAction : 내 포인트 리스트 뽑기
	//AdminPointProAction
	public ArrayList<MemberPoint> getMyPointList(int page, String id) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<MemberPoint> memberPointList = myPageDAO.getMyPointList(page, id);
		
		close(con);
		
		return memberPointList;
	}

	//MemberPointProAction
	//AdminPointProAction
	public int getMyPointCount(String id) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int memberPointCount = myPageDAO.getMyPointCount(id);
		
		close(con);
		
		return memberPointCount;
	}

	//AdminServerMoneyAction
	public int getAllPoint() throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int allPoint = myPageDAO.getAllPoint();
		
		close(con);
		
		return allPoint;
	}

	//AdminServerTotalAction
	public ArrayList<MemberPoint> getTotalPointList(int page, int intviewCount) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<MemberPoint> pointList = myPageDAO.getTotalPointList(page, intviewCount);
		
		close(con);
		
		return pointList;
	}

	//AdminServerTotalAction
	public int getTotalPointListCount() throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int pointListCount = myPageDAO.getTotalPointListCount();
		
		close(con);
		
		return pointListCount;
	}

	//AdminServerTotalAction
	public int getIDPointListCount(String searchID) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		int pointListCount = myPageDAO.getIDPointListCount(searchID);
		
		close(con);
		
		return pointListCount;
	}

	//AdminServerTotalAction
	public ArrayList<MemberPoint> getIDPointList(int page, int intviewCount, String searchID) throws Exception {
		Connection con = getConnection();
		
		MyPageDAO myPageDAO = MyPageDAO.getInstance();
		
		myPageDAO.setConnection(con);
		
		ArrayList<MemberPoint> pointList = myPageDAO.getIDPointList(page, intviewCount, searchID);
		
		close(con);
		
		return pointList;
	}
}
