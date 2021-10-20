package menu.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.Member;

public class BoardNoticeDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = null;
		Member member = new Member();
	
		HttpSession session = request.getSession();
		
		Member loginMember = (Member)session.getAttribute("member");
		
		int Notice_num = Integer.parseInt(request.getParameter("Notice_num"));
		String admin = member.getAuthor();
		BoardNoticeService boardQuestionService = new BoardNoticeService();
		boolean isDeleteSuccess = boardQuestionService.deleteBoardNotice(Notice_num);
		System.out.println(admin);

		if(loginMember.getAuthor().equalsIgnoreCase("1")) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('공지사항 삭제 권한이 없습니다.');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		if(!isDeleteSuccess){
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out=response.getWriter();
			out.println("<script>");
			out.println("alert('삭제실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		else {
			forward = new ActionForward();
			forward.setPath("boardNoticeDeleteSuccess.bm");
			forward.setRedirect(true);
		}
		
		
		return forward;
	}
		

}
