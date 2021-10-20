package menu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardNoticeService;
import vo.ActionForward;

public class BoardFileUpdateProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;

		String file = request.getParameter("Notice_file");
		int Notice_num = Integer.parseInt(request.getParameter("Notice_num"));

		BoardNoticeService boardNoticeService = new BoardNoticeService();

		boolean UpdateSuccess = boardNoticeService.UpdateFile(file, Notice_num);

		if (!UpdateSuccess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('파일 수정이 되지 않았습니다.');");
			out.print("history.back();");
			out.print("</script>");
		} else {
			request.setAttribute("Notice_num", Notice_num);
			forward = new ActionForward();
			forward.setPath("board/fileUpdateSuccess.jsp");
			forward.setRedirect(false);
		}

		return forward;
	}

}
