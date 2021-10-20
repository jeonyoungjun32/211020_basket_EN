package menu.action;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.BoardNotice;
import vo.Member;

public class BoardNoticeInsertProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
	
		ActionForward forward = null;
		
		int fileSize=10*1024*1024;
		
		//파일이 업로드 될 서버상의 실제 디렉토리(폴더) 경로
		ServletContext context = request.getServletContext();
		String realFolder = null;
		String saveFolder = "/boardUpload";
		realFolder = context.getRealPath(saveFolder);
		MultipartRequest multi= new MultipartRequest(request, realFolder,fileSize,"UTF-8",
													new DefaultFileRenamePolicy());
													
		String fileName = multi.getOriginalFileName("Notice_file");
		
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("member");
		String id = member.getId();
		
		if(id == null || member == null) {
			forward = new ActionForward();
			forward.setRedirect(true);
			forward.setPath("login.bk");
		}
		
		BoardNotice boardNotice = new BoardNotice();
		
		boardNotice.setNotice_title(multi.getParameter("Notice_title"));
		System.out.println(multi.getParameter("Notice_title"));
		boardNotice.setNotice_contents(multi.getParameter("Notice_contents"));
		boardNotice.setNotice_file((String)multi.getFileNames().nextElement());
		BoardNoticeService boardNoticeService  = new BoardNoticeService();
		boolean isInsertSuccess = boardNoticeService.insertBoardNotice(boardNotice,id,fileName);
			
			if(!isInsertSuccess) {
				response.setContentType("text/html;charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.print("<script>");
				out.print("alert('공지사항 등록 실패!');");
				out.print("history.back();");
				out.print("</script>");
			}
			 
				
				forward = new ActionForward();
				forward.setRedirect(true);
				forward.setPath("boardNoticeInsertSuccess.bm");//문의게시판 페이지 보기 폼 요청
		
				return forward;
	}

}
