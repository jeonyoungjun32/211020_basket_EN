package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import menu.action.AdminQuestionDeleteProAction;
import menu.action.AdminQuestionInsertFromAction;
import menu.action.AdminQuestionInsertProAction;
import menu.action.BoardFileUpdateFormAction;
import menu.action.BoardFileUpdateProAction;
import menu.action.BoardNoticeDeleteProAction;
import menu.action.BoardNoticeDetailProAction;
import menu.action.BoardQuestionDetailAction;
import menu.action.BoardQuestionViewAction;
import menu.action.MemberBoardQuestionInsertProAction;
import menu.action.BoardNoticeInsertProAction;
import menu.action.BoardNoticeListAction;
import menu.action.BoardNoticeUpdateFormAction;
import menu.action.BoardNoticeUpdateProAction;
import menu.action.fileDown;
import vo.ActionForward;

/**
 * Servlet implementation class BKFrontController
 */
@WebServlet("*.bm")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String RequestURI = request.getRequestURI();
		String conextPath = request.getContextPath();
		String command = RequestURI.substring(conextPath.length());
		ActionForward forward = null;
		Action action = null;
		
		System.out.println(command);
		
		/*?????? ??????*/
		if (command.equals("/boardQuestionForm.bm")) {//??????????????? ????????? ?????? ??? ??????
			action = new BoardQuestionViewAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/memberBoardQuestionForm.bm")) {
			forward = new ActionForward();
			forward.setPath("/board/memberBoardQuestionInsertForm.jsp");
		}
		 else if (command.equals("/memberBoardQuestionInsertPro.bm")) {// ??????????????? ?????? ??????
			action = new MemberBoardQuestionInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/boardQuestionDetailForm.bm")) {//????????? ?????????????????? ??? ??????
			action = new BoardQuestionDetailAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/adminQuestionInsertForm.bm")) {//????????? ?????? ??? ??????
			action = new AdminQuestionInsertFromAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/adminQuestionInsertPro.bm")) {// ??????????????? ?????? ?????? ??????
			action = new AdminQuestionInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminQuestionInsertSuccess.bm")) {// ??????????????? ??????
				forward = new ActionForward();
				forward.setPath("/board/adminQuestionInsertSuccess.jsp");
		}else if (command.equals("/adminQuestionDelete.bm")) {// ??????????????? ??????
			action = new AdminQuestionDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/adminQuestionDeleteSuccess.bm")) {// ??????????????? ??????
			forward = new ActionForward();
			forward.setPath("/board/adminQuestionDeleteSuccess.jsp");
		}else if(command.equals("/fileDown.bm")) {
			action = new fileDown();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/************????????????****************/
		else if(command.equals("/boardNoticeList.bm")) {//???????????? ?????? ???
			action = new BoardNoticeListAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardNoticeInsertForm.bm")) {// ??????????????? ??????
			forward = new ActionForward();
			forward.setPath("/board/boardNoticeInsertForm.jsp");
		}else if (command.equals("/boardNoticeInsertPro.bm")) {// ???????????? ?????? ??????
			action = new BoardNoticeInsertProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardNoticeInsertSuccess.bm")) {// ??????????????? ??????
			forward = new ActionForward();
			forward.setPath("/board/boardNoticeInsertSuccess.jsp");
		}
		else if (command.equals("/boardNoticeDetail.bm")) {// ???????????? ?????? ??????
			action = new BoardNoticeDetailProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if (command.equals("/boardNoticeDelete.bm")) {// ???????????? ?????? ??????
			action = new BoardNoticeDeleteProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/boardNoticeDeleteSuccess.bm")) {// ??????????????? ??????
			forward = new ActionForward();
			forward.setPath("/board/boardNoticeDeleteSuccess.jsp");
		}else if(command.equals("/boardNoticeUpdateForm.bm")) {// ??????????????? ??????
			action = new BoardNoticeUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		else if (command.equals("/boardNoticeUpdate.bm")) {// ???????????? ?????? ??????
			action = new BoardNoticeUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(command.equals("/fileUpdateForm.bm")) {// ??????????????? ??????
			action = new BoardFileUpdateFormAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}else if (command.equals("/fileUpdatePro.bm")) {// ???????????? ?????? ??????
			action = new BoardFileUpdateProAction();
			try {
				forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		if (forward != null) {
			if (forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				request.getRequestDispatcher(forward.getPath()).forward(request, response);
			}
		}
	}
}
