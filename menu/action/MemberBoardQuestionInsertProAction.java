package menu.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import menu.action.Action;
import svc.BoardQuestionService;
import vo.ActionForward;
import vo.BoardQuestion;
import vo.Member;

public class MemberBoardQuestionInsertProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = null;

		int fileSize = 10 * 1024 * 1024;

		// 파일이 업로드 될 서버상의 실제 디렉토리(폴더) 경로
		ServletContext context = request.getServletContext();
		String realFolder = null;
		String saveFolder = "/boardUpload";
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi = new MultipartRequest(request, realFolder, fileSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String fileName = multi.getOriginalFileName("board_file");

		// multi로 만들면 변수에 getParameter로 값을 넣고
		String q_choice = multi.getParameter("q_choice");

		HttpSession session = request.getSession();
		Member member = (Member) session.getAttribute("member");

		if (member.getId() == null || member == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login.bk");
		} else {
			String id = member.getId();
			if (q_choice == "" || q_choice == null) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('문의종류를 선택해주세요.');");
				out.print("history.back();");
				out.print("</script>");
			}

			BoardQuestion boardQuestion = new BoardQuestion();

			boardQuestion.setBoard_choice(multi.getParameter("board_choice"));
			// 변수이름만 넣으면 된다. 여기서 또 getParmeter를 넣으면 오류 null값 들어감
			boardQuestion.setQ_choice(q_choice);
			boardQuestion.setBoard_subject(multi.getParameter("board_subject"));
			boardQuestion.setBoard_content(multi.getParameter("board_content"));
			boardQuestion.setBoard_file((String) multi.getFileNames().nextElement());
			BoardQuestionService boardQuestionService = new BoardQuestionService();

			boolean isInsertSuccess = boardQuestionService.insertBoardQuestion(boardQuestion, id, fileName);

			if (!isInsertSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('문희글 등록 실패!');");
				out.print("history.back();");
				out.print("</script>");
			}

			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.print("<script>");
			out.print("alert('문의글 등록 시 삭제나 수정이 불가능 합니다. 신중히 작성해주시기 바랍니다.');");
			out.print("history.back();");
			out.print("</script>");
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("boardQuestionForm.bm");// 문의게시판 페이지 보기 폼 요청
		}

		return forward;
	}

}
