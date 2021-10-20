package menu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menu.action.Action;
import svc.BoardQuestionService;
import vo.ActionForward;
import vo.BoardQuestion;
import vo.Member;

public class AdminQuestionInsertProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		String id = member.getId();

		BoardQuestion boardQuestion = new BoardQuestion();
		String board_choice = request.getParameter("board_choice");
		String q_choice = request.getParameter("q_choice");

		boardQuestion.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		boardQuestion.setId(request.getParameter("id"));
		boardQuestion.setBoard_choice(request.getParameter("board_choice"));
		boardQuestion.setQ_choice(request.getParameter("q_choice"));
		boardQuestion.setBoard_subject(request.getParameter("board_subject"));
		boardQuestion.setBoard_content(request.getParameter("board_content"));
		boardQuestion.setBoard_re(Integer.parseInt(request.getParameter("board_re")));
		boardQuestion.setBoard_re_loc(Integer.parseInt(request.getParameter("board_re_loc")));
		boardQuestion.setBoard_re_seq(Integer.parseInt(request.getParameter("board_re_seq")));
		boardQuestion.setBoard_date(request.getParameter("board_date"));

		BoardQuestionService boardQuestionService = new BoardQuestionService();
		boolean isInsertSuccess = boardQuestionService.adminQuestionInsert(boardQuestion, id, q_choice, board_choice);

		if (!isInsertSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답변글등록실패')");
			out.println("history.back()");
			out.println("</script>");
		} else {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("board/adminQuestionInsertSuccess.jsp");
		}

		return forward;
	}
}
