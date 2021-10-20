package menu.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardNoticeService;
import vo.ActionForward;
import vo.BoardNotice;
import vo.BoardPageInfo;

public class BoardNoticeListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<BoardNotice> boardNoticeList = new ArrayList<BoardNotice>();
		ActionForward forward = null;
		int page =1;
		int limit = 10;
		
		if(request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		BoardNoticeService boardNoticeService = new BoardNoticeService();
		int listCount = boardNoticeService.getListCount();
		boardNoticeList = boardNoticeService.getBoardNoticeList(page, limit);
		
		int maxPage = (int)((double)listCount/limit+0.95);
		int startPage = (((int)((double)page/10+0.9))-1)* 10+1;
		int endPage = startPage+10-1;
		
		if(endPage > maxPage) endPage = maxPage;
		
		BoardPageInfo NoticePageInfo = new BoardPageInfo();
		NoticePageInfo.setEndPage(endPage);
		NoticePageInfo.setListCount(listCount);
		NoticePageInfo.setMaxPage(maxPage);
		NoticePageInfo.setPage(page);
		NoticePageInfo.setStartPage(startPage);
		request.setAttribute("NoticePageInfo", NoticePageInfo);
		request.setAttribute("boardNoticeList", boardNoticeList);
		forward = new ActionForward();
		forward.setPath("/board/boardNoticeList.jsp");
		forward.setRedirect(false);
		
		
		
		return forward;
	}

}
