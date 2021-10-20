package menu.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardQuestionService;
import vo.ActionForward;
import vo.BoardQuestion;

public class AdminQuestionInsertFromAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String nowPage = request.getParameter("page");

		BoardQuestionService boardQuestionService = new BoardQuestionService();
		/* list도 가지고 와야함(수정중) 문의글 번호를 가지고 와서 id를 비교하고 id가 맞으면 글 내용 표시 아니면 back */
		BoardQuestion boardQuestion = boardQuestionService.getAdminQuestionForm(board_num);

		request.setAttribute("page", nowPage);
		request.setAttribute("boardQuestion", boardQuestion);
		forward.setRedirect(false);
		// path값 제대로 안주면 무한루프돔
		forward.setPath("board/adminQuestionInsertForm.jsp");

		return forward;

	}
}
