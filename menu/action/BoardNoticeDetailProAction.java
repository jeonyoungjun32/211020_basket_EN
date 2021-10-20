package menu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.BoardNotice;

public class BoardNoticeDetailProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		
		int Notice_num =0;
		 ActionForward forward = new ActionForward();
		try {
			Notice_num =(int)session.getAttribute("Notice_num");
			String page = request.getParameter("page");
			BoardNoticeService boardNoticeService = new BoardNoticeService();
			BoardNotice boardNotice = boardNoticeService.getNoticeDetail(Notice_num);
			
			request.setAttribute("page", page);
			request.setAttribute("boardNotice", boardNotice);
			forward.setPath("/board/boardNoticeDetailForm.jsp");
			
		} catch (Exception e) {
			Notice_num = Integer.parseInt(request.getParameter("Notice_num"));
			String page = request.getParameter("page");
			BoardNoticeService boardNoticeService = new BoardNoticeService();
			BoardNotice boardNotice = boardNoticeService.getNoticeDetail(Notice_num);
			
			request.setAttribute("page", page);
			request.setAttribute("boardNotice", boardNotice);
			forward.setPath("/board/boardNoticeDetailForm.jsp");
		}
		
		return forward;
	}

}
