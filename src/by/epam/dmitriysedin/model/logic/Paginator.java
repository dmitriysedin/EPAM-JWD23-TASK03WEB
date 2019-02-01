package by.epam.dmitriysedin.model.logic;

import javax.servlet.http.HttpServletRequest;

public class Paginator {

	private static final int rowsByPage = 5;

	public int[] measureIndex(HttpServletRequest request) {
		
		int firstIndex = 0;
		int lastIndex = firstIndex + rowsByPage;
		
		if(request.getParameter("page") != null && 
				request.getParameter("page").equals("next") &&
					request.getParameter("lastrow") != null) {
		firstIndex = Integer.parseInt(request.getParameter("lastrow"));
		lastIndex = firstIndex + rowsByPage;
		}
		
		if(request.getParameter("page") != null && 
				request.getParameter("page").equals("previous") &&
					request.getParameter("firstrow") != null) {
		firstIndex = Integer.parseInt(request.getParameter("firstrow")) - rowsByPage;
		lastIndex = firstIndex + rowsByPage;
		}
		
		return new int[] {firstIndex, lastIndex};
	}
	
}
