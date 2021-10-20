package menu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.BoardNotice;

public class BoardNoticeUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		int Notice_num = Integer.parseInt(request.getParameter("Notice_num"));		
		
		BoardNoticeService boardNoticeService = new BoardNoticeService();
		BoardNotice boardNoticeList = boardNoticeService.UpdateList(Notice_num);
		
		request.setAttribute("boardNoticeList", boardNoticeList);
		
		forward = new ActionForward();
		forward.setPath("/board/boardNoticeUpdateForm.jsp");
		
		
		return forward;
	}

}
