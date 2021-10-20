package menu.action;

import java.io.File;
import java.io.FileInputStream;

import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import vo.ActionForward;

public class fileDown implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("utf-8");
		String fileName = request.getParameter("board_file");
		
		ServletContext context = request.getServletContext();
		String realFolder = null;
		String saveFolder = "/boardUpload";
		realFolder = context.getRealPath(saveFolder);
		
		File file = new File(realFolder+"/"+fileName);
		String mimeType = context.getMimeType(file.toString());
		
		if(mimeType == null) {
			response.setContentType("application/octet=stream");
		}
		
		if(request.getHeader("user-agent").indexOf("MSIE") == -1) {
			fileName = new String(fileName.getBytes("UTF-8"), "8859_1");
		}else {
			fileName = new String(fileName.getBytes("EUC=KR"), "8859_1");
		}
 		
		response.setHeader("Content-Disposition", "attachment; fileName= " + fileName);
		
		FileInputStream fileInputStream = new FileInputStream(file);
		ServletOutputStream servletOutputStream = response.getOutputStream();
		
		byte b[] = new byte[1024];
		int data = 0;
		
		while((data=(fileInputStream.read(b, 0, b.length))) != -1) {
			servletOutputStream.write(b, 0, data);
		}
		
		servletOutputStream.flush();
		servletOutputStream.close();
		fileInputStream.close();
		
		return forward;
	}

}
