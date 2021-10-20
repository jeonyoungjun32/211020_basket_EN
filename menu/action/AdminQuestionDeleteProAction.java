package menu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardQuestionService;
import vo.ActionForward;

public class AdminQuestionDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		int board_num = Integer.parseInt(request.getParameter("board_num"));

		BoardQuestionService boardQuestionService = new BoardQuestionService();
		boolean isDeleteSuccess = boardQuestionService.deleteBoard(board_num);

		if (!isDeleteSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}

		else {
			forward = new ActionForward();
			forward.setPath("adminQuestionDeleteSuccess.bm");
			forward.setRedirect(true);
		}

		return forward;
	}

}
