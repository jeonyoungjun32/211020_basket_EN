package menu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.BoardNotice;

public class BoardFileUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int Notice_num = Integer.parseInt(request.getParameter("Notice_num"));

		BoardNoticeService boardNoticeService = new BoardNoticeService();

		BoardNotice boardNotice = boardNoticeService.getBoardNotice(Notice_num);

		request.setAttribute("boardNotice", boardNotice);

		ActionForward forward = new ActionForward();

		forward.setPath("board/fileUpdateForm.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
