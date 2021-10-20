package menu.action;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.action.Action;
import svc.BoardQuestionService;
import vo.ActionForward;
import vo.BoardPageInfo;
import vo.BoardQuestion;

public class BoardQuestionViewAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		/* 작성자id와 등급으로 글목록 표시 나중에 바꿔야함 */
		/* list도 가지고 와야함(수정중) */
		ArrayList<BoardQuestion> boardQuestionPageList = new ArrayList<BoardQuestion>();

		int page = 1;
		int limit = 10;

		if (request.getParameter("page") != null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		BoardQuestionService boardQuestionService = new BoardQuestionService();
		int listCount = boardQuestionService.getListCount();
		boardQuestionPageList = boardQuestionService.getPageBoardQuestion(page, limit);

		ActionForward forward = null;
		int maxPage = (int) ((double) listCount / limit + 0.95);
		int startPage = (((int) ((double) page / 10 + 0.9)) - 1) * 10 + 1;
		int endPage = startPage + 10 - 1;

		if (endPage > maxPage)
			endPage = maxPage;

		BoardPageInfo boardPageInfo = new BoardPageInfo();
		boardPageInfo.setEndPage(endPage);
		boardPageInfo.setListCount(listCount);
		boardPageInfo.setMaxPage(maxPage);
		boardPageInfo.setPage(page);
		boardPageInfo.setStartPage(startPage);
		request.setAttribute("boardPageInfo", boardPageInfo);
		request.setAttribute("boardQuestionPageList", boardQuestionPageList);
		forward = new ActionForward();
		forward.setPath("board/boardQuestionForm.jsp");
		forward.setRedirect(false);

		return forward;
	}

}
