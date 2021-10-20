package menu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.BoardNotice;

public class BoardNoticeUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = null;
		int Notice_num = Integer.parseInt(request.getParameter("Notice_num"));
		String Notice_title = request.getParameter("Notice_title");
		String Notice_contents = request.getParameter("Notice_contents");
		BoardNotice boardNotice = new BoardNotice();
		
		BoardNoticeService boardNoticeService = new BoardNoticeService();
		boolean isUpDateCount = boardNoticeService.UpdateNotice(boardNotice ,Notice_num,Notice_title,Notice_contents);
		
		if(!isUpDateCount) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('수정 실패');");
			out.println("history.back()");
			out.println("</script>");
		}
		forward = new ActionForward();
		forward.setRedirect(false);
		forward.setPath("board/boardNoticeUpdateSuccess.jsp"); 
		
		return forward;
	}

}
