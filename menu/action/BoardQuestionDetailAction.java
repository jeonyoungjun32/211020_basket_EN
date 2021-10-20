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

public class BoardQuestionDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		/* 작성자id와 등급으로 접근제한 만들어야함 */
		ActionForward forward = new ActionForward();

		int board_num = Integer.parseInt(request.getParameter("board_num"));

		String id = request.getParameter("id");

		HttpSession session = request.getSession();

		Member loginMember = (Member) session.getAttribute("member");
		String board_choice = request.getParameter("board_choice");

		BoardQuestion boardQuestion = new BoardQuestion();

		BoardQuestionService boardQuestionService = new BoardQuestionService();
		boardQuestion = boardQuestionService.getDetailBoardQuestion(board_num);

		BoardQuestion boardQuestionList = boardQuestionService.getBoardQuestionList(board_num);

		if (loginMember.getId().equalsIgnoreCase(id)) {
			request.setAttribute("boardQuestionList", boardQuestionList);
			request.setAttribute("boardQuestion", boardQuestion);
			forward.setPath("board/boardQuestionDetailForm.jsp");
		}
		
		if (loginMember.getAuthor().equalsIgnoreCase("2") || loginMember.getAuthor().equalsIgnoreCase("3")) {
			request.setAttribute("boardQuestionList", boardQuestionList);
			request.setAttribute("boardQuestion", boardQuestion);
			forward.setPath("board/boardQuestionDetailForm.jsp");
		}
		
		if (board_choice.equalsIgnoreCase("2")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('비공개 문의글입니다. 작성자만 확인 가능합니다.');");
			out.print("history.back();");
			out.print("</script>");
		}

		if (board_choice.equalsIgnoreCase("1")) {
			request.setAttribute("boardQuestionList", boardQuestionList);
			request.setAttribute("boardQuestion", boardQuestion);
			forward.setPath("board/boardQuestionDetailForm.jsp");
		}

		return forward;

	}

}
